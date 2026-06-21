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

class Tuple1<T1>(
    val t1: T1,
) : Tuple(1) {
    operator fun component1(): T1 = t1
}

class Tuple2<T1, T2>(
    val t1: T1,
    val t2: T2,
) : Tuple(2) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
}

class Tuple3<T1, T2, T3>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
) : Tuple(3) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
}

class Tuple4<T1, T2, T3, T4>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
) : Tuple(4) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
}

class Tuple5<T1, T2, T3, T4, T5>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
) : Tuple(5) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
}

class Tuple6<T1, T2, T3, T4, T5, T6>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
) : Tuple(6) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
}

class Tuple7<T1, T2, T3, T4, T5, T6, T7>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
) : Tuple(7) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
}

class Tuple8<T1, T2, T3, T4, T5, T6, T7, T8>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
) : Tuple(8) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
}

class Tuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
) : Tuple(9) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
}

class Tuple10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
) : Tuple(10) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
}

class Tuple11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
) : Tuple(11) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
}

class Tuple12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
) : Tuple(12) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
}

class Tuple13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
) : Tuple(13) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
}

class Tuple14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
) : Tuple(14) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
}

class Tuple15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
) : Tuple(15) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
}

class Tuple16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
) : Tuple(16) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
}

class Tuple17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
) : Tuple(17) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
}

class Tuple18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
) : Tuple(18) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
}

class Tuple19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
) : Tuple(19) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
}

class Tuple20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
) : Tuple(20) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
}

class Tuple21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
) : Tuple(21) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
}

class Tuple22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
) : Tuple(22) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
}

class Tuple23<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
) : Tuple(23) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
}

class Tuple24<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
) : Tuple(24) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
}

class Tuple25<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
) : Tuple(25) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
}

class Tuple26<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
) : Tuple(26) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
}

class Tuple27<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
) : Tuple(27) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
}

class Tuple28<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
) : Tuple(28) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
}

class Tuple29<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
) : Tuple(29) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
}

class Tuple30<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
) : Tuple(30) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
}

class Tuple31<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
) : Tuple(31) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
}

class Tuple32<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
) : Tuple(32) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
}

class Tuple33<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
) : Tuple(33) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
}

class Tuple34<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
) : Tuple(34) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
}

class Tuple35<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
) : Tuple(35) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
}

class Tuple36<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
) : Tuple(36) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
}

class Tuple37<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
) : Tuple(37) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
}

class Tuple38<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
) : Tuple(38) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
}

class Tuple39<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
) : Tuple(39) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
}

class Tuple40<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
) : Tuple(40) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
}

class Tuple41<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
) : Tuple(41) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
}

class Tuple42<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
) : Tuple(42) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
}

class Tuple43<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
) : Tuple(43) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
}

class Tuple44<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
) : Tuple(44) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
}

class Tuple45<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
) : Tuple(45) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
}

class Tuple46<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
) : Tuple(46) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
}

class Tuple47<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
) : Tuple(47) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
}

class Tuple48<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
) : Tuple(48) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
}

class Tuple49<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
) : Tuple(49) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
}

class Tuple50<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
) : Tuple(50) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
}

class Tuple51<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
) : Tuple(51) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
}

class Tuple52<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
) : Tuple(52) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
}

class Tuple53<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
) : Tuple(53) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
}

class Tuple54<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
) : Tuple(54) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
}

class Tuple55<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
) : Tuple(55) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
}

class Tuple56<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
) : Tuple(56) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
}

class Tuple57<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
) : Tuple(57) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
}

class Tuple58<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
    val t58: T58,
) : Tuple(58) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
    operator fun component58(): T58 = t58
}

class Tuple59<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
    val t58: T58,
    val t59: T59,
) : Tuple(59) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
    operator fun component58(): T58 = t58
    operator fun component59(): T59 = t59
}

class Tuple60<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
    val t58: T58,
    val t59: T59,
    val t60: T60,
) : Tuple(60) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
    operator fun component58(): T58 = t58
    operator fun component59(): T59 = t59
    operator fun component60(): T60 = t60
}

class Tuple61<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
    val t58: T58,
    val t59: T59,
    val t60: T60,
    val t61: T61,
) : Tuple(61) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
    operator fun component58(): T58 = t58
    operator fun component59(): T59 = t59
    operator fun component60(): T60 = t60
    operator fun component61(): T61 = t61
}

class Tuple62<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
    val t58: T58,
    val t59: T59,
    val t60: T60,
    val t61: T61,
    val t62: T62,
) : Tuple(62) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
    operator fun component58(): T58 = t58
    operator fun component59(): T59 = t59
    operator fun component60(): T60 = t60
    operator fun component61(): T61 = t61
    operator fun component62(): T62 = t62
}

class Tuple63<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
    val t58: T58,
    val t59: T59,
    val t60: T60,
    val t61: T61,
    val t62: T62,
    val t63: T63,
) : Tuple(63) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
    operator fun component58(): T58 = t58
    operator fun component59(): T59 = t59
    operator fun component60(): T60 = t60
    operator fun component61(): T61 = t61
    operator fun component62(): T62 = t62
    operator fun component63(): T63 = t63
}

class Tuple64<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
    val t58: T58,
    val t59: T59,
    val t60: T60,
    val t61: T61,
    val t62: T62,
    val t63: T63,
    val t64: T64,
) : Tuple(64) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
    operator fun component58(): T58 = t58
    operator fun component59(): T59 = t59
    operator fun component60(): T60 = t60
    operator fun component61(): T61 = t61
    operator fun component62(): T62 = t62
    operator fun component63(): T63 = t63
    operator fun component64(): T64 = t64
}

class Tuple65<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
    val t58: T58,
    val t59: T59,
    val t60: T60,
    val t61: T61,
    val t62: T62,
    val t63: T63,
    val t64: T64,
    val t65: T65,
) : Tuple(65) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
    operator fun component58(): T58 = t58
    operator fun component59(): T59 = t59
    operator fun component60(): T60 = t60
    operator fun component61(): T61 = t61
    operator fun component62(): T62 = t62
    operator fun component63(): T63 = t63
    operator fun component64(): T64 = t64
    operator fun component65(): T65 = t65
}

class Tuple66<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
    val t58: T58,
    val t59: T59,
    val t60: T60,
    val t61: T61,
    val t62: T62,
    val t63: T63,
    val t64: T64,
    val t65: T65,
    val t66: T66,
) : Tuple(66) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
    operator fun component58(): T58 = t58
    operator fun component59(): T59 = t59
    operator fun component60(): T60 = t60
    operator fun component61(): T61 = t61
    operator fun component62(): T62 = t62
    operator fun component63(): T63 = t63
    operator fun component64(): T64 = t64
    operator fun component65(): T65 = t65
    operator fun component66(): T66 = t66
}

class Tuple67<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
    val t58: T58,
    val t59: T59,
    val t60: T60,
    val t61: T61,
    val t62: T62,
    val t63: T63,
    val t64: T64,
    val t65: T65,
    val t66: T66,
    val t67: T67,
) : Tuple(67) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
    operator fun component58(): T58 = t58
    operator fun component59(): T59 = t59
    operator fun component60(): T60 = t60
    operator fun component61(): T61 = t61
    operator fun component62(): T62 = t62
    operator fun component63(): T63 = t63
    operator fun component64(): T64 = t64
    operator fun component65(): T65 = t65
    operator fun component66(): T66 = t66
    operator fun component67(): T67 = t67
}

class Tuple68<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
    val t58: T58,
    val t59: T59,
    val t60: T60,
    val t61: T61,
    val t62: T62,
    val t63: T63,
    val t64: T64,
    val t65: T65,
    val t66: T66,
    val t67: T67,
    val t68: T68,
) : Tuple(68) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
    operator fun component58(): T58 = t58
    operator fun component59(): T59 = t59
    operator fun component60(): T60 = t60
    operator fun component61(): T61 = t61
    operator fun component62(): T62 = t62
    operator fun component63(): T63 = t63
    operator fun component64(): T64 = t64
    operator fun component65(): T65 = t65
    operator fun component66(): T66 = t66
    operator fun component67(): T67 = t67
    operator fun component68(): T68 = t68
}

class Tuple69<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
    val t58: T58,
    val t59: T59,
    val t60: T60,
    val t61: T61,
    val t62: T62,
    val t63: T63,
    val t64: T64,
    val t65: T65,
    val t66: T66,
    val t67: T67,
    val t68: T68,
    val t69: T69,
) : Tuple(69) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
    operator fun component58(): T58 = t58
    operator fun component59(): T59 = t59
    operator fun component60(): T60 = t60
    operator fun component61(): T61 = t61
    operator fun component62(): T62 = t62
    operator fun component63(): T63 = t63
    operator fun component64(): T64 = t64
    operator fun component65(): T65 = t65
    operator fun component66(): T66 = t66
    operator fun component67(): T67 = t67
    operator fun component68(): T68 = t68
    operator fun component69(): T69 = t69
}

class Tuple70<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
    val t58: T58,
    val t59: T59,
    val t60: T60,
    val t61: T61,
    val t62: T62,
    val t63: T63,
    val t64: T64,
    val t65: T65,
    val t66: T66,
    val t67: T67,
    val t68: T68,
    val t69: T69,
    val t70: T70,
) : Tuple(70) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
    operator fun component58(): T58 = t58
    operator fun component59(): T59 = t59
    operator fun component60(): T60 = t60
    operator fun component61(): T61 = t61
    operator fun component62(): T62 = t62
    operator fun component63(): T63 = t63
    operator fun component64(): T64 = t64
    operator fun component65(): T65 = t65
    operator fun component66(): T66 = t66
    operator fun component67(): T67 = t67
    operator fun component68(): T68 = t68
    operator fun component69(): T69 = t69
    operator fun component70(): T70 = t70
}

class Tuple71<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
    val t58: T58,
    val t59: T59,
    val t60: T60,
    val t61: T61,
    val t62: T62,
    val t63: T63,
    val t64: T64,
    val t65: T65,
    val t66: T66,
    val t67: T67,
    val t68: T68,
    val t69: T69,
    val t70: T70,
    val t71: T71,
) : Tuple(71) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
    operator fun component58(): T58 = t58
    operator fun component59(): T59 = t59
    operator fun component60(): T60 = t60
    operator fun component61(): T61 = t61
    operator fun component62(): T62 = t62
    operator fun component63(): T63 = t63
    operator fun component64(): T64 = t64
    operator fun component65(): T65 = t65
    operator fun component66(): T66 = t66
    operator fun component67(): T67 = t67
    operator fun component68(): T68 = t68
    operator fun component69(): T69 = t69
    operator fun component70(): T70 = t70
    operator fun component71(): T71 = t71
}

class Tuple72<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
    val t58: T58,
    val t59: T59,
    val t60: T60,
    val t61: T61,
    val t62: T62,
    val t63: T63,
    val t64: T64,
    val t65: T65,
    val t66: T66,
    val t67: T67,
    val t68: T68,
    val t69: T69,
    val t70: T70,
    val t71: T71,
    val t72: T72,
) : Tuple(72) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
    operator fun component58(): T58 = t58
    operator fun component59(): T59 = t59
    operator fun component60(): T60 = t60
    operator fun component61(): T61 = t61
    operator fun component62(): T62 = t62
    operator fun component63(): T63 = t63
    operator fun component64(): T64 = t64
    operator fun component65(): T65 = t65
    operator fun component66(): T66 = t66
    operator fun component67(): T67 = t67
    operator fun component68(): T68 = t68
    operator fun component69(): T69 = t69
    operator fun component70(): T70 = t70
    operator fun component71(): T71 = t71
    operator fun component72(): T72 = t72
}

class Tuple73<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
    val t58: T58,
    val t59: T59,
    val t60: T60,
    val t61: T61,
    val t62: T62,
    val t63: T63,
    val t64: T64,
    val t65: T65,
    val t66: T66,
    val t67: T67,
    val t68: T68,
    val t69: T69,
    val t70: T70,
    val t71: T71,
    val t72: T72,
    val t73: T73,
) : Tuple(73) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
    operator fun component58(): T58 = t58
    operator fun component59(): T59 = t59
    operator fun component60(): T60 = t60
    operator fun component61(): T61 = t61
    operator fun component62(): T62 = t62
    operator fun component63(): T63 = t63
    operator fun component64(): T64 = t64
    operator fun component65(): T65 = t65
    operator fun component66(): T66 = t66
    operator fun component67(): T67 = t67
    operator fun component68(): T68 = t68
    operator fun component69(): T69 = t69
    operator fun component70(): T70 = t70
    operator fun component71(): T71 = t71
    operator fun component72(): T72 = t72
    operator fun component73(): T73 = t73
}

class Tuple74<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
    val t58: T58,
    val t59: T59,
    val t60: T60,
    val t61: T61,
    val t62: T62,
    val t63: T63,
    val t64: T64,
    val t65: T65,
    val t66: T66,
    val t67: T67,
    val t68: T68,
    val t69: T69,
    val t70: T70,
    val t71: T71,
    val t72: T72,
    val t73: T73,
    val t74: T74,
) : Tuple(74) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
    operator fun component58(): T58 = t58
    operator fun component59(): T59 = t59
    operator fun component60(): T60 = t60
    operator fun component61(): T61 = t61
    operator fun component62(): T62 = t62
    operator fun component63(): T63 = t63
    operator fun component64(): T64 = t64
    operator fun component65(): T65 = t65
    operator fun component66(): T66 = t66
    operator fun component67(): T67 = t67
    operator fun component68(): T68 = t68
    operator fun component69(): T69 = t69
    operator fun component70(): T70 = t70
    operator fun component71(): T71 = t71
    operator fun component72(): T72 = t72
    operator fun component73(): T73 = t73
    operator fun component74(): T74 = t74
}

class Tuple75<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
    val t58: T58,
    val t59: T59,
    val t60: T60,
    val t61: T61,
    val t62: T62,
    val t63: T63,
    val t64: T64,
    val t65: T65,
    val t66: T66,
    val t67: T67,
    val t68: T68,
    val t69: T69,
    val t70: T70,
    val t71: T71,
    val t72: T72,
    val t73: T73,
    val t74: T74,
    val t75: T75,
) : Tuple(75) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
    operator fun component58(): T58 = t58
    operator fun component59(): T59 = t59
    operator fun component60(): T60 = t60
    operator fun component61(): T61 = t61
    operator fun component62(): T62 = t62
    operator fun component63(): T63 = t63
    operator fun component64(): T64 = t64
    operator fun component65(): T65 = t65
    operator fun component66(): T66 = t66
    operator fun component67(): T67 = t67
    operator fun component68(): T68 = t68
    operator fun component69(): T69 = t69
    operator fun component70(): T70 = t70
    operator fun component71(): T71 = t71
    operator fun component72(): T72 = t72
    operator fun component73(): T73 = t73
    operator fun component74(): T74 = t74
    operator fun component75(): T75 = t75
}

class Tuple76<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
    val t58: T58,
    val t59: T59,
    val t60: T60,
    val t61: T61,
    val t62: T62,
    val t63: T63,
    val t64: T64,
    val t65: T65,
    val t66: T66,
    val t67: T67,
    val t68: T68,
    val t69: T69,
    val t70: T70,
    val t71: T71,
    val t72: T72,
    val t73: T73,
    val t74: T74,
    val t75: T75,
    val t76: T76,
) : Tuple(76) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
    operator fun component58(): T58 = t58
    operator fun component59(): T59 = t59
    operator fun component60(): T60 = t60
    operator fun component61(): T61 = t61
    operator fun component62(): T62 = t62
    operator fun component63(): T63 = t63
    operator fun component64(): T64 = t64
    operator fun component65(): T65 = t65
    operator fun component66(): T66 = t66
    operator fun component67(): T67 = t67
    operator fun component68(): T68 = t68
    operator fun component69(): T69 = t69
    operator fun component70(): T70 = t70
    operator fun component71(): T71 = t71
    operator fun component72(): T72 = t72
    operator fun component73(): T73 = t73
    operator fun component74(): T74 = t74
    operator fun component75(): T75 = t75
    operator fun component76(): T76 = t76
}

class Tuple77<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
    val t58: T58,
    val t59: T59,
    val t60: T60,
    val t61: T61,
    val t62: T62,
    val t63: T63,
    val t64: T64,
    val t65: T65,
    val t66: T66,
    val t67: T67,
    val t68: T68,
    val t69: T69,
    val t70: T70,
    val t71: T71,
    val t72: T72,
    val t73: T73,
    val t74: T74,
    val t75: T75,
    val t76: T76,
    val t77: T77,
) : Tuple(77) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
    operator fun component58(): T58 = t58
    operator fun component59(): T59 = t59
    operator fun component60(): T60 = t60
    operator fun component61(): T61 = t61
    operator fun component62(): T62 = t62
    operator fun component63(): T63 = t63
    operator fun component64(): T64 = t64
    operator fun component65(): T65 = t65
    operator fun component66(): T66 = t66
    operator fun component67(): T67 = t67
    operator fun component68(): T68 = t68
    operator fun component69(): T69 = t69
    operator fun component70(): T70 = t70
    operator fun component71(): T71 = t71
    operator fun component72(): T72 = t72
    operator fun component73(): T73 = t73
    operator fun component74(): T74 = t74
    operator fun component75(): T75 = t75
    operator fun component76(): T76 = t76
    operator fun component77(): T77 = t77
}

class Tuple78<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
    val t58: T58,
    val t59: T59,
    val t60: T60,
    val t61: T61,
    val t62: T62,
    val t63: T63,
    val t64: T64,
    val t65: T65,
    val t66: T66,
    val t67: T67,
    val t68: T68,
    val t69: T69,
    val t70: T70,
    val t71: T71,
    val t72: T72,
    val t73: T73,
    val t74: T74,
    val t75: T75,
    val t76: T76,
    val t77: T77,
    val t78: T78,
) : Tuple(78) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
    operator fun component58(): T58 = t58
    operator fun component59(): T59 = t59
    operator fun component60(): T60 = t60
    operator fun component61(): T61 = t61
    operator fun component62(): T62 = t62
    operator fun component63(): T63 = t63
    operator fun component64(): T64 = t64
    operator fun component65(): T65 = t65
    operator fun component66(): T66 = t66
    operator fun component67(): T67 = t67
    operator fun component68(): T68 = t68
    operator fun component69(): T69 = t69
    operator fun component70(): T70 = t70
    operator fun component71(): T71 = t71
    operator fun component72(): T72 = t72
    operator fun component73(): T73 = t73
    operator fun component74(): T74 = t74
    operator fun component75(): T75 = t75
    operator fun component76(): T76 = t76
    operator fun component77(): T77 = t77
    operator fun component78(): T78 = t78
}

class Tuple79<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
    val t58: T58,
    val t59: T59,
    val t60: T60,
    val t61: T61,
    val t62: T62,
    val t63: T63,
    val t64: T64,
    val t65: T65,
    val t66: T66,
    val t67: T67,
    val t68: T68,
    val t69: T69,
    val t70: T70,
    val t71: T71,
    val t72: T72,
    val t73: T73,
    val t74: T74,
    val t75: T75,
    val t76: T76,
    val t77: T77,
    val t78: T78,
    val t79: T79,
) : Tuple(79) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
    operator fun component58(): T58 = t58
    operator fun component59(): T59 = t59
    operator fun component60(): T60 = t60
    operator fun component61(): T61 = t61
    operator fun component62(): T62 = t62
    operator fun component63(): T63 = t63
    operator fun component64(): T64 = t64
    operator fun component65(): T65 = t65
    operator fun component66(): T66 = t66
    operator fun component67(): T67 = t67
    operator fun component68(): T68 = t68
    operator fun component69(): T69 = t69
    operator fun component70(): T70 = t70
    operator fun component71(): T71 = t71
    operator fun component72(): T72 = t72
    operator fun component73(): T73 = t73
    operator fun component74(): T74 = t74
    operator fun component75(): T75 = t75
    operator fun component76(): T76 = t76
    operator fun component77(): T77 = t77
    operator fun component78(): T78 = t78
    operator fun component79(): T79 = t79
}

class Tuple80<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79, T80>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
    val t58: T58,
    val t59: T59,
    val t60: T60,
    val t61: T61,
    val t62: T62,
    val t63: T63,
    val t64: T64,
    val t65: T65,
    val t66: T66,
    val t67: T67,
    val t68: T68,
    val t69: T69,
    val t70: T70,
    val t71: T71,
    val t72: T72,
    val t73: T73,
    val t74: T74,
    val t75: T75,
    val t76: T76,
    val t77: T77,
    val t78: T78,
    val t79: T79,
    val t80: T80,
) : Tuple(80) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
    operator fun component58(): T58 = t58
    operator fun component59(): T59 = t59
    operator fun component60(): T60 = t60
    operator fun component61(): T61 = t61
    operator fun component62(): T62 = t62
    operator fun component63(): T63 = t63
    operator fun component64(): T64 = t64
    operator fun component65(): T65 = t65
    operator fun component66(): T66 = t66
    operator fun component67(): T67 = t67
    operator fun component68(): T68 = t68
    operator fun component69(): T69 = t69
    operator fun component70(): T70 = t70
    operator fun component71(): T71 = t71
    operator fun component72(): T72 = t72
    operator fun component73(): T73 = t73
    operator fun component74(): T74 = t74
    operator fun component75(): T75 = t75
    operator fun component76(): T76 = t76
    operator fun component77(): T77 = t77
    operator fun component78(): T78 = t78
    operator fun component79(): T79 = t79
    operator fun component80(): T80 = t80
}

class Tuple81<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79, T80, T81>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
    val t58: T58,
    val t59: T59,
    val t60: T60,
    val t61: T61,
    val t62: T62,
    val t63: T63,
    val t64: T64,
    val t65: T65,
    val t66: T66,
    val t67: T67,
    val t68: T68,
    val t69: T69,
    val t70: T70,
    val t71: T71,
    val t72: T72,
    val t73: T73,
    val t74: T74,
    val t75: T75,
    val t76: T76,
    val t77: T77,
    val t78: T78,
    val t79: T79,
    val t80: T80,
    val t81: T81,
) : Tuple(81) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
    operator fun component58(): T58 = t58
    operator fun component59(): T59 = t59
    operator fun component60(): T60 = t60
    operator fun component61(): T61 = t61
    operator fun component62(): T62 = t62
    operator fun component63(): T63 = t63
    operator fun component64(): T64 = t64
    operator fun component65(): T65 = t65
    operator fun component66(): T66 = t66
    operator fun component67(): T67 = t67
    operator fun component68(): T68 = t68
    operator fun component69(): T69 = t69
    operator fun component70(): T70 = t70
    operator fun component71(): T71 = t71
    operator fun component72(): T72 = t72
    operator fun component73(): T73 = t73
    operator fun component74(): T74 = t74
    operator fun component75(): T75 = t75
    operator fun component76(): T76 = t76
    operator fun component77(): T77 = t77
    operator fun component78(): T78 = t78
    operator fun component79(): T79 = t79
    operator fun component80(): T80 = t80
    operator fun component81(): T81 = t81
}

class Tuple82<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79, T80, T81, T82>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
    val t58: T58,
    val t59: T59,
    val t60: T60,
    val t61: T61,
    val t62: T62,
    val t63: T63,
    val t64: T64,
    val t65: T65,
    val t66: T66,
    val t67: T67,
    val t68: T68,
    val t69: T69,
    val t70: T70,
    val t71: T71,
    val t72: T72,
    val t73: T73,
    val t74: T74,
    val t75: T75,
    val t76: T76,
    val t77: T77,
    val t78: T78,
    val t79: T79,
    val t80: T80,
    val t81: T81,
    val t82: T82,
) : Tuple(82) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
    operator fun component58(): T58 = t58
    operator fun component59(): T59 = t59
    operator fun component60(): T60 = t60
    operator fun component61(): T61 = t61
    operator fun component62(): T62 = t62
    operator fun component63(): T63 = t63
    operator fun component64(): T64 = t64
    operator fun component65(): T65 = t65
    operator fun component66(): T66 = t66
    operator fun component67(): T67 = t67
    operator fun component68(): T68 = t68
    operator fun component69(): T69 = t69
    operator fun component70(): T70 = t70
    operator fun component71(): T71 = t71
    operator fun component72(): T72 = t72
    operator fun component73(): T73 = t73
    operator fun component74(): T74 = t74
    operator fun component75(): T75 = t75
    operator fun component76(): T76 = t76
    operator fun component77(): T77 = t77
    operator fun component78(): T78 = t78
    operator fun component79(): T79 = t79
    operator fun component80(): T80 = t80
    operator fun component81(): T81 = t81
    operator fun component82(): T82 = t82
}

class Tuple83<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79, T80, T81, T82, T83>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
    val t58: T58,
    val t59: T59,
    val t60: T60,
    val t61: T61,
    val t62: T62,
    val t63: T63,
    val t64: T64,
    val t65: T65,
    val t66: T66,
    val t67: T67,
    val t68: T68,
    val t69: T69,
    val t70: T70,
    val t71: T71,
    val t72: T72,
    val t73: T73,
    val t74: T74,
    val t75: T75,
    val t76: T76,
    val t77: T77,
    val t78: T78,
    val t79: T79,
    val t80: T80,
    val t81: T81,
    val t82: T82,
    val t83: T83,
) : Tuple(83) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
    operator fun component58(): T58 = t58
    operator fun component59(): T59 = t59
    operator fun component60(): T60 = t60
    operator fun component61(): T61 = t61
    operator fun component62(): T62 = t62
    operator fun component63(): T63 = t63
    operator fun component64(): T64 = t64
    operator fun component65(): T65 = t65
    operator fun component66(): T66 = t66
    operator fun component67(): T67 = t67
    operator fun component68(): T68 = t68
    operator fun component69(): T69 = t69
    operator fun component70(): T70 = t70
    operator fun component71(): T71 = t71
    operator fun component72(): T72 = t72
    operator fun component73(): T73 = t73
    operator fun component74(): T74 = t74
    operator fun component75(): T75 = t75
    operator fun component76(): T76 = t76
    operator fun component77(): T77 = t77
    operator fun component78(): T78 = t78
    operator fun component79(): T79 = t79
    operator fun component80(): T80 = t80
    operator fun component81(): T81 = t81
    operator fun component82(): T82 = t82
    operator fun component83(): T83 = t83
}

class Tuple84<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79, T80, T81, T82, T83, T84>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
    val t58: T58,
    val t59: T59,
    val t60: T60,
    val t61: T61,
    val t62: T62,
    val t63: T63,
    val t64: T64,
    val t65: T65,
    val t66: T66,
    val t67: T67,
    val t68: T68,
    val t69: T69,
    val t70: T70,
    val t71: T71,
    val t72: T72,
    val t73: T73,
    val t74: T74,
    val t75: T75,
    val t76: T76,
    val t77: T77,
    val t78: T78,
    val t79: T79,
    val t80: T80,
    val t81: T81,
    val t82: T82,
    val t83: T83,
    val t84: T84,
) : Tuple(84) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
    operator fun component58(): T58 = t58
    operator fun component59(): T59 = t59
    operator fun component60(): T60 = t60
    operator fun component61(): T61 = t61
    operator fun component62(): T62 = t62
    operator fun component63(): T63 = t63
    operator fun component64(): T64 = t64
    operator fun component65(): T65 = t65
    operator fun component66(): T66 = t66
    operator fun component67(): T67 = t67
    operator fun component68(): T68 = t68
    operator fun component69(): T69 = t69
    operator fun component70(): T70 = t70
    operator fun component71(): T71 = t71
    operator fun component72(): T72 = t72
    operator fun component73(): T73 = t73
    operator fun component74(): T74 = t74
    operator fun component75(): T75 = t75
    operator fun component76(): T76 = t76
    operator fun component77(): T77 = t77
    operator fun component78(): T78 = t78
    operator fun component79(): T79 = t79
    operator fun component80(): T80 = t80
    operator fun component81(): T81 = t81
    operator fun component82(): T82 = t82
    operator fun component83(): T83 = t83
    operator fun component84(): T84 = t84
}

class Tuple85<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79, T80, T81, T82, T83, T84, T85>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
    val t58: T58,
    val t59: T59,
    val t60: T60,
    val t61: T61,
    val t62: T62,
    val t63: T63,
    val t64: T64,
    val t65: T65,
    val t66: T66,
    val t67: T67,
    val t68: T68,
    val t69: T69,
    val t70: T70,
    val t71: T71,
    val t72: T72,
    val t73: T73,
    val t74: T74,
    val t75: T75,
    val t76: T76,
    val t77: T77,
    val t78: T78,
    val t79: T79,
    val t80: T80,
    val t81: T81,
    val t82: T82,
    val t83: T83,
    val t84: T84,
    val t85: T85,
) : Tuple(85) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
    operator fun component58(): T58 = t58
    operator fun component59(): T59 = t59
    operator fun component60(): T60 = t60
    operator fun component61(): T61 = t61
    operator fun component62(): T62 = t62
    operator fun component63(): T63 = t63
    operator fun component64(): T64 = t64
    operator fun component65(): T65 = t65
    operator fun component66(): T66 = t66
    operator fun component67(): T67 = t67
    operator fun component68(): T68 = t68
    operator fun component69(): T69 = t69
    operator fun component70(): T70 = t70
    operator fun component71(): T71 = t71
    operator fun component72(): T72 = t72
    operator fun component73(): T73 = t73
    operator fun component74(): T74 = t74
    operator fun component75(): T75 = t75
    operator fun component76(): T76 = t76
    operator fun component77(): T77 = t77
    operator fun component78(): T78 = t78
    operator fun component79(): T79 = t79
    operator fun component80(): T80 = t80
    operator fun component81(): T81 = t81
    operator fun component82(): T82 = t82
    operator fun component83(): T83 = t83
    operator fun component84(): T84 = t84
    operator fun component85(): T85 = t85
}

class Tuple86<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79, T80, T81, T82, T83, T84, T85, T86>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
    val t58: T58,
    val t59: T59,
    val t60: T60,
    val t61: T61,
    val t62: T62,
    val t63: T63,
    val t64: T64,
    val t65: T65,
    val t66: T66,
    val t67: T67,
    val t68: T68,
    val t69: T69,
    val t70: T70,
    val t71: T71,
    val t72: T72,
    val t73: T73,
    val t74: T74,
    val t75: T75,
    val t76: T76,
    val t77: T77,
    val t78: T78,
    val t79: T79,
    val t80: T80,
    val t81: T81,
    val t82: T82,
    val t83: T83,
    val t84: T84,
    val t85: T85,
    val t86: T86,
) : Tuple(86) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
    operator fun component58(): T58 = t58
    operator fun component59(): T59 = t59
    operator fun component60(): T60 = t60
    operator fun component61(): T61 = t61
    operator fun component62(): T62 = t62
    operator fun component63(): T63 = t63
    operator fun component64(): T64 = t64
    operator fun component65(): T65 = t65
    operator fun component66(): T66 = t66
    operator fun component67(): T67 = t67
    operator fun component68(): T68 = t68
    operator fun component69(): T69 = t69
    operator fun component70(): T70 = t70
    operator fun component71(): T71 = t71
    operator fun component72(): T72 = t72
    operator fun component73(): T73 = t73
    operator fun component74(): T74 = t74
    operator fun component75(): T75 = t75
    operator fun component76(): T76 = t76
    operator fun component77(): T77 = t77
    operator fun component78(): T78 = t78
    operator fun component79(): T79 = t79
    operator fun component80(): T80 = t80
    operator fun component81(): T81 = t81
    operator fun component82(): T82 = t82
    operator fun component83(): T83 = t83
    operator fun component84(): T84 = t84
    operator fun component85(): T85 = t85
    operator fun component86(): T86 = t86
}

class Tuple87<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79, T80, T81, T82, T83, T84, T85, T86, T87>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
    val t58: T58,
    val t59: T59,
    val t60: T60,
    val t61: T61,
    val t62: T62,
    val t63: T63,
    val t64: T64,
    val t65: T65,
    val t66: T66,
    val t67: T67,
    val t68: T68,
    val t69: T69,
    val t70: T70,
    val t71: T71,
    val t72: T72,
    val t73: T73,
    val t74: T74,
    val t75: T75,
    val t76: T76,
    val t77: T77,
    val t78: T78,
    val t79: T79,
    val t80: T80,
    val t81: T81,
    val t82: T82,
    val t83: T83,
    val t84: T84,
    val t85: T85,
    val t86: T86,
    val t87: T87,
) : Tuple(87) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
    operator fun component58(): T58 = t58
    operator fun component59(): T59 = t59
    operator fun component60(): T60 = t60
    operator fun component61(): T61 = t61
    operator fun component62(): T62 = t62
    operator fun component63(): T63 = t63
    operator fun component64(): T64 = t64
    operator fun component65(): T65 = t65
    operator fun component66(): T66 = t66
    operator fun component67(): T67 = t67
    operator fun component68(): T68 = t68
    operator fun component69(): T69 = t69
    operator fun component70(): T70 = t70
    operator fun component71(): T71 = t71
    operator fun component72(): T72 = t72
    operator fun component73(): T73 = t73
    operator fun component74(): T74 = t74
    operator fun component75(): T75 = t75
    operator fun component76(): T76 = t76
    operator fun component77(): T77 = t77
    operator fun component78(): T78 = t78
    operator fun component79(): T79 = t79
    operator fun component80(): T80 = t80
    operator fun component81(): T81 = t81
    operator fun component82(): T82 = t82
    operator fun component83(): T83 = t83
    operator fun component84(): T84 = t84
    operator fun component85(): T85 = t85
    operator fun component86(): T86 = t86
    operator fun component87(): T87 = t87
}

class Tuple88<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79, T80, T81, T82, T83, T84, T85, T86, T87, T88>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
    val t58: T58,
    val t59: T59,
    val t60: T60,
    val t61: T61,
    val t62: T62,
    val t63: T63,
    val t64: T64,
    val t65: T65,
    val t66: T66,
    val t67: T67,
    val t68: T68,
    val t69: T69,
    val t70: T70,
    val t71: T71,
    val t72: T72,
    val t73: T73,
    val t74: T74,
    val t75: T75,
    val t76: T76,
    val t77: T77,
    val t78: T78,
    val t79: T79,
    val t80: T80,
    val t81: T81,
    val t82: T82,
    val t83: T83,
    val t84: T84,
    val t85: T85,
    val t86: T86,
    val t87: T87,
    val t88: T88,
) : Tuple(88) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
    operator fun component58(): T58 = t58
    operator fun component59(): T59 = t59
    operator fun component60(): T60 = t60
    operator fun component61(): T61 = t61
    operator fun component62(): T62 = t62
    operator fun component63(): T63 = t63
    operator fun component64(): T64 = t64
    operator fun component65(): T65 = t65
    operator fun component66(): T66 = t66
    operator fun component67(): T67 = t67
    operator fun component68(): T68 = t68
    operator fun component69(): T69 = t69
    operator fun component70(): T70 = t70
    operator fun component71(): T71 = t71
    operator fun component72(): T72 = t72
    operator fun component73(): T73 = t73
    operator fun component74(): T74 = t74
    operator fun component75(): T75 = t75
    operator fun component76(): T76 = t76
    operator fun component77(): T77 = t77
    operator fun component78(): T78 = t78
    operator fun component79(): T79 = t79
    operator fun component80(): T80 = t80
    operator fun component81(): T81 = t81
    operator fun component82(): T82 = t82
    operator fun component83(): T83 = t83
    operator fun component84(): T84 = t84
    operator fun component85(): T85 = t85
    operator fun component86(): T86 = t86
    operator fun component87(): T87 = t87
    operator fun component88(): T88 = t88
}

class Tuple89<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79, T80, T81, T82, T83, T84, T85, T86, T87, T88, T89>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
    val t58: T58,
    val t59: T59,
    val t60: T60,
    val t61: T61,
    val t62: T62,
    val t63: T63,
    val t64: T64,
    val t65: T65,
    val t66: T66,
    val t67: T67,
    val t68: T68,
    val t69: T69,
    val t70: T70,
    val t71: T71,
    val t72: T72,
    val t73: T73,
    val t74: T74,
    val t75: T75,
    val t76: T76,
    val t77: T77,
    val t78: T78,
    val t79: T79,
    val t80: T80,
    val t81: T81,
    val t82: T82,
    val t83: T83,
    val t84: T84,
    val t85: T85,
    val t86: T86,
    val t87: T87,
    val t88: T88,
    val t89: T89,
) : Tuple(89) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
    operator fun component58(): T58 = t58
    operator fun component59(): T59 = t59
    operator fun component60(): T60 = t60
    operator fun component61(): T61 = t61
    operator fun component62(): T62 = t62
    operator fun component63(): T63 = t63
    operator fun component64(): T64 = t64
    operator fun component65(): T65 = t65
    operator fun component66(): T66 = t66
    operator fun component67(): T67 = t67
    operator fun component68(): T68 = t68
    operator fun component69(): T69 = t69
    operator fun component70(): T70 = t70
    operator fun component71(): T71 = t71
    operator fun component72(): T72 = t72
    operator fun component73(): T73 = t73
    operator fun component74(): T74 = t74
    operator fun component75(): T75 = t75
    operator fun component76(): T76 = t76
    operator fun component77(): T77 = t77
    operator fun component78(): T78 = t78
    operator fun component79(): T79 = t79
    operator fun component80(): T80 = t80
    operator fun component81(): T81 = t81
    operator fun component82(): T82 = t82
    operator fun component83(): T83 = t83
    operator fun component84(): T84 = t84
    operator fun component85(): T85 = t85
    operator fun component86(): T86 = t86
    operator fun component87(): T87 = t87
    operator fun component88(): T88 = t88
    operator fun component89(): T89 = t89
}

class Tuple90<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79, T80, T81, T82, T83, T84, T85, T86, T87, T88, T89, T90>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
    val t58: T58,
    val t59: T59,
    val t60: T60,
    val t61: T61,
    val t62: T62,
    val t63: T63,
    val t64: T64,
    val t65: T65,
    val t66: T66,
    val t67: T67,
    val t68: T68,
    val t69: T69,
    val t70: T70,
    val t71: T71,
    val t72: T72,
    val t73: T73,
    val t74: T74,
    val t75: T75,
    val t76: T76,
    val t77: T77,
    val t78: T78,
    val t79: T79,
    val t80: T80,
    val t81: T81,
    val t82: T82,
    val t83: T83,
    val t84: T84,
    val t85: T85,
    val t86: T86,
    val t87: T87,
    val t88: T88,
    val t89: T89,
    val t90: T90,
) : Tuple(90) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
    operator fun component58(): T58 = t58
    operator fun component59(): T59 = t59
    operator fun component60(): T60 = t60
    operator fun component61(): T61 = t61
    operator fun component62(): T62 = t62
    operator fun component63(): T63 = t63
    operator fun component64(): T64 = t64
    operator fun component65(): T65 = t65
    operator fun component66(): T66 = t66
    operator fun component67(): T67 = t67
    operator fun component68(): T68 = t68
    operator fun component69(): T69 = t69
    operator fun component70(): T70 = t70
    operator fun component71(): T71 = t71
    operator fun component72(): T72 = t72
    operator fun component73(): T73 = t73
    operator fun component74(): T74 = t74
    operator fun component75(): T75 = t75
    operator fun component76(): T76 = t76
    operator fun component77(): T77 = t77
    operator fun component78(): T78 = t78
    operator fun component79(): T79 = t79
    operator fun component80(): T80 = t80
    operator fun component81(): T81 = t81
    operator fun component82(): T82 = t82
    operator fun component83(): T83 = t83
    operator fun component84(): T84 = t84
    operator fun component85(): T85 = t85
    operator fun component86(): T86 = t86
    operator fun component87(): T87 = t87
    operator fun component88(): T88 = t88
    operator fun component89(): T89 = t89
    operator fun component90(): T90 = t90
}

class Tuple91<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79, T80, T81, T82, T83, T84, T85, T86, T87, T88, T89, T90, T91>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
    val t58: T58,
    val t59: T59,
    val t60: T60,
    val t61: T61,
    val t62: T62,
    val t63: T63,
    val t64: T64,
    val t65: T65,
    val t66: T66,
    val t67: T67,
    val t68: T68,
    val t69: T69,
    val t70: T70,
    val t71: T71,
    val t72: T72,
    val t73: T73,
    val t74: T74,
    val t75: T75,
    val t76: T76,
    val t77: T77,
    val t78: T78,
    val t79: T79,
    val t80: T80,
    val t81: T81,
    val t82: T82,
    val t83: T83,
    val t84: T84,
    val t85: T85,
    val t86: T86,
    val t87: T87,
    val t88: T88,
    val t89: T89,
    val t90: T90,
    val t91: T91,
) : Tuple(91) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
    operator fun component58(): T58 = t58
    operator fun component59(): T59 = t59
    operator fun component60(): T60 = t60
    operator fun component61(): T61 = t61
    operator fun component62(): T62 = t62
    operator fun component63(): T63 = t63
    operator fun component64(): T64 = t64
    operator fun component65(): T65 = t65
    operator fun component66(): T66 = t66
    operator fun component67(): T67 = t67
    operator fun component68(): T68 = t68
    operator fun component69(): T69 = t69
    operator fun component70(): T70 = t70
    operator fun component71(): T71 = t71
    operator fun component72(): T72 = t72
    operator fun component73(): T73 = t73
    operator fun component74(): T74 = t74
    operator fun component75(): T75 = t75
    operator fun component76(): T76 = t76
    operator fun component77(): T77 = t77
    operator fun component78(): T78 = t78
    operator fun component79(): T79 = t79
    operator fun component80(): T80 = t80
    operator fun component81(): T81 = t81
    operator fun component82(): T82 = t82
    operator fun component83(): T83 = t83
    operator fun component84(): T84 = t84
    operator fun component85(): T85 = t85
    operator fun component86(): T86 = t86
    operator fun component87(): T87 = t87
    operator fun component88(): T88 = t88
    operator fun component89(): T89 = t89
    operator fun component90(): T90 = t90
    operator fun component91(): T91 = t91
}

class Tuple92<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79, T80, T81, T82, T83, T84, T85, T86, T87, T88, T89, T90, T91, T92>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
    val t58: T58,
    val t59: T59,
    val t60: T60,
    val t61: T61,
    val t62: T62,
    val t63: T63,
    val t64: T64,
    val t65: T65,
    val t66: T66,
    val t67: T67,
    val t68: T68,
    val t69: T69,
    val t70: T70,
    val t71: T71,
    val t72: T72,
    val t73: T73,
    val t74: T74,
    val t75: T75,
    val t76: T76,
    val t77: T77,
    val t78: T78,
    val t79: T79,
    val t80: T80,
    val t81: T81,
    val t82: T82,
    val t83: T83,
    val t84: T84,
    val t85: T85,
    val t86: T86,
    val t87: T87,
    val t88: T88,
    val t89: T89,
    val t90: T90,
    val t91: T91,
    val t92: T92,
) : Tuple(92) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
    operator fun component58(): T58 = t58
    operator fun component59(): T59 = t59
    operator fun component60(): T60 = t60
    operator fun component61(): T61 = t61
    operator fun component62(): T62 = t62
    operator fun component63(): T63 = t63
    operator fun component64(): T64 = t64
    operator fun component65(): T65 = t65
    operator fun component66(): T66 = t66
    operator fun component67(): T67 = t67
    operator fun component68(): T68 = t68
    operator fun component69(): T69 = t69
    operator fun component70(): T70 = t70
    operator fun component71(): T71 = t71
    operator fun component72(): T72 = t72
    operator fun component73(): T73 = t73
    operator fun component74(): T74 = t74
    operator fun component75(): T75 = t75
    operator fun component76(): T76 = t76
    operator fun component77(): T77 = t77
    operator fun component78(): T78 = t78
    operator fun component79(): T79 = t79
    operator fun component80(): T80 = t80
    operator fun component81(): T81 = t81
    operator fun component82(): T82 = t82
    operator fun component83(): T83 = t83
    operator fun component84(): T84 = t84
    operator fun component85(): T85 = t85
    operator fun component86(): T86 = t86
    operator fun component87(): T87 = t87
    operator fun component88(): T88 = t88
    operator fun component89(): T89 = t89
    operator fun component90(): T90 = t90
    operator fun component91(): T91 = t91
    operator fun component92(): T92 = t92
}

class Tuple93<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79, T80, T81, T82, T83, T84, T85, T86, T87, T88, T89, T90, T91, T92, T93>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
    val t58: T58,
    val t59: T59,
    val t60: T60,
    val t61: T61,
    val t62: T62,
    val t63: T63,
    val t64: T64,
    val t65: T65,
    val t66: T66,
    val t67: T67,
    val t68: T68,
    val t69: T69,
    val t70: T70,
    val t71: T71,
    val t72: T72,
    val t73: T73,
    val t74: T74,
    val t75: T75,
    val t76: T76,
    val t77: T77,
    val t78: T78,
    val t79: T79,
    val t80: T80,
    val t81: T81,
    val t82: T82,
    val t83: T83,
    val t84: T84,
    val t85: T85,
    val t86: T86,
    val t87: T87,
    val t88: T88,
    val t89: T89,
    val t90: T90,
    val t91: T91,
    val t92: T92,
    val t93: T93,
) : Tuple(93) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
    operator fun component58(): T58 = t58
    operator fun component59(): T59 = t59
    operator fun component60(): T60 = t60
    operator fun component61(): T61 = t61
    operator fun component62(): T62 = t62
    operator fun component63(): T63 = t63
    operator fun component64(): T64 = t64
    operator fun component65(): T65 = t65
    operator fun component66(): T66 = t66
    operator fun component67(): T67 = t67
    operator fun component68(): T68 = t68
    operator fun component69(): T69 = t69
    operator fun component70(): T70 = t70
    operator fun component71(): T71 = t71
    operator fun component72(): T72 = t72
    operator fun component73(): T73 = t73
    operator fun component74(): T74 = t74
    operator fun component75(): T75 = t75
    operator fun component76(): T76 = t76
    operator fun component77(): T77 = t77
    operator fun component78(): T78 = t78
    operator fun component79(): T79 = t79
    operator fun component80(): T80 = t80
    operator fun component81(): T81 = t81
    operator fun component82(): T82 = t82
    operator fun component83(): T83 = t83
    operator fun component84(): T84 = t84
    operator fun component85(): T85 = t85
    operator fun component86(): T86 = t86
    operator fun component87(): T87 = t87
    operator fun component88(): T88 = t88
    operator fun component89(): T89 = t89
    operator fun component90(): T90 = t90
    operator fun component91(): T91 = t91
    operator fun component92(): T92 = t92
    operator fun component93(): T93 = t93
}

class Tuple94<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79, T80, T81, T82, T83, T84, T85, T86, T87, T88, T89, T90, T91, T92, T93, T94>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
    val t58: T58,
    val t59: T59,
    val t60: T60,
    val t61: T61,
    val t62: T62,
    val t63: T63,
    val t64: T64,
    val t65: T65,
    val t66: T66,
    val t67: T67,
    val t68: T68,
    val t69: T69,
    val t70: T70,
    val t71: T71,
    val t72: T72,
    val t73: T73,
    val t74: T74,
    val t75: T75,
    val t76: T76,
    val t77: T77,
    val t78: T78,
    val t79: T79,
    val t80: T80,
    val t81: T81,
    val t82: T82,
    val t83: T83,
    val t84: T84,
    val t85: T85,
    val t86: T86,
    val t87: T87,
    val t88: T88,
    val t89: T89,
    val t90: T90,
    val t91: T91,
    val t92: T92,
    val t93: T93,
    val t94: T94,
) : Tuple(94) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
    operator fun component58(): T58 = t58
    operator fun component59(): T59 = t59
    operator fun component60(): T60 = t60
    operator fun component61(): T61 = t61
    operator fun component62(): T62 = t62
    operator fun component63(): T63 = t63
    operator fun component64(): T64 = t64
    operator fun component65(): T65 = t65
    operator fun component66(): T66 = t66
    operator fun component67(): T67 = t67
    operator fun component68(): T68 = t68
    operator fun component69(): T69 = t69
    operator fun component70(): T70 = t70
    operator fun component71(): T71 = t71
    operator fun component72(): T72 = t72
    operator fun component73(): T73 = t73
    operator fun component74(): T74 = t74
    operator fun component75(): T75 = t75
    operator fun component76(): T76 = t76
    operator fun component77(): T77 = t77
    operator fun component78(): T78 = t78
    operator fun component79(): T79 = t79
    operator fun component80(): T80 = t80
    operator fun component81(): T81 = t81
    operator fun component82(): T82 = t82
    operator fun component83(): T83 = t83
    operator fun component84(): T84 = t84
    operator fun component85(): T85 = t85
    operator fun component86(): T86 = t86
    operator fun component87(): T87 = t87
    operator fun component88(): T88 = t88
    operator fun component89(): T89 = t89
    operator fun component90(): T90 = t90
    operator fun component91(): T91 = t91
    operator fun component92(): T92 = t92
    operator fun component93(): T93 = t93
    operator fun component94(): T94 = t94
}

class Tuple95<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79, T80, T81, T82, T83, T84, T85, T86, T87, T88, T89, T90, T91, T92, T93, T94, T95>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
    val t58: T58,
    val t59: T59,
    val t60: T60,
    val t61: T61,
    val t62: T62,
    val t63: T63,
    val t64: T64,
    val t65: T65,
    val t66: T66,
    val t67: T67,
    val t68: T68,
    val t69: T69,
    val t70: T70,
    val t71: T71,
    val t72: T72,
    val t73: T73,
    val t74: T74,
    val t75: T75,
    val t76: T76,
    val t77: T77,
    val t78: T78,
    val t79: T79,
    val t80: T80,
    val t81: T81,
    val t82: T82,
    val t83: T83,
    val t84: T84,
    val t85: T85,
    val t86: T86,
    val t87: T87,
    val t88: T88,
    val t89: T89,
    val t90: T90,
    val t91: T91,
    val t92: T92,
    val t93: T93,
    val t94: T94,
    val t95: T95,
) : Tuple(95) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
    operator fun component58(): T58 = t58
    operator fun component59(): T59 = t59
    operator fun component60(): T60 = t60
    operator fun component61(): T61 = t61
    operator fun component62(): T62 = t62
    operator fun component63(): T63 = t63
    operator fun component64(): T64 = t64
    operator fun component65(): T65 = t65
    operator fun component66(): T66 = t66
    operator fun component67(): T67 = t67
    operator fun component68(): T68 = t68
    operator fun component69(): T69 = t69
    operator fun component70(): T70 = t70
    operator fun component71(): T71 = t71
    operator fun component72(): T72 = t72
    operator fun component73(): T73 = t73
    operator fun component74(): T74 = t74
    operator fun component75(): T75 = t75
    operator fun component76(): T76 = t76
    operator fun component77(): T77 = t77
    operator fun component78(): T78 = t78
    operator fun component79(): T79 = t79
    operator fun component80(): T80 = t80
    operator fun component81(): T81 = t81
    operator fun component82(): T82 = t82
    operator fun component83(): T83 = t83
    operator fun component84(): T84 = t84
    operator fun component85(): T85 = t85
    operator fun component86(): T86 = t86
    operator fun component87(): T87 = t87
    operator fun component88(): T88 = t88
    operator fun component89(): T89 = t89
    operator fun component90(): T90 = t90
    operator fun component91(): T91 = t91
    operator fun component92(): T92 = t92
    operator fun component93(): T93 = t93
    operator fun component94(): T94 = t94
    operator fun component95(): T95 = t95
}

class Tuple96<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79, T80, T81, T82, T83, T84, T85, T86, T87, T88, T89, T90, T91, T92, T93, T94, T95, T96>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
    val t58: T58,
    val t59: T59,
    val t60: T60,
    val t61: T61,
    val t62: T62,
    val t63: T63,
    val t64: T64,
    val t65: T65,
    val t66: T66,
    val t67: T67,
    val t68: T68,
    val t69: T69,
    val t70: T70,
    val t71: T71,
    val t72: T72,
    val t73: T73,
    val t74: T74,
    val t75: T75,
    val t76: T76,
    val t77: T77,
    val t78: T78,
    val t79: T79,
    val t80: T80,
    val t81: T81,
    val t82: T82,
    val t83: T83,
    val t84: T84,
    val t85: T85,
    val t86: T86,
    val t87: T87,
    val t88: T88,
    val t89: T89,
    val t90: T90,
    val t91: T91,
    val t92: T92,
    val t93: T93,
    val t94: T94,
    val t95: T95,
    val t96: T96,
) : Tuple(96) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
    operator fun component58(): T58 = t58
    operator fun component59(): T59 = t59
    operator fun component60(): T60 = t60
    operator fun component61(): T61 = t61
    operator fun component62(): T62 = t62
    operator fun component63(): T63 = t63
    operator fun component64(): T64 = t64
    operator fun component65(): T65 = t65
    operator fun component66(): T66 = t66
    operator fun component67(): T67 = t67
    operator fun component68(): T68 = t68
    operator fun component69(): T69 = t69
    operator fun component70(): T70 = t70
    operator fun component71(): T71 = t71
    operator fun component72(): T72 = t72
    operator fun component73(): T73 = t73
    operator fun component74(): T74 = t74
    operator fun component75(): T75 = t75
    operator fun component76(): T76 = t76
    operator fun component77(): T77 = t77
    operator fun component78(): T78 = t78
    operator fun component79(): T79 = t79
    operator fun component80(): T80 = t80
    operator fun component81(): T81 = t81
    operator fun component82(): T82 = t82
    operator fun component83(): T83 = t83
    operator fun component84(): T84 = t84
    operator fun component85(): T85 = t85
    operator fun component86(): T86 = t86
    operator fun component87(): T87 = t87
    operator fun component88(): T88 = t88
    operator fun component89(): T89 = t89
    operator fun component90(): T90 = t90
    operator fun component91(): T91 = t91
    operator fun component92(): T92 = t92
    operator fun component93(): T93 = t93
    operator fun component94(): T94 = t94
    operator fun component95(): T95 = t95
    operator fun component96(): T96 = t96
}

class Tuple97<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79, T80, T81, T82, T83, T84, T85, T86, T87, T88, T89, T90, T91, T92, T93, T94, T95, T96, T97>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
    val t58: T58,
    val t59: T59,
    val t60: T60,
    val t61: T61,
    val t62: T62,
    val t63: T63,
    val t64: T64,
    val t65: T65,
    val t66: T66,
    val t67: T67,
    val t68: T68,
    val t69: T69,
    val t70: T70,
    val t71: T71,
    val t72: T72,
    val t73: T73,
    val t74: T74,
    val t75: T75,
    val t76: T76,
    val t77: T77,
    val t78: T78,
    val t79: T79,
    val t80: T80,
    val t81: T81,
    val t82: T82,
    val t83: T83,
    val t84: T84,
    val t85: T85,
    val t86: T86,
    val t87: T87,
    val t88: T88,
    val t89: T89,
    val t90: T90,
    val t91: T91,
    val t92: T92,
    val t93: T93,
    val t94: T94,
    val t95: T95,
    val t96: T96,
    val t97: T97,
) : Tuple(97) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
    operator fun component58(): T58 = t58
    operator fun component59(): T59 = t59
    operator fun component60(): T60 = t60
    operator fun component61(): T61 = t61
    operator fun component62(): T62 = t62
    operator fun component63(): T63 = t63
    operator fun component64(): T64 = t64
    operator fun component65(): T65 = t65
    operator fun component66(): T66 = t66
    operator fun component67(): T67 = t67
    operator fun component68(): T68 = t68
    operator fun component69(): T69 = t69
    operator fun component70(): T70 = t70
    operator fun component71(): T71 = t71
    operator fun component72(): T72 = t72
    operator fun component73(): T73 = t73
    operator fun component74(): T74 = t74
    operator fun component75(): T75 = t75
    operator fun component76(): T76 = t76
    operator fun component77(): T77 = t77
    operator fun component78(): T78 = t78
    operator fun component79(): T79 = t79
    operator fun component80(): T80 = t80
    operator fun component81(): T81 = t81
    operator fun component82(): T82 = t82
    operator fun component83(): T83 = t83
    operator fun component84(): T84 = t84
    operator fun component85(): T85 = t85
    operator fun component86(): T86 = t86
    operator fun component87(): T87 = t87
    operator fun component88(): T88 = t88
    operator fun component89(): T89 = t89
    operator fun component90(): T90 = t90
    operator fun component91(): T91 = t91
    operator fun component92(): T92 = t92
    operator fun component93(): T93 = t93
    operator fun component94(): T94 = t94
    operator fun component95(): T95 = t95
    operator fun component96(): T96 = t96
    operator fun component97(): T97 = t97
}

class Tuple98<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79, T80, T81, T82, T83, T84, T85, T86, T87, T88, T89, T90, T91, T92, T93, T94, T95, T96, T97, T98>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
    val t58: T58,
    val t59: T59,
    val t60: T60,
    val t61: T61,
    val t62: T62,
    val t63: T63,
    val t64: T64,
    val t65: T65,
    val t66: T66,
    val t67: T67,
    val t68: T68,
    val t69: T69,
    val t70: T70,
    val t71: T71,
    val t72: T72,
    val t73: T73,
    val t74: T74,
    val t75: T75,
    val t76: T76,
    val t77: T77,
    val t78: T78,
    val t79: T79,
    val t80: T80,
    val t81: T81,
    val t82: T82,
    val t83: T83,
    val t84: T84,
    val t85: T85,
    val t86: T86,
    val t87: T87,
    val t88: T88,
    val t89: T89,
    val t90: T90,
    val t91: T91,
    val t92: T92,
    val t93: T93,
    val t94: T94,
    val t95: T95,
    val t96: T96,
    val t97: T97,
    val t98: T98,
) : Tuple(98) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
    operator fun component58(): T58 = t58
    operator fun component59(): T59 = t59
    operator fun component60(): T60 = t60
    operator fun component61(): T61 = t61
    operator fun component62(): T62 = t62
    operator fun component63(): T63 = t63
    operator fun component64(): T64 = t64
    operator fun component65(): T65 = t65
    operator fun component66(): T66 = t66
    operator fun component67(): T67 = t67
    operator fun component68(): T68 = t68
    operator fun component69(): T69 = t69
    operator fun component70(): T70 = t70
    operator fun component71(): T71 = t71
    operator fun component72(): T72 = t72
    operator fun component73(): T73 = t73
    operator fun component74(): T74 = t74
    operator fun component75(): T75 = t75
    operator fun component76(): T76 = t76
    operator fun component77(): T77 = t77
    operator fun component78(): T78 = t78
    operator fun component79(): T79 = t79
    operator fun component80(): T80 = t80
    operator fun component81(): T81 = t81
    operator fun component82(): T82 = t82
    operator fun component83(): T83 = t83
    operator fun component84(): T84 = t84
    operator fun component85(): T85 = t85
    operator fun component86(): T86 = t86
    operator fun component87(): T87 = t87
    operator fun component88(): T88 = t88
    operator fun component89(): T89 = t89
    operator fun component90(): T90 = t90
    operator fun component91(): T91 = t91
    operator fun component92(): T92 = t92
    operator fun component93(): T93 = t93
    operator fun component94(): T94 = t94
    operator fun component95(): T95 = t95
    operator fun component96(): T96 = t96
    operator fun component97(): T97 = t97
    operator fun component98(): T98 = t98
}

class Tuple99<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79, T80, T81, T82, T83, T84, T85, T86, T87, T88, T89, T90, T91, T92, T93, T94, T95, T96, T97, T98, T99>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
    val t58: T58,
    val t59: T59,
    val t60: T60,
    val t61: T61,
    val t62: T62,
    val t63: T63,
    val t64: T64,
    val t65: T65,
    val t66: T66,
    val t67: T67,
    val t68: T68,
    val t69: T69,
    val t70: T70,
    val t71: T71,
    val t72: T72,
    val t73: T73,
    val t74: T74,
    val t75: T75,
    val t76: T76,
    val t77: T77,
    val t78: T78,
    val t79: T79,
    val t80: T80,
    val t81: T81,
    val t82: T82,
    val t83: T83,
    val t84: T84,
    val t85: T85,
    val t86: T86,
    val t87: T87,
    val t88: T88,
    val t89: T89,
    val t90: T90,
    val t91: T91,
    val t92: T92,
    val t93: T93,
    val t94: T94,
    val t95: T95,
    val t96: T96,
    val t97: T97,
    val t98: T98,
    val t99: T99,
) : Tuple(99) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
    operator fun component58(): T58 = t58
    operator fun component59(): T59 = t59
    operator fun component60(): T60 = t60
    operator fun component61(): T61 = t61
    operator fun component62(): T62 = t62
    operator fun component63(): T63 = t63
    operator fun component64(): T64 = t64
    operator fun component65(): T65 = t65
    operator fun component66(): T66 = t66
    operator fun component67(): T67 = t67
    operator fun component68(): T68 = t68
    operator fun component69(): T69 = t69
    operator fun component70(): T70 = t70
    operator fun component71(): T71 = t71
    operator fun component72(): T72 = t72
    operator fun component73(): T73 = t73
    operator fun component74(): T74 = t74
    operator fun component75(): T75 = t75
    operator fun component76(): T76 = t76
    operator fun component77(): T77 = t77
    operator fun component78(): T78 = t78
    operator fun component79(): T79 = t79
    operator fun component80(): T80 = t80
    operator fun component81(): T81 = t81
    operator fun component82(): T82 = t82
    operator fun component83(): T83 = t83
    operator fun component84(): T84 = t84
    operator fun component85(): T85 = t85
    operator fun component86(): T86 = t86
    operator fun component87(): T87 = t87
    operator fun component88(): T88 = t88
    operator fun component89(): T89 = t89
    operator fun component90(): T90 = t90
    operator fun component91(): T91 = t91
    operator fun component92(): T92 = t92
    operator fun component93(): T93 = t93
    operator fun component94(): T94 = t94
    operator fun component95(): T95 = t95
    operator fun component96(): T96 = t96
    operator fun component97(): T97 = t97
    operator fun component98(): T98 = t98
    operator fun component99(): T99 = t99
}

class Tuple100<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T23, T24, T25, T26, T27, T28, T29, T30, T31, T32, T33, T34, T35, T36, T37, T38, T39, T40, T41, T42, T43, T44, T45, T46, T47, T48, T49, T50, T51, T52, T53, T54, T55, T56, T57, T58, T59, T60, T61, T62, T63, T64, T65, T66, T67, T68, T69, T70, T71, T72, T73, T74, T75, T76, T77, T78, T79, T80, T81, T82, T83, T84, T85, T86, T87, T88, T89, T90, T91, T92, T93, T94, T95, T96, T97, T98, T99, T100>(
    val t1: T1,
    val t2: T2,
    val t3: T3,
    val t4: T4,
    val t5: T5,
    val t6: T6,
    val t7: T7,
    val t8: T8,
    val t9: T9,
    val t10: T10,
    val t11: T11,
    val t12: T12,
    val t13: T13,
    val t14: T14,
    val t15: T15,
    val t16: T16,
    val t17: T17,
    val t18: T18,
    val t19: T19,
    val t20: T20,
    val t21: T21,
    val t22: T22,
    val t23: T23,
    val t24: T24,
    val t25: T25,
    val t26: T26,
    val t27: T27,
    val t28: T28,
    val t29: T29,
    val t30: T30,
    val t31: T31,
    val t32: T32,
    val t33: T33,
    val t34: T34,
    val t35: T35,
    val t36: T36,
    val t37: T37,
    val t38: T38,
    val t39: T39,
    val t40: T40,
    val t41: T41,
    val t42: T42,
    val t43: T43,
    val t44: T44,
    val t45: T45,
    val t46: T46,
    val t47: T47,
    val t48: T48,
    val t49: T49,
    val t50: T50,
    val t51: T51,
    val t52: T52,
    val t53: T53,
    val t54: T54,
    val t55: T55,
    val t56: T56,
    val t57: T57,
    val t58: T58,
    val t59: T59,
    val t60: T60,
    val t61: T61,
    val t62: T62,
    val t63: T63,
    val t64: T64,
    val t65: T65,
    val t66: T66,
    val t67: T67,
    val t68: T68,
    val t69: T69,
    val t70: T70,
    val t71: T71,
    val t72: T72,
    val t73: T73,
    val t74: T74,
    val t75: T75,
    val t76: T76,
    val t77: T77,
    val t78: T78,
    val t79: T79,
    val t80: T80,
    val t81: T81,
    val t82: T82,
    val t83: T83,
    val t84: T84,
    val t85: T85,
    val t86: T86,
    val t87: T87,
    val t88: T88,
    val t89: T89,
    val t90: T90,
    val t91: T91,
    val t92: T92,
    val t93: T93,
    val t94: T94,
    val t95: T95,
    val t96: T96,
    val t97: T97,
    val t98: T98,
    val t99: T99,
    val t100: T100,
) : Tuple(100) {
    operator fun component1(): T1 = t1
    operator fun component2(): T2 = t2
    operator fun component3(): T3 = t3
    operator fun component4(): T4 = t4
    operator fun component5(): T5 = t5
    operator fun component6(): T6 = t6
    operator fun component7(): T7 = t7
    operator fun component8(): T8 = t8
    operator fun component9(): T9 = t9
    operator fun component10(): T10 = t10
    operator fun component11(): T11 = t11
    operator fun component12(): T12 = t12
    operator fun component13(): T13 = t13
    operator fun component14(): T14 = t14
    operator fun component15(): T15 = t15
    operator fun component16(): T16 = t16
    operator fun component17(): T17 = t17
    operator fun component18(): T18 = t18
    operator fun component19(): T19 = t19
    operator fun component20(): T20 = t20
    operator fun component21(): T21 = t21
    operator fun component22(): T22 = t22
    operator fun component23(): T23 = t23
    operator fun component24(): T24 = t24
    operator fun component25(): T25 = t25
    operator fun component26(): T26 = t26
    operator fun component27(): T27 = t27
    operator fun component28(): T28 = t28
    operator fun component29(): T29 = t29
    operator fun component30(): T30 = t30
    operator fun component31(): T31 = t31
    operator fun component32(): T32 = t32
    operator fun component33(): T33 = t33
    operator fun component34(): T34 = t34
    operator fun component35(): T35 = t35
    operator fun component36(): T36 = t36
    operator fun component37(): T37 = t37
    operator fun component38(): T38 = t38
    operator fun component39(): T39 = t39
    operator fun component40(): T40 = t40
    operator fun component41(): T41 = t41
    operator fun component42(): T42 = t42
    operator fun component43(): T43 = t43
    operator fun component44(): T44 = t44
    operator fun component45(): T45 = t45
    operator fun component46(): T46 = t46
    operator fun component47(): T47 = t47
    operator fun component48(): T48 = t48
    operator fun component49(): T49 = t49
    operator fun component50(): T50 = t50
    operator fun component51(): T51 = t51
    operator fun component52(): T52 = t52
    operator fun component53(): T53 = t53
    operator fun component54(): T54 = t54
    operator fun component55(): T55 = t55
    operator fun component56(): T56 = t56
    operator fun component57(): T57 = t57
    operator fun component58(): T58 = t58
    operator fun component59(): T59 = t59
    operator fun component60(): T60 = t60
    operator fun component61(): T61 = t61
    operator fun component62(): T62 = t62
    operator fun component63(): T63 = t63
    operator fun component64(): T64 = t64
    operator fun component65(): T65 = t65
    operator fun component66(): T66 = t66
    operator fun component67(): T67 = t67
    operator fun component68(): T68 = t68
    operator fun component69(): T69 = t69
    operator fun component70(): T70 = t70
    operator fun component71(): T71 = t71
    operator fun component72(): T72 = t72
    operator fun component73(): T73 = t73
    operator fun component74(): T74 = t74
    operator fun component75(): T75 = t75
    operator fun component76(): T76 = t76
    operator fun component77(): T77 = t77
    operator fun component78(): T78 = t78
    operator fun component79(): T79 = t79
    operator fun component80(): T80 = t80
    operator fun component81(): T81 = t81
    operator fun component82(): T82 = t82
    operator fun component83(): T83 = t83
    operator fun component84(): T84 = t84
    operator fun component85(): T85 = t85
    operator fun component86(): T86 = t86
    operator fun component87(): T87 = t87
    operator fun component88(): T88 = t88
    operator fun component89(): T89 = t89
    operator fun component90(): T90 = t90
    operator fun component91(): T91 = t91
    operator fun component92(): T92 = t92
    operator fun component93(): T93 = t93
    operator fun component94(): T94 = t94
    operator fun component95(): T95 = t95
    operator fun component96(): T96 = t96
    operator fun component97(): T97 = t97
    operator fun component98(): T98 = t98
    operator fun component99(): T99 = t99
    operator fun component100(): T100 = t100
}
