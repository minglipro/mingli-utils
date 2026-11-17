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
 * CurrentFile ByteBufferWrapperConvertor.kt
 * LastUpdate 2026-03-15 11:05:48
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.buffer.convertor

import com.mingliqiye.utils.buffer.ByteBufferWrapper
import com.mingliqiye.utils.bytes.ByteFlags
import com.mingliqiye.utils.time.DateTime
import com.mingliqiye.utils.uuid.UUID
import java.math.BigDecimal
import java.math.BigInteger
import java.time.LocalDateTime
import java.util.*
import java.util.concurrent.ConcurrentHashMap
import java.util.UUID as JUUID

/**
 * ByteBufferWrapper 类型转换器接口。
 *
 * 定义某种类型与 [ByteBufferWrapper] 之间的读写规则。
 *
 * @param T 该转换器处理的数据类型
 */
interface ByteBufferWrapperConvertorInterface<T : Any> {
	/**
	 * 将对象写入缓冲区。
	 *
	 * @param obj 要写入的对象
	 * @param byteBufferWrapper 目标缓冲区包装器
	 */
	fun write(obj: T, byteBufferWrapper: ByteBufferWrapper)

	/**
	 * 从缓冲区中读取对象。
	 *
	 * @param byteBufferWrapper 源缓冲区包装器
	 * @param parameters 读取时需要的额外参数（如数组长度）
	 * @return 读取并转换后的对象
	 */
	fun read(byteBufferWrapper: ByteBufferWrapper, parameters: Array<Any>): T

	/**
	 * 获取该转换器处理的数据类型。
	 *
	 * @return 类型对应的 Class 对象
	 */
	fun getType(): Class<T>
}

/**
 * ByteBufferWrapper 类型转换器抽象基类。
 *
 * 提供转换器实例的缓存创建以及默认转换器的注册功能。
 *
 * @param T 该转换器处理的数据类型
 */
abstract class ByteBufferWrapperConvertor<T : Any> : ByteBufferWrapperConvertorInterface<T> {
	/**
	 * 返回包含所处理类型信息的字符串表示。
	 */
	override fun toString(): String {
		return "ByteBufferWrapperConvertor(type=${getType()})"
	}

	/**
	 * 伴生对象，管理转换器实例缓存并提供默认转换器安装方法。
	 */
	companion object {
		private val _instantiations =
			ConcurrentHashMap<Class<ByteBufferWrapperConvertor<*>>, ByteBufferWrapperConvertor<*>>()

		/**
		 * 获取指定转换器类的实例，不存在时通过无参构造函数创建并缓存。
		 *
		 * @param clazz 转换器类对应的 Class 对象
		 * @return 缓存的或新创建的转换器实例
		 */
		@JvmStatic
		fun getInstantiation(clazz: Class<ByteBufferWrapperConvertor<*>>): ByteBufferWrapperConvertor<*> {
			return _instantiations.getOrPut(clazz) {
				clazz.getConstructor().newInstance()
			}
		}

		/**
		 * 获取具体化类型 T 对应的转换器实例，不存在时创建并缓存。
		 *
		 * @param T 转换器类型，必须提供无参构造函数
		 * @return 缓存的或新创建的转换器实例
		 */
		@JvmStatic
		@Suppress("UNCHECKED_CAST")
		inline fun <reified T : ByteBufferWrapperConvertor<*>> getInstantiation(): ByteBufferWrapperConvertor<*> {
			return getInstantiation(T::class.java as Class<ByteBufferWrapperConvertor<*>>)
		}

		/**
		 * 安装所有默认转换器。
		 *
		 * 将基础类型、大数、字符串、时间、UUID 及各类数组的转换器注册到 [ByteBufferWrapper]。
		 */
		fun defaultConvertorInstall() {
			ByteBufferWrapper.addConvertor<BigDecimalBufferWrapperConvertor>()
			ByteBufferWrapper.addConvertor<BigIntegerBufferWrapperConvertor>()
			ByteBufferWrapper.addConvertor<BooleanBufferWrapperConvertor>()
			ByteBufferWrapper.addConvertor<BytedBufferWrapperConvertor>()
			ByteBufferWrapper.addConvertor<ByteFlagsBufferWrapperConvertor>()
			ByteBufferWrapper.addConvertor<CharBufferWrapperConvertor>()
			ByteBufferWrapper.addConvertor<DateBufferWrapperConvertor>()
			ByteBufferWrapper.addConvertor<DateTimeFlagsBufferWrapperConvertor>()
			ByteBufferWrapper.addConvertor<DoubleBufferWrapperConvertor>()
			ByteBufferWrapper.addConvertor<FloatBufferWrapperConvertor>()
			ByteBufferWrapper.addConvertor<IntBufferWrapperConvertor>()
			ByteBufferWrapper.addConvertor<JUUIDBufferWrapperConvertor>()
			ByteBufferWrapper.addConvertor<LocalDateTimeBufferWrapperConvertor>()
			ByteBufferWrapper.addConvertor<LongBufferWrapperConvertor>()
			ByteBufferWrapper.addConvertor<ShortBufferWrapperConvertor>()
			ByteBufferWrapper.addConvertor<StringBufferWrapperConvertor>()
			ByteBufferWrapper.addConvertor<UUIDBufferWrapperConvertor>()
			ByteBufferWrapper.addConvertor<ByteArrayBufferWrapperConvertor>()
			ByteBufferWrapper.addConvertor<CharArrayBufferWrapperConvertor>()
			ByteBufferWrapper.addConvertor<ShortArrayBufferWrapperConvertor>()
			ByteBufferWrapper.addConvertor<IntArrayBufferWrapperConvertor>()
			ByteBufferWrapper.addConvertor<LongArrayBufferWrapperConvertor>()
			ByteBufferWrapper.addConvertor<FloatArrayBufferWrapperConvertor>()
			ByteBufferWrapper.addConvertor<DoubleArrayBufferWrapperConvertor>()
			ByteBufferWrapper.addConvertor<BooleanArrayBufferWrapperConvertor>()
		}
	}
}

/**
 * 基于读写函数构造的通用对象转换器。
 *
 * 通过传入的写入函数、读取函数和类型信息实现转换逻辑，读取时忽略额外参数。
 *
 * @param T 该转换器处理的数据类型
 * @param write 写入函数，将对象写入缓冲区
 * @param read 读取函数，从缓冲区读取对象
 * @param typer 该转换器处理的数据类型对应的 Class 对象
 */
abstract class ObjectBufferWrapperConvertor<T : Any>(
	val write: ByteBufferWrapper.(obj: T) -> Unit,
	val read: ByteBufferWrapper.() -> T,
	val typer: Class<T>,
) : ByteBufferWrapperConvertor<T>() {
	override fun write(obj: T, byteBufferWrapper: ByteBufferWrapper) = write.invoke(byteBufferWrapper, obj)
	override fun read(byteBufferWrapper: ByteBufferWrapper, parameters: Array<Any>): T =
		read.invoke(byteBufferWrapper)

	override fun getType(): Class<T> = typer
}


/** [Byte] 类型转换器，使用 putByte/getByte 读写。 */
class BytedBufferWrapperConvertor : ObjectBufferWrapperConvertor<Byte>(
	ByteBufferWrapper::putByte,
	ByteBufferWrapper::getByte,
	Byte::class.java,
)

/** [Char] 类型转换器，使用 putChar/getChar 读写。 */
class CharBufferWrapperConvertor : ObjectBufferWrapperConvertor<Char>(
	ByteBufferWrapper::putChar,
	ByteBufferWrapper::getChar,
	Char::class.java,
)

/** [Short] 类型转换器，使用 putShort/getShort 读写。 */
class ShortBufferWrapperConvertor : ObjectBufferWrapperConvertor<Short>(
	ByteBufferWrapper::putShort,
	ByteBufferWrapper::getShort,
	Short::class.java,
)

/** [Int] 类型转换器，使用 putInt/getInt 读写。 */
class IntBufferWrapperConvertor : ObjectBufferWrapperConvertor<Int>(
	ByteBufferWrapper::putInt,
	ByteBufferWrapper::getInt,
	Int::class.java,
)

/** [Long] 类型转换器，使用 putLong/getLong 读写。 */
class LongBufferWrapperConvertor : ObjectBufferWrapperConvertor<Long>(
	ByteBufferWrapper::putLong,
	ByteBufferWrapper::getLong,
	Long::class.java,
)

/** [Double] 类型转换器，使用 putDouble/getDouble 读写。 */
class DoubleBufferWrapperConvertor : ObjectBufferWrapperConvertor<Double>(
	ByteBufferWrapper::putDouble,
	ByteBufferWrapper::getDouble,
	Double::class.java,
)

/** [Float] 类型转换器，使用 putFloat/getFloat 读写。 */
class FloatBufferWrapperConvertor : ObjectBufferWrapperConvertor<Float>(
	ByteBufferWrapper::putFloat,
	ByteBufferWrapper::getFloat,
	Float::class.java,
)

/** [BigInteger] 类型转换器，使用 putBigInteger/getBigInteger 读写。 */
class BigIntegerBufferWrapperConvertor : ObjectBufferWrapperConvertor<BigInteger>(
	ByteBufferWrapper::putBigInteger,
	ByteBufferWrapper::getBigInteger,
	BigInteger::class.java,
)

/** [BigDecimal] 类型转换器，使用 putBigDecimal/getBigDecimal 读写。 */
class BigDecimalBufferWrapperConvertor : ObjectBufferWrapperConvertor<BigDecimal>(
	ByteBufferWrapper::putBigDecimal,
	ByteBufferWrapper::getBigDecimal,
	BigDecimal::class.java,
)

/** [Boolean] 类型转换器，使用 putBoolean/getBoolean 读写。 */
class BooleanBufferWrapperConvertor : ObjectBufferWrapperConvertor<Boolean>(
	ByteBufferWrapper::putBoolean,
	ByteBufferWrapper::getBoolean,
	Boolean::class.java,
)

/** [String] 类型转换器，使用 putString/getString 读写。 */
class StringBufferWrapperConvertor : ObjectBufferWrapperConvertor<String>(
	ByteBufferWrapper::putString,
	ByteBufferWrapper::getString,
	String::class.java,
)

/** [ByteFlags] 类型转换器，使用 putFlag/getFlag 读写。 */
class ByteFlagsBufferWrapperConvertor : ObjectBufferWrapperConvertor<ByteFlags>(
	ByteBufferWrapper::putFlag,
	ByteBufferWrapper::getFlag,
	ByteFlags::class.java,
)


/** Java [JUUID] 类型转换器，使用 putUUID/getJUUID 读写。 */
class JUUIDBufferWrapperConvertor : ObjectBufferWrapperConvertor<JUUID>(
	ByteBufferWrapper::putUUID,
	ByteBufferWrapper::getJUUID,
	JUUID::class.java,
)

/** 自定义 [UUID] 类型转换器，使用 putUUID/getUUID 读写。 */
class UUIDBufferWrapperConvertor : ObjectBufferWrapperConvertor<UUID>(
	ByteBufferWrapper::putUUID,
	ByteBufferWrapper::getUUID,
	UUID::class.java,
)

/** [DateTime] 类型转换器，使用 putDateTime/getDateTime 读写。 */
class DateTimeFlagsBufferWrapperConvertor : ObjectBufferWrapperConvertor<DateTime>(
	ByteBufferWrapper::putDateTime,
	ByteBufferWrapper::getDateTime,
	DateTime::class.java,
)

/** [LocalDateTime] 类型转换器，使用 putLocalDateTime/getLocalDateTime 读写。 */
class LocalDateTimeBufferWrapperConvertor : ObjectBufferWrapperConvertor<LocalDateTime>(
	ByteBufferWrapper::putLocalDateTime,
	ByteBufferWrapper::getLocalDateTime,
	LocalDateTime::class.java,
)

/** [Date] 类型转换器，使用 putDate/getDate 读写。 */
class DateBufferWrapperConvertor : ObjectBufferWrapperConvertor<Date>(
	ByteBufferWrapper::putDate,
	ByteBufferWrapper::getDate,
	Date::class.java,
)

/**
 * 基于读写函数构造的通用数组转换器。
 *
 * 读取时要求额外参数的第一个元素为 Int 类型的数组长度。
 *
 * @param T 该转换器处理的数组类型
 * @param write 写入函数，将数组写入缓冲区
 * @param read 读取函数，按指定长度从缓冲区读取数组
 * @param typer 该转换器处理的数组类型对应的 Class 对象
 */
abstract class ArrayBufferWrapperConvertor<T : Any>(
	val write: ByteBufferWrapper.(obj: T) -> Unit,
	val read: ByteBufferWrapper.(size: Int) -> T,
	val typer: Class<T>,
) : ByteBufferWrapperConvertor<T>() {
	override fun write(obj: T, byteBufferWrapper: ByteBufferWrapper) = write.invoke(byteBufferWrapper, obj)
	/**
	 * 从缓冲区读取数组，要求 parameters[0] 为 Int 类型的长度。
	 *
	 * @throws IllegalArgumentException 如果参数为空或第一个参数不是 Int
	 */
	override fun read(byteBufferWrapper: ByteBufferWrapper, parameters: Array<Any>): T {
		if (parameters.isEmpty()) {
			throw IllegalArgumentException("parameters cannot be empty, must has a Int")
		}
		val size = parameters[0]
		if (size !is Int)
			throw IllegalArgumentException("parameters[0] cannot be Int, must has a Int")
		return read.invoke(byteBufferWrapper, size)
	}

	override fun getType(): Class<T> = typer
}

/** [ByteArray] 类型转换器，使用 putByteArray/getByteArray 读写。 */
class ByteArrayBufferWrapperConvertor : ArrayBufferWrapperConvertor<ByteArray>(
	ByteBufferWrapper::putByteArray,
	ByteBufferWrapper::getByteArray,
	ByteArray::class.java,
)

/** [CharArray] 类型转换器，使用 putCharArray/getCharArray 读写。 */
class CharArrayBufferWrapperConvertor : ArrayBufferWrapperConvertor<CharArray>(
	ByteBufferWrapper::putCharArray,
	ByteBufferWrapper::getCharArray,
	CharArray::class.java,
)

/** [ShortArray] 类型转换器，使用 putShortArray/getShortArray 读写。 */
class ShortArrayBufferWrapperConvertor : ArrayBufferWrapperConvertor<ShortArray>(
	ByteBufferWrapper::putShortArray,
	ByteBufferWrapper::getShortArray,
	ShortArray::class.java,
)

/** [IntArray] 类型转换器，使用 putIntArray/getIntArray 读写。 */
class IntArrayBufferWrapperConvertor : ArrayBufferWrapperConvertor<IntArray>(
	ByteBufferWrapper::putIntArray,
	ByteBufferWrapper::getIntArray,
	IntArray::class.java,
)

/** [LongArray] 类型转换器，使用 putLongArray/getLongArray 读写。 */
class LongArrayBufferWrapperConvertor : ArrayBufferWrapperConvertor<LongArray>(
	ByteBufferWrapper::putLongArray,
	ByteBufferWrapper::getLongArray,
	LongArray::class.java,
)

/** [FloatArray] 类型转换器，使用 putFloatArray/getFloatArray 读写。 */
class FloatArrayBufferWrapperConvertor : ArrayBufferWrapperConvertor<FloatArray>(
	ByteBufferWrapper::putFloatArray,
	ByteBufferWrapper::getFloatArray,
	FloatArray::class.java,
)

/** [DoubleArray] 类型转换器，使用 putDoubleArray/getDoubleArray 读写。 */
class DoubleArrayBufferWrapperConvertor : ArrayBufferWrapperConvertor<DoubleArray>(
	ByteBufferWrapper::putDoubleArray,
	ByteBufferWrapper::getDoubleArray,
	DoubleArray::class.java,
)


/** [BooleanArray] 类型转换器，使用 putBooleanArray/getBooleanArray 读写。 */
class BooleanArrayBufferWrapperConvertor : ArrayBufferWrapperConvertor<BooleanArray>(
	ByteBufferWrapper::putBooleanArray,
	ByteBufferWrapper::getBooleanArray,
	BooleanArray::class.java,
)
