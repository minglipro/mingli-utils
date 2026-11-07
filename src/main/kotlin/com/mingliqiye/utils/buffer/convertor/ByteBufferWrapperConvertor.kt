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

interface ByteBufferWrapperConvertorInterface<T : Any> {
	fun write(obj: T, byteBufferWrapper: ByteBufferWrapper)
	fun read(byteBufferWrapper: ByteBufferWrapper, parameters: Array<Any>): T
	fun getType(): Class<T>
}

abstract class ByteBufferWrapperConvertor<T : Any> : ByteBufferWrapperConvertorInterface<T> {
	override fun toString(): String {
		return "ByteBufferWrapperConvertor(type=${getType()})"
	}

	companion object {
		private val _instantiations =
			ConcurrentHashMap<Class<ByteBufferWrapperConvertor<*>>, ByteBufferWrapperConvertor<*>>()

		@JvmStatic
		fun getInstantiation(clazz: Class<ByteBufferWrapperConvertor<*>>): ByteBufferWrapperConvertor<*> {
			return _instantiations.getOrPut(clazz) {
				clazz.getConstructor().newInstance()
			}
		}

		@JvmStatic
		@Suppress("UNCHECKED_CAST")
		inline fun <reified T : ByteBufferWrapperConvertor<*>> getInstantiation(): ByteBufferWrapperConvertor<*> {
			return getInstantiation(T::class.java as Class<ByteBufferWrapperConvertor<*>>)
		}

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


class BytedBufferWrapperConvertor : ObjectBufferWrapperConvertor<Byte>(
	ByteBufferWrapper::putByte,
	ByteBufferWrapper::getByte,
	Byte::class.java,
)

class CharBufferWrapperConvertor : ObjectBufferWrapperConvertor<Char>(
	ByteBufferWrapper::putChar,
	ByteBufferWrapper::getChar,
	Char::class.java,
)

class ShortBufferWrapperConvertor : ObjectBufferWrapperConvertor<Short>(
	ByteBufferWrapper::putShort,
	ByteBufferWrapper::getShort,
	Short::class.java,
)

class IntBufferWrapperConvertor : ObjectBufferWrapperConvertor<Int>(
	ByteBufferWrapper::putInt,
	ByteBufferWrapper::getInt,
	Int::class.java,
)

class LongBufferWrapperConvertor : ObjectBufferWrapperConvertor<Long>(
	ByteBufferWrapper::putLong,
	ByteBufferWrapper::getLong,
	Long::class.java,
)

class DoubleBufferWrapperConvertor : ObjectBufferWrapperConvertor<Double>(
	ByteBufferWrapper::putDouble,
	ByteBufferWrapper::getDouble,
	Double::class.java,
)

class FloatBufferWrapperConvertor : ObjectBufferWrapperConvertor<Float>(
	ByteBufferWrapper::putFloat,
	ByteBufferWrapper::getFloat,
	Float::class.java,
)

class BigIntegerBufferWrapperConvertor : ObjectBufferWrapperConvertor<BigInteger>(
	ByteBufferWrapper::putBigInteger,
	ByteBufferWrapper::getBigInteger,
	BigInteger::class.java,
)

class BigDecimalBufferWrapperConvertor : ObjectBufferWrapperConvertor<BigDecimal>(
	ByteBufferWrapper::putBigDecimal,
	ByteBufferWrapper::getBigDecimal,
	BigDecimal::class.java,
)

class BooleanBufferWrapperConvertor : ObjectBufferWrapperConvertor<Boolean>(
	ByteBufferWrapper::putBoolean,
	ByteBufferWrapper::getBoolean,
	Boolean::class.java,
)

class StringBufferWrapperConvertor : ObjectBufferWrapperConvertor<String>(
	ByteBufferWrapper::putString,
	ByteBufferWrapper::getString,
	String::class.java,
)

class ByteFlagsBufferWrapperConvertor : ObjectBufferWrapperConvertor<ByteFlags>(
	ByteBufferWrapper::putFlag,
	ByteBufferWrapper::getFlag,
	ByteFlags::class.java,
)


class JUUIDBufferWrapperConvertor : ObjectBufferWrapperConvertor<JUUID>(
	ByteBufferWrapper::putUUID,
	ByteBufferWrapper::getJUUID,
	JUUID::class.java,
)

class UUIDBufferWrapperConvertor : ObjectBufferWrapperConvertor<UUID>(
	ByteBufferWrapper::putUUID,
	ByteBufferWrapper::getUUID,
	UUID::class.java,
)

class DateTimeFlagsBufferWrapperConvertor : ObjectBufferWrapperConvertor<DateTime>(
	ByteBufferWrapper::putDateTime,
	ByteBufferWrapper::getDateTime,
	DateTime::class.java,
)

class LocalDateTimeBufferWrapperConvertor : ObjectBufferWrapperConvertor<LocalDateTime>(
	ByteBufferWrapper::putLocalDateTime,
	ByteBufferWrapper::getLocalDateTime,
	LocalDateTime::class.java,
)

class DateBufferWrapperConvertor : ObjectBufferWrapperConvertor<Date>(
	ByteBufferWrapper::putDate,
	ByteBufferWrapper::getDate,
	Date::class.java,
)

abstract class ArrayBufferWrapperConvertor<T : Any>(
	val write: ByteBufferWrapper.(obj: T) -> Unit,
	val read: ByteBufferWrapper.(size: Int) -> T,
	val typer: Class<T>,
) : ByteBufferWrapperConvertor<T>() {
	override fun write(obj: T, byteBufferWrapper: ByteBufferWrapper) = write.invoke(byteBufferWrapper, obj)
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

class ByteArrayBufferWrapperConvertor : ArrayBufferWrapperConvertor<ByteArray>(
	ByteBufferWrapper::putByteArray,
	ByteBufferWrapper::getByteArray,
	ByteArray::class.java,
)

class CharArrayBufferWrapperConvertor : ArrayBufferWrapperConvertor<CharArray>(
	ByteBufferWrapper::putCharArray,
	ByteBufferWrapper::getCharArray,
	CharArray::class.java,
)

class ShortArrayBufferWrapperConvertor : ArrayBufferWrapperConvertor<ShortArray>(
	ByteBufferWrapper::putShortArray,
	ByteBufferWrapper::getShortArray,
	ShortArray::class.java,
)

class IntArrayBufferWrapperConvertor : ArrayBufferWrapperConvertor<IntArray>(
	ByteBufferWrapper::putIntArray,
	ByteBufferWrapper::getIntArray,
	IntArray::class.java,
)

class LongArrayBufferWrapperConvertor : ArrayBufferWrapperConvertor<LongArray>(
	ByteBufferWrapper::putLongArray,
	ByteBufferWrapper::getLongArray,
	LongArray::class.java,
)

class FloatArrayBufferWrapperConvertor : ArrayBufferWrapperConvertor<FloatArray>(
	ByteBufferWrapper::putFloatArray,
	ByteBufferWrapper::getFloatArray,
	FloatArray::class.java,
)

class DoubleArrayBufferWrapperConvertor : ArrayBufferWrapperConvertor<DoubleArray>(
	ByteBufferWrapper::putDoubleArray,
	ByteBufferWrapper::getDoubleArray,
	DoubleArray::class.java,
)


class BooleanArrayBufferWrapperConvertor : ArrayBufferWrapperConvertor<BooleanArray>(
	ByteBufferWrapper::putBooleanArray,
	ByteBufferWrapper::getBooleanArray,
	BooleanArray::class.java,
)
