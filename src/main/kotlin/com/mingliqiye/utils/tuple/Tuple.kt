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
 * CurrentFile Tuple.kt
 * LastUpdate 2026-06-21 10:40:58
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.tuple

/**
 * 1 元组，持有 1 个元素（t1 ~ t1），支持解构声明。
 */
class Tuple1<T1>(
	/** 第 1 个元素。 */
	val t1: T1,
) : Tuple(1) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
}

/**
 * 2 元组，持有 2 个元素（t1 ~ t2），支持解构声明。
 */
class Tuple2<T1, T2>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
) : Tuple(2) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
}

/**
 * 3 元组，持有 3 个元素（t1 ~ t3），支持解构声明。
 */
class Tuple3<T1, T2, T3>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
) : Tuple(3) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
}

/**
 * 4 元组，持有 4 个元素（t1 ~ t4），支持解构声明。
 */
class Tuple4<T1, T2, T3, T4>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
) : Tuple(4) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
}

/**
 * 5 元组，持有 5 个元素（t1 ~ t5），支持解构声明。
 */
class Tuple5<T1, T2, T3, T4, T5>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
) : Tuple(5) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
}

/**
 * 6 元组，持有 6 个元素（t1 ~ t6），支持解构声明。
 */
class Tuple6<T1, T2, T3, T4, T5, T6>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
) : Tuple(6) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
}

/**
 * 7 元组，持有 7 个元素（t1 ~ t7），支持解构声明。
 */
class Tuple7<T1, T2, T3, T4, T5, T6, T7>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
) : Tuple(7) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
}

/**
 * 8 元组，持有 8 个元素（t1 ~ t8），支持解构声明。
 */
class Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
) : Tuple(8) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
}

/**
 * 9 元组，持有 9 个元素（t1 ~ t9），支持解构声明。
 */
class Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
) : Tuple(9) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
}

/**
 * 10 元组，持有 10 个元素（t1 ~ t10），支持解构声明。
 */
class Tuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
) : Tuple(10) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
}

/**
 * 11 元组，持有 11 个元素（t1 ~ t11），支持解构声明。
 */
class Tuple11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
) : Tuple(11) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
}

/**
 * 12 元组，持有 12 个元素（t1 ~ t12），支持解构声明。
 */
class Tuple12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
) : Tuple(12) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
}

/**
 * 13 元组，持有 13 个元素（t1 ~ t13），支持解构声明。
 */
class Tuple13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
) : Tuple(13) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
}

/**
 * 14 元组，持有 14 个元素（t1 ~ t14），支持解构声明。
 */
class Tuple14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
) : Tuple(14) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
}

/**
 * 15 元组，持有 15 个元素（t1 ~ t15），支持解构声明。
 */
class Tuple15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
) : Tuple(15) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
}

/**
 * 16 元组，持有 16 个元素（t1 ~ t16），支持解构声明。
 */
class Tuple16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
) : Tuple(16) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
}

/**
 * 17 元组，持有 17 个元素（t1 ~ t17），支持解构声明。
 */
class Tuple17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
) : Tuple(17) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
}

/**
 * 18 元组，持有 18 个元素（t1 ~ t18），支持解构声明。
 */
class Tuple18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
) : Tuple(18) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
}

/**
 * 19 元组，持有 19 个元素（t1 ~ t19），支持解构声明。
 */
class Tuple19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
) : Tuple(19) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
}

/**
 * 20 元组，持有 20 个元素（t1 ~ t20），支持解构声明。
 */
class Tuple20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
) : Tuple(20) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
}

/**
 * 21 元组，持有 21 个元素（t1 ~ t21），支持解构声明。
 */
class Tuple21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
) : Tuple(21) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
}

/**
 * 22 元组，持有 22 个元素（t1 ~ t22），支持解构声明。
 */
class Tuple22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
) : Tuple(22) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
}

/**
 * 23 元组，持有 23 个元素（t1 ~ t23），支持解构声明。
 */
class Tuple23<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
) : Tuple(23) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
}

/**
 * 24 元组，持有 24 个元素（t1 ~ t24），支持解构声明。
 */
class Tuple24<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
) : Tuple(24) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
}

/**
 * 25 元组，持有 25 个元素（t1 ~ t25），支持解构声明。
 */
class Tuple25<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
) : Tuple(25) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
}

/**
 * 26 元组，持有 26 个元素（t1 ~ t26），支持解构声明。
 */
class Tuple26<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
) : Tuple(26) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
}

/**
 * 27 元组，持有 27 个元素（t1 ~ t27），支持解构声明。
 */
class Tuple27<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
) : Tuple(27) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
}

/**
 * 28 元组，持有 28 个元素（t1 ~ t28），支持解构声明。
 */
class Tuple28<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
) : Tuple(28) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
}

/**
 * 29 元组，持有 29 个元素（t1 ~ t29），支持解构声明。
 */
class Tuple29<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
) : Tuple(29) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
}

/**
 * 30 元组，持有 30 个元素（t1 ~ t30），支持解构声明。
 */
class Tuple30<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
) : Tuple(30) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
}

/**
 * 31 元组，持有 31 个元素（t1 ~ t31），支持解构声明。
 */
class Tuple31<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
) : Tuple(31) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
}

/**
 * 32 元组，持有 32 个元素（t1 ~ t32），支持解构声明。
 */
class Tuple32<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
) : Tuple(32) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
}

/**
 * 33 元组，持有 33 个元素（t1 ~ t33），支持解构声明。
 */
class Tuple33<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
) : Tuple(33) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
}

/**
 * 34 元组，持有 34 个元素（t1 ~ t34），支持解构声明。
 */
class Tuple34<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
) : Tuple(34) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
}

/**
 * 35 元组，持有 35 个元素（t1 ~ t35），支持解构声明。
 */
class Tuple35<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
) : Tuple(35) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
}

/**
 * 36 元组，持有 36 个元素（t1 ~ t36），支持解构声明。
 */
class Tuple36<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
) : Tuple(36) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
}

/**
 * 37 元组，持有 37 个元素（t1 ~ t37），支持解构声明。
 */
class Tuple37<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
) : Tuple(37) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
}

/**
 * 38 元组，持有 38 个元素（t1 ~ t38），支持解构声明。
 */
class Tuple38<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
) : Tuple(38) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
}

/**
 * 39 元组，持有 39 个元素（t1 ~ t39），支持解构声明。
 */
class Tuple39<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
) : Tuple(39) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
}

/**
 * 40 元组，持有 40 个元素（t1 ~ t40），支持解构声明。
 */
class Tuple40<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
) : Tuple(40) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
}

/**
 * 41 元组，持有 41 个元素（t1 ~ t41），支持解构声明。
 */
class Tuple41<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
) : Tuple(41) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
}

/**
 * 42 元组，持有 42 个元素（t1 ~ t42），支持解构声明。
 */
class Tuple42<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
) : Tuple(42) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
}

/**
 * 43 元组，持有 43 个元素（t1 ~ t43），支持解构声明。
 */
class Tuple43<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
) : Tuple(43) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
}

/**
 * 44 元组，持有 44 个元素（t1 ~ t44），支持解构声明。
 */
class Tuple44<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
) : Tuple(44) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
}

/**
 * 45 元组，持有 45 个元素（t1 ~ t45），支持解构声明。
 */
class Tuple45<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
) : Tuple(45) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
}

/**
 * 46 元组，持有 46 个元素（t1 ~ t46），支持解构声明。
 */
class Tuple46<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
) : Tuple(46) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
}

/**
 * 47 元组，持有 47 个元素（t1 ~ t47），支持解构声明。
 */
class Tuple47<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
) : Tuple(47) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
}

/**
 * 48 元组，持有 48 个元素（t1 ~ t48），支持解构声明。
 */
class Tuple48<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
) : Tuple(48) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
}

/**
 * 49 元组，持有 49 个元素（t1 ~ t49），支持解构声明。
 */
class Tuple49<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
) : Tuple(49) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
}

/**
 * 50 元组，持有 50 个元素（t1 ~ t50），支持解构声明。
 */
class Tuple50<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
) : Tuple(50) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
}

/**
 * 51 元组，持有 51 个元素（t1 ~ t51），支持解构声明。
 */
class Tuple51<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
) : Tuple(51) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
}

/**
 * 52 元组，持有 52 个元素（t1 ~ t52），支持解构声明。
 */
class Tuple52<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
) : Tuple(52) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
}

/**
 * 53 元组，持有 53 个元素（t1 ~ t53），支持解构声明。
 */
class Tuple53<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
) : Tuple(53) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
}

/**
 * 54 元组，持有 54 个元素（t1 ~ t54），支持解构声明。
 */
class Tuple54<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
) : Tuple(54) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
}

/**
 * 55 元组，持有 55 个元素（t1 ~ t55），支持解构声明。
 */
class Tuple55<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
) : Tuple(55) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
}

/**
 * 56 元组，持有 56 个元素（t1 ~ t56），支持解构声明。
 */
class Tuple56<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
) : Tuple(56) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
}

/**
 * 57 元组，持有 57 个元素（t1 ~ t57），支持解构声明。
 */
class Tuple57<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
) : Tuple(57) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
}

/**
 * 58 元组，持有 58 个元素（t1 ~ t58），支持解构声明。
 */
class Tuple58<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
	/** 第 58 个元素。 */
	val t58: T58,
) : Tuple(58) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
	/** 返回第 58 个元素 [t58]，用于解构声明。 */
	operator fun component58(): T58 = t58
}

/**
 * 59 元组，持有 59 个元素（t1 ~ t59），支持解构声明。
 */
class Tuple59<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
	/** 第 58 个元素。 */
	val t58: T58,
	/** 第 59 个元素。 */
	val t59: T59,
) : Tuple(59) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
	/** 返回第 58 个元素 [t58]，用于解构声明。 */
	operator fun component58(): T58 = t58
	/** 返回第 59 个元素 [t59]，用于解构声明。 */
	operator fun component59(): T59 = t59
}

/**
 * 60 元组，持有 60 个元素（t1 ~ t60），支持解构声明。
 */
class Tuple60<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
	/** 第 58 个元素。 */
	val t58: T58,
	/** 第 59 个元素。 */
	val t59: T59,
	/** 第 60 个元素。 */
	val t60: T60,
) : Tuple(60) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
	/** 返回第 58 个元素 [t58]，用于解构声明。 */
	operator fun component58(): T58 = t58
	/** 返回第 59 个元素 [t59]，用于解构声明。 */
	operator fun component59(): T59 = t59
	/** 返回第 60 个元素 [t60]，用于解构声明。 */
	operator fun component60(): T60 = t60
}

/**
 * 61 元组，持有 61 个元素（t1 ~ t61），支持解构声明。
 */
class Tuple61<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
	/** 第 58 个元素。 */
	val t58: T58,
	/** 第 59 个元素。 */
	val t59: T59,
	/** 第 60 个元素。 */
	val t60: T60,
	/** 第 61 个元素。 */
	val t61: T61,
) : Tuple(61) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
	/** 返回第 58 个元素 [t58]，用于解构声明。 */
	operator fun component58(): T58 = t58
	/** 返回第 59 个元素 [t59]，用于解构声明。 */
	operator fun component59(): T59 = t59
	/** 返回第 60 个元素 [t60]，用于解构声明。 */
	operator fun component60(): T60 = t60
	/** 返回第 61 个元素 [t61]，用于解构声明。 */
	operator fun component61(): T61 = t61
}

/**
 * 62 元组，持有 62 个元素（t1 ~ t62），支持解构声明。
 */
class Tuple62<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
	/** 第 58 个元素。 */
	val t58: T58,
	/** 第 59 个元素。 */
	val t59: T59,
	/** 第 60 个元素。 */
	val t60: T60,
	/** 第 61 个元素。 */
	val t61: T61,
	/** 第 62 个元素。 */
	val t62: T62,
) : Tuple(62) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
	/** 返回第 58 个元素 [t58]，用于解构声明。 */
	operator fun component58(): T58 = t58
	/** 返回第 59 个元素 [t59]，用于解构声明。 */
	operator fun component59(): T59 = t59
	/** 返回第 60 个元素 [t60]，用于解构声明。 */
	operator fun component60(): T60 = t60
	/** 返回第 61 个元素 [t61]，用于解构声明。 */
	operator fun component61(): T61 = t61
	/** 返回第 62 个元素 [t62]，用于解构声明。 */
	operator fun component62(): T62 = t62
}

/**
 * 63 元组，持有 63 个元素（t1 ~ t63），支持解构声明。
 */
class Tuple63<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
	/** 第 58 个元素。 */
	val t58: T58,
	/** 第 59 个元素。 */
	val t59: T59,
	/** 第 60 个元素。 */
	val t60: T60,
	/** 第 61 个元素。 */
	val t61: T61,
	/** 第 62 个元素。 */
	val t62: T62,
	/** 第 63 个元素。 */
	val t63: T63,
) : Tuple(63) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
	/** 返回第 58 个元素 [t58]，用于解构声明。 */
	operator fun component58(): T58 = t58
	/** 返回第 59 个元素 [t59]，用于解构声明。 */
	operator fun component59(): T59 = t59
	/** 返回第 60 个元素 [t60]，用于解构声明。 */
	operator fun component60(): T60 = t60
	/** 返回第 61 个元素 [t61]，用于解构声明。 */
	operator fun component61(): T61 = t61
	/** 返回第 62 个元素 [t62]，用于解构声明。 */
	operator fun component62(): T62 = t62
	/** 返回第 63 个元素 [t63]，用于解构声明。 */
	operator fun component63(): T63 = t63
}

/**
 * 64 元组，持有 64 个元素（t1 ~ t64），支持解构声明。
 */
class Tuple64<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
	/** 第 58 个元素。 */
	val t58: T58,
	/** 第 59 个元素。 */
	val t59: T59,
	/** 第 60 个元素。 */
	val t60: T60,
	/** 第 61 个元素。 */
	val t61: T61,
	/** 第 62 个元素。 */
	val t62: T62,
	/** 第 63 个元素。 */
	val t63: T63,
	/** 第 64 个元素。 */
	val t64: T64,
) : Tuple(64) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
	/** 返回第 58 个元素 [t58]，用于解构声明。 */
	operator fun component58(): T58 = t58
	/** 返回第 59 个元素 [t59]，用于解构声明。 */
	operator fun component59(): T59 = t59
	/** 返回第 60 个元素 [t60]，用于解构声明。 */
	operator fun component60(): T60 = t60
	/** 返回第 61 个元素 [t61]，用于解构声明。 */
	operator fun component61(): T61 = t61
	/** 返回第 62 个元素 [t62]，用于解构声明。 */
	operator fun component62(): T62 = t62
	/** 返回第 63 个元素 [t63]，用于解构声明。 */
	operator fun component63(): T63 = t63
	/** 返回第 64 个元素 [t64]，用于解构声明。 */
	operator fun component64(): T64 = t64
}

/**
 * 65 元组，持有 65 个元素（t1 ~ t65），支持解构声明。
 */
class Tuple65<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
	/** 第 58 个元素。 */
	val t58: T58,
	/** 第 59 个元素。 */
	val t59: T59,
	/** 第 60 个元素。 */
	val t60: T60,
	/** 第 61 个元素。 */
	val t61: T61,
	/** 第 62 个元素。 */
	val t62: T62,
	/** 第 63 个元素。 */
	val t63: T63,
	/** 第 64 个元素。 */
	val t64: T64,
	/** 第 65 个元素。 */
	val t65: T65,
) : Tuple(65) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
	/** 返回第 58 个元素 [t58]，用于解构声明。 */
	operator fun component58(): T58 = t58
	/** 返回第 59 个元素 [t59]，用于解构声明。 */
	operator fun component59(): T59 = t59
	/** 返回第 60 个元素 [t60]，用于解构声明。 */
	operator fun component60(): T60 = t60
	/** 返回第 61 个元素 [t61]，用于解构声明。 */
	operator fun component61(): T61 = t61
	/** 返回第 62 个元素 [t62]，用于解构声明。 */
	operator fun component62(): T62 = t62
	/** 返回第 63 个元素 [t63]，用于解构声明。 */
	operator fun component63(): T63 = t63
	/** 返回第 64 个元素 [t64]，用于解构声明。 */
	operator fun component64(): T64 = t64
	/** 返回第 65 个元素 [t65]，用于解构声明。 */
	operator fun component65(): T65 = t65
}

/**
 * 66 元组，持有 66 个元素（t1 ~ t66），支持解构声明。
 */
class Tuple66<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
	/** 第 58 个元素。 */
	val t58: T58,
	/** 第 59 个元素。 */
	val t59: T59,
	/** 第 60 个元素。 */
	val t60: T60,
	/** 第 61 个元素。 */
	val t61: T61,
	/** 第 62 个元素。 */
	val t62: T62,
	/** 第 63 个元素。 */
	val t63: T63,
	/** 第 64 个元素。 */
	val t64: T64,
	/** 第 65 个元素。 */
	val t65: T65,
	/** 第 66 个元素。 */
	val t66: T66,
) : Tuple(66) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
	/** 返回第 58 个元素 [t58]，用于解构声明。 */
	operator fun component58(): T58 = t58
	/** 返回第 59 个元素 [t59]，用于解构声明。 */
	operator fun component59(): T59 = t59
	/** 返回第 60 个元素 [t60]，用于解构声明。 */
	operator fun component60(): T60 = t60
	/** 返回第 61 个元素 [t61]，用于解构声明。 */
	operator fun component61(): T61 = t61
	/** 返回第 62 个元素 [t62]，用于解构声明。 */
	operator fun component62(): T62 = t62
	/** 返回第 63 个元素 [t63]，用于解构声明。 */
	operator fun component63(): T63 = t63
	/** 返回第 64 个元素 [t64]，用于解构声明。 */
	operator fun component64(): T64 = t64
	/** 返回第 65 个元素 [t65]，用于解构声明。 */
	operator fun component65(): T65 = t65
	/** 返回第 66 个元素 [t66]，用于解构声明。 */
	operator fun component66(): T66 = t66
}

/**
 * 67 元组，持有 67 个元素（t1 ~ t67），支持解构声明。
 */
class Tuple67<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
	/** 第 58 个元素。 */
	val t58: T58,
	/** 第 59 个元素。 */
	val t59: T59,
	/** 第 60 个元素。 */
	val t60: T60,
	/** 第 61 个元素。 */
	val t61: T61,
	/** 第 62 个元素。 */
	val t62: T62,
	/** 第 63 个元素。 */
	val t63: T63,
	/** 第 64 个元素。 */
	val t64: T64,
	/** 第 65 个元素。 */
	val t65: T65,
	/** 第 66 个元素。 */
	val t66: T66,
	/** 第 67 个元素。 */
	val t67: T67,
) : Tuple(67) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
	/** 返回第 58 个元素 [t58]，用于解构声明。 */
	operator fun component58(): T58 = t58
	/** 返回第 59 个元素 [t59]，用于解构声明。 */
	operator fun component59(): T59 = t59
	/** 返回第 60 个元素 [t60]，用于解构声明。 */
	operator fun component60(): T60 = t60
	/** 返回第 61 个元素 [t61]，用于解构声明。 */
	operator fun component61(): T61 = t61
	/** 返回第 62 个元素 [t62]，用于解构声明。 */
	operator fun component62(): T62 = t62
	/** 返回第 63 个元素 [t63]，用于解构声明。 */
	operator fun component63(): T63 = t63
	/** 返回第 64 个元素 [t64]，用于解构声明。 */
	operator fun component64(): T64 = t64
	/** 返回第 65 个元素 [t65]，用于解构声明。 */
	operator fun component65(): T65 = t65
	/** 返回第 66 个元素 [t66]，用于解构声明。 */
	operator fun component66(): T66 = t66
	/** 返回第 67 个元素 [t67]，用于解构声明。 */
	operator fun component67(): T67 = t67
}

/**
 * 68 元组，持有 68 个元素（t1 ~ t68），支持解构声明。
 */
class Tuple68<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
	/** 第 58 个元素。 */
	val t58: T58,
	/** 第 59 个元素。 */
	val t59: T59,
	/** 第 60 个元素。 */
	val t60: T60,
	/** 第 61 个元素。 */
	val t61: T61,
	/** 第 62 个元素。 */
	val t62: T62,
	/** 第 63 个元素。 */
	val t63: T63,
	/** 第 64 个元素。 */
	val t64: T64,
	/** 第 65 个元素。 */
	val t65: T65,
	/** 第 66 个元素。 */
	val t66: T66,
	/** 第 67 个元素。 */
	val t67: T67,
	/** 第 68 个元素。 */
	val t68: T68,
) : Tuple(68) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
	/** 返回第 58 个元素 [t58]，用于解构声明。 */
	operator fun component58(): T58 = t58
	/** 返回第 59 个元素 [t59]，用于解构声明。 */
	operator fun component59(): T59 = t59
	/** 返回第 60 个元素 [t60]，用于解构声明。 */
	operator fun component60(): T60 = t60
	/** 返回第 61 个元素 [t61]，用于解构声明。 */
	operator fun component61(): T61 = t61
	/** 返回第 62 个元素 [t62]，用于解构声明。 */
	operator fun component62(): T62 = t62
	/** 返回第 63 个元素 [t63]，用于解构声明。 */
	operator fun component63(): T63 = t63
	/** 返回第 64 个元素 [t64]，用于解构声明。 */
	operator fun component64(): T64 = t64
	/** 返回第 65 个元素 [t65]，用于解构声明。 */
	operator fun component65(): T65 = t65
	/** 返回第 66 个元素 [t66]，用于解构声明。 */
	operator fun component66(): T66 = t66
	/** 返回第 67 个元素 [t67]，用于解构声明。 */
	operator fun component67(): T67 = t67
	/** 返回第 68 个元素 [t68]，用于解构声明。 */
	operator fun component68(): T68 = t68
}

/**
 * 69 元组，持有 69 个元素（t1 ~ t69），支持解构声明。
 */
class Tuple69<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
	/** 第 58 个元素。 */
	val t58: T58,
	/** 第 59 个元素。 */
	val t59: T59,
	/** 第 60 个元素。 */
	val t60: T60,
	/** 第 61 个元素。 */
	val t61: T61,
	/** 第 62 个元素。 */
	val t62: T62,
	/** 第 63 个元素。 */
	val t63: T63,
	/** 第 64 个元素。 */
	val t64: T64,
	/** 第 65 个元素。 */
	val t65: T65,
	/** 第 66 个元素。 */
	val t66: T66,
	/** 第 67 个元素。 */
	val t67: T67,
	/** 第 68 个元素。 */
	val t68: T68,
	/** 第 69 个元素。 */
	val t69: T69,
) : Tuple(69) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
	/** 返回第 58 个元素 [t58]，用于解构声明。 */
	operator fun component58(): T58 = t58
	/** 返回第 59 个元素 [t59]，用于解构声明。 */
	operator fun component59(): T59 = t59
	/** 返回第 60 个元素 [t60]，用于解构声明。 */
	operator fun component60(): T60 = t60
	/** 返回第 61 个元素 [t61]，用于解构声明。 */
	operator fun component61(): T61 = t61
	/** 返回第 62 个元素 [t62]，用于解构声明。 */
	operator fun component62(): T62 = t62
	/** 返回第 63 个元素 [t63]，用于解构声明。 */
	operator fun component63(): T63 = t63
	/** 返回第 64 个元素 [t64]，用于解构声明。 */
	operator fun component64(): T64 = t64
	/** 返回第 65 个元素 [t65]，用于解构声明。 */
	operator fun component65(): T65 = t65
	/** 返回第 66 个元素 [t66]，用于解构声明。 */
	operator fun component66(): T66 = t66
	/** 返回第 67 个元素 [t67]，用于解构声明。 */
	operator fun component67(): T67 = t67
	/** 返回第 68 个元素 [t68]，用于解构声明。 */
	operator fun component68(): T68 = t68
	/** 返回第 69 个元素 [t69]，用于解构声明。 */
	operator fun component69(): T69 = t69
}

/**
 * 70 元组，持有 70 个元素（t1 ~ t70），支持解构声明。
 */
class Tuple70<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
	/** 第 58 个元素。 */
	val t58: T58,
	/** 第 59 个元素。 */
	val t59: T59,
	/** 第 60 个元素。 */
	val t60: T60,
	/** 第 61 个元素。 */
	val t61: T61,
	/** 第 62 个元素。 */
	val t62: T62,
	/** 第 63 个元素。 */
	val t63: T63,
	/** 第 64 个元素。 */
	val t64: T64,
	/** 第 65 个元素。 */
	val t65: T65,
	/** 第 66 个元素。 */
	val t66: T66,
	/** 第 67 个元素。 */
	val t67: T67,
	/** 第 68 个元素。 */
	val t68: T68,
	/** 第 69 个元素。 */
	val t69: T69,
	/** 第 70 个元素。 */
	val t70: T70,
) : Tuple(70) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
	/** 返回第 58 个元素 [t58]，用于解构声明。 */
	operator fun component58(): T58 = t58
	/** 返回第 59 个元素 [t59]，用于解构声明。 */
	operator fun component59(): T59 = t59
	/** 返回第 60 个元素 [t60]，用于解构声明。 */
	operator fun component60(): T60 = t60
	/** 返回第 61 个元素 [t61]，用于解构声明。 */
	operator fun component61(): T61 = t61
	/** 返回第 62 个元素 [t62]，用于解构声明。 */
	operator fun component62(): T62 = t62
	/** 返回第 63 个元素 [t63]，用于解构声明。 */
	operator fun component63(): T63 = t63
	/** 返回第 64 个元素 [t64]，用于解构声明。 */
	operator fun component64(): T64 = t64
	/** 返回第 65 个元素 [t65]，用于解构声明。 */
	operator fun component65(): T65 = t65
	/** 返回第 66 个元素 [t66]，用于解构声明。 */
	operator fun component66(): T66 = t66
	/** 返回第 67 个元素 [t67]，用于解构声明。 */
	operator fun component67(): T67 = t67
	/** 返回第 68 个元素 [t68]，用于解构声明。 */
	operator fun component68(): T68 = t68
	/** 返回第 69 个元素 [t69]，用于解构声明。 */
	operator fun component69(): T69 = t69
	/** 返回第 70 个元素 [t70]，用于解构声明。 */
	operator fun component70(): T70 = t70
}

/**
 * 71 元组，持有 71 个元素（t1 ~ t71），支持解构声明。
 */
class Tuple71<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
	/** 第 58 个元素。 */
	val t58: T58,
	/** 第 59 个元素。 */
	val t59: T59,
	/** 第 60 个元素。 */
	val t60: T60,
	/** 第 61 个元素。 */
	val t61: T61,
	/** 第 62 个元素。 */
	val t62: T62,
	/** 第 63 个元素。 */
	val t63: T63,
	/** 第 64 个元素。 */
	val t64: T64,
	/** 第 65 个元素。 */
	val t65: T65,
	/** 第 66 个元素。 */
	val t66: T66,
	/** 第 67 个元素。 */
	val t67: T67,
	/** 第 68 个元素。 */
	val t68: T68,
	/** 第 69 个元素。 */
	val t69: T69,
	/** 第 70 个元素。 */
	val t70: T70,
	/** 第 71 个元素。 */
	val t71: T71,
) : Tuple(71) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
	/** 返回第 58 个元素 [t58]，用于解构声明。 */
	operator fun component58(): T58 = t58
	/** 返回第 59 个元素 [t59]，用于解构声明。 */
	operator fun component59(): T59 = t59
	/** 返回第 60 个元素 [t60]，用于解构声明。 */
	operator fun component60(): T60 = t60
	/** 返回第 61 个元素 [t61]，用于解构声明。 */
	operator fun component61(): T61 = t61
	/** 返回第 62 个元素 [t62]，用于解构声明。 */
	operator fun component62(): T62 = t62
	/** 返回第 63 个元素 [t63]，用于解构声明。 */
	operator fun component63(): T63 = t63
	/** 返回第 64 个元素 [t64]，用于解构声明。 */
	operator fun component64(): T64 = t64
	/** 返回第 65 个元素 [t65]，用于解构声明。 */
	operator fun component65(): T65 = t65
	/** 返回第 66 个元素 [t66]，用于解构声明。 */
	operator fun component66(): T66 = t66
	/** 返回第 67 个元素 [t67]，用于解构声明。 */
	operator fun component67(): T67 = t67
	/** 返回第 68 个元素 [t68]，用于解构声明。 */
	operator fun component68(): T68 = t68
	/** 返回第 69 个元素 [t69]，用于解构声明。 */
	operator fun component69(): T69 = t69
	/** 返回第 70 个元素 [t70]，用于解构声明。 */
	operator fun component70(): T70 = t70
	/** 返回第 71 个元素 [t71]，用于解构声明。 */
	operator fun component71(): T71 = t71
}

/**
 * 72 元组，持有 72 个元素（t1 ~ t72），支持解构声明。
 */
class Tuple72<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
	/** 第 58 个元素。 */
	val t58: T58,
	/** 第 59 个元素。 */
	val t59: T59,
	/** 第 60 个元素。 */
	val t60: T60,
	/** 第 61 个元素。 */
	val t61: T61,
	/** 第 62 个元素。 */
	val t62: T62,
	/** 第 63 个元素。 */
	val t63: T63,
	/** 第 64 个元素。 */
	val t64: T64,
	/** 第 65 个元素。 */
	val t65: T65,
	/** 第 66 个元素。 */
	val t66: T66,
	/** 第 67 个元素。 */
	val t67: T67,
	/** 第 68 个元素。 */
	val t68: T68,
	/** 第 69 个元素。 */
	val t69: T69,
	/** 第 70 个元素。 */
	val t70: T70,
	/** 第 71 个元素。 */
	val t71: T71,
	/** 第 72 个元素。 */
	val t72: T72,
) : Tuple(72) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
	/** 返回第 58 个元素 [t58]，用于解构声明。 */
	operator fun component58(): T58 = t58
	/** 返回第 59 个元素 [t59]，用于解构声明。 */
	operator fun component59(): T59 = t59
	/** 返回第 60 个元素 [t60]，用于解构声明。 */
	operator fun component60(): T60 = t60
	/** 返回第 61 个元素 [t61]，用于解构声明。 */
	operator fun component61(): T61 = t61
	/** 返回第 62 个元素 [t62]，用于解构声明。 */
	operator fun component62(): T62 = t62
	/** 返回第 63 个元素 [t63]，用于解构声明。 */
	operator fun component63(): T63 = t63
	/** 返回第 64 个元素 [t64]，用于解构声明。 */
	operator fun component64(): T64 = t64
	/** 返回第 65 个元素 [t65]，用于解构声明。 */
	operator fun component65(): T65 = t65
	/** 返回第 66 个元素 [t66]，用于解构声明。 */
	operator fun component66(): T66 = t66
	/** 返回第 67 个元素 [t67]，用于解构声明。 */
	operator fun component67(): T67 = t67
	/** 返回第 68 个元素 [t68]，用于解构声明。 */
	operator fun component68(): T68 = t68
	/** 返回第 69 个元素 [t69]，用于解构声明。 */
	operator fun component69(): T69 = t69
	/** 返回第 70 个元素 [t70]，用于解构声明。 */
	operator fun component70(): T70 = t70
	/** 返回第 71 个元素 [t71]，用于解构声明。 */
	operator fun component71(): T71 = t71
	/** 返回第 72 个元素 [t72]，用于解构声明。 */
	operator fun component72(): T72 = t72
}

/**
 * 73 元组，持有 73 个元素（t1 ~ t73），支持解构声明。
 */
class Tuple73<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
	/** 第 58 个元素。 */
	val t58: T58,
	/** 第 59 个元素。 */
	val t59: T59,
	/** 第 60 个元素。 */
	val t60: T60,
	/** 第 61 个元素。 */
	val t61: T61,
	/** 第 62 个元素。 */
	val t62: T62,
	/** 第 63 个元素。 */
	val t63: T63,
	/** 第 64 个元素。 */
	val t64: T64,
	/** 第 65 个元素。 */
	val t65: T65,
	/** 第 66 个元素。 */
	val t66: T66,
	/** 第 67 个元素。 */
	val t67: T67,
	/** 第 68 个元素。 */
	val t68: T68,
	/** 第 69 个元素。 */
	val t69: T69,
	/** 第 70 个元素。 */
	val t70: T70,
	/** 第 71 个元素。 */
	val t71: T71,
	/** 第 72 个元素。 */
	val t72: T72,
	/** 第 73 个元素。 */
	val t73: T73,
) : Tuple(73) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
	/** 返回第 58 个元素 [t58]，用于解构声明。 */
	operator fun component58(): T58 = t58
	/** 返回第 59 个元素 [t59]，用于解构声明。 */
	operator fun component59(): T59 = t59
	/** 返回第 60 个元素 [t60]，用于解构声明。 */
	operator fun component60(): T60 = t60
	/** 返回第 61 个元素 [t61]，用于解构声明。 */
	operator fun component61(): T61 = t61
	/** 返回第 62 个元素 [t62]，用于解构声明。 */
	operator fun component62(): T62 = t62
	/** 返回第 63 个元素 [t63]，用于解构声明。 */
	operator fun component63(): T63 = t63
	/** 返回第 64 个元素 [t64]，用于解构声明。 */
	operator fun component64(): T64 = t64
	/** 返回第 65 个元素 [t65]，用于解构声明。 */
	operator fun component65(): T65 = t65
	/** 返回第 66 个元素 [t66]，用于解构声明。 */
	operator fun component66(): T66 = t66
	/** 返回第 67 个元素 [t67]，用于解构声明。 */
	operator fun component67(): T67 = t67
	/** 返回第 68 个元素 [t68]，用于解构声明。 */
	operator fun component68(): T68 = t68
	/** 返回第 69 个元素 [t69]，用于解构声明。 */
	operator fun component69(): T69 = t69
	/** 返回第 70 个元素 [t70]，用于解构声明。 */
	operator fun component70(): T70 = t70
	/** 返回第 71 个元素 [t71]，用于解构声明。 */
	operator fun component71(): T71 = t71
	/** 返回第 72 个元素 [t72]，用于解构声明。 */
	operator fun component72(): T72 = t72
	/** 返回第 73 个元素 [t73]，用于解构声明。 */
	operator fun component73(): T73 = t73
}

/**
 * 74 元组，持有 74 个元素（t1 ~ t74），支持解构声明。
 */
class Tuple74<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
	/** 第 58 个元素。 */
	val t58: T58,
	/** 第 59 个元素。 */
	val t59: T59,
	/** 第 60 个元素。 */
	val t60: T60,
	/** 第 61 个元素。 */
	val t61: T61,
	/** 第 62 个元素。 */
	val t62: T62,
	/** 第 63 个元素。 */
	val t63: T63,
	/** 第 64 个元素。 */
	val t64: T64,
	/** 第 65 个元素。 */
	val t65: T65,
	/** 第 66 个元素。 */
	val t66: T66,
	/** 第 67 个元素。 */
	val t67: T67,
	/** 第 68 个元素。 */
	val t68: T68,
	/** 第 69 个元素。 */
	val t69: T69,
	/** 第 70 个元素。 */
	val t70: T70,
	/** 第 71 个元素。 */
	val t71: T71,
	/** 第 72 个元素。 */
	val t72: T72,
	/** 第 73 个元素。 */
	val t73: T73,
	/** 第 74 个元素。 */
	val t74: T74,
) : Tuple(74) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
	/** 返回第 58 个元素 [t58]，用于解构声明。 */
	operator fun component58(): T58 = t58
	/** 返回第 59 个元素 [t59]，用于解构声明。 */
	operator fun component59(): T59 = t59
	/** 返回第 60 个元素 [t60]，用于解构声明。 */
	operator fun component60(): T60 = t60
	/** 返回第 61 个元素 [t61]，用于解构声明。 */
	operator fun component61(): T61 = t61
	/** 返回第 62 个元素 [t62]，用于解构声明。 */
	operator fun component62(): T62 = t62
	/** 返回第 63 个元素 [t63]，用于解构声明。 */
	operator fun component63(): T63 = t63
	/** 返回第 64 个元素 [t64]，用于解构声明。 */
	operator fun component64(): T64 = t64
	/** 返回第 65 个元素 [t65]，用于解构声明。 */
	operator fun component65(): T65 = t65
	/** 返回第 66 个元素 [t66]，用于解构声明。 */
	operator fun component66(): T66 = t66
	/** 返回第 67 个元素 [t67]，用于解构声明。 */
	operator fun component67(): T67 = t67
	/** 返回第 68 个元素 [t68]，用于解构声明。 */
	operator fun component68(): T68 = t68
	/** 返回第 69 个元素 [t69]，用于解构声明。 */
	operator fun component69(): T69 = t69
	/** 返回第 70 个元素 [t70]，用于解构声明。 */
	operator fun component70(): T70 = t70
	/** 返回第 71 个元素 [t71]，用于解构声明。 */
	operator fun component71(): T71 = t71
	/** 返回第 72 个元素 [t72]，用于解构声明。 */
	operator fun component72(): T72 = t72
	/** 返回第 73 个元素 [t73]，用于解构声明。 */
	operator fun component73(): T73 = t73
	/** 返回第 74 个元素 [t74]，用于解构声明。 */
	operator fun component74(): T74 = t74
}

/**
 * 75 元组，持有 75 个元素（t1 ~ t75），支持解构声明。
 */
class Tuple75<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
	/** 第 58 个元素。 */
	val t58: T58,
	/** 第 59 个元素。 */
	val t59: T59,
	/** 第 60 个元素。 */
	val t60: T60,
	/** 第 61 个元素。 */
	val t61: T61,
	/** 第 62 个元素。 */
	val t62: T62,
	/** 第 63 个元素。 */
	val t63: T63,
	/** 第 64 个元素。 */
	val t64: T64,
	/** 第 65 个元素。 */
	val t65: T65,
	/** 第 66 个元素。 */
	val t66: T66,
	/** 第 67 个元素。 */
	val t67: T67,
	/** 第 68 个元素。 */
	val t68: T68,
	/** 第 69 个元素。 */
	val t69: T69,
	/** 第 70 个元素。 */
	val t70: T70,
	/** 第 71 个元素。 */
	val t71: T71,
	/** 第 72 个元素。 */
	val t72: T72,
	/** 第 73 个元素。 */
	val t73: T73,
	/** 第 74 个元素。 */
	val t74: T74,
	/** 第 75 个元素。 */
	val t75: T75,
) : Tuple(75) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
	/** 返回第 58 个元素 [t58]，用于解构声明。 */
	operator fun component58(): T58 = t58
	/** 返回第 59 个元素 [t59]，用于解构声明。 */
	operator fun component59(): T59 = t59
	/** 返回第 60 个元素 [t60]，用于解构声明。 */
	operator fun component60(): T60 = t60
	/** 返回第 61 个元素 [t61]，用于解构声明。 */
	operator fun component61(): T61 = t61
	/** 返回第 62 个元素 [t62]，用于解构声明。 */
	operator fun component62(): T62 = t62
	/** 返回第 63 个元素 [t63]，用于解构声明。 */
	operator fun component63(): T63 = t63
	/** 返回第 64 个元素 [t64]，用于解构声明。 */
	operator fun component64(): T64 = t64
	/** 返回第 65 个元素 [t65]，用于解构声明。 */
	operator fun component65(): T65 = t65
	/** 返回第 66 个元素 [t66]，用于解构声明。 */
	operator fun component66(): T66 = t66
	/** 返回第 67 个元素 [t67]，用于解构声明。 */
	operator fun component67(): T67 = t67
	/** 返回第 68 个元素 [t68]，用于解构声明。 */
	operator fun component68(): T68 = t68
	/** 返回第 69 个元素 [t69]，用于解构声明。 */
	operator fun component69(): T69 = t69
	/** 返回第 70 个元素 [t70]，用于解构声明。 */
	operator fun component70(): T70 = t70
	/** 返回第 71 个元素 [t71]，用于解构声明。 */
	operator fun component71(): T71 = t71
	/** 返回第 72 个元素 [t72]，用于解构声明。 */
	operator fun component72(): T72 = t72
	/** 返回第 73 个元素 [t73]，用于解构声明。 */
	operator fun component73(): T73 = t73
	/** 返回第 74 个元素 [t74]，用于解构声明。 */
	operator fun component74(): T74 = t74
	/** 返回第 75 个元素 [t75]，用于解构声明。 */
	operator fun component75(): T75 = t75
}

/**
 * 76 元组，持有 76 个元素（t1 ~ t76），支持解构声明。
 */
class Tuple76<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
	/** 第 58 个元素。 */
	val t58: T58,
	/** 第 59 个元素。 */
	val t59: T59,
	/** 第 60 个元素。 */
	val t60: T60,
	/** 第 61 个元素。 */
	val t61: T61,
	/** 第 62 个元素。 */
	val t62: T62,
	/** 第 63 个元素。 */
	val t63: T63,
	/** 第 64 个元素。 */
	val t64: T64,
	/** 第 65 个元素。 */
	val t65: T65,
	/** 第 66 个元素。 */
	val t66: T66,
	/** 第 67 个元素。 */
	val t67: T67,
	/** 第 68 个元素。 */
	val t68: T68,
	/** 第 69 个元素。 */
	val t69: T69,
	/** 第 70 个元素。 */
	val t70: T70,
	/** 第 71 个元素。 */
	val t71: T71,
	/** 第 72 个元素。 */
	val t72: T72,
	/** 第 73 个元素。 */
	val t73: T73,
	/** 第 74 个元素。 */
	val t74: T74,
	/** 第 75 个元素。 */
	val t75: T75,
	/** 第 76 个元素。 */
	val t76: T76,
) : Tuple(76) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
	/** 返回第 58 个元素 [t58]，用于解构声明。 */
	operator fun component58(): T58 = t58
	/** 返回第 59 个元素 [t59]，用于解构声明。 */
	operator fun component59(): T59 = t59
	/** 返回第 60 个元素 [t60]，用于解构声明。 */
	operator fun component60(): T60 = t60
	/** 返回第 61 个元素 [t61]，用于解构声明。 */
	operator fun component61(): T61 = t61
	/** 返回第 62 个元素 [t62]，用于解构声明。 */
	operator fun component62(): T62 = t62
	/** 返回第 63 个元素 [t63]，用于解构声明。 */
	operator fun component63(): T63 = t63
	/** 返回第 64 个元素 [t64]，用于解构声明。 */
	operator fun component64(): T64 = t64
	/** 返回第 65 个元素 [t65]，用于解构声明。 */
	operator fun component65(): T65 = t65
	/** 返回第 66 个元素 [t66]，用于解构声明。 */
	operator fun component66(): T66 = t66
	/** 返回第 67 个元素 [t67]，用于解构声明。 */
	operator fun component67(): T67 = t67
	/** 返回第 68 个元素 [t68]，用于解构声明。 */
	operator fun component68(): T68 = t68
	/** 返回第 69 个元素 [t69]，用于解构声明。 */
	operator fun component69(): T69 = t69
	/** 返回第 70 个元素 [t70]，用于解构声明。 */
	operator fun component70(): T70 = t70
	/** 返回第 71 个元素 [t71]，用于解构声明。 */
	operator fun component71(): T71 = t71
	/** 返回第 72 个元素 [t72]，用于解构声明。 */
	operator fun component72(): T72 = t72
	/** 返回第 73 个元素 [t73]，用于解构声明。 */
	operator fun component73(): T73 = t73
	/** 返回第 74 个元素 [t74]，用于解构声明。 */
	operator fun component74(): T74 = t74
	/** 返回第 75 个元素 [t75]，用于解构声明。 */
	operator fun component75(): T75 = t75
	/** 返回第 76 个元素 [t76]，用于解构声明。 */
	operator fun component76(): T76 = t76
}

/**
 * 77 元组，持有 77 个元素（t1 ~ t77），支持解构声明。
 */
class Tuple77<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
	/** 第 58 个元素。 */
	val t58: T58,
	/** 第 59 个元素。 */
	val t59: T59,
	/** 第 60 个元素。 */
	val t60: T60,
	/** 第 61 个元素。 */
	val t61: T61,
	/** 第 62 个元素。 */
	val t62: T62,
	/** 第 63 个元素。 */
	val t63: T63,
	/** 第 64 个元素。 */
	val t64: T64,
	/** 第 65 个元素。 */
	val t65: T65,
	/** 第 66 个元素。 */
	val t66: T66,
	/** 第 67 个元素。 */
	val t67: T67,
	/** 第 68 个元素。 */
	val t68: T68,
	/** 第 69 个元素。 */
	val t69: T69,
	/** 第 70 个元素。 */
	val t70: T70,
	/** 第 71 个元素。 */
	val t71: T71,
	/** 第 72 个元素。 */
	val t72: T72,
	/** 第 73 个元素。 */
	val t73: T73,
	/** 第 74 个元素。 */
	val t74: T74,
	/** 第 75 个元素。 */
	val t75: T75,
	/** 第 76 个元素。 */
	val t76: T76,
	/** 第 77 个元素。 */
	val t77: T77,
) : Tuple(77) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
	/** 返回第 58 个元素 [t58]，用于解构声明。 */
	operator fun component58(): T58 = t58
	/** 返回第 59 个元素 [t59]，用于解构声明。 */
	operator fun component59(): T59 = t59
	/** 返回第 60 个元素 [t60]，用于解构声明。 */
	operator fun component60(): T60 = t60
	/** 返回第 61 个元素 [t61]，用于解构声明。 */
	operator fun component61(): T61 = t61
	/** 返回第 62 个元素 [t62]，用于解构声明。 */
	operator fun component62(): T62 = t62
	/** 返回第 63 个元素 [t63]，用于解构声明。 */
	operator fun component63(): T63 = t63
	/** 返回第 64 个元素 [t64]，用于解构声明。 */
	operator fun component64(): T64 = t64
	/** 返回第 65 个元素 [t65]，用于解构声明。 */
	operator fun component65(): T65 = t65
	/** 返回第 66 个元素 [t66]，用于解构声明。 */
	operator fun component66(): T66 = t66
	/** 返回第 67 个元素 [t67]，用于解构声明。 */
	operator fun component67(): T67 = t67
	/** 返回第 68 个元素 [t68]，用于解构声明。 */
	operator fun component68(): T68 = t68
	/** 返回第 69 个元素 [t69]，用于解构声明。 */
	operator fun component69(): T69 = t69
	/** 返回第 70 个元素 [t70]，用于解构声明。 */
	operator fun component70(): T70 = t70
	/** 返回第 71 个元素 [t71]，用于解构声明。 */
	operator fun component71(): T71 = t71
	/** 返回第 72 个元素 [t72]，用于解构声明。 */
	operator fun component72(): T72 = t72
	/** 返回第 73 个元素 [t73]，用于解构声明。 */
	operator fun component73(): T73 = t73
	/** 返回第 74 个元素 [t74]，用于解构声明。 */
	operator fun component74(): T74 = t74
	/** 返回第 75 个元素 [t75]，用于解构声明。 */
	operator fun component75(): T75 = t75
	/** 返回第 76 个元素 [t76]，用于解构声明。 */
	operator fun component76(): T76 = t76
	/** 返回第 77 个元素 [t77]，用于解构声明。 */
	operator fun component77(): T77 = t77
}

/**
 * 78 元组，持有 78 个元素（t1 ~ t78），支持解构声明。
 */
class Tuple78<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
	/** 第 58 个元素。 */
	val t58: T58,
	/** 第 59 个元素。 */
	val t59: T59,
	/** 第 60 个元素。 */
	val t60: T60,
	/** 第 61 个元素。 */
	val t61: T61,
	/** 第 62 个元素。 */
	val t62: T62,
	/** 第 63 个元素。 */
	val t63: T63,
	/** 第 64 个元素。 */
	val t64: T64,
	/** 第 65 个元素。 */
	val t65: T65,
	/** 第 66 个元素。 */
	val t66: T66,
	/** 第 67 个元素。 */
	val t67: T67,
	/** 第 68 个元素。 */
	val t68: T68,
	/** 第 69 个元素。 */
	val t69: T69,
	/** 第 70 个元素。 */
	val t70: T70,
	/** 第 71 个元素。 */
	val t71: T71,
	/** 第 72 个元素。 */
	val t72: T72,
	/** 第 73 个元素。 */
	val t73: T73,
	/** 第 74 个元素。 */
	val t74: T74,
	/** 第 75 个元素。 */
	val t75: T75,
	/** 第 76 个元素。 */
	val t76: T76,
	/** 第 77 个元素。 */
	val t77: T77,
	/** 第 78 个元素。 */
	val t78: T78,
) : Tuple(78) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
	/** 返回第 58 个元素 [t58]，用于解构声明。 */
	operator fun component58(): T58 = t58
	/** 返回第 59 个元素 [t59]，用于解构声明。 */
	operator fun component59(): T59 = t59
	/** 返回第 60 个元素 [t60]，用于解构声明。 */
	operator fun component60(): T60 = t60
	/** 返回第 61 个元素 [t61]，用于解构声明。 */
	operator fun component61(): T61 = t61
	/** 返回第 62 个元素 [t62]，用于解构声明。 */
	operator fun component62(): T62 = t62
	/** 返回第 63 个元素 [t63]，用于解构声明。 */
	operator fun component63(): T63 = t63
	/** 返回第 64 个元素 [t64]，用于解构声明。 */
	operator fun component64(): T64 = t64
	/** 返回第 65 个元素 [t65]，用于解构声明。 */
	operator fun component65(): T65 = t65
	/** 返回第 66 个元素 [t66]，用于解构声明。 */
	operator fun component66(): T66 = t66
	/** 返回第 67 个元素 [t67]，用于解构声明。 */
	operator fun component67(): T67 = t67
	/** 返回第 68 个元素 [t68]，用于解构声明。 */
	operator fun component68(): T68 = t68
	/** 返回第 69 个元素 [t69]，用于解构声明。 */
	operator fun component69(): T69 = t69
	/** 返回第 70 个元素 [t70]，用于解构声明。 */
	operator fun component70(): T70 = t70
	/** 返回第 71 个元素 [t71]，用于解构声明。 */
	operator fun component71(): T71 = t71
	/** 返回第 72 个元素 [t72]，用于解构声明。 */
	operator fun component72(): T72 = t72
	/** 返回第 73 个元素 [t73]，用于解构声明。 */
	operator fun component73(): T73 = t73
	/** 返回第 74 个元素 [t74]，用于解构声明。 */
	operator fun component74(): T74 = t74
	/** 返回第 75 个元素 [t75]，用于解构声明。 */
	operator fun component75(): T75 = t75
	/** 返回第 76 个元素 [t76]，用于解构声明。 */
	operator fun component76(): T76 = t76
	/** 返回第 77 个元素 [t77]，用于解构声明。 */
	operator fun component77(): T77 = t77
	/** 返回第 78 个元素 [t78]，用于解构声明。 */
	operator fun component78(): T78 = t78
}

/**
 * 79 元组，持有 79 个元素（t1 ~ t79），支持解构声明。
 */
class Tuple79<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
	/** 第 58 个元素。 */
	val t58: T58,
	/** 第 59 个元素。 */
	val t59: T59,
	/** 第 60 个元素。 */
	val t60: T60,
	/** 第 61 个元素。 */
	val t61: T61,
	/** 第 62 个元素。 */
	val t62: T62,
	/** 第 63 个元素。 */
	val t63: T63,
	/** 第 64 个元素。 */
	val t64: T64,
	/** 第 65 个元素。 */
	val t65: T65,
	/** 第 66 个元素。 */
	val t66: T66,
	/** 第 67 个元素。 */
	val t67: T67,
	/** 第 68 个元素。 */
	val t68: T68,
	/** 第 69 个元素。 */
	val t69: T69,
	/** 第 70 个元素。 */
	val t70: T70,
	/** 第 71 个元素。 */
	val t71: T71,
	/** 第 72 个元素。 */
	val t72: T72,
	/** 第 73 个元素。 */
	val t73: T73,
	/** 第 74 个元素。 */
	val t74: T74,
	/** 第 75 个元素。 */
	val t75: T75,
	/** 第 76 个元素。 */
	val t76: T76,
	/** 第 77 个元素。 */
	val t77: T77,
	/** 第 78 个元素。 */
	val t78: T78,
	/** 第 79 个元素。 */
	val t79: T79,
) : Tuple(79) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
	/** 返回第 58 个元素 [t58]，用于解构声明。 */
	operator fun component58(): T58 = t58
	/** 返回第 59 个元素 [t59]，用于解构声明。 */
	operator fun component59(): T59 = t59
	/** 返回第 60 个元素 [t60]，用于解构声明。 */
	operator fun component60(): T60 = t60
	/** 返回第 61 个元素 [t61]，用于解构声明。 */
	operator fun component61(): T61 = t61
	/** 返回第 62 个元素 [t62]，用于解构声明。 */
	operator fun component62(): T62 = t62
	/** 返回第 63 个元素 [t63]，用于解构声明。 */
	operator fun component63(): T63 = t63
	/** 返回第 64 个元素 [t64]，用于解构声明。 */
	operator fun component64(): T64 = t64
	/** 返回第 65 个元素 [t65]，用于解构声明。 */
	operator fun component65(): T65 = t65
	/** 返回第 66 个元素 [t66]，用于解构声明。 */
	operator fun component66(): T66 = t66
	/** 返回第 67 个元素 [t67]，用于解构声明。 */
	operator fun component67(): T67 = t67
	/** 返回第 68 个元素 [t68]，用于解构声明。 */
	operator fun component68(): T68 = t68
	/** 返回第 69 个元素 [t69]，用于解构声明。 */
	operator fun component69(): T69 = t69
	/** 返回第 70 个元素 [t70]，用于解构声明。 */
	operator fun component70(): T70 = t70
	/** 返回第 71 个元素 [t71]，用于解构声明。 */
	operator fun component71(): T71 = t71
	/** 返回第 72 个元素 [t72]，用于解构声明。 */
	operator fun component72(): T72 = t72
	/** 返回第 73 个元素 [t73]，用于解构声明。 */
	operator fun component73(): T73 = t73
	/** 返回第 74 个元素 [t74]，用于解构声明。 */
	operator fun component74(): T74 = t74
	/** 返回第 75 个元素 [t75]，用于解构声明。 */
	operator fun component75(): T75 = t75
	/** 返回第 76 个元素 [t76]，用于解构声明。 */
	operator fun component76(): T76 = t76
	/** 返回第 77 个元素 [t77]，用于解构声明。 */
	operator fun component77(): T77 = t77
	/** 返回第 78 个元素 [t78]，用于解构声明。 */
	operator fun component78(): T78 = t78
	/** 返回第 79 个元素 [t79]，用于解构声明。 */
	operator fun component79(): T79 = t79
}

/**
 * 80 元组，持有 80 个元素（t1 ~ t80），支持解构声明。
 */
class Tuple80<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79, T80>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
	/** 第 58 个元素。 */
	val t58: T58,
	/** 第 59 个元素。 */
	val t59: T59,
	/** 第 60 个元素。 */
	val t60: T60,
	/** 第 61 个元素。 */
	val t61: T61,
	/** 第 62 个元素。 */
	val t62: T62,
	/** 第 63 个元素。 */
	val t63: T63,
	/** 第 64 个元素。 */
	val t64: T64,
	/** 第 65 个元素。 */
	val t65: T65,
	/** 第 66 个元素。 */
	val t66: T66,
	/** 第 67 个元素。 */
	val t67: T67,
	/** 第 68 个元素。 */
	val t68: T68,
	/** 第 69 个元素。 */
	val t69: T69,
	/** 第 70 个元素。 */
	val t70: T70,
	/** 第 71 个元素。 */
	val t71: T71,
	/** 第 72 个元素。 */
	val t72: T72,
	/** 第 73 个元素。 */
	val t73: T73,
	/** 第 74 个元素。 */
	val t74: T74,
	/** 第 75 个元素。 */
	val t75: T75,
	/** 第 76 个元素。 */
	val t76: T76,
	/** 第 77 个元素。 */
	val t77: T77,
	/** 第 78 个元素。 */
	val t78: T78,
	/** 第 79 个元素。 */
	val t79: T79,
	/** 第 80 个元素。 */
	val t80: T80,
) : Tuple(80) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
	/** 返回第 58 个元素 [t58]，用于解构声明。 */
	operator fun component58(): T58 = t58
	/** 返回第 59 个元素 [t59]，用于解构声明。 */
	operator fun component59(): T59 = t59
	/** 返回第 60 个元素 [t60]，用于解构声明。 */
	operator fun component60(): T60 = t60
	/** 返回第 61 个元素 [t61]，用于解构声明。 */
	operator fun component61(): T61 = t61
	/** 返回第 62 个元素 [t62]，用于解构声明。 */
	operator fun component62(): T62 = t62
	/** 返回第 63 个元素 [t63]，用于解构声明。 */
	operator fun component63(): T63 = t63
	/** 返回第 64 个元素 [t64]，用于解构声明。 */
	operator fun component64(): T64 = t64
	/** 返回第 65 个元素 [t65]，用于解构声明。 */
	operator fun component65(): T65 = t65
	/** 返回第 66 个元素 [t66]，用于解构声明。 */
	operator fun component66(): T66 = t66
	/** 返回第 67 个元素 [t67]，用于解构声明。 */
	operator fun component67(): T67 = t67
	/** 返回第 68 个元素 [t68]，用于解构声明。 */
	operator fun component68(): T68 = t68
	/** 返回第 69 个元素 [t69]，用于解构声明。 */
	operator fun component69(): T69 = t69
	/** 返回第 70 个元素 [t70]，用于解构声明。 */
	operator fun component70(): T70 = t70
	/** 返回第 71 个元素 [t71]，用于解构声明。 */
	operator fun component71(): T71 = t71
	/** 返回第 72 个元素 [t72]，用于解构声明。 */
	operator fun component72(): T72 = t72
	/** 返回第 73 个元素 [t73]，用于解构声明。 */
	operator fun component73(): T73 = t73
	/** 返回第 74 个元素 [t74]，用于解构声明。 */
	operator fun component74(): T74 = t74
	/** 返回第 75 个元素 [t75]，用于解构声明。 */
	operator fun component75(): T75 = t75
	/** 返回第 76 个元素 [t76]，用于解构声明。 */
	operator fun component76(): T76 = t76
	/** 返回第 77 个元素 [t77]，用于解构声明。 */
	operator fun component77(): T77 = t77
	/** 返回第 78 个元素 [t78]，用于解构声明。 */
	operator fun component78(): T78 = t78
	/** 返回第 79 个元素 [t79]，用于解构声明。 */
	operator fun component79(): T79 = t79
	/** 返回第 80 个元素 [t80]，用于解构声明。 */
	operator fun component80(): T80 = t80
}

/**
 * 81 元组，持有 81 个元素（t1 ~ t81），支持解构声明。
 */
class Tuple81<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79, T80, T81>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
	/** 第 58 个元素。 */
	val t58: T58,
	/** 第 59 个元素。 */
	val t59: T59,
	/** 第 60 个元素。 */
	val t60: T60,
	/** 第 61 个元素。 */
	val t61: T61,
	/** 第 62 个元素。 */
	val t62: T62,
	/** 第 63 个元素。 */
	val t63: T63,
	/** 第 64 个元素。 */
	val t64: T64,
	/** 第 65 个元素。 */
	val t65: T65,
	/** 第 66 个元素。 */
	val t66: T66,
	/** 第 67 个元素。 */
	val t67: T67,
	/** 第 68 个元素。 */
	val t68: T68,
	/** 第 69 个元素。 */
	val t69: T69,
	/** 第 70 个元素。 */
	val t70: T70,
	/** 第 71 个元素。 */
	val t71: T71,
	/** 第 72 个元素。 */
	val t72: T72,
	/** 第 73 个元素。 */
	val t73: T73,
	/** 第 74 个元素。 */
	val t74: T74,
	/** 第 75 个元素。 */
	val t75: T75,
	/** 第 76 个元素。 */
	val t76: T76,
	/** 第 77 个元素。 */
	val t77: T77,
	/** 第 78 个元素。 */
	val t78: T78,
	/** 第 79 个元素。 */
	val t79: T79,
	/** 第 80 个元素。 */
	val t80: T80,
	/** 第 81 个元素。 */
	val t81: T81,
) : Tuple(81) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
	/** 返回第 58 个元素 [t58]，用于解构声明。 */
	operator fun component58(): T58 = t58
	/** 返回第 59 个元素 [t59]，用于解构声明。 */
	operator fun component59(): T59 = t59
	/** 返回第 60 个元素 [t60]，用于解构声明。 */
	operator fun component60(): T60 = t60
	/** 返回第 61 个元素 [t61]，用于解构声明。 */
	operator fun component61(): T61 = t61
	/** 返回第 62 个元素 [t62]，用于解构声明。 */
	operator fun component62(): T62 = t62
	/** 返回第 63 个元素 [t63]，用于解构声明。 */
	operator fun component63(): T63 = t63
	/** 返回第 64 个元素 [t64]，用于解构声明。 */
	operator fun component64(): T64 = t64
	/** 返回第 65 个元素 [t65]，用于解构声明。 */
	operator fun component65(): T65 = t65
	/** 返回第 66 个元素 [t66]，用于解构声明。 */
	operator fun component66(): T66 = t66
	/** 返回第 67 个元素 [t67]，用于解构声明。 */
	operator fun component67(): T67 = t67
	/** 返回第 68 个元素 [t68]，用于解构声明。 */
	operator fun component68(): T68 = t68
	/** 返回第 69 个元素 [t69]，用于解构声明。 */
	operator fun component69(): T69 = t69
	/** 返回第 70 个元素 [t70]，用于解构声明。 */
	operator fun component70(): T70 = t70
	/** 返回第 71 个元素 [t71]，用于解构声明。 */
	operator fun component71(): T71 = t71
	/** 返回第 72 个元素 [t72]，用于解构声明。 */
	operator fun component72(): T72 = t72
	/** 返回第 73 个元素 [t73]，用于解构声明。 */
	operator fun component73(): T73 = t73
	/** 返回第 74 个元素 [t74]，用于解构声明。 */
	operator fun component74(): T74 = t74
	/** 返回第 75 个元素 [t75]，用于解构声明。 */
	operator fun component75(): T75 = t75
	/** 返回第 76 个元素 [t76]，用于解构声明。 */
	operator fun component76(): T76 = t76
	/** 返回第 77 个元素 [t77]，用于解构声明。 */
	operator fun component77(): T77 = t77
	/** 返回第 78 个元素 [t78]，用于解构声明。 */
	operator fun component78(): T78 = t78
	/** 返回第 79 个元素 [t79]，用于解构声明。 */
	operator fun component79(): T79 = t79
	/** 返回第 80 个元素 [t80]，用于解构声明。 */
	operator fun component80(): T80 = t80
	/** 返回第 81 个元素 [t81]，用于解构声明。 */
	operator fun component81(): T81 = t81
}

/**
 * 82 元组，持有 82 个元素（t1 ~ t82），支持解构声明。
 */
class Tuple82<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79, T80, T81, T82>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
	/** 第 58 个元素。 */
	val t58: T58,
	/** 第 59 个元素。 */
	val t59: T59,
	/** 第 60 个元素。 */
	val t60: T60,
	/** 第 61 个元素。 */
	val t61: T61,
	/** 第 62 个元素。 */
	val t62: T62,
	/** 第 63 个元素。 */
	val t63: T63,
	/** 第 64 个元素。 */
	val t64: T64,
	/** 第 65 个元素。 */
	val t65: T65,
	/** 第 66 个元素。 */
	val t66: T66,
	/** 第 67 个元素。 */
	val t67: T67,
	/** 第 68 个元素。 */
	val t68: T68,
	/** 第 69 个元素。 */
	val t69: T69,
	/** 第 70 个元素。 */
	val t70: T70,
	/** 第 71 个元素。 */
	val t71: T71,
	/** 第 72 个元素。 */
	val t72: T72,
	/** 第 73 个元素。 */
	val t73: T73,
	/** 第 74 个元素。 */
	val t74: T74,
	/** 第 75 个元素。 */
	val t75: T75,
	/** 第 76 个元素。 */
	val t76: T76,
	/** 第 77 个元素。 */
	val t77: T77,
	/** 第 78 个元素。 */
	val t78: T78,
	/** 第 79 个元素。 */
	val t79: T79,
	/** 第 80 个元素。 */
	val t80: T80,
	/** 第 81 个元素。 */
	val t81: T81,
	/** 第 82 个元素。 */
	val t82: T82,
) : Tuple(82) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
	/** 返回第 58 个元素 [t58]，用于解构声明。 */
	operator fun component58(): T58 = t58
	/** 返回第 59 个元素 [t59]，用于解构声明。 */
	operator fun component59(): T59 = t59
	/** 返回第 60 个元素 [t60]，用于解构声明。 */
	operator fun component60(): T60 = t60
	/** 返回第 61 个元素 [t61]，用于解构声明。 */
	operator fun component61(): T61 = t61
	/** 返回第 62 个元素 [t62]，用于解构声明。 */
	operator fun component62(): T62 = t62
	/** 返回第 63 个元素 [t63]，用于解构声明。 */
	operator fun component63(): T63 = t63
	/** 返回第 64 个元素 [t64]，用于解构声明。 */
	operator fun component64(): T64 = t64
	/** 返回第 65 个元素 [t65]，用于解构声明。 */
	operator fun component65(): T65 = t65
	/** 返回第 66 个元素 [t66]，用于解构声明。 */
	operator fun component66(): T66 = t66
	/** 返回第 67 个元素 [t67]，用于解构声明。 */
	operator fun component67(): T67 = t67
	/** 返回第 68 个元素 [t68]，用于解构声明。 */
	operator fun component68(): T68 = t68
	/** 返回第 69 个元素 [t69]，用于解构声明。 */
	operator fun component69(): T69 = t69
	/** 返回第 70 个元素 [t70]，用于解构声明。 */
	operator fun component70(): T70 = t70
	/** 返回第 71 个元素 [t71]，用于解构声明。 */
	operator fun component71(): T71 = t71
	/** 返回第 72 个元素 [t72]，用于解构声明。 */
	operator fun component72(): T72 = t72
	/** 返回第 73 个元素 [t73]，用于解构声明。 */
	operator fun component73(): T73 = t73
	/** 返回第 74 个元素 [t74]，用于解构声明。 */
	operator fun component74(): T74 = t74
	/** 返回第 75 个元素 [t75]，用于解构声明。 */
	operator fun component75(): T75 = t75
	/** 返回第 76 个元素 [t76]，用于解构声明。 */
	operator fun component76(): T76 = t76
	/** 返回第 77 个元素 [t77]，用于解构声明。 */
	operator fun component77(): T77 = t77
	/** 返回第 78 个元素 [t78]，用于解构声明。 */
	operator fun component78(): T78 = t78
	/** 返回第 79 个元素 [t79]，用于解构声明。 */
	operator fun component79(): T79 = t79
	/** 返回第 80 个元素 [t80]，用于解构声明。 */
	operator fun component80(): T80 = t80
	/** 返回第 81 个元素 [t81]，用于解构声明。 */
	operator fun component81(): T81 = t81
	/** 返回第 82 个元素 [t82]，用于解构声明。 */
	operator fun component82(): T82 = t82
}

/**
 * 83 元组，持有 83 个元素（t1 ~ t83），支持解构声明。
 */
class Tuple83<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79, T80, T81, T82, T83>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
	/** 第 58 个元素。 */
	val t58: T58,
	/** 第 59 个元素。 */
	val t59: T59,
	/** 第 60 个元素。 */
	val t60: T60,
	/** 第 61 个元素。 */
	val t61: T61,
	/** 第 62 个元素。 */
	val t62: T62,
	/** 第 63 个元素。 */
	val t63: T63,
	/** 第 64 个元素。 */
	val t64: T64,
	/** 第 65 个元素。 */
	val t65: T65,
	/** 第 66 个元素。 */
	val t66: T66,
	/** 第 67 个元素。 */
	val t67: T67,
	/** 第 68 个元素。 */
	val t68: T68,
	/** 第 69 个元素。 */
	val t69: T69,
	/** 第 70 个元素。 */
	val t70: T70,
	/** 第 71 个元素。 */
	val t71: T71,
	/** 第 72 个元素。 */
	val t72: T72,
	/** 第 73 个元素。 */
	val t73: T73,
	/** 第 74 个元素。 */
	val t74: T74,
	/** 第 75 个元素。 */
	val t75: T75,
	/** 第 76 个元素。 */
	val t76: T76,
	/** 第 77 个元素。 */
	val t77: T77,
	/** 第 78 个元素。 */
	val t78: T78,
	/** 第 79 个元素。 */
	val t79: T79,
	/** 第 80 个元素。 */
	val t80: T80,
	/** 第 81 个元素。 */
	val t81: T81,
	/** 第 82 个元素。 */
	val t82: T82,
	/** 第 83 个元素。 */
	val t83: T83,
) : Tuple(83) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
	/** 返回第 58 个元素 [t58]，用于解构声明。 */
	operator fun component58(): T58 = t58
	/** 返回第 59 个元素 [t59]，用于解构声明。 */
	operator fun component59(): T59 = t59
	/** 返回第 60 个元素 [t60]，用于解构声明。 */
	operator fun component60(): T60 = t60
	/** 返回第 61 个元素 [t61]，用于解构声明。 */
	operator fun component61(): T61 = t61
	/** 返回第 62 个元素 [t62]，用于解构声明。 */
	operator fun component62(): T62 = t62
	/** 返回第 63 个元素 [t63]，用于解构声明。 */
	operator fun component63(): T63 = t63
	/** 返回第 64 个元素 [t64]，用于解构声明。 */
	operator fun component64(): T64 = t64
	/** 返回第 65 个元素 [t65]，用于解构声明。 */
	operator fun component65(): T65 = t65
	/** 返回第 66 个元素 [t66]，用于解构声明。 */
	operator fun component66(): T66 = t66
	/** 返回第 67 个元素 [t67]，用于解构声明。 */
	operator fun component67(): T67 = t67
	/** 返回第 68 个元素 [t68]，用于解构声明。 */
	operator fun component68(): T68 = t68
	/** 返回第 69 个元素 [t69]，用于解构声明。 */
	operator fun component69(): T69 = t69
	/** 返回第 70 个元素 [t70]，用于解构声明。 */
	operator fun component70(): T70 = t70
	/** 返回第 71 个元素 [t71]，用于解构声明。 */
	operator fun component71(): T71 = t71
	/** 返回第 72 个元素 [t72]，用于解构声明。 */
	operator fun component72(): T72 = t72
	/** 返回第 73 个元素 [t73]，用于解构声明。 */
	operator fun component73(): T73 = t73
	/** 返回第 74 个元素 [t74]，用于解构声明。 */
	operator fun component74(): T74 = t74
	/** 返回第 75 个元素 [t75]，用于解构声明。 */
	operator fun component75(): T75 = t75
	/** 返回第 76 个元素 [t76]，用于解构声明。 */
	operator fun component76(): T76 = t76
	/** 返回第 77 个元素 [t77]，用于解构声明。 */
	operator fun component77(): T77 = t77
	/** 返回第 78 个元素 [t78]，用于解构声明。 */
	operator fun component78(): T78 = t78
	/** 返回第 79 个元素 [t79]，用于解构声明。 */
	operator fun component79(): T79 = t79
	/** 返回第 80 个元素 [t80]，用于解构声明。 */
	operator fun component80(): T80 = t80
	/** 返回第 81 个元素 [t81]，用于解构声明。 */
	operator fun component81(): T81 = t81
	/** 返回第 82 个元素 [t82]，用于解构声明。 */
	operator fun component82(): T82 = t82
	/** 返回第 83 个元素 [t83]，用于解构声明。 */
	operator fun component83(): T83 = t83
}

/**
 * 84 元组，持有 84 个元素（t1 ~ t84），支持解构声明。
 */
class Tuple84<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79, T80, T81, T82, T83, T84>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
	/** 第 58 个元素。 */
	val t58: T58,
	/** 第 59 个元素。 */
	val t59: T59,
	/** 第 60 个元素。 */
	val t60: T60,
	/** 第 61 个元素。 */
	val t61: T61,
	/** 第 62 个元素。 */
	val t62: T62,
	/** 第 63 个元素。 */
	val t63: T63,
	/** 第 64 个元素。 */
	val t64: T64,
	/** 第 65 个元素。 */
	val t65: T65,
	/** 第 66 个元素。 */
	val t66: T66,
	/** 第 67 个元素。 */
	val t67: T67,
	/** 第 68 个元素。 */
	val t68: T68,
	/** 第 69 个元素。 */
	val t69: T69,
	/** 第 70 个元素。 */
	val t70: T70,
	/** 第 71 个元素。 */
	val t71: T71,
	/** 第 72 个元素。 */
	val t72: T72,
	/** 第 73 个元素。 */
	val t73: T73,
	/** 第 74 个元素。 */
	val t74: T74,
	/** 第 75 个元素。 */
	val t75: T75,
	/** 第 76 个元素。 */
	val t76: T76,
	/** 第 77 个元素。 */
	val t77: T77,
	/** 第 78 个元素。 */
	val t78: T78,
	/** 第 79 个元素。 */
	val t79: T79,
	/** 第 80 个元素。 */
	val t80: T80,
	/** 第 81 个元素。 */
	val t81: T81,
	/** 第 82 个元素。 */
	val t82: T82,
	/** 第 83 个元素。 */
	val t83: T83,
	/** 第 84 个元素。 */
	val t84: T84,
) : Tuple(84) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
	/** 返回第 58 个元素 [t58]，用于解构声明。 */
	operator fun component58(): T58 = t58
	/** 返回第 59 个元素 [t59]，用于解构声明。 */
	operator fun component59(): T59 = t59
	/** 返回第 60 个元素 [t60]，用于解构声明。 */
	operator fun component60(): T60 = t60
	/** 返回第 61 个元素 [t61]，用于解构声明。 */
	operator fun component61(): T61 = t61
	/** 返回第 62 个元素 [t62]，用于解构声明。 */
	operator fun component62(): T62 = t62
	/** 返回第 63 个元素 [t63]，用于解构声明。 */
	operator fun component63(): T63 = t63
	/** 返回第 64 个元素 [t64]，用于解构声明。 */
	operator fun component64(): T64 = t64
	/** 返回第 65 个元素 [t65]，用于解构声明。 */
	operator fun component65(): T65 = t65
	/** 返回第 66 个元素 [t66]，用于解构声明。 */
	operator fun component66(): T66 = t66
	/** 返回第 67 个元素 [t67]，用于解构声明。 */
	operator fun component67(): T67 = t67
	/** 返回第 68 个元素 [t68]，用于解构声明。 */
	operator fun component68(): T68 = t68
	/** 返回第 69 个元素 [t69]，用于解构声明。 */
	operator fun component69(): T69 = t69
	/** 返回第 70 个元素 [t70]，用于解构声明。 */
	operator fun component70(): T70 = t70
	/** 返回第 71 个元素 [t71]，用于解构声明。 */
	operator fun component71(): T71 = t71
	/** 返回第 72 个元素 [t72]，用于解构声明。 */
	operator fun component72(): T72 = t72
	/** 返回第 73 个元素 [t73]，用于解构声明。 */
	operator fun component73(): T73 = t73
	/** 返回第 74 个元素 [t74]，用于解构声明。 */
	operator fun component74(): T74 = t74
	/** 返回第 75 个元素 [t75]，用于解构声明。 */
	operator fun component75(): T75 = t75
	/** 返回第 76 个元素 [t76]，用于解构声明。 */
	operator fun component76(): T76 = t76
	/** 返回第 77 个元素 [t77]，用于解构声明。 */
	operator fun component77(): T77 = t77
	/** 返回第 78 个元素 [t78]，用于解构声明。 */
	operator fun component78(): T78 = t78
	/** 返回第 79 个元素 [t79]，用于解构声明。 */
	operator fun component79(): T79 = t79
	/** 返回第 80 个元素 [t80]，用于解构声明。 */
	operator fun component80(): T80 = t80
	/** 返回第 81 个元素 [t81]，用于解构声明。 */
	operator fun component81(): T81 = t81
	/** 返回第 82 个元素 [t82]，用于解构声明。 */
	operator fun component82(): T82 = t82
	/** 返回第 83 个元素 [t83]，用于解构声明。 */
	operator fun component83(): T83 = t83
	/** 返回第 84 个元素 [t84]，用于解构声明。 */
	operator fun component84(): T84 = t84
}

/**
 * 85 元组，持有 85 个元素（t1 ~ t85），支持解构声明。
 */
class Tuple85<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79, T80, T81, T82, T83, T84, T85>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
	/** 第 58 个元素。 */
	val t58: T58,
	/** 第 59 个元素。 */
	val t59: T59,
	/** 第 60 个元素。 */
	val t60: T60,
	/** 第 61 个元素。 */
	val t61: T61,
	/** 第 62 个元素。 */
	val t62: T62,
	/** 第 63 个元素。 */
	val t63: T63,
	/** 第 64 个元素。 */
	val t64: T64,
	/** 第 65 个元素。 */
	val t65: T65,
	/** 第 66 个元素。 */
	val t66: T66,
	/** 第 67 个元素。 */
	val t67: T67,
	/** 第 68 个元素。 */
	val t68: T68,
	/** 第 69 个元素。 */
	val t69: T69,
	/** 第 70 个元素。 */
	val t70: T70,
	/** 第 71 个元素。 */
	val t71: T71,
	/** 第 72 个元素。 */
	val t72: T72,
	/** 第 73 个元素。 */
	val t73: T73,
	/** 第 74 个元素。 */
	val t74: T74,
	/** 第 75 个元素。 */
	val t75: T75,
	/** 第 76 个元素。 */
	val t76: T76,
	/** 第 77 个元素。 */
	val t77: T77,
	/** 第 78 个元素。 */
	val t78: T78,
	/** 第 79 个元素。 */
	val t79: T79,
	/** 第 80 个元素。 */
	val t80: T80,
	/** 第 81 个元素。 */
	val t81: T81,
	/** 第 82 个元素。 */
	val t82: T82,
	/** 第 83 个元素。 */
	val t83: T83,
	/** 第 84 个元素。 */
	val t84: T84,
	/** 第 85 个元素。 */
	val t85: T85,
) : Tuple(85) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
	/** 返回第 58 个元素 [t58]，用于解构声明。 */
	operator fun component58(): T58 = t58
	/** 返回第 59 个元素 [t59]，用于解构声明。 */
	operator fun component59(): T59 = t59
	/** 返回第 60 个元素 [t60]，用于解构声明。 */
	operator fun component60(): T60 = t60
	/** 返回第 61 个元素 [t61]，用于解构声明。 */
	operator fun component61(): T61 = t61
	/** 返回第 62 个元素 [t62]，用于解构声明。 */
	operator fun component62(): T62 = t62
	/** 返回第 63 个元素 [t63]，用于解构声明。 */
	operator fun component63(): T63 = t63
	/** 返回第 64 个元素 [t64]，用于解构声明。 */
	operator fun component64(): T64 = t64
	/** 返回第 65 个元素 [t65]，用于解构声明。 */
	operator fun component65(): T65 = t65
	/** 返回第 66 个元素 [t66]，用于解构声明。 */
	operator fun component66(): T66 = t66
	/** 返回第 67 个元素 [t67]，用于解构声明。 */
	operator fun component67(): T67 = t67
	/** 返回第 68 个元素 [t68]，用于解构声明。 */
	operator fun component68(): T68 = t68
	/** 返回第 69 个元素 [t69]，用于解构声明。 */
	operator fun component69(): T69 = t69
	/** 返回第 70 个元素 [t70]，用于解构声明。 */
	operator fun component70(): T70 = t70
	/** 返回第 71 个元素 [t71]，用于解构声明。 */
	operator fun component71(): T71 = t71
	/** 返回第 72 个元素 [t72]，用于解构声明。 */
	operator fun component72(): T72 = t72
	/** 返回第 73 个元素 [t73]，用于解构声明。 */
	operator fun component73(): T73 = t73
	/** 返回第 74 个元素 [t74]，用于解构声明。 */
	operator fun component74(): T74 = t74
	/** 返回第 75 个元素 [t75]，用于解构声明。 */
	operator fun component75(): T75 = t75
	/** 返回第 76 个元素 [t76]，用于解构声明。 */
	operator fun component76(): T76 = t76
	/** 返回第 77 个元素 [t77]，用于解构声明。 */
	operator fun component77(): T77 = t77
	/** 返回第 78 个元素 [t78]，用于解构声明。 */
	operator fun component78(): T78 = t78
	/** 返回第 79 个元素 [t79]，用于解构声明。 */
	operator fun component79(): T79 = t79
	/** 返回第 80 个元素 [t80]，用于解构声明。 */
	operator fun component80(): T80 = t80
	/** 返回第 81 个元素 [t81]，用于解构声明。 */
	operator fun component81(): T81 = t81
	/** 返回第 82 个元素 [t82]，用于解构声明。 */
	operator fun component82(): T82 = t82
	/** 返回第 83 个元素 [t83]，用于解构声明。 */
	operator fun component83(): T83 = t83
	/** 返回第 84 个元素 [t84]，用于解构声明。 */
	operator fun component84(): T84 = t84
	/** 返回第 85 个元素 [t85]，用于解构声明。 */
	operator fun component85(): T85 = t85
}

/**
 * 86 元组，持有 86 个元素（t1 ~ t86），支持解构声明。
 */
class Tuple86<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79, T80, T81, T82, T83, T84, T85, T86>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
	/** 第 58 个元素。 */
	val t58: T58,
	/** 第 59 个元素。 */
	val t59: T59,
	/** 第 60 个元素。 */
	val t60: T60,
	/** 第 61 个元素。 */
	val t61: T61,
	/** 第 62 个元素。 */
	val t62: T62,
	/** 第 63 个元素。 */
	val t63: T63,
	/** 第 64 个元素。 */
	val t64: T64,
	/** 第 65 个元素。 */
	val t65: T65,
	/** 第 66 个元素。 */
	val t66: T66,
	/** 第 67 个元素。 */
	val t67: T67,
	/** 第 68 个元素。 */
	val t68: T68,
	/** 第 69 个元素。 */
	val t69: T69,
	/** 第 70 个元素。 */
	val t70: T70,
	/** 第 71 个元素。 */
	val t71: T71,
	/** 第 72 个元素。 */
	val t72: T72,
	/** 第 73 个元素。 */
	val t73: T73,
	/** 第 74 个元素。 */
	val t74: T74,
	/** 第 75 个元素。 */
	val t75: T75,
	/** 第 76 个元素。 */
	val t76: T76,
	/** 第 77 个元素。 */
	val t77: T77,
	/** 第 78 个元素。 */
	val t78: T78,
	/** 第 79 个元素。 */
	val t79: T79,
	/** 第 80 个元素。 */
	val t80: T80,
	/** 第 81 个元素。 */
	val t81: T81,
	/** 第 82 个元素。 */
	val t82: T82,
	/** 第 83 个元素。 */
	val t83: T83,
	/** 第 84 个元素。 */
	val t84: T84,
	/** 第 85 个元素。 */
	val t85: T85,
	/** 第 86 个元素。 */
	val t86: T86,
) : Tuple(86) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
	/** 返回第 58 个元素 [t58]，用于解构声明。 */
	operator fun component58(): T58 = t58
	/** 返回第 59 个元素 [t59]，用于解构声明。 */
	operator fun component59(): T59 = t59
	/** 返回第 60 个元素 [t60]，用于解构声明。 */
	operator fun component60(): T60 = t60
	/** 返回第 61 个元素 [t61]，用于解构声明。 */
	operator fun component61(): T61 = t61
	/** 返回第 62 个元素 [t62]，用于解构声明。 */
	operator fun component62(): T62 = t62
	/** 返回第 63 个元素 [t63]，用于解构声明。 */
	operator fun component63(): T63 = t63
	/** 返回第 64 个元素 [t64]，用于解构声明。 */
	operator fun component64(): T64 = t64
	/** 返回第 65 个元素 [t65]，用于解构声明。 */
	operator fun component65(): T65 = t65
	/** 返回第 66 个元素 [t66]，用于解构声明。 */
	operator fun component66(): T66 = t66
	/** 返回第 67 个元素 [t67]，用于解构声明。 */
	operator fun component67(): T67 = t67
	/** 返回第 68 个元素 [t68]，用于解构声明。 */
	operator fun component68(): T68 = t68
	/** 返回第 69 个元素 [t69]，用于解构声明。 */
	operator fun component69(): T69 = t69
	/** 返回第 70 个元素 [t70]，用于解构声明。 */
	operator fun component70(): T70 = t70
	/** 返回第 71 个元素 [t71]，用于解构声明。 */
	operator fun component71(): T71 = t71
	/** 返回第 72 个元素 [t72]，用于解构声明。 */
	operator fun component72(): T72 = t72
	/** 返回第 73 个元素 [t73]，用于解构声明。 */
	operator fun component73(): T73 = t73
	/** 返回第 74 个元素 [t74]，用于解构声明。 */
	operator fun component74(): T74 = t74
	/** 返回第 75 个元素 [t75]，用于解构声明。 */
	operator fun component75(): T75 = t75
	/** 返回第 76 个元素 [t76]，用于解构声明。 */
	operator fun component76(): T76 = t76
	/** 返回第 77 个元素 [t77]，用于解构声明。 */
	operator fun component77(): T77 = t77
	/** 返回第 78 个元素 [t78]，用于解构声明。 */
	operator fun component78(): T78 = t78
	/** 返回第 79 个元素 [t79]，用于解构声明。 */
	operator fun component79(): T79 = t79
	/** 返回第 80 个元素 [t80]，用于解构声明。 */
	operator fun component80(): T80 = t80
	/** 返回第 81 个元素 [t81]，用于解构声明。 */
	operator fun component81(): T81 = t81
	/** 返回第 82 个元素 [t82]，用于解构声明。 */
	operator fun component82(): T82 = t82
	/** 返回第 83 个元素 [t83]，用于解构声明。 */
	operator fun component83(): T83 = t83
	/** 返回第 84 个元素 [t84]，用于解构声明。 */
	operator fun component84(): T84 = t84
	/** 返回第 85 个元素 [t85]，用于解构声明。 */
	operator fun component85(): T85 = t85
	/** 返回第 86 个元素 [t86]，用于解构声明。 */
	operator fun component86(): T86 = t86
}

/**
 * 87 元组，持有 87 个元素（t1 ~ t87），支持解构声明。
 */
class Tuple87<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79, T80, T81, T82, T83, T84, T85, T86, T87>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
	/** 第 58 个元素。 */
	val t58: T58,
	/** 第 59 个元素。 */
	val t59: T59,
	/** 第 60 个元素。 */
	val t60: T60,
	/** 第 61 个元素。 */
	val t61: T61,
	/** 第 62 个元素。 */
	val t62: T62,
	/** 第 63 个元素。 */
	val t63: T63,
	/** 第 64 个元素。 */
	val t64: T64,
	/** 第 65 个元素。 */
	val t65: T65,
	/** 第 66 个元素。 */
	val t66: T66,
	/** 第 67 个元素。 */
	val t67: T67,
	/** 第 68 个元素。 */
	val t68: T68,
	/** 第 69 个元素。 */
	val t69: T69,
	/** 第 70 个元素。 */
	val t70: T70,
	/** 第 71 个元素。 */
	val t71: T71,
	/** 第 72 个元素。 */
	val t72: T72,
	/** 第 73 个元素。 */
	val t73: T73,
	/** 第 74 个元素。 */
	val t74: T74,
	/** 第 75 个元素。 */
	val t75: T75,
	/** 第 76 个元素。 */
	val t76: T76,
	/** 第 77 个元素。 */
	val t77: T77,
	/** 第 78 个元素。 */
	val t78: T78,
	/** 第 79 个元素。 */
	val t79: T79,
	/** 第 80 个元素。 */
	val t80: T80,
	/** 第 81 个元素。 */
	val t81: T81,
	/** 第 82 个元素。 */
	val t82: T82,
	/** 第 83 个元素。 */
	val t83: T83,
	/** 第 84 个元素。 */
	val t84: T84,
	/** 第 85 个元素。 */
	val t85: T85,
	/** 第 86 个元素。 */
	val t86: T86,
	/** 第 87 个元素。 */
	val t87: T87,
) : Tuple(87) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
	/** 返回第 58 个元素 [t58]，用于解构声明。 */
	operator fun component58(): T58 = t58
	/** 返回第 59 个元素 [t59]，用于解构声明。 */
	operator fun component59(): T59 = t59
	/** 返回第 60 个元素 [t60]，用于解构声明。 */
	operator fun component60(): T60 = t60
	/** 返回第 61 个元素 [t61]，用于解构声明。 */
	operator fun component61(): T61 = t61
	/** 返回第 62 个元素 [t62]，用于解构声明。 */
	operator fun component62(): T62 = t62
	/** 返回第 63 个元素 [t63]，用于解构声明。 */
	operator fun component63(): T63 = t63
	/** 返回第 64 个元素 [t64]，用于解构声明。 */
	operator fun component64(): T64 = t64
	/** 返回第 65 个元素 [t65]，用于解构声明。 */
	operator fun component65(): T65 = t65
	/** 返回第 66 个元素 [t66]，用于解构声明。 */
	operator fun component66(): T66 = t66
	/** 返回第 67 个元素 [t67]，用于解构声明。 */
	operator fun component67(): T67 = t67
	/** 返回第 68 个元素 [t68]，用于解构声明。 */
	operator fun component68(): T68 = t68
	/** 返回第 69 个元素 [t69]，用于解构声明。 */
	operator fun component69(): T69 = t69
	/** 返回第 70 个元素 [t70]，用于解构声明。 */
	operator fun component70(): T70 = t70
	/** 返回第 71 个元素 [t71]，用于解构声明。 */
	operator fun component71(): T71 = t71
	/** 返回第 72 个元素 [t72]，用于解构声明。 */
	operator fun component72(): T72 = t72
	/** 返回第 73 个元素 [t73]，用于解构声明。 */
	operator fun component73(): T73 = t73
	/** 返回第 74 个元素 [t74]，用于解构声明。 */
	operator fun component74(): T74 = t74
	/** 返回第 75 个元素 [t75]，用于解构声明。 */
	operator fun component75(): T75 = t75
	/** 返回第 76 个元素 [t76]，用于解构声明。 */
	operator fun component76(): T76 = t76
	/** 返回第 77 个元素 [t77]，用于解构声明。 */
	operator fun component77(): T77 = t77
	/** 返回第 78 个元素 [t78]，用于解构声明。 */
	operator fun component78(): T78 = t78
	/** 返回第 79 个元素 [t79]，用于解构声明。 */
	operator fun component79(): T79 = t79
	/** 返回第 80 个元素 [t80]，用于解构声明。 */
	operator fun component80(): T80 = t80
	/** 返回第 81 个元素 [t81]，用于解构声明。 */
	operator fun component81(): T81 = t81
	/** 返回第 82 个元素 [t82]，用于解构声明。 */
	operator fun component82(): T82 = t82
	/** 返回第 83 个元素 [t83]，用于解构声明。 */
	operator fun component83(): T83 = t83
	/** 返回第 84 个元素 [t84]，用于解构声明。 */
	operator fun component84(): T84 = t84
	/** 返回第 85 个元素 [t85]，用于解构声明。 */
	operator fun component85(): T85 = t85
	/** 返回第 86 个元素 [t86]，用于解构声明。 */
	operator fun component86(): T86 = t86
	/** 返回第 87 个元素 [t87]，用于解构声明。 */
	operator fun component87(): T87 = t87
}

/**
 * 88 元组，持有 88 个元素（t1 ~ t88），支持解构声明。
 */
class Tuple88<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79, T80, T81, T82, T83, T84, T85, T86, T87, T88>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
	/** 第 58 个元素。 */
	val t58: T58,
	/** 第 59 个元素。 */
	val t59: T59,
	/** 第 60 个元素。 */
	val t60: T60,
	/** 第 61 个元素。 */
	val t61: T61,
	/** 第 62 个元素。 */
	val t62: T62,
	/** 第 63 个元素。 */
	val t63: T63,
	/** 第 64 个元素。 */
	val t64: T64,
	/** 第 65 个元素。 */
	val t65: T65,
	/** 第 66 个元素。 */
	val t66: T66,
	/** 第 67 个元素。 */
	val t67: T67,
	/** 第 68 个元素。 */
	val t68: T68,
	/** 第 69 个元素。 */
	val t69: T69,
	/** 第 70 个元素。 */
	val t70: T70,
	/** 第 71 个元素。 */
	val t71: T71,
	/** 第 72 个元素。 */
	val t72: T72,
	/** 第 73 个元素。 */
	val t73: T73,
	/** 第 74 个元素。 */
	val t74: T74,
	/** 第 75 个元素。 */
	val t75: T75,
	/** 第 76 个元素。 */
	val t76: T76,
	/** 第 77 个元素。 */
	val t77: T77,
	/** 第 78 个元素。 */
	val t78: T78,
	/** 第 79 个元素。 */
	val t79: T79,
	/** 第 80 个元素。 */
	val t80: T80,
	/** 第 81 个元素。 */
	val t81: T81,
	/** 第 82 个元素。 */
	val t82: T82,
	/** 第 83 个元素。 */
	val t83: T83,
	/** 第 84 个元素。 */
	val t84: T84,
	/** 第 85 个元素。 */
	val t85: T85,
	/** 第 86 个元素。 */
	val t86: T86,
	/** 第 87 个元素。 */
	val t87: T87,
	/** 第 88 个元素。 */
	val t88: T88,
) : Tuple(88) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
	/** 返回第 58 个元素 [t58]，用于解构声明。 */
	operator fun component58(): T58 = t58
	/** 返回第 59 个元素 [t59]，用于解构声明。 */
	operator fun component59(): T59 = t59
	/** 返回第 60 个元素 [t60]，用于解构声明。 */
	operator fun component60(): T60 = t60
	/** 返回第 61 个元素 [t61]，用于解构声明。 */
	operator fun component61(): T61 = t61
	/** 返回第 62 个元素 [t62]，用于解构声明。 */
	operator fun component62(): T62 = t62
	/** 返回第 63 个元素 [t63]，用于解构声明。 */
	operator fun component63(): T63 = t63
	/** 返回第 64 个元素 [t64]，用于解构声明。 */
	operator fun component64(): T64 = t64
	/** 返回第 65 个元素 [t65]，用于解构声明。 */
	operator fun component65(): T65 = t65
	/** 返回第 66 个元素 [t66]，用于解构声明。 */
	operator fun component66(): T66 = t66
	/** 返回第 67 个元素 [t67]，用于解构声明。 */
	operator fun component67(): T67 = t67
	/** 返回第 68 个元素 [t68]，用于解构声明。 */
	operator fun component68(): T68 = t68
	/** 返回第 69 个元素 [t69]，用于解构声明。 */
	operator fun component69(): T69 = t69
	/** 返回第 70 个元素 [t70]，用于解构声明。 */
	operator fun component70(): T70 = t70
	/** 返回第 71 个元素 [t71]，用于解构声明。 */
	operator fun component71(): T71 = t71
	/** 返回第 72 个元素 [t72]，用于解构声明。 */
	operator fun component72(): T72 = t72
	/** 返回第 73 个元素 [t73]，用于解构声明。 */
	operator fun component73(): T73 = t73
	/** 返回第 74 个元素 [t74]，用于解构声明。 */
	operator fun component74(): T74 = t74
	/** 返回第 75 个元素 [t75]，用于解构声明。 */
	operator fun component75(): T75 = t75
	/** 返回第 76 个元素 [t76]，用于解构声明。 */
	operator fun component76(): T76 = t76
	/** 返回第 77 个元素 [t77]，用于解构声明。 */
	operator fun component77(): T77 = t77
	/** 返回第 78 个元素 [t78]，用于解构声明。 */
	operator fun component78(): T78 = t78
	/** 返回第 79 个元素 [t79]，用于解构声明。 */
	operator fun component79(): T79 = t79
	/** 返回第 80 个元素 [t80]，用于解构声明。 */
	operator fun component80(): T80 = t80
	/** 返回第 81 个元素 [t81]，用于解构声明。 */
	operator fun component81(): T81 = t81
	/** 返回第 82 个元素 [t82]，用于解构声明。 */
	operator fun component82(): T82 = t82
	/** 返回第 83 个元素 [t83]，用于解构声明。 */
	operator fun component83(): T83 = t83
	/** 返回第 84 个元素 [t84]，用于解构声明。 */
	operator fun component84(): T84 = t84
	/** 返回第 85 个元素 [t85]，用于解构声明。 */
	operator fun component85(): T85 = t85
	/** 返回第 86 个元素 [t86]，用于解构声明。 */
	operator fun component86(): T86 = t86
	/** 返回第 87 个元素 [t87]，用于解构声明。 */
	operator fun component87(): T87 = t87
	/** 返回第 88 个元素 [t88]，用于解构声明。 */
	operator fun component88(): T88 = t88
}

/**
 * 89 元组，持有 89 个元素（t1 ~ t89），支持解构声明。
 */
class Tuple89<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79, T80, T81, T82, T83, T84, T85, T86, T87, T88, T89>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
	/** 第 58 个元素。 */
	val t58: T58,
	/** 第 59 个元素。 */
	val t59: T59,
	/** 第 60 个元素。 */
	val t60: T60,
	/** 第 61 个元素。 */
	val t61: T61,
	/** 第 62 个元素。 */
	val t62: T62,
	/** 第 63 个元素。 */
	val t63: T63,
	/** 第 64 个元素。 */
	val t64: T64,
	/** 第 65 个元素。 */
	val t65: T65,
	/** 第 66 个元素。 */
	val t66: T66,
	/** 第 67 个元素。 */
	val t67: T67,
	/** 第 68 个元素。 */
	val t68: T68,
	/** 第 69 个元素。 */
	val t69: T69,
	/** 第 70 个元素。 */
	val t70: T70,
	/** 第 71 个元素。 */
	val t71: T71,
	/** 第 72 个元素。 */
	val t72: T72,
	/** 第 73 个元素。 */
	val t73: T73,
	/** 第 74 个元素。 */
	val t74: T74,
	/** 第 75 个元素。 */
	val t75: T75,
	/** 第 76 个元素。 */
	val t76: T76,
	/** 第 77 个元素。 */
	val t77: T77,
	/** 第 78 个元素。 */
	val t78: T78,
	/** 第 79 个元素。 */
	val t79: T79,
	/** 第 80 个元素。 */
	val t80: T80,
	/** 第 81 个元素。 */
	val t81: T81,
	/** 第 82 个元素。 */
	val t82: T82,
	/** 第 83 个元素。 */
	val t83: T83,
	/** 第 84 个元素。 */
	val t84: T84,
	/** 第 85 个元素。 */
	val t85: T85,
	/** 第 86 个元素。 */
	val t86: T86,
	/** 第 87 个元素。 */
	val t87: T87,
	/** 第 88 个元素。 */
	val t88: T88,
	/** 第 89 个元素。 */
	val t89: T89,
) : Tuple(89) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
	/** 返回第 58 个元素 [t58]，用于解构声明。 */
	operator fun component58(): T58 = t58
	/** 返回第 59 个元素 [t59]，用于解构声明。 */
	operator fun component59(): T59 = t59
	/** 返回第 60 个元素 [t60]，用于解构声明。 */
	operator fun component60(): T60 = t60
	/** 返回第 61 个元素 [t61]，用于解构声明。 */
	operator fun component61(): T61 = t61
	/** 返回第 62 个元素 [t62]，用于解构声明。 */
	operator fun component62(): T62 = t62
	/** 返回第 63 个元素 [t63]，用于解构声明。 */
	operator fun component63(): T63 = t63
	/** 返回第 64 个元素 [t64]，用于解构声明。 */
	operator fun component64(): T64 = t64
	/** 返回第 65 个元素 [t65]，用于解构声明。 */
	operator fun component65(): T65 = t65
	/** 返回第 66 个元素 [t66]，用于解构声明。 */
	operator fun component66(): T66 = t66
	/** 返回第 67 个元素 [t67]，用于解构声明。 */
	operator fun component67(): T67 = t67
	/** 返回第 68 个元素 [t68]，用于解构声明。 */
	operator fun component68(): T68 = t68
	/** 返回第 69 个元素 [t69]，用于解构声明。 */
	operator fun component69(): T69 = t69
	/** 返回第 70 个元素 [t70]，用于解构声明。 */
	operator fun component70(): T70 = t70
	/** 返回第 71 个元素 [t71]，用于解构声明。 */
	operator fun component71(): T71 = t71
	/** 返回第 72 个元素 [t72]，用于解构声明。 */
	operator fun component72(): T72 = t72
	/** 返回第 73 个元素 [t73]，用于解构声明。 */
	operator fun component73(): T73 = t73
	/** 返回第 74 个元素 [t74]，用于解构声明。 */
	operator fun component74(): T74 = t74
	/** 返回第 75 个元素 [t75]，用于解构声明。 */
	operator fun component75(): T75 = t75
	/** 返回第 76 个元素 [t76]，用于解构声明。 */
	operator fun component76(): T76 = t76
	/** 返回第 77 个元素 [t77]，用于解构声明。 */
	operator fun component77(): T77 = t77
	/** 返回第 78 个元素 [t78]，用于解构声明。 */
	operator fun component78(): T78 = t78
	/** 返回第 79 个元素 [t79]，用于解构声明。 */
	operator fun component79(): T79 = t79
	/** 返回第 80 个元素 [t80]，用于解构声明。 */
	operator fun component80(): T80 = t80
	/** 返回第 81 个元素 [t81]，用于解构声明。 */
	operator fun component81(): T81 = t81
	/** 返回第 82 个元素 [t82]，用于解构声明。 */
	operator fun component82(): T82 = t82
	/** 返回第 83 个元素 [t83]，用于解构声明。 */
	operator fun component83(): T83 = t83
	/** 返回第 84 个元素 [t84]，用于解构声明。 */
	operator fun component84(): T84 = t84
	/** 返回第 85 个元素 [t85]，用于解构声明。 */
	operator fun component85(): T85 = t85
	/** 返回第 86 个元素 [t86]，用于解构声明。 */
	operator fun component86(): T86 = t86
	/** 返回第 87 个元素 [t87]，用于解构声明。 */
	operator fun component87(): T87 = t87
	/** 返回第 88 个元素 [t88]，用于解构声明。 */
	operator fun component88(): T88 = t88
	/** 返回第 89 个元素 [t89]，用于解构声明。 */
	operator fun component89(): T89 = t89
}

/**
 * 90 元组，持有 90 个元素（t1 ~ t90），支持解构声明。
 */
class Tuple90<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79, T80, T81, T82, T83, T84, T85, T86, T87, T88, T89, T90>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
	/** 第 58 个元素。 */
	val t58: T58,
	/** 第 59 个元素。 */
	val t59: T59,
	/** 第 60 个元素。 */
	val t60: T60,
	/** 第 61 个元素。 */
	val t61: T61,
	/** 第 62 个元素。 */
	val t62: T62,
	/** 第 63 个元素。 */
	val t63: T63,
	/** 第 64 个元素。 */
	val t64: T64,
	/** 第 65 个元素。 */
	val t65: T65,
	/** 第 66 个元素。 */
	val t66: T66,
	/** 第 67 个元素。 */
	val t67: T67,
	/** 第 68 个元素。 */
	val t68: T68,
	/** 第 69 个元素。 */
	val t69: T69,
	/** 第 70 个元素。 */
	val t70: T70,
	/** 第 71 个元素。 */
	val t71: T71,
	/** 第 72 个元素。 */
	val t72: T72,
	/** 第 73 个元素。 */
	val t73: T73,
	/** 第 74 个元素。 */
	val t74: T74,
	/** 第 75 个元素。 */
	val t75: T75,
	/** 第 76 个元素。 */
	val t76: T76,
	/** 第 77 个元素。 */
	val t77: T77,
	/** 第 78 个元素。 */
	val t78: T78,
	/** 第 79 个元素。 */
	val t79: T79,
	/** 第 80 个元素。 */
	val t80: T80,
	/** 第 81 个元素。 */
	val t81: T81,
	/** 第 82 个元素。 */
	val t82: T82,
	/** 第 83 个元素。 */
	val t83: T83,
	/** 第 84 个元素。 */
	val t84: T84,
	/** 第 85 个元素。 */
	val t85: T85,
	/** 第 86 个元素。 */
	val t86: T86,
	/** 第 87 个元素。 */
	val t87: T87,
	/** 第 88 个元素。 */
	val t88: T88,
	/** 第 89 个元素。 */
	val t89: T89,
	/** 第 90 个元素。 */
	val t90: T90,
) : Tuple(90) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
	/** 返回第 58 个元素 [t58]，用于解构声明。 */
	operator fun component58(): T58 = t58
	/** 返回第 59 个元素 [t59]，用于解构声明。 */
	operator fun component59(): T59 = t59
	/** 返回第 60 个元素 [t60]，用于解构声明。 */
	operator fun component60(): T60 = t60
	/** 返回第 61 个元素 [t61]，用于解构声明。 */
	operator fun component61(): T61 = t61
	/** 返回第 62 个元素 [t62]，用于解构声明。 */
	operator fun component62(): T62 = t62
	/** 返回第 63 个元素 [t63]，用于解构声明。 */
	operator fun component63(): T63 = t63
	/** 返回第 64 个元素 [t64]，用于解构声明。 */
	operator fun component64(): T64 = t64
	/** 返回第 65 个元素 [t65]，用于解构声明。 */
	operator fun component65(): T65 = t65
	/** 返回第 66 个元素 [t66]，用于解构声明。 */
	operator fun component66(): T66 = t66
	/** 返回第 67 个元素 [t67]，用于解构声明。 */
	operator fun component67(): T67 = t67
	/** 返回第 68 个元素 [t68]，用于解构声明。 */
	operator fun component68(): T68 = t68
	/** 返回第 69 个元素 [t69]，用于解构声明。 */
	operator fun component69(): T69 = t69
	/** 返回第 70 个元素 [t70]，用于解构声明。 */
	operator fun component70(): T70 = t70
	/** 返回第 71 个元素 [t71]，用于解构声明。 */
	operator fun component71(): T71 = t71
	/** 返回第 72 个元素 [t72]，用于解构声明。 */
	operator fun component72(): T72 = t72
	/** 返回第 73 个元素 [t73]，用于解构声明。 */
	operator fun component73(): T73 = t73
	/** 返回第 74 个元素 [t74]，用于解构声明。 */
	operator fun component74(): T74 = t74
	/** 返回第 75 个元素 [t75]，用于解构声明。 */
	operator fun component75(): T75 = t75
	/** 返回第 76 个元素 [t76]，用于解构声明。 */
	operator fun component76(): T76 = t76
	/** 返回第 77 个元素 [t77]，用于解构声明。 */
	operator fun component77(): T77 = t77
	/** 返回第 78 个元素 [t78]，用于解构声明。 */
	operator fun component78(): T78 = t78
	/** 返回第 79 个元素 [t79]，用于解构声明。 */
	operator fun component79(): T79 = t79
	/** 返回第 80 个元素 [t80]，用于解构声明。 */
	operator fun component80(): T80 = t80
	/** 返回第 81 个元素 [t81]，用于解构声明。 */
	operator fun component81(): T81 = t81
	/** 返回第 82 个元素 [t82]，用于解构声明。 */
	operator fun component82(): T82 = t82
	/** 返回第 83 个元素 [t83]，用于解构声明。 */
	operator fun component83(): T83 = t83
	/** 返回第 84 个元素 [t84]，用于解构声明。 */
	operator fun component84(): T84 = t84
	/** 返回第 85 个元素 [t85]，用于解构声明。 */
	operator fun component85(): T85 = t85
	/** 返回第 86 个元素 [t86]，用于解构声明。 */
	operator fun component86(): T86 = t86
	/** 返回第 87 个元素 [t87]，用于解构声明。 */
	operator fun component87(): T87 = t87
	/** 返回第 88 个元素 [t88]，用于解构声明。 */
	operator fun component88(): T88 = t88
	/** 返回第 89 个元素 [t89]，用于解构声明。 */
	operator fun component89(): T89 = t89
	/** 返回第 90 个元素 [t90]，用于解构声明。 */
	operator fun component90(): T90 = t90
}

/**
 * 91 元组，持有 91 个元素（t1 ~ t91），支持解构声明。
 */
class Tuple91<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79, T80, T81, T82, T83, T84, T85, T86, T87, T88, T89, T90, T91>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
	/** 第 58 个元素。 */
	val t58: T58,
	/** 第 59 个元素。 */
	val t59: T59,
	/** 第 60 个元素。 */
	val t60: T60,
	/** 第 61 个元素。 */
	val t61: T61,
	/** 第 62 个元素。 */
	val t62: T62,
	/** 第 63 个元素。 */
	val t63: T63,
	/** 第 64 个元素。 */
	val t64: T64,
	/** 第 65 个元素。 */
	val t65: T65,
	/** 第 66 个元素。 */
	val t66: T66,
	/** 第 67 个元素。 */
	val t67: T67,
	/** 第 68 个元素。 */
	val t68: T68,
	/** 第 69 个元素。 */
	val t69: T69,
	/** 第 70 个元素。 */
	val t70: T70,
	/** 第 71 个元素。 */
	val t71: T71,
	/** 第 72 个元素。 */
	val t72: T72,
	/** 第 73 个元素。 */
	val t73: T73,
	/** 第 74 个元素。 */
	val t74: T74,
	/** 第 75 个元素。 */
	val t75: T75,
	/** 第 76 个元素。 */
	val t76: T76,
	/** 第 77 个元素。 */
	val t77: T77,
	/** 第 78 个元素。 */
	val t78: T78,
	/** 第 79 个元素。 */
	val t79: T79,
	/** 第 80 个元素。 */
	val t80: T80,
	/** 第 81 个元素。 */
	val t81: T81,
	/** 第 82 个元素。 */
	val t82: T82,
	/** 第 83 个元素。 */
	val t83: T83,
	/** 第 84 个元素。 */
	val t84: T84,
	/** 第 85 个元素。 */
	val t85: T85,
	/** 第 86 个元素。 */
	val t86: T86,
	/** 第 87 个元素。 */
	val t87: T87,
	/** 第 88 个元素。 */
	val t88: T88,
	/** 第 89 个元素。 */
	val t89: T89,
	/** 第 90 个元素。 */
	val t90: T90,
	/** 第 91 个元素。 */
	val t91: T91,
) : Tuple(91) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
	/** 返回第 58 个元素 [t58]，用于解构声明。 */
	operator fun component58(): T58 = t58
	/** 返回第 59 个元素 [t59]，用于解构声明。 */
	operator fun component59(): T59 = t59
	/** 返回第 60 个元素 [t60]，用于解构声明。 */
	operator fun component60(): T60 = t60
	/** 返回第 61 个元素 [t61]，用于解构声明。 */
	operator fun component61(): T61 = t61
	/** 返回第 62 个元素 [t62]，用于解构声明。 */
	operator fun component62(): T62 = t62
	/** 返回第 63 个元素 [t63]，用于解构声明。 */
	operator fun component63(): T63 = t63
	/** 返回第 64 个元素 [t64]，用于解构声明。 */
	operator fun component64(): T64 = t64
	/** 返回第 65 个元素 [t65]，用于解构声明。 */
	operator fun component65(): T65 = t65
	/** 返回第 66 个元素 [t66]，用于解构声明。 */
	operator fun component66(): T66 = t66
	/** 返回第 67 个元素 [t67]，用于解构声明。 */
	operator fun component67(): T67 = t67
	/** 返回第 68 个元素 [t68]，用于解构声明。 */
	operator fun component68(): T68 = t68
	/** 返回第 69 个元素 [t69]，用于解构声明。 */
	operator fun component69(): T69 = t69
	/** 返回第 70 个元素 [t70]，用于解构声明。 */
	operator fun component70(): T70 = t70
	/** 返回第 71 个元素 [t71]，用于解构声明。 */
	operator fun component71(): T71 = t71
	/** 返回第 72 个元素 [t72]，用于解构声明。 */
	operator fun component72(): T72 = t72
	/** 返回第 73 个元素 [t73]，用于解构声明。 */
	operator fun component73(): T73 = t73
	/** 返回第 74 个元素 [t74]，用于解构声明。 */
	operator fun component74(): T74 = t74
	/** 返回第 75 个元素 [t75]，用于解构声明。 */
	operator fun component75(): T75 = t75
	/** 返回第 76 个元素 [t76]，用于解构声明。 */
	operator fun component76(): T76 = t76
	/** 返回第 77 个元素 [t77]，用于解构声明。 */
	operator fun component77(): T77 = t77
	/** 返回第 78 个元素 [t78]，用于解构声明。 */
	operator fun component78(): T78 = t78
	/** 返回第 79 个元素 [t79]，用于解构声明。 */
	operator fun component79(): T79 = t79
	/** 返回第 80 个元素 [t80]，用于解构声明。 */
	operator fun component80(): T80 = t80
	/** 返回第 81 个元素 [t81]，用于解构声明。 */
	operator fun component81(): T81 = t81
	/** 返回第 82 个元素 [t82]，用于解构声明。 */
	operator fun component82(): T82 = t82
	/** 返回第 83 个元素 [t83]，用于解构声明。 */
	operator fun component83(): T83 = t83
	/** 返回第 84 个元素 [t84]，用于解构声明。 */
	operator fun component84(): T84 = t84
	/** 返回第 85 个元素 [t85]，用于解构声明。 */
	operator fun component85(): T85 = t85
	/** 返回第 86 个元素 [t86]，用于解构声明。 */
	operator fun component86(): T86 = t86
	/** 返回第 87 个元素 [t87]，用于解构声明。 */
	operator fun component87(): T87 = t87
	/** 返回第 88 个元素 [t88]，用于解构声明。 */
	operator fun component88(): T88 = t88
	/** 返回第 89 个元素 [t89]，用于解构声明。 */
	operator fun component89(): T89 = t89
	/** 返回第 90 个元素 [t90]，用于解构声明。 */
	operator fun component90(): T90 = t90
	/** 返回第 91 个元素 [t91]，用于解构声明。 */
	operator fun component91(): T91 = t91
}

/**
 * 92 元组，持有 92 个元素（t1 ~ t92），支持解构声明。
 */
class Tuple92<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79, T80, T81, T82, T83, T84, T85, T86, T87, T88, T89, T90, T91, T92>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
	/** 第 58 个元素。 */
	val t58: T58,
	/** 第 59 个元素。 */
	val t59: T59,
	/** 第 60 个元素。 */
	val t60: T60,
	/** 第 61 个元素。 */
	val t61: T61,
	/** 第 62 个元素。 */
	val t62: T62,
	/** 第 63 个元素。 */
	val t63: T63,
	/** 第 64 个元素。 */
	val t64: T64,
	/** 第 65 个元素。 */
	val t65: T65,
	/** 第 66 个元素。 */
	val t66: T66,
	/** 第 67 个元素。 */
	val t67: T67,
	/** 第 68 个元素。 */
	val t68: T68,
	/** 第 69 个元素。 */
	val t69: T69,
	/** 第 70 个元素。 */
	val t70: T70,
	/** 第 71 个元素。 */
	val t71: T71,
	/** 第 72 个元素。 */
	val t72: T72,
	/** 第 73 个元素。 */
	val t73: T73,
	/** 第 74 个元素。 */
	val t74: T74,
	/** 第 75 个元素。 */
	val t75: T75,
	/** 第 76 个元素。 */
	val t76: T76,
	/** 第 77 个元素。 */
	val t77: T77,
	/** 第 78 个元素。 */
	val t78: T78,
	/** 第 79 个元素。 */
	val t79: T79,
	/** 第 80 个元素。 */
	val t80: T80,
	/** 第 81 个元素。 */
	val t81: T81,
	/** 第 82 个元素。 */
	val t82: T82,
	/** 第 83 个元素。 */
	val t83: T83,
	/** 第 84 个元素。 */
	val t84: T84,
	/** 第 85 个元素。 */
	val t85: T85,
	/** 第 86 个元素。 */
	val t86: T86,
	/** 第 87 个元素。 */
	val t87: T87,
	/** 第 88 个元素。 */
	val t88: T88,
	/** 第 89 个元素。 */
	val t89: T89,
	/** 第 90 个元素。 */
	val t90: T90,
	/** 第 91 个元素。 */
	val t91: T91,
	/** 第 92 个元素。 */
	val t92: T92,
) : Tuple(92) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
	/** 返回第 58 个元素 [t58]，用于解构声明。 */
	operator fun component58(): T58 = t58
	/** 返回第 59 个元素 [t59]，用于解构声明。 */
	operator fun component59(): T59 = t59
	/** 返回第 60 个元素 [t60]，用于解构声明。 */
	operator fun component60(): T60 = t60
	/** 返回第 61 个元素 [t61]，用于解构声明。 */
	operator fun component61(): T61 = t61
	/** 返回第 62 个元素 [t62]，用于解构声明。 */
	operator fun component62(): T62 = t62
	/** 返回第 63 个元素 [t63]，用于解构声明。 */
	operator fun component63(): T63 = t63
	/** 返回第 64 个元素 [t64]，用于解构声明。 */
	operator fun component64(): T64 = t64
	/** 返回第 65 个元素 [t65]，用于解构声明。 */
	operator fun component65(): T65 = t65
	/** 返回第 66 个元素 [t66]，用于解构声明。 */
	operator fun component66(): T66 = t66
	/** 返回第 67 个元素 [t67]，用于解构声明。 */
	operator fun component67(): T67 = t67
	/** 返回第 68 个元素 [t68]，用于解构声明。 */
	operator fun component68(): T68 = t68
	/** 返回第 69 个元素 [t69]，用于解构声明。 */
	operator fun component69(): T69 = t69
	/** 返回第 70 个元素 [t70]，用于解构声明。 */
	operator fun component70(): T70 = t70
	/** 返回第 71 个元素 [t71]，用于解构声明。 */
	operator fun component71(): T71 = t71
	/** 返回第 72 个元素 [t72]，用于解构声明。 */
	operator fun component72(): T72 = t72
	/** 返回第 73 个元素 [t73]，用于解构声明。 */
	operator fun component73(): T73 = t73
	/** 返回第 74 个元素 [t74]，用于解构声明。 */
	operator fun component74(): T74 = t74
	/** 返回第 75 个元素 [t75]，用于解构声明。 */
	operator fun component75(): T75 = t75
	/** 返回第 76 个元素 [t76]，用于解构声明。 */
	operator fun component76(): T76 = t76
	/** 返回第 77 个元素 [t77]，用于解构声明。 */
	operator fun component77(): T77 = t77
	/** 返回第 78 个元素 [t78]，用于解构声明。 */
	operator fun component78(): T78 = t78
	/** 返回第 79 个元素 [t79]，用于解构声明。 */
	operator fun component79(): T79 = t79
	/** 返回第 80 个元素 [t80]，用于解构声明。 */
	operator fun component80(): T80 = t80
	/** 返回第 81 个元素 [t81]，用于解构声明。 */
	operator fun component81(): T81 = t81
	/** 返回第 82 个元素 [t82]，用于解构声明。 */
	operator fun component82(): T82 = t82
	/** 返回第 83 个元素 [t83]，用于解构声明。 */
	operator fun component83(): T83 = t83
	/** 返回第 84 个元素 [t84]，用于解构声明。 */
	operator fun component84(): T84 = t84
	/** 返回第 85 个元素 [t85]，用于解构声明。 */
	operator fun component85(): T85 = t85
	/** 返回第 86 个元素 [t86]，用于解构声明。 */
	operator fun component86(): T86 = t86
	/** 返回第 87 个元素 [t87]，用于解构声明。 */
	operator fun component87(): T87 = t87
	/** 返回第 88 个元素 [t88]，用于解构声明。 */
	operator fun component88(): T88 = t88
	/** 返回第 89 个元素 [t89]，用于解构声明。 */
	operator fun component89(): T89 = t89
	/** 返回第 90 个元素 [t90]，用于解构声明。 */
	operator fun component90(): T90 = t90
	/** 返回第 91 个元素 [t91]，用于解构声明。 */
	operator fun component91(): T91 = t91
	/** 返回第 92 个元素 [t92]，用于解构声明。 */
	operator fun component92(): T92 = t92
}

/**
 * 93 元组，持有 93 个元素（t1 ~ t93），支持解构声明。
 */
class Tuple93<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79, T80, T81, T82, T83, T84, T85, T86, T87, T88, T89, T90, T91, T92, T93>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
	/** 第 58 个元素。 */
	val t58: T58,
	/** 第 59 个元素。 */
	val t59: T59,
	/** 第 60 个元素。 */
	val t60: T60,
	/** 第 61 个元素。 */
	val t61: T61,
	/** 第 62 个元素。 */
	val t62: T62,
	/** 第 63 个元素。 */
	val t63: T63,
	/** 第 64 个元素。 */
	val t64: T64,
	/** 第 65 个元素。 */
	val t65: T65,
	/** 第 66 个元素。 */
	val t66: T66,
	/** 第 67 个元素。 */
	val t67: T67,
	/** 第 68 个元素。 */
	val t68: T68,
	/** 第 69 个元素。 */
	val t69: T69,
	/** 第 70 个元素。 */
	val t70: T70,
	/** 第 71 个元素。 */
	val t71: T71,
	/** 第 72 个元素。 */
	val t72: T72,
	/** 第 73 个元素。 */
	val t73: T73,
	/** 第 74 个元素。 */
	val t74: T74,
	/** 第 75 个元素。 */
	val t75: T75,
	/** 第 76 个元素。 */
	val t76: T76,
	/** 第 77 个元素。 */
	val t77: T77,
	/** 第 78 个元素。 */
	val t78: T78,
	/** 第 79 个元素。 */
	val t79: T79,
	/** 第 80 个元素。 */
	val t80: T80,
	/** 第 81 个元素。 */
	val t81: T81,
	/** 第 82 个元素。 */
	val t82: T82,
	/** 第 83 个元素。 */
	val t83: T83,
	/** 第 84 个元素。 */
	val t84: T84,
	/** 第 85 个元素。 */
	val t85: T85,
	/** 第 86 个元素。 */
	val t86: T86,
	/** 第 87 个元素。 */
	val t87: T87,
	/** 第 88 个元素。 */
	val t88: T88,
	/** 第 89 个元素。 */
	val t89: T89,
	/** 第 90 个元素。 */
	val t90: T90,
	/** 第 91 个元素。 */
	val t91: T91,
	/** 第 92 个元素。 */
	val t92: T92,
	/** 第 93 个元素。 */
	val t93: T93,
) : Tuple(93) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
	/** 返回第 58 个元素 [t58]，用于解构声明。 */
	operator fun component58(): T58 = t58
	/** 返回第 59 个元素 [t59]，用于解构声明。 */
	operator fun component59(): T59 = t59
	/** 返回第 60 个元素 [t60]，用于解构声明。 */
	operator fun component60(): T60 = t60
	/** 返回第 61 个元素 [t61]，用于解构声明。 */
	operator fun component61(): T61 = t61
	/** 返回第 62 个元素 [t62]，用于解构声明。 */
	operator fun component62(): T62 = t62
	/** 返回第 63 个元素 [t63]，用于解构声明。 */
	operator fun component63(): T63 = t63
	/** 返回第 64 个元素 [t64]，用于解构声明。 */
	operator fun component64(): T64 = t64
	/** 返回第 65 个元素 [t65]，用于解构声明。 */
	operator fun component65(): T65 = t65
	/** 返回第 66 个元素 [t66]，用于解构声明。 */
	operator fun component66(): T66 = t66
	/** 返回第 67 个元素 [t67]，用于解构声明。 */
	operator fun component67(): T67 = t67
	/** 返回第 68 个元素 [t68]，用于解构声明。 */
	operator fun component68(): T68 = t68
	/** 返回第 69 个元素 [t69]，用于解构声明。 */
	operator fun component69(): T69 = t69
	/** 返回第 70 个元素 [t70]，用于解构声明。 */
	operator fun component70(): T70 = t70
	/** 返回第 71 个元素 [t71]，用于解构声明。 */
	operator fun component71(): T71 = t71
	/** 返回第 72 个元素 [t72]，用于解构声明。 */
	operator fun component72(): T72 = t72
	/** 返回第 73 个元素 [t73]，用于解构声明。 */
	operator fun component73(): T73 = t73
	/** 返回第 74 个元素 [t74]，用于解构声明。 */
	operator fun component74(): T74 = t74
	/** 返回第 75 个元素 [t75]，用于解构声明。 */
	operator fun component75(): T75 = t75
	/** 返回第 76 个元素 [t76]，用于解构声明。 */
	operator fun component76(): T76 = t76
	/** 返回第 77 个元素 [t77]，用于解构声明。 */
	operator fun component77(): T77 = t77
	/** 返回第 78 个元素 [t78]，用于解构声明。 */
	operator fun component78(): T78 = t78
	/** 返回第 79 个元素 [t79]，用于解构声明。 */
	operator fun component79(): T79 = t79
	/** 返回第 80 个元素 [t80]，用于解构声明。 */
	operator fun component80(): T80 = t80
	/** 返回第 81 个元素 [t81]，用于解构声明。 */
	operator fun component81(): T81 = t81
	/** 返回第 82 个元素 [t82]，用于解构声明。 */
	operator fun component82(): T82 = t82
	/** 返回第 83 个元素 [t83]，用于解构声明。 */
	operator fun component83(): T83 = t83
	/** 返回第 84 个元素 [t84]，用于解构声明。 */
	operator fun component84(): T84 = t84
	/** 返回第 85 个元素 [t85]，用于解构声明。 */
	operator fun component85(): T85 = t85
	/** 返回第 86 个元素 [t86]，用于解构声明。 */
	operator fun component86(): T86 = t86
	/** 返回第 87 个元素 [t87]，用于解构声明。 */
	operator fun component87(): T87 = t87
	/** 返回第 88 个元素 [t88]，用于解构声明。 */
	operator fun component88(): T88 = t88
	/** 返回第 89 个元素 [t89]，用于解构声明。 */
	operator fun component89(): T89 = t89
	/** 返回第 90 个元素 [t90]，用于解构声明。 */
	operator fun component90(): T90 = t90
	/** 返回第 91 个元素 [t91]，用于解构声明。 */
	operator fun component91(): T91 = t91
	/** 返回第 92 个元素 [t92]，用于解构声明。 */
	operator fun component92(): T92 = t92
	/** 返回第 93 个元素 [t93]，用于解构声明。 */
	operator fun component93(): T93 = t93
}

/**
 * 94 元组，持有 94 个元素（t1 ~ t94），支持解构声明。
 */
class Tuple94<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79, T80, T81, T82, T83, T84, T85, T86, T87, T88, T89, T90, T91, T92, T93, T94>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
	/** 第 58 个元素。 */
	val t58: T58,
	/** 第 59 个元素。 */
	val t59: T59,
	/** 第 60 个元素。 */
	val t60: T60,
	/** 第 61 个元素。 */
	val t61: T61,
	/** 第 62 个元素。 */
	val t62: T62,
	/** 第 63 个元素。 */
	val t63: T63,
	/** 第 64 个元素。 */
	val t64: T64,
	/** 第 65 个元素。 */
	val t65: T65,
	/** 第 66 个元素。 */
	val t66: T66,
	/** 第 67 个元素。 */
	val t67: T67,
	/** 第 68 个元素。 */
	val t68: T68,
	/** 第 69 个元素。 */
	val t69: T69,
	/** 第 70 个元素。 */
	val t70: T70,
	/** 第 71 个元素。 */
	val t71: T71,
	/** 第 72 个元素。 */
	val t72: T72,
	/** 第 73 个元素。 */
	val t73: T73,
	/** 第 74 个元素。 */
	val t74: T74,
	/** 第 75 个元素。 */
	val t75: T75,
	/** 第 76 个元素。 */
	val t76: T76,
	/** 第 77 个元素。 */
	val t77: T77,
	/** 第 78 个元素。 */
	val t78: T78,
	/** 第 79 个元素。 */
	val t79: T79,
	/** 第 80 个元素。 */
	val t80: T80,
	/** 第 81 个元素。 */
	val t81: T81,
	/** 第 82 个元素。 */
	val t82: T82,
	/** 第 83 个元素。 */
	val t83: T83,
	/** 第 84 个元素。 */
	val t84: T84,
	/** 第 85 个元素。 */
	val t85: T85,
	/** 第 86 个元素。 */
	val t86: T86,
	/** 第 87 个元素。 */
	val t87: T87,
	/** 第 88 个元素。 */
	val t88: T88,
	/** 第 89 个元素。 */
	val t89: T89,
	/** 第 90 个元素。 */
	val t90: T90,
	/** 第 91 个元素。 */
	val t91: T91,
	/** 第 92 个元素。 */
	val t92: T92,
	/** 第 93 个元素。 */
	val t93: T93,
	/** 第 94 个元素。 */
	val t94: T94,
) : Tuple(94) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
	/** 返回第 58 个元素 [t58]，用于解构声明。 */
	operator fun component58(): T58 = t58
	/** 返回第 59 个元素 [t59]，用于解构声明。 */
	operator fun component59(): T59 = t59
	/** 返回第 60 个元素 [t60]，用于解构声明。 */
	operator fun component60(): T60 = t60
	/** 返回第 61 个元素 [t61]，用于解构声明。 */
	operator fun component61(): T61 = t61
	/** 返回第 62 个元素 [t62]，用于解构声明。 */
	operator fun component62(): T62 = t62
	/** 返回第 63 个元素 [t63]，用于解构声明。 */
	operator fun component63(): T63 = t63
	/** 返回第 64 个元素 [t64]，用于解构声明。 */
	operator fun component64(): T64 = t64
	/** 返回第 65 个元素 [t65]，用于解构声明。 */
	operator fun component65(): T65 = t65
	/** 返回第 66 个元素 [t66]，用于解构声明。 */
	operator fun component66(): T66 = t66
	/** 返回第 67 个元素 [t67]，用于解构声明。 */
	operator fun component67(): T67 = t67
	/** 返回第 68 个元素 [t68]，用于解构声明。 */
	operator fun component68(): T68 = t68
	/** 返回第 69 个元素 [t69]，用于解构声明。 */
	operator fun component69(): T69 = t69
	/** 返回第 70 个元素 [t70]，用于解构声明。 */
	operator fun component70(): T70 = t70
	/** 返回第 71 个元素 [t71]，用于解构声明。 */
	operator fun component71(): T71 = t71
	/** 返回第 72 个元素 [t72]，用于解构声明。 */
	operator fun component72(): T72 = t72
	/** 返回第 73 个元素 [t73]，用于解构声明。 */
	operator fun component73(): T73 = t73
	/** 返回第 74 个元素 [t74]，用于解构声明。 */
	operator fun component74(): T74 = t74
	/** 返回第 75 个元素 [t75]，用于解构声明。 */
	operator fun component75(): T75 = t75
	/** 返回第 76 个元素 [t76]，用于解构声明。 */
	operator fun component76(): T76 = t76
	/** 返回第 77 个元素 [t77]，用于解构声明。 */
	operator fun component77(): T77 = t77
	/** 返回第 78 个元素 [t78]，用于解构声明。 */
	operator fun component78(): T78 = t78
	/** 返回第 79 个元素 [t79]，用于解构声明。 */
	operator fun component79(): T79 = t79
	/** 返回第 80 个元素 [t80]，用于解构声明。 */
	operator fun component80(): T80 = t80
	/** 返回第 81 个元素 [t81]，用于解构声明。 */
	operator fun component81(): T81 = t81
	/** 返回第 82 个元素 [t82]，用于解构声明。 */
	operator fun component82(): T82 = t82
	/** 返回第 83 个元素 [t83]，用于解构声明。 */
	operator fun component83(): T83 = t83
	/** 返回第 84 个元素 [t84]，用于解构声明。 */
	operator fun component84(): T84 = t84
	/** 返回第 85 个元素 [t85]，用于解构声明。 */
	operator fun component85(): T85 = t85
	/** 返回第 86 个元素 [t86]，用于解构声明。 */
	operator fun component86(): T86 = t86
	/** 返回第 87 个元素 [t87]，用于解构声明。 */
	operator fun component87(): T87 = t87
	/** 返回第 88 个元素 [t88]，用于解构声明。 */
	operator fun component88(): T88 = t88
	/** 返回第 89 个元素 [t89]，用于解构声明。 */
	operator fun component89(): T89 = t89
	/** 返回第 90 个元素 [t90]，用于解构声明。 */
	operator fun component90(): T90 = t90
	/** 返回第 91 个元素 [t91]，用于解构声明。 */
	operator fun component91(): T91 = t91
	/** 返回第 92 个元素 [t92]，用于解构声明。 */
	operator fun component92(): T92 = t92
	/** 返回第 93 个元素 [t93]，用于解构声明。 */
	operator fun component93(): T93 = t93
	/** 返回第 94 个元素 [t94]，用于解构声明。 */
	operator fun component94(): T94 = t94
}

/**
 * 95 元组，持有 95 个元素（t1 ~ t95），支持解构声明。
 */
class Tuple95<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79, T80, T81, T82, T83, T84, T85, T86, T87, T88, T89, T90, T91, T92, T93, T94, T95>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
	/** 第 58 个元素。 */
	val t58: T58,
	/** 第 59 个元素。 */
	val t59: T59,
	/** 第 60 个元素。 */
	val t60: T60,
	/** 第 61 个元素。 */
	val t61: T61,
	/** 第 62 个元素。 */
	val t62: T62,
	/** 第 63 个元素。 */
	val t63: T63,
	/** 第 64 个元素。 */
	val t64: T64,
	/** 第 65 个元素。 */
	val t65: T65,
	/** 第 66 个元素。 */
	val t66: T66,
	/** 第 67 个元素。 */
	val t67: T67,
	/** 第 68 个元素。 */
	val t68: T68,
	/** 第 69 个元素。 */
	val t69: T69,
	/** 第 70 个元素。 */
	val t70: T70,
	/** 第 71 个元素。 */
	val t71: T71,
	/** 第 72 个元素。 */
	val t72: T72,
	/** 第 73 个元素。 */
	val t73: T73,
	/** 第 74 个元素。 */
	val t74: T74,
	/** 第 75 个元素。 */
	val t75: T75,
	/** 第 76 个元素。 */
	val t76: T76,
	/** 第 77 个元素。 */
	val t77: T77,
	/** 第 78 个元素。 */
	val t78: T78,
	/** 第 79 个元素。 */
	val t79: T79,
	/** 第 80 个元素。 */
	val t80: T80,
	/** 第 81 个元素。 */
	val t81: T81,
	/** 第 82 个元素。 */
	val t82: T82,
	/** 第 83 个元素。 */
	val t83: T83,
	/** 第 84 个元素。 */
	val t84: T84,
	/** 第 85 个元素。 */
	val t85: T85,
	/** 第 86 个元素。 */
	val t86: T86,
	/** 第 87 个元素。 */
	val t87: T87,
	/** 第 88 个元素。 */
	val t88: T88,
	/** 第 89 个元素。 */
	val t89: T89,
	/** 第 90 个元素。 */
	val t90: T90,
	/** 第 91 个元素。 */
	val t91: T91,
	/** 第 92 个元素。 */
	val t92: T92,
	/** 第 93 个元素。 */
	val t93: T93,
	/** 第 94 个元素。 */
	val t94: T94,
	/** 第 95 个元素。 */
	val t95: T95,
) : Tuple(95) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
	/** 返回第 58 个元素 [t58]，用于解构声明。 */
	operator fun component58(): T58 = t58
	/** 返回第 59 个元素 [t59]，用于解构声明。 */
	operator fun component59(): T59 = t59
	/** 返回第 60 个元素 [t60]，用于解构声明。 */
	operator fun component60(): T60 = t60
	/** 返回第 61 个元素 [t61]，用于解构声明。 */
	operator fun component61(): T61 = t61
	/** 返回第 62 个元素 [t62]，用于解构声明。 */
	operator fun component62(): T62 = t62
	/** 返回第 63 个元素 [t63]，用于解构声明。 */
	operator fun component63(): T63 = t63
	/** 返回第 64 个元素 [t64]，用于解构声明。 */
	operator fun component64(): T64 = t64
	/** 返回第 65 个元素 [t65]，用于解构声明。 */
	operator fun component65(): T65 = t65
	/** 返回第 66 个元素 [t66]，用于解构声明。 */
	operator fun component66(): T66 = t66
	/** 返回第 67 个元素 [t67]，用于解构声明。 */
	operator fun component67(): T67 = t67
	/** 返回第 68 个元素 [t68]，用于解构声明。 */
	operator fun component68(): T68 = t68
	/** 返回第 69 个元素 [t69]，用于解构声明。 */
	operator fun component69(): T69 = t69
	/** 返回第 70 个元素 [t70]，用于解构声明。 */
	operator fun component70(): T70 = t70
	/** 返回第 71 个元素 [t71]，用于解构声明。 */
	operator fun component71(): T71 = t71
	/** 返回第 72 个元素 [t72]，用于解构声明。 */
	operator fun component72(): T72 = t72
	/** 返回第 73 个元素 [t73]，用于解构声明。 */
	operator fun component73(): T73 = t73
	/** 返回第 74 个元素 [t74]，用于解构声明。 */
	operator fun component74(): T74 = t74
	/** 返回第 75 个元素 [t75]，用于解构声明。 */
	operator fun component75(): T75 = t75
	/** 返回第 76 个元素 [t76]，用于解构声明。 */
	operator fun component76(): T76 = t76
	/** 返回第 77 个元素 [t77]，用于解构声明。 */
	operator fun component77(): T77 = t77
	/** 返回第 78 个元素 [t78]，用于解构声明。 */
	operator fun component78(): T78 = t78
	/** 返回第 79 个元素 [t79]，用于解构声明。 */
	operator fun component79(): T79 = t79
	/** 返回第 80 个元素 [t80]，用于解构声明。 */
	operator fun component80(): T80 = t80
	/** 返回第 81 个元素 [t81]，用于解构声明。 */
	operator fun component81(): T81 = t81
	/** 返回第 82 个元素 [t82]，用于解构声明。 */
	operator fun component82(): T82 = t82
	/** 返回第 83 个元素 [t83]，用于解构声明。 */
	operator fun component83(): T83 = t83
	/** 返回第 84 个元素 [t84]，用于解构声明。 */
	operator fun component84(): T84 = t84
	/** 返回第 85 个元素 [t85]，用于解构声明。 */
	operator fun component85(): T85 = t85
	/** 返回第 86 个元素 [t86]，用于解构声明。 */
	operator fun component86(): T86 = t86
	/** 返回第 87 个元素 [t87]，用于解构声明。 */
	operator fun component87(): T87 = t87
	/** 返回第 88 个元素 [t88]，用于解构声明。 */
	operator fun component88(): T88 = t88
	/** 返回第 89 个元素 [t89]，用于解构声明。 */
	operator fun component89(): T89 = t89
	/** 返回第 90 个元素 [t90]，用于解构声明。 */
	operator fun component90(): T90 = t90
	/** 返回第 91 个元素 [t91]，用于解构声明。 */
	operator fun component91(): T91 = t91
	/** 返回第 92 个元素 [t92]，用于解构声明。 */
	operator fun component92(): T92 = t92
	/** 返回第 93 个元素 [t93]，用于解构声明。 */
	operator fun component93(): T93 = t93
	/** 返回第 94 个元素 [t94]，用于解构声明。 */
	operator fun component94(): T94 = t94
	/** 返回第 95 个元素 [t95]，用于解构声明。 */
	operator fun component95(): T95 = t95
}

/**
 * 96 元组，持有 96 个元素（t1 ~ t96），支持解构声明。
 */
class Tuple96<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79, T80, T81, T82, T83, T84, T85, T86, T87, T88, T89, T90, T91, T92, T93, T94, T95, T96>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
	/** 第 58 个元素。 */
	val t58: T58,
	/** 第 59 个元素。 */
	val t59: T59,
	/** 第 60 个元素。 */
	val t60: T60,
	/** 第 61 个元素。 */
	val t61: T61,
	/** 第 62 个元素。 */
	val t62: T62,
	/** 第 63 个元素。 */
	val t63: T63,
	/** 第 64 个元素。 */
	val t64: T64,
	/** 第 65 个元素。 */
	val t65: T65,
	/** 第 66 个元素。 */
	val t66: T66,
	/** 第 67 个元素。 */
	val t67: T67,
	/** 第 68 个元素。 */
	val t68: T68,
	/** 第 69 个元素。 */
	val t69: T69,
	/** 第 70 个元素。 */
	val t70: T70,
	/** 第 71 个元素。 */
	val t71: T71,
	/** 第 72 个元素。 */
	val t72: T72,
	/** 第 73 个元素。 */
	val t73: T73,
	/** 第 74 个元素。 */
	val t74: T74,
	/** 第 75 个元素。 */
	val t75: T75,
	/** 第 76 个元素。 */
	val t76: T76,
	/** 第 77 个元素。 */
	val t77: T77,
	/** 第 78 个元素。 */
	val t78: T78,
	/** 第 79 个元素。 */
	val t79: T79,
	/** 第 80 个元素。 */
	val t80: T80,
	/** 第 81 个元素。 */
	val t81: T81,
	/** 第 82 个元素。 */
	val t82: T82,
	/** 第 83 个元素。 */
	val t83: T83,
	/** 第 84 个元素。 */
	val t84: T84,
	/** 第 85 个元素。 */
	val t85: T85,
	/** 第 86 个元素。 */
	val t86: T86,
	/** 第 87 个元素。 */
	val t87: T87,
	/** 第 88 个元素。 */
	val t88: T88,
	/** 第 89 个元素。 */
	val t89: T89,
	/** 第 90 个元素。 */
	val t90: T90,
	/** 第 91 个元素。 */
	val t91: T91,
	/** 第 92 个元素。 */
	val t92: T92,
	/** 第 93 个元素。 */
	val t93: T93,
	/** 第 94 个元素。 */
	val t94: T94,
	/** 第 95 个元素。 */
	val t95: T95,
	/** 第 96 个元素。 */
	val t96: T96,
) : Tuple(96) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
	/** 返回第 58 个元素 [t58]，用于解构声明。 */
	operator fun component58(): T58 = t58
	/** 返回第 59 个元素 [t59]，用于解构声明。 */
	operator fun component59(): T59 = t59
	/** 返回第 60 个元素 [t60]，用于解构声明。 */
	operator fun component60(): T60 = t60
	/** 返回第 61 个元素 [t61]，用于解构声明。 */
	operator fun component61(): T61 = t61
	/** 返回第 62 个元素 [t62]，用于解构声明。 */
	operator fun component62(): T62 = t62
	/** 返回第 63 个元素 [t63]，用于解构声明。 */
	operator fun component63(): T63 = t63
	/** 返回第 64 个元素 [t64]，用于解构声明。 */
	operator fun component64(): T64 = t64
	/** 返回第 65 个元素 [t65]，用于解构声明。 */
	operator fun component65(): T65 = t65
	/** 返回第 66 个元素 [t66]，用于解构声明。 */
	operator fun component66(): T66 = t66
	/** 返回第 67 个元素 [t67]，用于解构声明。 */
	operator fun component67(): T67 = t67
	/** 返回第 68 个元素 [t68]，用于解构声明。 */
	operator fun component68(): T68 = t68
	/** 返回第 69 个元素 [t69]，用于解构声明。 */
	operator fun component69(): T69 = t69
	/** 返回第 70 个元素 [t70]，用于解构声明。 */
	operator fun component70(): T70 = t70
	/** 返回第 71 个元素 [t71]，用于解构声明。 */
	operator fun component71(): T71 = t71
	/** 返回第 72 个元素 [t72]，用于解构声明。 */
	operator fun component72(): T72 = t72
	/** 返回第 73 个元素 [t73]，用于解构声明。 */
	operator fun component73(): T73 = t73
	/** 返回第 74 个元素 [t74]，用于解构声明。 */
	operator fun component74(): T74 = t74
	/** 返回第 75 个元素 [t75]，用于解构声明。 */
	operator fun component75(): T75 = t75
	/** 返回第 76 个元素 [t76]，用于解构声明。 */
	operator fun component76(): T76 = t76
	/** 返回第 77 个元素 [t77]，用于解构声明。 */
	operator fun component77(): T77 = t77
	/** 返回第 78 个元素 [t78]，用于解构声明。 */
	operator fun component78(): T78 = t78
	/** 返回第 79 个元素 [t79]，用于解构声明。 */
	operator fun component79(): T79 = t79
	/** 返回第 80 个元素 [t80]，用于解构声明。 */
	operator fun component80(): T80 = t80
	/** 返回第 81 个元素 [t81]，用于解构声明。 */
	operator fun component81(): T81 = t81
	/** 返回第 82 个元素 [t82]，用于解构声明。 */
	operator fun component82(): T82 = t82
	/** 返回第 83 个元素 [t83]，用于解构声明。 */
	operator fun component83(): T83 = t83
	/** 返回第 84 个元素 [t84]，用于解构声明。 */
	operator fun component84(): T84 = t84
	/** 返回第 85 个元素 [t85]，用于解构声明。 */
	operator fun component85(): T85 = t85
	/** 返回第 86 个元素 [t86]，用于解构声明。 */
	operator fun component86(): T86 = t86
	/** 返回第 87 个元素 [t87]，用于解构声明。 */
	operator fun component87(): T87 = t87
	/** 返回第 88 个元素 [t88]，用于解构声明。 */
	operator fun component88(): T88 = t88
	/** 返回第 89 个元素 [t89]，用于解构声明。 */
	operator fun component89(): T89 = t89
	/** 返回第 90 个元素 [t90]，用于解构声明。 */
	operator fun component90(): T90 = t90
	/** 返回第 91 个元素 [t91]，用于解构声明。 */
	operator fun component91(): T91 = t91
	/** 返回第 92 个元素 [t92]，用于解构声明。 */
	operator fun component92(): T92 = t92
	/** 返回第 93 个元素 [t93]，用于解构声明。 */
	operator fun component93(): T93 = t93
	/** 返回第 94 个元素 [t94]，用于解构声明。 */
	operator fun component94(): T94 = t94
	/** 返回第 95 个元素 [t95]，用于解构声明。 */
	operator fun component95(): T95 = t95
	/** 返回第 96 个元素 [t96]，用于解构声明。 */
	operator fun component96(): T96 = t96
}

/**
 * 97 元组，持有 97 个元素（t1 ~ t97），支持解构声明。
 */
class Tuple97<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79, T80, T81, T82, T83, T84, T85, T86, T87, T88, T89, T90, T91, T92, T93, T94, T95, T96, T97>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
	/** 第 58 个元素。 */
	val t58: T58,
	/** 第 59 个元素。 */
	val t59: T59,
	/** 第 60 个元素。 */
	val t60: T60,
	/** 第 61 个元素。 */
	val t61: T61,
	/** 第 62 个元素。 */
	val t62: T62,
	/** 第 63 个元素。 */
	val t63: T63,
	/** 第 64 个元素。 */
	val t64: T64,
	/** 第 65 个元素。 */
	val t65: T65,
	/** 第 66 个元素。 */
	val t66: T66,
	/** 第 67 个元素。 */
	val t67: T67,
	/** 第 68 个元素。 */
	val t68: T68,
	/** 第 69 个元素。 */
	val t69: T69,
	/** 第 70 个元素。 */
	val t70: T70,
	/** 第 71 个元素。 */
	val t71: T71,
	/** 第 72 个元素。 */
	val t72: T72,
	/** 第 73 个元素。 */
	val t73: T73,
	/** 第 74 个元素。 */
	val t74: T74,
	/** 第 75 个元素。 */
	val t75: T75,
	/** 第 76 个元素。 */
	val t76: T76,
	/** 第 77 个元素。 */
	val t77: T77,
	/** 第 78 个元素。 */
	val t78: T78,
	/** 第 79 个元素。 */
	val t79: T79,
	/** 第 80 个元素。 */
	val t80: T80,
	/** 第 81 个元素。 */
	val t81: T81,
	/** 第 82 个元素。 */
	val t82: T82,
	/** 第 83 个元素。 */
	val t83: T83,
	/** 第 84 个元素。 */
	val t84: T84,
	/** 第 85 个元素。 */
	val t85: T85,
	/** 第 86 个元素。 */
	val t86: T86,
	/** 第 87 个元素。 */
	val t87: T87,
	/** 第 88 个元素。 */
	val t88: T88,
	/** 第 89 个元素。 */
	val t89: T89,
	/** 第 90 个元素。 */
	val t90: T90,
	/** 第 91 个元素。 */
	val t91: T91,
	/** 第 92 个元素。 */
	val t92: T92,
	/** 第 93 个元素。 */
	val t93: T93,
	/** 第 94 个元素。 */
	val t94: T94,
	/** 第 95 个元素。 */
	val t95: T95,
	/** 第 96 个元素。 */
	val t96: T96,
	/** 第 97 个元素。 */
	val t97: T97,
) : Tuple(97) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
	/** 返回第 58 个元素 [t58]，用于解构声明。 */
	operator fun component58(): T58 = t58
	/** 返回第 59 个元素 [t59]，用于解构声明。 */
	operator fun component59(): T59 = t59
	/** 返回第 60 个元素 [t60]，用于解构声明。 */
	operator fun component60(): T60 = t60
	/** 返回第 61 个元素 [t61]，用于解构声明。 */
	operator fun component61(): T61 = t61
	/** 返回第 62 个元素 [t62]，用于解构声明。 */
	operator fun component62(): T62 = t62
	/** 返回第 63 个元素 [t63]，用于解构声明。 */
	operator fun component63(): T63 = t63
	/** 返回第 64 个元素 [t64]，用于解构声明。 */
	operator fun component64(): T64 = t64
	/** 返回第 65 个元素 [t65]，用于解构声明。 */
	operator fun component65(): T65 = t65
	/** 返回第 66 个元素 [t66]，用于解构声明。 */
	operator fun component66(): T66 = t66
	/** 返回第 67 个元素 [t67]，用于解构声明。 */
	operator fun component67(): T67 = t67
	/** 返回第 68 个元素 [t68]，用于解构声明。 */
	operator fun component68(): T68 = t68
	/** 返回第 69 个元素 [t69]，用于解构声明。 */
	operator fun component69(): T69 = t69
	/** 返回第 70 个元素 [t70]，用于解构声明。 */
	operator fun component70(): T70 = t70
	/** 返回第 71 个元素 [t71]，用于解构声明。 */
	operator fun component71(): T71 = t71
	/** 返回第 72 个元素 [t72]，用于解构声明。 */
	operator fun component72(): T72 = t72
	/** 返回第 73 个元素 [t73]，用于解构声明。 */
	operator fun component73(): T73 = t73
	/** 返回第 74 个元素 [t74]，用于解构声明。 */
	operator fun component74(): T74 = t74
	/** 返回第 75 个元素 [t75]，用于解构声明。 */
	operator fun component75(): T75 = t75
	/** 返回第 76 个元素 [t76]，用于解构声明。 */
	operator fun component76(): T76 = t76
	/** 返回第 77 个元素 [t77]，用于解构声明。 */
	operator fun component77(): T77 = t77
	/** 返回第 78 个元素 [t78]，用于解构声明。 */
	operator fun component78(): T78 = t78
	/** 返回第 79 个元素 [t79]，用于解构声明。 */
	operator fun component79(): T79 = t79
	/** 返回第 80 个元素 [t80]，用于解构声明。 */
	operator fun component80(): T80 = t80
	/** 返回第 81 个元素 [t81]，用于解构声明。 */
	operator fun component81(): T81 = t81
	/** 返回第 82 个元素 [t82]，用于解构声明。 */
	operator fun component82(): T82 = t82
	/** 返回第 83 个元素 [t83]，用于解构声明。 */
	operator fun component83(): T83 = t83
	/** 返回第 84 个元素 [t84]，用于解构声明。 */
	operator fun component84(): T84 = t84
	/** 返回第 85 个元素 [t85]，用于解构声明。 */
	operator fun component85(): T85 = t85
	/** 返回第 86 个元素 [t86]，用于解构声明。 */
	operator fun component86(): T86 = t86
	/** 返回第 87 个元素 [t87]，用于解构声明。 */
	operator fun component87(): T87 = t87
	/** 返回第 88 个元素 [t88]，用于解构声明。 */
	operator fun component88(): T88 = t88
	/** 返回第 89 个元素 [t89]，用于解构声明。 */
	operator fun component89(): T89 = t89
	/** 返回第 90 个元素 [t90]，用于解构声明。 */
	operator fun component90(): T90 = t90
	/** 返回第 91 个元素 [t91]，用于解构声明。 */
	operator fun component91(): T91 = t91
	/** 返回第 92 个元素 [t92]，用于解构声明。 */
	operator fun component92(): T92 = t92
	/** 返回第 93 个元素 [t93]，用于解构声明。 */
	operator fun component93(): T93 = t93
	/** 返回第 94 个元素 [t94]，用于解构声明。 */
	operator fun component94(): T94 = t94
	/** 返回第 95 个元素 [t95]，用于解构声明。 */
	operator fun component95(): T95 = t95
	/** 返回第 96 个元素 [t96]，用于解构声明。 */
	operator fun component96(): T96 = t96
	/** 返回第 97 个元素 [t97]，用于解构声明。 */
	operator fun component97(): T97 = t97
}

/**
 * 98 元组，持有 98 个元素（t1 ~ t98），支持解构声明。
 */
class Tuple98<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79, T80, T81, T82, T83, T84, T85, T86, T87, T88, T89, T90, T91, T92, T93, T94, T95, T96, T97, T98>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
	/** 第 58 个元素。 */
	val t58: T58,
	/** 第 59 个元素。 */
	val t59: T59,
	/** 第 60 个元素。 */
	val t60: T60,
	/** 第 61 个元素。 */
	val t61: T61,
	/** 第 62 个元素。 */
	val t62: T62,
	/** 第 63 个元素。 */
	val t63: T63,
	/** 第 64 个元素。 */
	val t64: T64,
	/** 第 65 个元素。 */
	val t65: T65,
	/** 第 66 个元素。 */
	val t66: T66,
	/** 第 67 个元素。 */
	val t67: T67,
	/** 第 68 个元素。 */
	val t68: T68,
	/** 第 69 个元素。 */
	val t69: T69,
	/** 第 70 个元素。 */
	val t70: T70,
	/** 第 71 个元素。 */
	val t71: T71,
	/** 第 72 个元素。 */
	val t72: T72,
	/** 第 73 个元素。 */
	val t73: T73,
	/** 第 74 个元素。 */
	val t74: T74,
	/** 第 75 个元素。 */
	val t75: T75,
	/** 第 76 个元素。 */
	val t76: T76,
	/** 第 77 个元素。 */
	val t77: T77,
	/** 第 78 个元素。 */
	val t78: T78,
	/** 第 79 个元素。 */
	val t79: T79,
	/** 第 80 个元素。 */
	val t80: T80,
	/** 第 81 个元素。 */
	val t81: T81,
	/** 第 82 个元素。 */
	val t82: T82,
	/** 第 83 个元素。 */
	val t83: T83,
	/** 第 84 个元素。 */
	val t84: T84,
	/** 第 85 个元素。 */
	val t85: T85,
	/** 第 86 个元素。 */
	val t86: T86,
	/** 第 87 个元素。 */
	val t87: T87,
	/** 第 88 个元素。 */
	val t88: T88,
	/** 第 89 个元素。 */
	val t89: T89,
	/** 第 90 个元素。 */
	val t90: T90,
	/** 第 91 个元素。 */
	val t91: T91,
	/** 第 92 个元素。 */
	val t92: T92,
	/** 第 93 个元素。 */
	val t93: T93,
	/** 第 94 个元素。 */
	val t94: T94,
	/** 第 95 个元素。 */
	val t95: T95,
	/** 第 96 个元素。 */
	val t96: T96,
	/** 第 97 个元素。 */
	val t97: T97,
	/** 第 98 个元素。 */
	val t98: T98,
) : Tuple(98) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
	/** 返回第 58 个元素 [t58]，用于解构声明。 */
	operator fun component58(): T58 = t58
	/** 返回第 59 个元素 [t59]，用于解构声明。 */
	operator fun component59(): T59 = t59
	/** 返回第 60 个元素 [t60]，用于解构声明。 */
	operator fun component60(): T60 = t60
	/** 返回第 61 个元素 [t61]，用于解构声明。 */
	operator fun component61(): T61 = t61
	/** 返回第 62 个元素 [t62]，用于解构声明。 */
	operator fun component62(): T62 = t62
	/** 返回第 63 个元素 [t63]，用于解构声明。 */
	operator fun component63(): T63 = t63
	/** 返回第 64 个元素 [t64]，用于解构声明。 */
	operator fun component64(): T64 = t64
	/** 返回第 65 个元素 [t65]，用于解构声明。 */
	operator fun component65(): T65 = t65
	/** 返回第 66 个元素 [t66]，用于解构声明。 */
	operator fun component66(): T66 = t66
	/** 返回第 67 个元素 [t67]，用于解构声明。 */
	operator fun component67(): T67 = t67
	/** 返回第 68 个元素 [t68]，用于解构声明。 */
	operator fun component68(): T68 = t68
	/** 返回第 69 个元素 [t69]，用于解构声明。 */
	operator fun component69(): T69 = t69
	/** 返回第 70 个元素 [t70]，用于解构声明。 */
	operator fun component70(): T70 = t70
	/** 返回第 71 个元素 [t71]，用于解构声明。 */
	operator fun component71(): T71 = t71
	/** 返回第 72 个元素 [t72]，用于解构声明。 */
	operator fun component72(): T72 = t72
	/** 返回第 73 个元素 [t73]，用于解构声明。 */
	operator fun component73(): T73 = t73
	/** 返回第 74 个元素 [t74]，用于解构声明。 */
	operator fun component74(): T74 = t74
	/** 返回第 75 个元素 [t75]，用于解构声明。 */
	operator fun component75(): T75 = t75
	/** 返回第 76 个元素 [t76]，用于解构声明。 */
	operator fun component76(): T76 = t76
	/** 返回第 77 个元素 [t77]，用于解构声明。 */
	operator fun component77(): T77 = t77
	/** 返回第 78 个元素 [t78]，用于解构声明。 */
	operator fun component78(): T78 = t78
	/** 返回第 79 个元素 [t79]，用于解构声明。 */
	operator fun component79(): T79 = t79
	/** 返回第 80 个元素 [t80]，用于解构声明。 */
	operator fun component80(): T80 = t80
	/** 返回第 81 个元素 [t81]，用于解构声明。 */
	operator fun component81(): T81 = t81
	/** 返回第 82 个元素 [t82]，用于解构声明。 */
	operator fun component82(): T82 = t82
	/** 返回第 83 个元素 [t83]，用于解构声明。 */
	operator fun component83(): T83 = t83
	/** 返回第 84 个元素 [t84]，用于解构声明。 */
	operator fun component84(): T84 = t84
	/** 返回第 85 个元素 [t85]，用于解构声明。 */
	operator fun component85(): T85 = t85
	/** 返回第 86 个元素 [t86]，用于解构声明。 */
	operator fun component86(): T86 = t86
	/** 返回第 87 个元素 [t87]，用于解构声明。 */
	operator fun component87(): T87 = t87
	/** 返回第 88 个元素 [t88]，用于解构声明。 */
	operator fun component88(): T88 = t88
	/** 返回第 89 个元素 [t89]，用于解构声明。 */
	operator fun component89(): T89 = t89
	/** 返回第 90 个元素 [t90]，用于解构声明。 */
	operator fun component90(): T90 = t90
	/** 返回第 91 个元素 [t91]，用于解构声明。 */
	operator fun component91(): T91 = t91
	/** 返回第 92 个元素 [t92]，用于解构声明。 */
	operator fun component92(): T92 = t92
	/** 返回第 93 个元素 [t93]，用于解构声明。 */
	operator fun component93(): T93 = t93
	/** 返回第 94 个元素 [t94]，用于解构声明。 */
	operator fun component94(): T94 = t94
	/** 返回第 95 个元素 [t95]，用于解构声明。 */
	operator fun component95(): T95 = t95
	/** 返回第 96 个元素 [t96]，用于解构声明。 */
	operator fun component96(): T96 = t96
	/** 返回第 97 个元素 [t97]，用于解构声明。 */
	operator fun component97(): T97 = t97
	/** 返回第 98 个元素 [t98]，用于解构声明。 */
	operator fun component98(): T98 = t98
}

/**
 * 99 元组，持有 99 个元素（t1 ~ t99），支持解构声明。
 */
class Tuple99<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79, T80, T81, T82, T83, T84, T85, T86, T87, T88, T89, T90, T91, T92, T93, T94, T95, T96, T97, T98, T99>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
	/** 第 58 个元素。 */
	val t58: T58,
	/** 第 59 个元素。 */
	val t59: T59,
	/** 第 60 个元素。 */
	val t60: T60,
	/** 第 61 个元素。 */
	val t61: T61,
	/** 第 62 个元素。 */
	val t62: T62,
	/** 第 63 个元素。 */
	val t63: T63,
	/** 第 64 个元素。 */
	val t64: T64,
	/** 第 65 个元素。 */
	val t65: T65,
	/** 第 66 个元素。 */
	val t66: T66,
	/** 第 67 个元素。 */
	val t67: T67,
	/** 第 68 个元素。 */
	val t68: T68,
	/** 第 69 个元素。 */
	val t69: T69,
	/** 第 70 个元素。 */
	val t70: T70,
	/** 第 71 个元素。 */
	val t71: T71,
	/** 第 72 个元素。 */
	val t72: T72,
	/** 第 73 个元素。 */
	val t73: T73,
	/** 第 74 个元素。 */
	val t74: T74,
	/** 第 75 个元素。 */
	val t75: T75,
	/** 第 76 个元素。 */
	val t76: T76,
	/** 第 77 个元素。 */
	val t77: T77,
	/** 第 78 个元素。 */
	val t78: T78,
	/** 第 79 个元素。 */
	val t79: T79,
	/** 第 80 个元素。 */
	val t80: T80,
	/** 第 81 个元素。 */
	val t81: T81,
	/** 第 82 个元素。 */
	val t82: T82,
	/** 第 83 个元素。 */
	val t83: T83,
	/** 第 84 个元素。 */
	val t84: T84,
	/** 第 85 个元素。 */
	val t85: T85,
	/** 第 86 个元素。 */
	val t86: T86,
	/** 第 87 个元素。 */
	val t87: T87,
	/** 第 88 个元素。 */
	val t88: T88,
	/** 第 89 个元素。 */
	val t89: T89,
	/** 第 90 个元素。 */
	val t90: T90,
	/** 第 91 个元素。 */
	val t91: T91,
	/** 第 92 个元素。 */
	val t92: T92,
	/** 第 93 个元素。 */
	val t93: T93,
	/** 第 94 个元素。 */
	val t94: T94,
	/** 第 95 个元素。 */
	val t95: T95,
	/** 第 96 个元素。 */
	val t96: T96,
	/** 第 97 个元素。 */
	val t97: T97,
	/** 第 98 个元素。 */
	val t98: T98,
	/** 第 99 个元素。 */
	val t99: T99,
) : Tuple(99) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
	/** 返回第 58 个元素 [t58]，用于解构声明。 */
	operator fun component58(): T58 = t58
	/** 返回第 59 个元素 [t59]，用于解构声明。 */
	operator fun component59(): T59 = t59
	/** 返回第 60 个元素 [t60]，用于解构声明。 */
	operator fun component60(): T60 = t60
	/** 返回第 61 个元素 [t61]，用于解构声明。 */
	operator fun component61(): T61 = t61
	/** 返回第 62 个元素 [t62]，用于解构声明。 */
	operator fun component62(): T62 = t62
	/** 返回第 63 个元素 [t63]，用于解构声明。 */
	operator fun component63(): T63 = t63
	/** 返回第 64 个元素 [t64]，用于解构声明。 */
	operator fun component64(): T64 = t64
	/** 返回第 65 个元素 [t65]，用于解构声明。 */
	operator fun component65(): T65 = t65
	/** 返回第 66 个元素 [t66]，用于解构声明。 */
	operator fun component66(): T66 = t66
	/** 返回第 67 个元素 [t67]，用于解构声明。 */
	operator fun component67(): T67 = t67
	/** 返回第 68 个元素 [t68]，用于解构声明。 */
	operator fun component68(): T68 = t68
	/** 返回第 69 个元素 [t69]，用于解构声明。 */
	operator fun component69(): T69 = t69
	/** 返回第 70 个元素 [t70]，用于解构声明。 */
	operator fun component70(): T70 = t70
	/** 返回第 71 个元素 [t71]，用于解构声明。 */
	operator fun component71(): T71 = t71
	/** 返回第 72 个元素 [t72]，用于解构声明。 */
	operator fun component72(): T72 = t72
	/** 返回第 73 个元素 [t73]，用于解构声明。 */
	operator fun component73(): T73 = t73
	/** 返回第 74 个元素 [t74]，用于解构声明。 */
	operator fun component74(): T74 = t74
	/** 返回第 75 个元素 [t75]，用于解构声明。 */
	operator fun component75(): T75 = t75
	/** 返回第 76 个元素 [t76]，用于解构声明。 */
	operator fun component76(): T76 = t76
	/** 返回第 77 个元素 [t77]，用于解构声明。 */
	operator fun component77(): T77 = t77
	/** 返回第 78 个元素 [t78]，用于解构声明。 */
	operator fun component78(): T78 = t78
	/** 返回第 79 个元素 [t79]，用于解构声明。 */
	operator fun component79(): T79 = t79
	/** 返回第 80 个元素 [t80]，用于解构声明。 */
	operator fun component80(): T80 = t80
	/** 返回第 81 个元素 [t81]，用于解构声明。 */
	operator fun component81(): T81 = t81
	/** 返回第 82 个元素 [t82]，用于解构声明。 */
	operator fun component82(): T82 = t82
	/** 返回第 83 个元素 [t83]，用于解构声明。 */
	operator fun component83(): T83 = t83
	/** 返回第 84 个元素 [t84]，用于解构声明。 */
	operator fun component84(): T84 = t84
	/** 返回第 85 个元素 [t85]，用于解构声明。 */
	operator fun component85(): T85 = t85
	/** 返回第 86 个元素 [t86]，用于解构声明。 */
	operator fun component86(): T86 = t86
	/** 返回第 87 个元素 [t87]，用于解构声明。 */
	operator fun component87(): T87 = t87
	/** 返回第 88 个元素 [t88]，用于解构声明。 */
	operator fun component88(): T88 = t88
	/** 返回第 89 个元素 [t89]，用于解构声明。 */
	operator fun component89(): T89 = t89
	/** 返回第 90 个元素 [t90]，用于解构声明。 */
	operator fun component90(): T90 = t90
	/** 返回第 91 个元素 [t91]，用于解构声明。 */
	operator fun component91(): T91 = t91
	/** 返回第 92 个元素 [t92]，用于解构声明。 */
	operator fun component92(): T92 = t92
	/** 返回第 93 个元素 [t93]，用于解构声明。 */
	operator fun component93(): T93 = t93
	/** 返回第 94 个元素 [t94]，用于解构声明。 */
	operator fun component94(): T94 = t94
	/** 返回第 95 个元素 [t95]，用于解构声明。 */
	operator fun component95(): T95 = t95
	/** 返回第 96 个元素 [t96]，用于解构声明。 */
	operator fun component96(): T96 = t96
	/** 返回第 97 个元素 [t97]，用于解构声明。 */
	operator fun component97(): T97 = t97
	/** 返回第 98 个元素 [t98]，用于解构声明。 */
	operator fun component98(): T98 = t98
	/** 返回第 99 个元素 [t99]，用于解构声明。 */
	operator fun component99(): T99 = t99
}

/**
 * 100 元组，持有 100 个元素（t1 ~ t100），支持解构声明。
 */
class Tuple100<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79, T80, T81, T82, T83, T84, T85, T86, T87, T88, T89, T90, T91, T92, T93, T94, T95, T96, T97, T98, T99, T100>(
	/** 第 1 个元素。 */
	val t1: T1,
	/** 第 2 个元素。 */
	val t2: T2,
	/** 第 3 个元素。 */
	val t3: T3,
	/** 第 4 个元素。 */
	val t4: T4,
	/** 第 5 个元素。 */
	val t5: T5,
	/** 第 6 个元素。 */
	val t6: T6,
	/** 第 7 个元素。 */
	val t7: T7,
	/** 第 8 个元素。 */
	val t8: T8,
	/** 第 9 个元素。 */
	val t9: T9,
	/** 第 10 个元素。 */
	val t10: T10,
	/** 第 11 个元素。 */
	val t11: T11,
	/** 第 12 个元素。 */
	val t12: T12,
	/** 第 13 个元素。 */
	val t13: T13,
	/** 第 14 个元素。 */
	val t14: T14,
	/** 第 15 个元素。 */
	val t15: T15,
	/** 第 16 个元素。 */
	val t16: T16,
	/** 第 17 个元素。 */
	val t17: T17,
	/** 第 18 个元素。 */
	val t18: T18,
	/** 第 19 个元素。 */
	val t19: T19,
	/** 第 20 个元素。 */
	val t20: T20,
	/** 第 21 个元素。 */
	val t21: T21,
	/** 第 22 个元素。 */
	val t22: T22,
	/** 第 23 个元素。 */
	val t23: T23,
	/** 第 24 个元素。 */
	val t24: T24,
	/** 第 25 个元素。 */
	val t25: T25,
	/** 第 26 个元素。 */
	val t26: T26,
	/** 第 27 个元素。 */
	val t27: T27,
	/** 第 28 个元素。 */
	val t28: T28,
	/** 第 29 个元素。 */
	val t29: T29,
	/** 第 30 个元素。 */
	val t30: T30,
	/** 第 31 个元素。 */
	val t31: T31,
	/** 第 32 个元素。 */
	val t32: T32,
	/** 第 33 个元素。 */
	val t33: T33,
	/** 第 34 个元素。 */
	val t34: T34,
	/** 第 35 个元素。 */
	val t35: T35,
	/** 第 36 个元素。 */
	val t36: T36,
	/** 第 37 个元素。 */
	val t37: T37,
	/** 第 38 个元素。 */
	val t38: T38,
	/** 第 39 个元素。 */
	val t39: T39,
	/** 第 40 个元素。 */
	val t40: T40,
	/** 第 41 个元素。 */
	val t41: T41,
	/** 第 42 个元素。 */
	val t42: T42,
	/** 第 43 个元素。 */
	val t43: T43,
	/** 第 44 个元素。 */
	val t44: T44,
	/** 第 45 个元素。 */
	val t45: T45,
	/** 第 46 个元素。 */
	val t46: T46,
	/** 第 47 个元素。 */
	val t47: T47,
	/** 第 48 个元素。 */
	val t48: T48,
	/** 第 49 个元素。 */
	val t49: T49,
	/** 第 50 个元素。 */
	val t50: T50,
	/** 第 51 个元素。 */
	val t51: T51,
	/** 第 52 个元素。 */
	val t52: T52,
	/** 第 53 个元素。 */
	val t53: T53,
	/** 第 54 个元素。 */
	val t54: T54,
	/** 第 55 个元素。 */
	val t55: T55,
	/** 第 56 个元素。 */
	val t56: T56,
	/** 第 57 个元素。 */
	val t57: T57,
	/** 第 58 个元素。 */
	val t58: T58,
	/** 第 59 个元素。 */
	val t59: T59,
	/** 第 60 个元素。 */
	val t60: T60,
	/** 第 61 个元素。 */
	val t61: T61,
	/** 第 62 个元素。 */
	val t62: T62,
	/** 第 63 个元素。 */
	val t63: T63,
	/** 第 64 个元素。 */
	val t64: T64,
	/** 第 65 个元素。 */
	val t65: T65,
	/** 第 66 个元素。 */
	val t66: T66,
	/** 第 67 个元素。 */
	val t67: T67,
	/** 第 68 个元素。 */
	val t68: T68,
	/** 第 69 个元素。 */
	val t69: T69,
	/** 第 70 个元素。 */
	val t70: T70,
	/** 第 71 个元素。 */
	val t71: T71,
	/** 第 72 个元素。 */
	val t72: T72,
	/** 第 73 个元素。 */
	val t73: T73,
	/** 第 74 个元素。 */
	val t74: T74,
	/** 第 75 个元素。 */
	val t75: T75,
	/** 第 76 个元素。 */
	val t76: T76,
	/** 第 77 个元素。 */
	val t77: T77,
	/** 第 78 个元素。 */
	val t78: T78,
	/** 第 79 个元素。 */
	val t79: T79,
	/** 第 80 个元素。 */
	val t80: T80,
	/** 第 81 个元素。 */
	val t81: T81,
	/** 第 82 个元素。 */
	val t82: T82,
	/** 第 83 个元素。 */
	val t83: T83,
	/** 第 84 个元素。 */
	val t84: T84,
	/** 第 85 个元素。 */
	val t85: T85,
	/** 第 86 个元素。 */
	val t86: T86,
	/** 第 87 个元素。 */
	val t87: T87,
	/** 第 88 个元素。 */
	val t88: T88,
	/** 第 89 个元素。 */
	val t89: T89,
	/** 第 90 个元素。 */
	val t90: T90,
	/** 第 91 个元素。 */
	val t91: T91,
	/** 第 92 个元素。 */
	val t92: T92,
	/** 第 93 个元素。 */
	val t93: T93,
	/** 第 94 个元素。 */
	val t94: T94,
	/** 第 95 个元素。 */
	val t95: T95,
	/** 第 96 个元素。 */
	val t96: T96,
	/** 第 97 个元素。 */
	val t97: T97,
	/** 第 98 个元素。 */
	val t98: T98,
	/** 第 99 个元素。 */
	val t99: T99,
	/** 第 100 个元素。 */
	val t100: T100,
) : Tuple(100) {
	/** 返回第 1 个元素 [t1]，用于解构声明。 */
	operator fun component1(): T1 = t1
	/** 返回第 2 个元素 [t2]，用于解构声明。 */
	operator fun component2(): T2 = t2
	/** 返回第 3 个元素 [t3]，用于解构声明。 */
	operator fun component3(): T3 = t3
	/** 返回第 4 个元素 [t4]，用于解构声明。 */
	operator fun component4(): T4 = t4
	/** 返回第 5 个元素 [t5]，用于解构声明。 */
	operator fun component5(): T5 = t5
	/** 返回第 6 个元素 [t6]，用于解构声明。 */
	operator fun component6(): T6 = t6
	/** 返回第 7 个元素 [t7]，用于解构声明。 */
	operator fun component7(): T7 = t7
	/** 返回第 8 个元素 [t8]，用于解构声明。 */
	operator fun component8(): T8 = t8
	/** 返回第 9 个元素 [t9]，用于解构声明。 */
	operator fun component9(): T9 = t9
	/** 返回第 10 个元素 [t10]，用于解构声明。 */
	operator fun component10(): T10 = t10
	/** 返回第 11 个元素 [t11]，用于解构声明。 */
	operator fun component11(): T11 = t11
	/** 返回第 12 个元素 [t12]，用于解构声明。 */
	operator fun component12(): T12 = t12
	/** 返回第 13 个元素 [t13]，用于解构声明。 */
	operator fun component13(): T13 = t13
	/** 返回第 14 个元素 [t14]，用于解构声明。 */
	operator fun component14(): T14 = t14
	/** 返回第 15 个元素 [t15]，用于解构声明。 */
	operator fun component15(): T15 = t15
	/** 返回第 16 个元素 [t16]，用于解构声明。 */
	operator fun component16(): T16 = t16
	/** 返回第 17 个元素 [t17]，用于解构声明。 */
	operator fun component17(): T17 = t17
	/** 返回第 18 个元素 [t18]，用于解构声明。 */
	operator fun component18(): T18 = t18
	/** 返回第 19 个元素 [t19]，用于解构声明。 */
	operator fun component19(): T19 = t19
	/** 返回第 20 个元素 [t20]，用于解构声明。 */
	operator fun component20(): T20 = t20
	/** 返回第 21 个元素 [t21]，用于解构声明。 */
	operator fun component21(): T21 = t21
	/** 返回第 22 个元素 [t22]，用于解构声明。 */
	operator fun component22(): T22 = t22
	/** 返回第 23 个元素 [t23]，用于解构声明。 */
	operator fun component23(): T23 = t23
	/** 返回第 24 个元素 [t24]，用于解构声明。 */
	operator fun component24(): T24 = t24
	/** 返回第 25 个元素 [t25]，用于解构声明。 */
	operator fun component25(): T25 = t25
	/** 返回第 26 个元素 [t26]，用于解构声明。 */
	operator fun component26(): T26 = t26
	/** 返回第 27 个元素 [t27]，用于解构声明。 */
	operator fun component27(): T27 = t27
	/** 返回第 28 个元素 [t28]，用于解构声明。 */
	operator fun component28(): T28 = t28
	/** 返回第 29 个元素 [t29]，用于解构声明。 */
	operator fun component29(): T29 = t29
	/** 返回第 30 个元素 [t30]，用于解构声明。 */
	operator fun component30(): T30 = t30
	/** 返回第 31 个元素 [t31]，用于解构声明。 */
	operator fun component31(): T31 = t31
	/** 返回第 32 个元素 [t32]，用于解构声明。 */
	operator fun component32(): T32 = t32
	/** 返回第 33 个元素 [t33]，用于解构声明。 */
	operator fun component33(): T33 = t33
	/** 返回第 34 个元素 [t34]，用于解构声明。 */
	operator fun component34(): T34 = t34
	/** 返回第 35 个元素 [t35]，用于解构声明。 */
	operator fun component35(): T35 = t35
	/** 返回第 36 个元素 [t36]，用于解构声明。 */
	operator fun component36(): T36 = t36
	/** 返回第 37 个元素 [t37]，用于解构声明。 */
	operator fun component37(): T37 = t37
	/** 返回第 38 个元素 [t38]，用于解构声明。 */
	operator fun component38(): T38 = t38
	/** 返回第 39 个元素 [t39]，用于解构声明。 */
	operator fun component39(): T39 = t39
	/** 返回第 40 个元素 [t40]，用于解构声明。 */
	operator fun component40(): T40 = t40
	/** 返回第 41 个元素 [t41]，用于解构声明。 */
	operator fun component41(): T41 = t41
	/** 返回第 42 个元素 [t42]，用于解构声明。 */
	operator fun component42(): T42 = t42
	/** 返回第 43 个元素 [t43]，用于解构声明。 */
	operator fun component43(): T43 = t43
	/** 返回第 44 个元素 [t44]，用于解构声明。 */
	operator fun component44(): T44 = t44
	/** 返回第 45 个元素 [t45]，用于解构声明。 */
	operator fun component45(): T45 = t45
	/** 返回第 46 个元素 [t46]，用于解构声明。 */
	operator fun component46(): T46 = t46
	/** 返回第 47 个元素 [t47]，用于解构声明。 */
	operator fun component47(): T47 = t47
	/** 返回第 48 个元素 [t48]，用于解构声明。 */
	operator fun component48(): T48 = t48
	/** 返回第 49 个元素 [t49]，用于解构声明。 */
	operator fun component49(): T49 = t49
	/** 返回第 50 个元素 [t50]，用于解构声明。 */
	operator fun component50(): T50 = t50
	/** 返回第 51 个元素 [t51]，用于解构声明。 */
	operator fun component51(): T51 = t51
	/** 返回第 52 个元素 [t52]，用于解构声明。 */
	operator fun component52(): T52 = t52
	/** 返回第 53 个元素 [t53]，用于解构声明。 */
	operator fun component53(): T53 = t53
	/** 返回第 54 个元素 [t54]，用于解构声明。 */
	operator fun component54(): T54 = t54
	/** 返回第 55 个元素 [t55]，用于解构声明。 */
	operator fun component55(): T55 = t55
	/** 返回第 56 个元素 [t56]，用于解构声明。 */
	operator fun component56(): T56 = t56
	/** 返回第 57 个元素 [t57]，用于解构声明。 */
	operator fun component57(): T57 = t57
	/** 返回第 58 个元素 [t58]，用于解构声明。 */
	operator fun component58(): T58 = t58
	/** 返回第 59 个元素 [t59]，用于解构声明。 */
	operator fun component59(): T59 = t59
	/** 返回第 60 个元素 [t60]，用于解构声明。 */
	operator fun component60(): T60 = t60
	/** 返回第 61 个元素 [t61]，用于解构声明。 */
	operator fun component61(): T61 = t61
	/** 返回第 62 个元素 [t62]，用于解构声明。 */
	operator fun component62(): T62 = t62
	/** 返回第 63 个元素 [t63]，用于解构声明。 */
	operator fun component63(): T63 = t63
	/** 返回第 64 个元素 [t64]，用于解构声明。 */
	operator fun component64(): T64 = t64
	/** 返回第 65 个元素 [t65]，用于解构声明。 */
	operator fun component65(): T65 = t65
	/** 返回第 66 个元素 [t66]，用于解构声明。 */
	operator fun component66(): T66 = t66
	/** 返回第 67 个元素 [t67]，用于解构声明。 */
	operator fun component67(): T67 = t67
	/** 返回第 68 个元素 [t68]，用于解构声明。 */
	operator fun component68(): T68 = t68
	/** 返回第 69 个元素 [t69]，用于解构声明。 */
	operator fun component69(): T69 = t69
	/** 返回第 70 个元素 [t70]，用于解构声明。 */
	operator fun component70(): T70 = t70
	/** 返回第 71 个元素 [t71]，用于解构声明。 */
	operator fun component71(): T71 = t71
	/** 返回第 72 个元素 [t72]，用于解构声明。 */
	operator fun component72(): T72 = t72
	/** 返回第 73 个元素 [t73]，用于解构声明。 */
	operator fun component73(): T73 = t73
	/** 返回第 74 个元素 [t74]，用于解构声明。 */
	operator fun component74(): T74 = t74
	/** 返回第 75 个元素 [t75]，用于解构声明。 */
	operator fun component75(): T75 = t75
	/** 返回第 76 个元素 [t76]，用于解构声明。 */
	operator fun component76(): T76 = t76
	/** 返回第 77 个元素 [t77]，用于解构声明。 */
	operator fun component77(): T77 = t77
	/** 返回第 78 个元素 [t78]，用于解构声明。 */
	operator fun component78(): T78 = t78
	/** 返回第 79 个元素 [t79]，用于解构声明。 */
	operator fun component79(): T79 = t79
	/** 返回第 80 个元素 [t80]，用于解构声明。 */
	operator fun component80(): T80 = t80
	/** 返回第 81 个元素 [t81]，用于解构声明。 */
	operator fun component81(): T81 = t81
	/** 返回第 82 个元素 [t82]，用于解构声明。 */
	operator fun component82(): T82 = t82
	/** 返回第 83 个元素 [t83]，用于解构声明。 */
	operator fun component83(): T83 = t83
	/** 返回第 84 个元素 [t84]，用于解构声明。 */
	operator fun component84(): T84 = t84
	/** 返回第 85 个元素 [t85]，用于解构声明。 */
	operator fun component85(): T85 = t85
	/** 返回第 86 个元素 [t86]，用于解构声明。 */
	operator fun component86(): T86 = t86
	/** 返回第 87 个元素 [t87]，用于解构声明。 */
	operator fun component87(): T87 = t87
	/** 返回第 88 个元素 [t88]，用于解构声明。 */
	operator fun component88(): T88 = t88
	/** 返回第 89 个元素 [t89]，用于解构声明。 */
	operator fun component89(): T89 = t89
	/** 返回第 90 个元素 [t90]，用于解构声明。 */
	operator fun component90(): T90 = t90
	/** 返回第 91 个元素 [t91]，用于解构声明。 */
	operator fun component91(): T91 = t91
	/** 返回第 92 个元素 [t92]，用于解构声明。 */
	operator fun component92(): T92 = t92
	/** 返回第 93 个元素 [t93]，用于解构声明。 */
	operator fun component93(): T93 = t93
	/** 返回第 94 个元素 [t94]，用于解构声明。 */
	operator fun component94(): T94 = t94
	/** 返回第 95 个元素 [t95]，用于解构声明。 */
	operator fun component95(): T95 = t95
	/** 返回第 96 个元素 [t96]，用于解构声明。 */
	operator fun component96(): T96 = t96
	/** 返回第 97 个元素 [t97]，用于解构声明。 */
	operator fun component97(): T97 = t97
	/** 返回第 98 个元素 [t98]，用于解构声明。 */
	operator fun component98(): T98 = t98
	/** 返回第 99 个元素 [t99]，用于解构声明。 */
	operator fun component99(): T99 = t99
	/** 返回第 100 个元素 [t100]，用于解构声明。 */
	operator fun component100(): T100 = t100
}
