/*
 * Copyright 2026 mingliqiye
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * ProjectName mingli-utils
 * ModuleName mingli-utils.main
 * CurrentFile ByteBufferWrapper.kt
 * LastUpdate 2026-06-21 10:37:47
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.buffer

import com.mingliqiye.utils.buffer.convertor.ByteBufferWrapperConvertor
import com.mingliqiye.utils.bytes.*
import com.mingliqiye.utils.netty.toByteBuffer
import com.mingliqiye.utils.time.DateTime
import com.mingliqiye.utils.time.DateTime.Companion.toDateTime
import com.mingliqiye.utils.uuid.UUID
import com.mingliqiye.utils.uuid.UUID.Companion.toMLUUID
import io.netty.buffer.ByteBuf
import java.math.BigDecimal
import java.math.BigInteger
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.charset.Charset
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*
import java.util.concurrent.ConcurrentHashMap

/**
 * ByteBuffer 包装器
 *
 * 提供对 java.nio.ByteBuffer 的完整封装，支持链式调用和丰富的数据类型读写。
 * 包含基础类型、大数、时间、UUID 等多种数据类型的读写方法。
 * 100000 iterations took 52ms
 *
 * 使用示例：
 * ```
 * // 写入数据
 * val wrapper = ByteBufferWrapper.allocate(1024)
 *     .putInt(100)
 *     .putString("Hello")
 *     .putUUID(UUID.randomUUID())
 *     .flip() // 切换到读模式
 *
 * // 读取数据
 * val intValue = wrapper.getInt()
 * val strValue = wrapper.getString()
 * val uuidValue = wrapper.getUUID()
 * ```
 *
 * @param buffer 底层的 ByteBuffer 实例（私有构造，通过工厂方法创建）
 */
class ByteBufferWrapper private constructor(private val buffer: ByteBuffer) {
	/**
	 * 缓冲区容量（总大小）
	 */
	@get:JvmName("capacity")
	val capacity: Int get() = buffer.capacity()

	/**
	 * 当前位置（读写位置）
	 */
	@get:JvmName("position")
	val position: Int get() = buffer.position()

	/**
	 * 剩余可读写字节数
	 */
	@get:JvmName("remaining")
	val remaining: Int get() = buffer.remaining()

	/**
	 * 是否还有剩余字节
	 */
	@get:JvmName("hasRemaining")
	val hasRemaining: Boolean get() = buffer.hasRemaining()

	/**
	 * 限制位置
	 */
	@get:JvmName("limit")
	val limit: Int get() = buffer.limit()

	/**
	 * 标记位置（实际 ByteBuffer 没有直接获取 mark 的方法，这里返回当前position）
	 */
	@get:JvmName("mark")
	val mark: Int get() = remaining

	/**
	 * 是否具有可访问的底层数组
	 */
	@get:JvmName("hasArray")
	val hasArray: Boolean get() = buffer.hasArray()

	/**
	 * 获取底层数组（如果存在）
	 *
	 * @return 底层字节数组
	 * @throws UnsupportedOperationException 如果没有底层数组（如直接缓冲区）
	 */
	@get:JvmName("array")
	val array: ByteArray get() = buffer.array()

	/**
	 * 转换为整个字节数组
	 *
	 * @return 数组偏移量
	 * @throws UnsupportedOperationException 如果没有底层数组
	 */
	fun toByteArray(): ByteArray = getByteArray(remaining)

	/**
	 * 获取底层数组的偏移量
	 *
	 * @return 数组偏移量
	 * @throws UnsupportedOperationException 如果没有底层数组
	 */

	@get:JvmName("arrayOffset")
	val arrayOffset: Int get() = buffer.arrayOffset()

	/**
	 * 是否为只读缓冲区
	 */
	@get:JvmName("isReadOnly")
	val isReadOnly: Boolean get() = buffer.isReadOnly

	/**
	 * 是否为直接缓冲区（堆外内存）
	 */
	@get:JvmName("isDirect")
	val isDirect: Boolean get() = buffer.isDirect

	/**
	 * 当前字节序（大端/小端）
	 */
	@get:JvmName("order")
	val byteOrder: ByteOrder get() = buffer.order()

	/**
	 * 是否为大端字节序
	 */
	@get:JvmName("isBigEndian")
	val isBigEndian: Boolean get() = byteOrder == ByteOrder.BIG_ENDIAN

	/**
	 * 是否为小端字节序
	 */
	@get:JvmName("isLittleEndian")
	val isLittleEndian: Boolean get() = byteOrder == ByteOrder.LITTLE_ENDIAN

	/**
	 * 缓冲区是否为空（无剩余字节）
	 */
	@get:JvmName("isEmpty")
	val isEmpty: Boolean get() = !hasRemaining

	/**
	 * 缓冲区是否已满（position == capacity）
	 */
	@get:JvmName("isFull")
	val isFull: Boolean get() = position == capacity

	/**
	 * 当前位置是否在限制之内
	 */
	@get:JvmName("isWithinLimit")
	val isWithinLimit: Boolean get() = position < limit

	/**
	 * 是否已到达限制位置
	 */
	@get:JvmName("isAtLimit")
	val isAtLimit: Boolean get() = position == limit

	/**
	 * 获取缓冲区的字符串表示
	 *
	 * @return 格式化的字符串信息
	 */
	override fun toString(): String {
		return "ByteBufferWrapper(capacity=$capacity, position=$position, limit=$limit, remaining=$remaining)#${hashCode()}"
	}

	companion object {
		/**
		 * 包装现有的 ByteBuffer
		 *
		 * @param buffer 要包装的 ByteBuffer
		 * @return 新的 ByteBufferWrapper 实例
		 */
		@JvmStatic
		fun wrap(buffer: ByteBuffer): ByteBufferWrapper {
			return ByteBufferWrapper(buffer)
		}

		/**
		 * 包装现有的 ByteBuf
		 *
		 * @param buffer 要包装的 ByteBuf
		 * @return 新的 ByteBufferWrapper 实例
		 */
		@JvmStatic
		fun wrap(buffer: ByteBuf): ByteBufferWrapper {
			return ByteBufferWrapper(buffer.toByteBuffer())
		}

		/**
		 * 包装字节数组
		 *
		 * @param array 要包装的字节数组
		 * @return 新的 ByteBufferWrapper 实例
		 */
		@JvmStatic
		fun wrap(array: ByteArray): ByteBufferWrapper {
			return ByteBufferWrapper(ByteBuffer.wrap(array))
		}

		/**
		 * 包装字节数组的一部分
		 *
		 * @param array 要包装的字节数组
		 * @param offset 起始偏移量
		 * @param length 长度
		 * @return 新的 ByteBufferWrapper 实例
		 */
		@JvmStatic
		fun wrap(array: ByteArray, offset: Int, length: Int): ByteBufferWrapper {
			return ByteBufferWrapper(ByteBuffer.wrap(array, offset, length))
		}

		/**
		 * 分配堆内缓冲区
		 *
		 * @param capacity 缓冲区容量
		 * @return 新的 ByteBufferWrapper 实例
		 */
		@JvmStatic
		fun allocate(capacity: Int): ByteBufferWrapper {
			return ByteBufferWrapper(ByteBuffer.allocate(capacity))
		}

		/**
		 * 分配直接缓冲区（堆外内存）
		 * 适用于高性能 I/O 场景，但分配和释放成本较高
		 *
		 * @param capacity 缓冲区容量
		 * @return 新的 ByteBufferWrapper 实例
		 */
		@JvmStatic
		fun allocateDirect(capacity: Int): ByteBufferWrapper {
			return ByteBufferWrapper(ByteBuffer.allocateDirect(capacity))
		}

		/**
		 * 添加转换器到映射表，转换器内部通过 getType() 提供自己的类型信息
		 *
		 * @param byteBufferWrapperConvertor 要添加的转换器实例，其泛型类型信息通过 getType() 方法获取
		 */
		@JvmStatic
		fun addConvertor(byteBufferWrapperConvertor: ByteBufferWrapperConvertor<*>) {
			_ByteBufferWrapperConvertorMap[byteBufferWrapperConvertor.getType().kotlin.javaObjectType] =
				byteBufferWrapperConvertor
		}

		@JvmName("inline_addConvertor")
		inline fun <reified T : ByteBufferWrapperConvertor<*>> addConvertor() {
			addConvertor(ByteBufferWrapperConvertor.getInstantiation<T>())
		}

		/**
		 * 添加转换器到映射表，显式指定要处理的类型 Class<T>
		 *
		 * @param clazz 要处理的类型对应的 Class 对象
		 * @param byteBufferWrapperConvertor 与指定类型匹配的转换器实例
		 * @param T 要处理的数据类型
		 */
		@JvmStatic
		fun <T : Any> addConvertor(clazz: Class<T>, byteBufferWrapperConvertor: ByteBufferWrapperConvertor<T>) {
			_ByteBufferWrapperConvertorMap[clazz.kotlin.javaObjectType] = byteBufferWrapperConvertor
		}

		/**
		 * 根据类型 Class<T> 从映射表中获取对应的转换器，并进行类型转换
		 *
		 * @param clazz 要获取转换器的类型对应的 Class 对象
		 * @param T 要处理的数据类型
		 * @return 与指定类型匹配的转换器实例，如果不存在则返回 null
		 */
		@JvmStatic
		@Suppress("UNCHECKED_CAST")
		fun <T : Any> getConvertor(clazz: Class<T>): ByteBufferWrapperConvertor<T>? {
			return _ByteBufferWrapperConvertorMap[clazz] as? ByteBufferWrapperConvertor<T>
		}

		/**
		 * 从映射表中移除指定类型的转换器
		 *
		 * @param clazz 要移除转换器的类型对应的 Class 对象
		 */
		@JvmStatic
		fun delectConvertor(clazz: Class<*>) {
			_ByteBufferWrapperConvertorMap.remove(clazz)
		}

		/**
		 * 存储类型与转换器映射关系的线程安全哈希表
		 * 键：要处理的类型 Class<*>
		 * 值：对应的转换器实例 ByteBufferWrapperConvertor<*>
		 */
		private val _ByteBufferWrapperConvertorMap =
			ConcurrentHashMap<Class<*>, ByteBufferWrapperConvertor<*>>(64, 1.5f)


		init {
			ByteBufferWrapperConvertor.defaultConvertorInstall()
		}
	}


	/**
	 * 将对象写入 ByteBufferWrapper
	 *
	 * 根据对象的实际类型获取对应的转换器，使用该转换器将对象写入当前的 ByteBufferWrapper
	 * 支持方法链调用（返回 this）
	 *
	 * @param obj 要写入的对象，类型为 T
	 * @return 当前的 ByteBufferWrapper 实例，支持链式调用
	 * @throws IllegalArgumentException 如果该对象类型没有注册对应的转换器
	 */
	fun putObject(obj: Any): ByteBufferWrapper {
		val convertor = getConvertor(obj.javaClass)
			?: throw IllegalArgumentException("${obj.javaClass.canonicalName} does not convertor exist")
		convertor.write(obj, this)
		return this
	}

	/**
	 * 将一个字节写入缓冲区。
	 *
	 * @param byte 要写入的字节值
	 * @return 当前包装器实例，支持链式调用
	 */
	fun put(byte: Byte): ByteBufferWrapper = putByte(byte)

	/**
	 * 将一个字符写入缓冲区（2字节）。
	 *
	 * @param char 要写入的字符值
	 * @return 当前包装器实例，支持链式调用
	 */
	fun put(char: Char): ByteBufferWrapper = putChar(char)

	/**
	 * 将一个短整数写入缓冲区（2字节）。
	 *
	 * @param short 要写入的短整数
	 * @return 当前包装器实例，支持链式调用
	 */
	fun put(short: Short): ByteBufferWrapper = putShort(short)

	/**
	 * 将一个整数写入缓冲区（4字节）。
	 *
	 * @param int 要写入的长整数
	 * @return 当前包装器实例，支持链式调用
	 */
	fun put(int: Int): ByteBufferWrapper = putInt(int)

	/**
	 * 将一个长整数写入缓冲区（8字节）。
	 *
	 * @param long 要写入的长整数
	 * @return 当前包装器实例，支持链式调用
	 */
	fun put(long: Long): ByteBufferWrapper = putLong(long)

	/**
	 * 将一个布尔值写入缓冲区（1字节）。
	 * 通常编码为：true = 0x01，false = 0x00。
	 *
	 * @param boolean 要写入的布尔值
	 * @return 当前包装器实例，支持链式调用
	 */
	fun put(boolean: Boolean): ByteBufferWrapper = putBoolean(boolean)

	/**
	 * 将一个单精度浮点数写入缓冲区（4字节）。
	 *
	 * @param float 要写入的单精度浮点数
	 * @return 当前包装器实例，支持链式调用
	 */
	fun put(float: Float): ByteBufferWrapper = putFloat(float)

	/**
	 * 将一个双精度浮点数写入缓冲区（8字节）。
	 *
	 * @param double 要写入的双精度浮点数
	 * @return 当前包装器实例，支持链式调用
	 */
	fun put(double: Double): ByteBufferWrapper = putDouble(double)

	/**
	 * 将字节数组完整写入缓冲区。
	 *
	 * @param byteArray 要写入的字节数组
	 * @return 当前包装器实例，支持链式调用
	 */
	fun put(byteArray: ByteArray): ByteBufferWrapper = putByteArray(byteArray)

	/**
	 * 将字符数组完整写入缓冲区（每个字符2字节）。
	 *
	 * @param charArray 要写入的字符数组
	 * @return 当前包装器实例，支持链式调用
	 */
	fun put(charArray: CharArray): ByteBufferWrapper = putCharArray(charArray)

	/**
	 * 将短整数数组完整写入缓冲区（每个短整数2字节）。
	 *
	 * @param shortArray 要写入的短整数数组
	 * @return 当前包装器实例，支持链式调用
	 */
	fun put(shortArray: ShortArray): ByteBufferWrapper = putShortArray(shortArray)

	/**
	 * 将整数数组完整写入缓冲区（每个长整数4字节）。
	 *
	 * @param intArray 要写入的长整数数组
	 * @return 当前包装器实例，支持链式调用
	 */
	fun put(intArray: IntArray): ByteBufferWrapper = putIntArray(intArray)

	/**
	 * 将长整数数组完整写入缓冲区（每个长整数8字节）。
	 *
	 * @param longArray 要写入的长整数数组
	 * @return 当前包装器实例，支持链式调用
	 */
	fun put(longArray: LongArray): ByteBufferWrapper = putLongArray(longArray)

	/**
	 * 将布尔数组完整写入缓冲区（每个布尔值1字节）。
	 *
	 * @param booleanArray 要写入的布尔数组
	 * @return 当前包装器实例，支持链式调用
	 */
	fun put(booleanArray: BooleanArray): ByteBufferWrapper = putBooleanArray(booleanArray)

	/**
	 * 将单精度浮点数数组完整写入缓冲区（每个浮点数4字节）。
	 *
	 * @param floatArray 要写入的单精度浮点数数组
	 * @return 当前包装器实例，支持链式调用
	 */
	fun put(floatArray: FloatArray): ByteBufferWrapper = putFloatArray(floatArray)

	/**
	 * 将双精度浮点数数组完整写入缓冲区（每个双精度浮点数8字节）。
	 *
	 * @param doubleArray 要写入的双精度浮点数数组
	 * @return 当前包装器实例，支持链式调用
	 */
	fun put(doubleArray: DoubleArray): ByteBufferWrapper = putDoubleArray(doubleArray)

	/**
	 * 将 DateTime 对象写入缓冲区。
	 *
	 * @param dateTime 要写入的 DateTime 对象
	 * @return 当前包装器实例，支持链式调用
	 */
	fun put(dateTime: DateTime): ByteBufferWrapper = putDateTime(dateTime)

	/**
	 * 将 LocalDateTime 对象写入缓冲区。
	 *
	 * @param localDateTime 要写入的 LocalDateTime 对象
	 * @return 当前包装器实例，支持链式调用
	 */
	fun put(localDateTime: LocalDateTime): ByteBufferWrapper = putLocalDateTime(localDateTime)

	/**
	 * 将 Date 对象写入缓冲区。
	 *
	 * @param date 要写入的 Date 对象
	 * @return 当前包装器实例，支持链式调用
	 */
	fun put(date: Date): ByteBufferWrapper = putDate(date)

	/**
	 * 将字符串写入缓冲区。
	 *
	 * @param string 要写入的字符串
	 * @return 当前包装器实例，支持链式调用
	 */
	fun put(string: String): ByteBufferWrapper = putString(string)

	/**
	 * 将 ByteFlags 标志位对象写入缓冲区。
	 *
	 * @param byteFlags 要写入的标志位对象
	 * @return 当前包装器实例，支持链式调用
	 */
	fun put(byteFlags: ByteFlags): ByteBufferWrapper = putFlag(byteFlags)

	/**
	 * 从 ByteBufferWrapper 中读取指定类型的对象
	 *
	 * 根据指定的类型获取对应的转换器，使用该转换器从当前的 ByteBufferWrapper 中读取对象
	 *
	 * @param clazz 要读取的对象类型对应的 Class 对象
	 * @param T 要读取的对象类型
	 * @return 读取并转换后的 T 类型对象
	 * @throws IllegalArgumentException 如果该类型没有注册对应的转换器
	 */
	fun <T : Any> getObject(clazz: Class<T>, parameters: Array<Any>): T {

		val convertor =
			getConvertor(clazz) ?: throw IllegalArgumentException("${clazz.canonicalName} does not convertor exist")
		return convertor.read(this, parameters)
	}

	fun <T : Any> getObject(clazz: Class<T>): T {
		return getObject(clazz, emptyArray())
	}

	fun <T : Any> getObject(clazz: Class<T>, size: Int): T {
		return getObject(clazz, arrayOf(size))
	}

	@JvmName("inline_getObject")
	inline fun <reified T : Any> getObject(parameters: Array<Any>): T {
		return getObject(T::class.java, parameters)
	}

	@JvmName("inline_getObject")
	inline fun <reified T : Any> getObject(size: Int): T {
		return getObject(T::class.java, size)
	}

	@JvmName("inline_getObject")
	inline fun <reified T : Any> getObject(): T {
		return getObject(T::class.java)
	}


	/**
	 * 写入字节数组
	 *
	 * @param byteArray 要写入的字节数组
	 * @param offset 起始偏移量（默认为0）
	 * @param length 写入长度（默认为数组长度）
	 * @return 当前对象（支持链式调用）
	 */
	fun putByteArray(byteArray: ByteArray, offset: Int = 0, length: Int = byteArray.size): ByteBufferWrapper {
		buffer.put(byteArray, offset, length)
		return this
	}

	fun putByteArray(size: Int, init: (Int) -> Byte): ByteBufferWrapper {
		buffer.put(ByteArray(size, init))
		return this
	}

	fun putCharArray(charArray: CharArray): ByteBufferWrapper {
		putByteArray(charArray.size) {
			charArray[it].code.toByte()
		}
		return this
	}

	fun getCharArray(size: Int): CharArray {
		return getByteArray(size).let {
			CharArray(it.size) { s ->
				it[s].toInt().toChar()
			}
		}
	}

	fun putIntArray(intArray: IntArray): ByteBufferWrapper {
		intArray.forEach(::putInt)
		return this
	}

	fun getIntArray(size: Int): IntArray {
		return IntArray(size) { getInt() }
	}

	fun putShortArray(shortArray: ShortArray): ByteBufferWrapper {
		shortArray.forEach(::putShort)
		return this
	}

	fun getShortArray(size: Int): ShortArray {
		return ShortArray(size) { getShort() }
	}

	fun putLongArray(longArray: LongArray): ByteBufferWrapper {
		longArray.forEach(::putLong)
		return this
	}

	fun getLongArray(size: Int): LongArray {
		return LongArray(size) { getLong() }
	}


	fun putDoubleArray(doubleArray: DoubleArray): ByteBufferWrapper {
		doubleArray.forEach(::putDouble)
		return this
	}

	fun getDoubleArray(size: Int): DoubleArray {
		return DoubleArray(size) { getDouble() }
	}

	fun putFloatArray(floatArray: FloatArray): ByteBufferWrapper {
		floatArray.forEach(::putFloat)
		return this
	}

	fun getFloatArray(size: Int): FloatArray {
		return FloatArray(size) { getFloat() }
	}

	fun putBooleanArray(booleanArray: BooleanArray): ByteBufferWrapper {
		putByteArray(booleanArray.size) {
			if (booleanArray[it]) 0x01 else 0x00
		}
		return this
	}

	fun getBooleanArray(size: Int): BooleanArray {
		return getByteArray(size).let {
			BooleanArray(it.size) { index ->
				when (val itm = it[index]) {
					0x00.toByte() -> false
					0x01.toByte() -> true
					else -> throw IllegalArgumentException("$itm not Boolean")
				}
			}
		}
	}

	/**
	 * 写入单个字节
	 *
	 * @param byte 要写入的字节
	 * @return 当前对象（支持链式调用）
	 */
	fun putByte(byte: Byte): ByteBufferWrapper {
		buffer.put(byte)
		return this
	}

	/**
	 * 写入字符（2字节）
	 *
	 * @param char 要写入的字符
	 * @return 当前对象（支持链式调用）
	 */
	fun putChar(char: Char): ByteBufferWrapper {
		buffer.putChar(char)
		return this
	}

	/**
	 * 写入短整数（2字节）
	 *
	 * @param short 要写入的短整数
	 * @return 当前对象（支持链式调用）
	 */
	fun putShort(short: Short): ByteBufferWrapper {
		buffer.putShort(short)
		return this
	}

	/**
	 * 写入整数（4字节）
	 *
	 * @param int 要写入的整数
	 * @return 当前对象（支持链式调用）
	 */
	fun putInt(int: Int): ByteBufferWrapper {
		buffer.putInt(int)
		return this
	}

	/**
	 * 写入长整数（8字节）
	 *
	 * @param long 要写入的长整数
	 * @return 当前对象（支持链式调用）
	 */
	fun putLong(long: Long): ByteBufferWrapper {
		buffer.putLong(long)
		return this
	}

	/**
	 * 写入 BigInteger（大整数）
	 * 格式：[长度:4字节] + []
	 *
	 * @param bigInteger 要写入的 BigInteger
	 * @return 当前对象（支持链式调用）
	 */
	fun putBigInteger(bigInteger: BigInteger): ByteBufferWrapper {
		val byteArray = bigInteger.toByteArray()
		putInt(byteArray.size)
		buffer.put(byteArray)
		return this
	}

	/**
	 * 写入单精度浮点数（4字节）
	 *
	 * @param float 要写入的浮点数
	 * @return 当前对象（支持链式调用）
	 */
	fun putFloat(float: Float): ByteBufferWrapper {
		buffer.putFloat(float)
		return this
	}

	/**
	 * 写入双精度浮点数（8字节）
	 *
	 * @param double 要写入的双精度浮点数
	 * @return 当前对象（支持链式调用）
	 */
	fun putDouble(double: Double): ByteBufferWrapper {
		buffer.putDouble(double)
		return this
	}

	/**
	 * 写入 BigDecimal（高精度小数）
	 * 格式：[scale:4字节] + [BigInteger]
	 *
	 * @param bigDecimal 要写入的 BigDecimal
	 * @return 当前对象（支持链式调用）
	 */
	fun putBigDecimal(bigDecimal: BigDecimal): ByteBufferWrapper {
		putInt(bigDecimal.scale())
		putBigInteger(bigDecimal.unscaledValue())
		return this
	}

	/**
	 * 写入布尔值（1字节）
	 * 0x00 = false, 0x01 = true
	 *
	 * @param boolean 要写入的布尔值
	 * @return 当前对象（支持链式调用）
	 */
	fun putBoolean(boolean: Boolean): ByteBufferWrapper {
		putByte(if (boolean) 0x01 else 0x00)
		return this
	}

	/**
	 * 写入标志位（ByteFlags）
	 *
	 * @param flags 要写入的标志位
	 * @return 当前对象（支持链式调用）
	 */
	fun putFlag(flags: ByteFlags): ByteBufferWrapper {
		putByte(flags.toByte())
		return this
	}

	/**
	 * 写入字符串（带长度前缀）
	 * 格式：[长度:变长] + [UTF-8字节数组]
	 *
	 * @param string 要写入的字符串
	 * @param charset 字符集（默认 UTF-8）
	 * @return 当前对象（支持链式调用）
	 */
	fun putString(string: String, charset: Charset = Charsets.UTF_8): ByteBufferWrapper {
		buffer.putString(string, charset)
		return this
	}

	/**
	 * 写入变长编码的短整数
	 * 使用 VarInt 编码节省空间
	 *
	 * @param varShort 要写入的短整数
	 * @return 当前对象（支持链式调用）
	 */
	fun putVarShort(varShort: Short): ByteBufferWrapper {
		buffer.putVarShort(varShort)
		return this
	}

	/**
	 * 写入变长编码的整数
	 * 使用 VarInt 编码节省空间
	 *
	 * @param varInt 要写入的整数
	 * @return 当前对象（支持链式调用）
	 */
	fun putVarInt(varInt: Int): ByteBufferWrapper {
		buffer.putVarInt(varInt)
		return this
	}

	/**
	 * 写入变长编码的长整数
	 * 使用 VarLong 编码节省空间
	 *
	 * @param varLong 要写入的长整数
	 * @return 当前对象（支持链式调用）
	 */
	fun putVarLong(varLong: Long): ByteBufferWrapper {
		buffer.putVarLong(varLong)
		return this
	}

	/**
	 * 写入 Instant（时间戳）
	 * 格式：[seconds:8字节] + [nanos:4字节]
	 *
	 * @param instant 要写入的 Instant
	 * @return 当前对象（支持链式调用）
	 */
	fun putInstant(instant: Instant): ByteBufferWrapper {
		putLong(instant.epochSecond)
		putInt(instant.nano)
		return this
	}

	/**
	 * 写入 DateTime（Joda-Time）
	 *
	 * @param dateTime 要写入的 DateTime
	 * @return 当前对象（支持链式调用）
	 */
	fun putDateTime(dateTime: DateTime): ByteBufferWrapper {
		putInstant(dateTime.toInstant())
		return this
	}

	/**
	 * 写入 LocalDateTime（Java 8 时间）
	 *
	 * @param localDateTime 要写入的 LocalDateTime
	 * @return 当前对象（支持链式调用）
	 */
	fun putLocalDateTime(localDateTime: LocalDateTime): ByteBufferWrapper {
		putDateTime(localDateTime.toDateTime())
		return this
	}

	/**
	 * 写入 Date（传统 Java 日期）
	 *
	 * @param date 要写入的 Date
	 * @return 当前对象（支持链式调用）
	 */
	fun putDate(date: Date): ByteBufferWrapper {
		putDateTime(date.toDateTime())
		return this
	}

	/**
	 * 写入自定义 UUID
	 *
	 * @param uuid 要写入的 UUID
	 * @return 当前对象（支持链式调用）
	 */
	fun putUUID(uuid: UUID): ByteBufferWrapper {
		putByteArray(uuid.toBytes())
		return this
	}

	/**
	 * 写入 Java UUID
	 *
	 * @param uuid 要写入的 Java UUID
	 * @return 当前对象（支持链式调用）
	 */
	fun putUUID(uuid: java.util.UUID): ByteBufferWrapper {
		putByteArray(uuid.toMLUUID().toBytes())
		return this
	}

	/**
	 * 读取字节数组
	 *
	 * @param size 要读取的字节数
	 * @return 读取的字节数组
	 */
	fun getByteArray(size: Int): ByteArray {
		return ByteArray(size).let {
			buffer.get(it)
			it
		}
	}

	/**
	 * 读取单个字节
	 *
	 * @return 读取的字节
	 */
	fun getByte(): Byte {
		return buffer.get()
	}

	/**
	 * 读取字符
	 *
	 * @return 读取的字符
	 */
	fun getChar(): Char {
		return buffer.getChar()
	}

	/**
	 * 读取短整数
	 *
	 * @return 读取的短整数
	 */
	fun getShort(): Short {
		return buffer.getShort()
	}

	/**
	 * 读取整数
	 *
	 * @return 读取的整数
	 */
	fun getInt(): Int {
		return buffer.getInt()
	}

	/**
	 * 读取长整数
	 *
	 * @return 读取的长整数
	 */
	fun getLong(): Long {
		return buffer.getLong()
	}

	/**
	 * 读取 BigInteger
	 *
	 * @return 读取的 BigInteger
	 */
	fun getBigInteger(): BigInteger {
		return BigInteger(getByteArray(getInt()))
	}

	/**
	 * 读取单精度浮点数
	 *
	 * @return 读取的浮点数
	 */
	fun getFloat(): Float {
		return buffer.getFloat()
	}

	/**
	 * 读取双精度浮点数
	 *
	 * @return 读取的双精度浮点数
	 */
	fun getDouble(): Double {
		return buffer.getDouble()
	}

	/**
	 * 读取 BigDecimal
	 *
	 * @return 读取的 BigDecimal
	 */
	fun getBigDecimal(): BigDecimal {
		val scale = getInt()
		return BigDecimal(getBigInteger(), scale)
	}

	/**
	 * 读取布尔值
	 *
	 * @return 读取的布尔值
	 * @throws IllegalArgumentException 如果字节值不是 0x00 或 0x01
	 */
	fun getBoolean(): Boolean {
		return when (getByte()) {
			0x00.toByte() -> false
			0x01.toByte() -> true
			else -> throw java.lang.IllegalArgumentException("Not a boolean")
		}
	}

	/**
	 * 读取标志位
	 *
	 * @return 读取的 ByteFlags
	 */
	fun getFlag(): ByteFlags {
		return ByteFlags(getByte())
	}

	/**
	 * 读取字符串
	 *
	 * @param charset 字符集（默认 UTF-8）
	 * @return 读取的字符串
	 */
	fun getString(charset: Charset = Charsets.UTF_8): String {
		return buffer.getString(charset)
	}

	/**
	 * 读取变长编码的短整数
	 *
	 * @return 读取的短整数
	 */
	fun getVarShort(): Short {
		return buffer.getVarShort()
	}

	/**
	 * 读取变长编码的整数
	 *
	 * @return 读取的整数
	 */
	fun getVarInt(): Int {
		return buffer.getVarInt()
	}

	/**
	 * 读取变长编码的长整数
	 *
	 * @return 读取的长整数
	 */
	fun getVarLong(): Long {
		return buffer.getVarLong()
	}

	/**
	 * 读取 Instant
	 *
	 * @return 读取的 Instant
	 */
	fun getInstant(): Instant {
		return Instant.ofEpochSecond(getLong(), getInt().toLong())
	}

	/**
	 * 读取 DateTime（Joda-Time）
	 *
	 * @param zoneId 时区（默认系统时区）
	 * @return 读取的 DateTime
	 */
	fun getDateTime(zoneId: ZoneId = ZoneId.systemDefault()): DateTime {
		return DateTime.of(getInstant(), zoneId)
	}

	/**
	 * 读取 LocalDateTime
	 *
	 * @param zoneId 时区（默认系统时区）
	 * @return 读取的 LocalDateTime
	 */
	fun getLocalDateTime(zoneId: ZoneId = ZoneId.systemDefault()): LocalDateTime {
		return getDateTime(zoneId).toLocalDateTime()
	}

	/**
	 * 读取 Date
	 *
	 * @param zoneId 时区（默认系统时区）
	 * @return 读取的 Date
	 */
	fun getDate(zoneId: ZoneId = ZoneId.systemDefault()): Date {
		return getDateTime(zoneId).toDate()
	}

	/**
	 * 读取自定义 UUID
	 *
	 * @return 读取的 UUID
	 */
	fun getUUID(): UUID {
		return getByteArray(16).let {
			UUID.of(it)
		}
	}

	/**
	 * 读取 Java UUID
	 *
	 * @return 读取的 Java UUID
	 */
	fun getJUUID(): java.util.UUID {
		return getByteArray(16).let {
			UUID.of(it).getUuid()
		}
	}

	/**
	 * 创建当前缓冲区的副本
	 * 共享内容但拥有独立的位置、限制和标记
	 *
	 * @return 新的 ByteBufferWrapper 实例
	 */
	fun duplicate(): ByteBufferWrapper {
		return ByteBufferWrapper(buffer.duplicate())
	}

	/**
	 * 创建当前缓冲区的只读视图
	 *
	 * @return 只读的 ByteBufferWrapper 实例
	 */
	fun asReadOnly(): ByteBufferWrapper {
		return ByteBufferWrapper(buffer.asReadOnlyBuffer())
	}

	/**
	 * 创建当前缓冲区的切片
	 * 从当前位置到限制的共享视图
	 *
	 * @return 新的 ByteBufferWrapper 实例
	 */
	fun slice(): ByteBufferWrapper {
		return ByteBufferWrapper(buffer.slice())
	}

	/**
	 * 设置位置
	 *
	 * @param newPosition 新的位置
	 * @return 当前对象（支持链式调用）
	 * @throws IllegalArgumentException 如果位置超出范围
	 */
	fun position(newPosition: Int): ByteBufferWrapper {
		buffer.position(newPosition)
		return this
	}

	/**
	 * 设置限制
	 *
	 * @param newLimit 新的限制
	 * @return 当前对象（支持链式调用）
	 * @throws IllegalArgumentException 如果限制超出范围
	 */
	fun limit(newLimit: Int): ByteBufferWrapper {
		buffer.limit(newLimit)
		return this
	}

	/**
	 * 设置标记位置
	 *
	 * @return 当前对象（支持链式调用）
	 */
	fun mark(): ByteBufferWrapper {
		buffer.mark()
		return this
	}

	/**
	 * 重置到标记位置
	 *
	 * @return 当前对象（支持链式调用）
	 * @throws java.nio.InvalidMarkException 如果没有标记
	 */
	fun reset(): ByteBufferWrapper {
		buffer.reset()
		return this
	}

	/**
	 * 设置字节序
	 *
	 * @param byteOrder 字节序（BIG_ENDIAN 或 LITTLE_ENDIAN）
	 * @return 当前对象（支持链式调用）
	 */
	fun order(byteOrder: ByteOrder): ByteBufferWrapper {
		buffer.order(byteOrder)
		return this
	}

	/**
	 * 设置为大端字节序
	 *
	 * @return 当前对象（支持链式调用）
	 */
	fun asBigEndian(): ByteBufferWrapper {
		buffer.order(ByteOrder.BIG_ENDIAN)
		return this
	}

	/**
	 * 设置为小端字节序
	 *
	 * @return 当前对象（支持链式调用）
	 */
	fun asLittleEndian(): ByteBufferWrapper {
		buffer.order(ByteOrder.LITTLE_ENDIAN)
		return this
	}

	/**
	 * 清除缓冲区
	 * position = 0, limit = capacity, mark = -1
	 * 准备重新写入
	 *
	 * @return 当前对象（支持链式调用）
	 */
	fun clear(): ByteBufferWrapper {
		buffer.clear()
		return this
	}

	/**
	 * 翻转缓冲区
	 * limit = position, position = 0, mark = -1
	 * 用于从写入模式切换到读取模式
	 *
	 * @return 当前对象（支持链式调用）
	 */
	fun flip(): ByteBufferWrapper {
		buffer.flip()
		return this
	}

	/**
	 * 重绕缓冲区
	 * position = 0, mark = -1
	 * 准备重新读取
	 *
	 * @return 当前对象（支持链式调用）
	 */
	fun rewind(): ByteBufferWrapper {
		buffer.rewind()
		return this
	}

	/**
	 * 压缩缓冲区
	 * 将未读数据移到开头，position = 剩余字节数，limit = capacity
	 * 适用于部分读取后想继续写入的场景
	 *
	 * @return 当前对象（支持链式调用）
	 */
	fun compact(): ByteBufferWrapper {
		buffer.compact()
		return this
	}

	/**
	 * 跳过指定字节数
	 * 相当于 position += bytes
	 *
	 * @param bytes 要跳过的字节数
	 * @return 当前对象（支持链式调用）
	 * @throws IllegalArgumentException 如果跳过的字节数超出范围
	 */
	fun skip(bytes: Int): ByteBufferWrapper {
		buffer.position(buffer.position() + bytes)
		return this
	}

	/**
	 * 跳转到指定位置
	 *
	 * @param newPosition 目标位置
	 * @return 当前对象（支持链式调用）
	 */
	fun jumpTo(newPosition: Int): ByteBufferWrapper {
		buffer.position(newPosition)
		return this
	}

	/**
	 * 回到开头
	 * position = 0
	 *
	 * @return 当前对象（支持链式调用）
	 */
	fun rewindToStart(): ByteBufferWrapper {
		buffer.position(0)
		return this
	}

	/**
	 * 跳到末尾
	 * position = limit
	 *
	 * @return 当前对象（支持链式调用）
	 */
	fun jumpToEnd(): ByteBufferWrapper {
		buffer.position(buffer.limit())
		return this
	}
}
