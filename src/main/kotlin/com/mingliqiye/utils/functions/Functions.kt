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
 * CurrentFile Functions.kt
 * LastUpdate 2026-02-05 11:20:59
 * UpdateUser MingLiPro
 */

@file:JvmName("Functions")

package com.mingliqiye.utils.functions

/**
 * 对任意对象执行无参函数调用，执行完成后返回接收者自身。
 *
 * @param function 要执行的无参函数
 * @return 接收者自身
 */
fun <T> T.with(function: Function): T = function.call().let {
	this
}

/**
 * 以接收者自身作为参数执行函数调用，执行完成后返回接收者自身。
 *
 * @param function 接收一个参数的函数，调用时传入接收者自身
 * @return 接收者自身
 */
fun <T> T.with(function: P1Function<T>): T = function.call(this).let {
	this
}

/**
 * 无参数且无返回值的函数式接口。
 */
@FunctionalInterface
fun interface Function {
	/**
	 * 执行函数调用。
	 */
	fun call()
}

/**
 * 接收 1 个参数且无返回值的函数式接口。
 *
 * @param P 参数类型
 */
@FunctionalInterface
fun interface P1Function<P> {
	/**
	 * 执行函数调用。
	 *
	 * @param p 参数
	 */
	fun call(p: P)
}

/**
 * 无参数且带返回值的函数式接口。
 *
 * @param R 返回值类型
 */
@FunctionalInterface
fun interface RFunction<R> {
	/**
	 * 执行函数调用。
	 *
	 * @return 函数执行结果
	 */
	fun call(): R
}

/**
 * 接收 1 个参数且带返回值的函数式接口。
 *
 * @param P 参数类型
 * @param R 返回值类型
 */
@FunctionalInterface
fun interface P1RFunction<P, R> {
	/**
	 * 执行函数调用。
	 *
	 * @param p 参数
	 * @return 函数执行结果
	 */
	fun call(p: P): R
}

/**
 * 接收 2 个参数且无返回值的函数式接口。
 *
 * @param P 第 1 个参数类型
 * @param P1 第 2 个参数类型
 */
@FunctionalInterface
fun interface P2Function<P, P1> {
	/**
	 * 执行函数调用。
	 *
	 * @param p 第 1 个参数
	 * @param p1 第 2 个参数
	 */
	fun call(p: P, p1: P1)
}

/**
 * 接收 2 个参数且带返回值的函数式接口。
 *
 * @param P 第 1 个参数类型
 * @param P1 第 2 个参数类型
 * @param R 返回值类型
 */
@FunctionalInterface
fun interface P2RFunction<P, P1, R> {
	/**
	 * 执行函数调用。
	 *
	 * @param p 第 1 个参数
	 * @param p1 第 2 个参数
	 * @return 函数执行结果
	 */
	fun call(p: P, p1: P1): R
}

/**
 * 接收 3 个参数且无返回值的函数式接口，参数类型依次为 P、P1、P2。
 */
@FunctionalInterface
fun interface P3Function<P, P1, P2> {
	/**
	 * 执行函数调用，参数依次为 p、p1、p2。
	 */
	fun call(p: P, p1: P1, p2: P2)
}

/**
 * 接收 3 个参数且带返回值的函数式接口，参数类型依次为 P、P1、P2，返回值类型为 R。
 */
@FunctionalInterface
fun interface P3RFunction<P, P1, P2, R> {
	/**
	 * 执行函数调用，参数依次为 p、p1、p2。
	 *
	 * @return 函数执行结果
	 */
	fun call(p: P, p1: P1, p2: P2): R
}

/**
 * 接收 4 个参数且无返回值的函数式接口，参数类型依次为 P、P1 至 P3。
 */
@FunctionalInterface
fun interface P4Function<P, P1, P2, P3> {
	/**
	 * 执行函数调用，参数依次为 p、p1 至 p3。
	 */
	fun call(p: P, p1: P1, p2: P2, p3: P3)
}

/**
 * 接收 4 个参数且带返回值的函数式接口，参数类型依次为 P、P1 至 P3，返回值类型为 R。
 */
@FunctionalInterface
fun interface P4RFunction<P, P1, P2, P3, R> {
	/**
	 * 执行函数调用，参数依次为 p、p1 至 p3。
	 *
	 * @return 函数执行结果
	 */
	fun call(p: P, p1: P1, p2: P2, p3: P3): R
}

/**
 * 接收 5 个参数且无返回值的函数式接口，参数类型依次为 P、P1 至 P4。
 */
@FunctionalInterface
fun interface P5Function<P, P1, P2, P3, P4> {
	/**
	 * 执行函数调用，参数依次为 p、p1 至 p4。
	 */
	fun call(p: P, p1: P1, p2: P2, p3: P3, p4: P4)
}

/**
 * 接收 5 个参数且带返回值的函数式接口，参数类型依次为 P、P1 至 P4，返回值类型为 R。
 */
@FunctionalInterface
fun interface P5RFunction<P, P1, P2, P3, P4, R> {
	/**
	 * 执行函数调用，参数依次为 p、p1 至 p4。
	 *
	 * @return 函数执行结果
	 */
	fun call(p: P, p1: P1, p2: P2, p3: P3, p4: P4): R
}

/**
 * 接收 6 个参数且无返回值的函数式接口，参数类型依次为 P、P1 至 P5。
 */
@FunctionalInterface
fun interface P6Function<P, P1, P2, P3, P4, P5> {
	/**
	 * 执行函数调用，参数依次为 p、p1 至 p5。
	 */
	fun call(p: P, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5)
}

/**
 * 接收 6 个参数且带返回值的函数式接口，参数类型依次为 P、P1 至 P5，返回值类型为 R。
 */
@FunctionalInterface
fun interface P6RFunction<P, P1, P2, P3, P4, P5, R> {
	/**
	 * 执行函数调用，参数依次为 p、p1 至 p5。
	 *
	 * @return 函数执行结果
	 */
	fun call(p: P, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5): R
}

/**
 * 接收 7 个参数且无返回值的函数式接口，参数类型依次为 P、P1 至 P6。
 */
@FunctionalInterface
fun interface P7Function<P, P1, P2, P3, P4, P5, P6> {
	/**
	 * 执行函数调用，参数依次为 p、p1 至 p6。
	 */
	fun call(p: P, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6)
}

/**
 * 接收 7 个参数且带返回值的函数式接口，参数类型依次为 P、P1 至 P6，返回值类型为 R。
 */
@FunctionalInterface
fun interface P7RFunction<P, P1, P2, P3, P4, P5, P6, R> {
	/**
	 * 执行函数调用，参数依次为 p、p1 至 p6。
	 *
	 * @return 函数执行结果
	 */
	fun call(p: P, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6): R
}

/**
 * 接收 8 个参数且无返回值的函数式接口，参数类型依次为 P、P1 至 P7。
 */
@FunctionalInterface
fun interface P8Function<P, P1, P2, P3, P4, P5, P6, P7> {
	/**
	 * 执行函数调用，参数依次为 p、p1 至 p7。
	 */
	fun call(p: P, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7)
}

/**
 * 接收 8 个参数且带返回值的函数式接口，参数类型依次为 P、P1 至 P7，返回值类型为 R。
 */
@FunctionalInterface
fun interface P8RFunction<P, P1, P2, P3, P4, P5, P6, P7, R> {
	/**
	 * 执行函数调用，参数依次为 p、p1 至 p7。
	 *
	 * @return 函数执行结果
	 */
	fun call(p: P, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7): R
}

/**
 * 接收 9 个参数且无返回值的函数式接口，参数类型依次为 P、P1 至 P8。
 */
@FunctionalInterface
fun interface P9Function<P, P1, P2, P3, P4, P5, P6, P7, P8> {
	/**
	 * 执行函数调用，参数依次为 p、p1 至 p8。
	 */
	fun call(p: P, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8)
}

/**
 * 接收 9 个参数且带返回值的函数式接口，参数类型依次为 P、P1 至 P8，返回值类型为 R。
 */
@FunctionalInterface
fun interface P9RFunction<P, P1, P2, P3, P4, P5, P6, P7, P8, R> {
	/**
	 * 执行函数调用，参数依次为 p、p1 至 p8。
	 *
	 * @return 函数执行结果
	 */
	fun call(p: P, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8): R
}

/**
 * 接收 10 个参数且无返回值的函数式接口，参数类型依次为 P、P1 至 P9。
 */
@FunctionalInterface
fun interface P10Function<P, P1, P2, P3, P4, P5, P6, P7, P8, P9> {
	/**
	 * 执行函数调用，参数依次为 p、p1 至 p9。
	 */
	fun call(p: P, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8, p9: P9)
}

/**
 * 接收 10 个参数且带返回值的函数式接口，参数类型依次为 P、P1 至 P9，返回值类型为 R。
 */
@FunctionalInterface
fun interface P10RFunction<P, P1, P2, P3, P4, P5, P6, P7, P8, P9, R> {
	/**
	 * 执行函数调用，参数依次为 p、p1 至 p9。
	 *
	 * @return 函数执行结果
	 */
	fun call(p: P, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8, p9: P9): R
}

/**
 * 接收 11 个参数且无返回值的函数式接口，参数类型依次为 P、P1 至 P10。
 */
@FunctionalInterface
fun interface P11Function<P, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10> {
	/**
	 * 执行函数调用，参数依次为 p、p1 至 p10。
	 */
	fun call(p: P, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8, p9: P9, p10: P10)
}

/**
 * 接收 11 个参数且带返回值的函数式接口，参数类型依次为 P、P1 至 P10，返回值类型为 R。
 */
@FunctionalInterface
fun interface P11RFunction<P, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, R> {
	/**
	 * 执行函数调用，参数依次为 p、p1 至 p10。
	 *
	 * @return 函数执行结果
	 */
	fun call(p: P, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8, p9: P9, p10: P10): R
}

/**
 * 接收 12 个参数且无返回值的函数式接口，参数类型依次为 P、P1 至 P11。
 */
@FunctionalInterface
fun interface P12Function<P, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11> {
	/**
	 * 执行函数调用，参数依次为 p、p1 至 p11。
	 */
	fun call(p: P, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8, p9: P9, p10: P10, p11: P11)
}

/**
 * 接收 12 个参数且带返回值的函数式接口，参数类型依次为 P、P1 至 P11，返回值类型为 R。
 */
@FunctionalInterface
fun interface P12RFunction<P, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, R> {
	/**
	 * 执行函数调用，参数依次为 p、p1 至 p11。
	 *
	 * @return 函数执行结果
	 */
	fun call(p: P, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8, p9: P9, p10: P10, p11: P11): R
}

/**
 * 接收 13 个参数且无返回值的函数式接口，参数类型依次为 P、P1 至 P12。
 */
@FunctionalInterface
fun interface P13Function<P, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12> {
	/**
	 * 执行函数调用，参数依次为 p、p1 至 p12。
	 */
	fun call(p: P, p1: P1, p2: P2, p3: P3, p4: P4, p5: P5, p6: P6, p7: P7, p8: P8, p9: P9, p10: P10, p11: P11, p12: P12)
}

/**
 * 接收 13 个参数且带返回值的函数式接口，参数类型依次为 P、P1 至 P12，返回值类型为 R。
 */
@FunctionalInterface
fun interface P13RFunction<P, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, R> {
	/**
	 * 执行函数调用，参数依次为 p、p1 至 p12。
	 *
	 * @return 函数执行结果
	 */
	fun call(
		p: P,
		p1: P1,
		p2: P2,
		p3: P3,
		p4: P4,
		p5: P5,
		p6: P6,
		p7: P7,
		p8: P8,
		p9: P9,
		p10: P10,
		p11: P11,
		p12: P12,
	): R
}

/**
 * 接收 14 个参数且无返回值的函数式接口，参数类型依次为 P、P1 至 P13。
 */
@FunctionalInterface
fun interface P14Function<P, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13> {
	/**
	 * 执行函数调用，参数依次为 p、p1 至 p13。
	 */
	fun call(
		p: P,
		p1: P1,
		p2: P2,
		p3: P3,
		p4: P4,
		p5: P5,
		p6: P6,
		p7: P7,
		p8: P8,
		p9: P9,
		p10: P10,
		p11: P11,
		p12: P12,
		p13: P13,
	)
}

/**
 * 接收 14 个参数且带返回值的函数式接口，参数类型依次为 P、P1 至 P13，返回值类型为 R。
 */
@FunctionalInterface
fun interface P14RFunction<P, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, R> {
	/**
	 * 执行函数调用，参数依次为 p、p1 至 p13。
	 *
	 * @return 函数执行结果
	 */
	fun call(
		p: P,
		p1: P1,
		p2: P2,
		p3: P3,
		p4: P4,
		p5: P5,
		p6: P6,
		p7: P7,
		p8: P8,
		p9: P9,
		p10: P10,
		p11: P11,
		p12: P12,
		p13: P13,
	): R
}

/**
 * 接收 15 个参数且无返回值的函数式接口，参数类型依次为 P、P1 至 P14。
 */
@FunctionalInterface
fun interface P15Function<P, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14> {
	/**
	 * 执行函数调用，参数依次为 p、p1 至 p14。
	 */
	fun call(
		p: P,
		p1: P1,
		p2: P2,
		p3: P3,
		p4: P4,
		p5: P5,
		p6: P6,
		p7: P7,
		p8: P8,
		p9: P9,
		p10: P10,
		p11: P11,
		p12: P12,
		p13: P13,
		p14: P14,
	)
}

/**
 * 接收 15 个参数且带返回值的函数式接口，参数类型依次为 P、P1 至 P14，返回值类型为 R。
 */
@FunctionalInterface
fun interface P15RFunction<P, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, R> {
	/**
	 * 执行函数调用，参数依次为 p、p1 至 p14。
	 *
	 * @return 函数执行结果
	 */
	fun call(
		p: P,
		p1: P1,
		p2: P2,
		p3: P3,
		p4: P4,
		p5: P5,
		p6: P6,
		p7: P7,
		p8: P8,
		p9: P9,
		p10: P10,
		p11: P11,
		p12: P12,
		p13: P13,
		p14: P14,
	): R
}

/**
 * 接收 16 个参数且无返回值的函数式接口，参数类型依次为 P、P1 至 P15。
 */
@FunctionalInterface
fun interface P16Function<P, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15> {
	/**
	 * 执行函数调用，参数依次为 p、p1 至 p15。
	 */
	fun call(
		p: P,
		p1: P1,
		p2: P2,
		p3: P3,
		p4: P4,
		p5: P5,
		p6: P6,
		p7: P7,
		p8: P8,
		p9: P9,
		p10: P10,
		p11: P11,
		p12: P12,
		p13: P13,
		p14: P14,
		p15: P15,
	)
}

/**
 * 接收 16 个参数且带返回值的函数式接口，参数类型依次为 P、P1 至 P15，返回值类型为 R。
 */
@FunctionalInterface
fun interface P16RFunction<P, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, R> {
	/**
	 * 执行函数调用，参数依次为 p、p1 至 p15。
	 *
	 * @return 函数执行结果
	 */
	fun call(
		p: P,
		p1: P1,
		p2: P2,
		p3: P3,
		p4: P4,
		p5: P5,
		p6: P6,
		p7: P7,
		p8: P8,
		p9: P9,
		p10: P10,
		p11: P11,
		p12: P12,
		p13: P13,
		p14: P14,
		p15: P15,
	): R
}

/**
 * 接收 17 个参数且无返回值的函数式接口，参数类型依次为 P、P1 至 P16。
 */
@FunctionalInterface
fun interface P17Function<P, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16> {
	/**
	 * 执行函数调用，参数依次为 p、p1 至 p16。
	 */
	fun call(
		p: P,
		p1: P1,
		p2: P2,
		p3: P3,
		p4: P4,
		p5: P5,
		p6: P6,
		p7: P7,
		p8: P8,
		p9: P9,
		p10: P10,
		p11: P11,
		p12: P12,
		p13: P13,
		p14: P14,
		p15: P15,
		p16: P16,
	)
}

/**
 * 接收 17 个参数且带返回值的函数式接口，参数类型依次为 P、P1 至 P16，返回值类型为 R。
 */
@FunctionalInterface
fun interface P17RFunction<P, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, R> {
	/**
	 * 执行函数调用，参数依次为 p、p1 至 p16。
	 *
	 * @return 函数执行结果
	 */
	fun call(
		p: P,
		p1: P1,
		p2: P2,
		p3: P3,
		p4: P4,
		p5: P5,
		p6: P6,
		p7: P7,
		p8: P8,
		p9: P9,
		p10: P10,
		p11: P11,
		p12: P12,
		p13: P13,
		p14: P14,
		p15: P15,
		p16: P16,
	): R
}

/**
 * 接收 18 个参数且无返回值的函数式接口，参数类型依次为 P、P1 至 P17。
 */
@FunctionalInterface
fun interface P18Function<P, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17> {
	/**
	 * 执行函数调用，参数依次为 p、p1 至 p17。
	 */
	fun call(
		p: P,
		p1: P1,
		p2: P2,
		p3: P3,
		p4: P4,
		p5: P5,
		p6: P6,
		p7: P7,
		p8: P8,
		p9: P9,
		p10: P10,
		p11: P11,
		p12: P12,
		p13: P13,
		p14: P14,
		p15: P15,
		p16: P16,
		p17: P17,
	)
}

/**
 * 接收 18 个参数且带返回值的函数式接口，参数类型依次为 P、P1 至 P17，返回值类型为 R。
 */
@FunctionalInterface
fun interface P18RFunction<P, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, R> {
	/**
	 * 执行函数调用，参数依次为 p、p1 至 p17。
	 *
	 * @return 函数执行结果
	 */
	fun call(
		p: P,
		p1: P1,
		p2: P2,
		p3: P3,
		p4: P4,
		p5: P5,
		p6: P6,
		p7: P7,
		p8: P8,
		p9: P9,
		p10: P10,
		p11: P11,
		p12: P12,
		p13: P13,
		p14: P14,
		p15: P15,
		p16: P16,
		p17: P17,
	): R
}

/**
 * 接收 19 个参数且无返回值的函数式接口，参数类型依次为 P、P1 至 P18。
 */
@FunctionalInterface
fun interface P19Function<P, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18> {
	/**
	 * 执行函数调用，参数依次为 p、p1 至 p18。
	 */
	fun call(
		p: P,
		p1: P1,
		p2: P2,
		p3: P3,
		p4: P4,
		p5: P5,
		p6: P6,
		p7: P7,
		p8: P8,
		p9: P9,
		p10: P10,
		p11: P11,
		p12: P12,
		p13: P13,
		p14: P14,
		p15: P15,
		p16: P16,
		p17: P17,
		p18: P18,
	)
}

/**
 * 接收 19 个参数且带返回值的函数式接口，参数类型依次为 P、P1 至 P18，返回值类型为 R。
 */
@FunctionalInterface
fun interface P19RFunction<P, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, R> {
	/**
	 * 执行函数调用，参数依次为 p、p1 至 p18。
	 *
	 * @return 函数执行结果
	 */
	fun call(
		p: P,
		p1: P1,
		p2: P2,
		p3: P3,
		p4: P4,
		p5: P5,
		p6: P6,
		p7: P7,
		p8: P8,
		p9: P9,
		p10: P10,
		p11: P11,
		p12: P12,
		p13: P13,
		p14: P14,
		p15: P15,
		p16: P16,
		p17: P17,
		p18: P18,
	): R
}

/**
 * 接收 20 个参数且无返回值的函数式接口，参数类型依次为 P、P1 至 P19。
 */
@FunctionalInterface
fun interface P20Function<P, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19> {
	/**
	 * 执行函数调用，参数依次为 p、p1 至 p19。
	 */
	fun call(
		p: P,
		p1: P1,
		p2: P2,
		p3: P3,
		p4: P4,
		p5: P5,
		p6: P6,
		p7: P7,
		p8: P8,
		p9: P9,
		p10: P10,
		p11: P11,
		p12: P12,
		p13: P13,
		p14: P14,
		p15: P15,
		p16: P16,
		p17: P17,
		p18: P18,
		p19: P19,
	)
}

/**
 * 接收 20 个参数且带返回值的函数式接口，参数类型依次为 P、P1 至 P19，返回值类型为 R。
 */
@FunctionalInterface
fun interface P20RFunction<P, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, R> {
	/**
	 * 执行函数调用，参数依次为 p、p1 至 p19。
	 *
	 * @return 函数执行结果
	 */
	fun call(
		p: P,
		p1: P1,
		p2: P2,
		p3: P3,
		p4: P4,
		p5: P5,
		p6: P6,
		p7: P7,
		p8: P8,
		p9: P9,
		p10: P10,
		p11: P11,
		p12: P12,
		p13: P13,
		p14: P14,
		p15: P15,
		p16: P16,
		p17: P17,
		p18: P18,
		p19: P19,
	): R
}

/**
 * 接收 21 个参数且无返回值的函数式接口，参数类型依次为 P、P1 至 P20。
 */
@FunctionalInterface
fun interface P21Function<P, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20> {
	/**
	 * 执行函数调用，参数依次为 p、p1 至 p20。
	 */
	fun call(
		p: P,
		p1: P1,
		p2: P2,
		p3: P3,
		p4: P4,
		p5: P5,
		p6: P6,
		p7: P7,
		p8: P8,
		p9: P9,
		p10: P10,
		p11: P11,
		p12: P12,
		p13: P13,
		p14: P14,
		p15: P15,
		p16: P16,
		p17: P17,
		p18: P18,
		p19: P19,
		p20: P20,
	)
}

/**
 * 接收 21 个参数且带返回值的函数式接口，参数类型依次为 P、P1 至 P20，返回值类型为 R。
 */
@FunctionalInterface
fun interface P21RFunction<P, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, R> {
	/**
	 * 执行函数调用，参数依次为 p、p1 至 p20。
	 *
	 * @return 函数执行结果
	 */
	fun call(
		p: P,
		p1: P1,
		p2: P2,
		p3: P3,
		p4: P4,
		p5: P5,
		p6: P6,
		p7: P7,
		p8: P8,
		p9: P9,
		p10: P10,
		p11: P11,
		p12: P12,
		p13: P13,
		p14: P14,
		p15: P15,
		p16: P16,
		p17: P17,
		p18: P18,
		p19: P19,
		p20: P20,
	): R
}

/**
 * 接收 22 个参数且无返回值的函数式接口，参数类型依次为 P、P1 至 P21。
 */
@FunctionalInterface
fun interface P22Function<P, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21> {
	/**
	 * 执行函数调用，参数依次为 p、p1 至 p21。
	 */
	fun call(
		p: P,
		p1: P1,
		p2: P2,
		p3: P3,
		p4: P4,
		p5: P5,
		p6: P6,
		p7: P7,
		p8: P8,
		p9: P9,
		p10: P10,
		p11: P11,
		p12: P12,
		p13: P13,
		p14: P14,
		p15: P15,
		p16: P16,
		p17: P17,
		p18: P18,
		p19: P19,
		p20: P20,
		p21: P21,
	)
}

/**
 * 接收 22 个参数且带返回值的函数式接口，参数类型依次为 P、P1 至 P21，返回值类型为 R。
 */
@FunctionalInterface
fun interface P22RFunction<P, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21, R> {
	/**
	 * 执行函数调用，参数依次为 p、p1 至 p21。
	 *
	 * @return 函数执行结果
	 */
	fun call(
		p: P,
		p1: P1,
		p2: P2,
		p3: P3,
		p4: P4,
		p5: P5,
		p6: P6,
		p7: P7,
		p8: P8,
		p9: P9,
		p10: P10,
		p11: P11,
		p12: P12,
		p13: P13,
		p14: P14,
		p15: P15,
		p16: P16,
		p17: P17,
		p18: P18,
		p19: P19,
		p20: P20,
		p21: P21,
	): R
}

/**
 * 接收 23 个参数且无返回值的函数式接口，参数类型依次为 P、P1 至 P22。
 */
@FunctionalInterface
fun interface P23Function<P, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21, P22> {
	/**
	 * 执行函数调用，参数依次为 p、p1 至 p22。
	 */
	fun call(
		p: P,
		p1: P1,
		p2: P2,
		p3: P3,
		p4: P4,
		p5: P5,
		p6: P6,
		p7: P7,
		p8: P8,
		p9: P9,
		p10: P10,
		p11: P11,
		p12: P12,
		p13: P13,
		p14: P14,
		p15: P15,
		p16: P16,
		p17: P17,
		p18: P18,
		p19: P19,
		p20: P20,
		p21: P21,
		p22: P22,
	)
}

/**
 * 接收 23 个参数且带返回值的函数式接口，参数类型依次为 P、P1 至 P22，返回值类型为 R。
 */
@FunctionalInterface
fun interface P23RFunction<P, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21, P22, R> {
	/**
	 * 执行函数调用，参数依次为 p、p1 至 p22。
	 *
	 * @return 函数执行结果
	 */
	fun call(
		p: P,
		p1: P1,
		p2: P2,
		p3: P3,
		p4: P4,
		p5: P5,
		p6: P6,
		p7: P7,
		p8: P8,
		p9: P9,
		p10: P10,
		p11: P11,
		p12: P12,
		p13: P13,
		p14: P14,
		p15: P15,
		p16: P16,
		p17: P17,
		p18: P18,
		p19: P19,
		p20: P20,
		p21: P21,
		p22: P22,
	): R
}

/**
 * 接收 24 个参数且无返回值的函数式接口，参数类型依次为 P、P1 至 P23。
 */
@FunctionalInterface
fun interface P24Function<P, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21, P22, P23> {
	/**
	 * 执行函数调用，参数依次为 p、p1 至 p23。
	 */
	fun call(
		p: P,
		p1: P1,
		p2: P2,
		p3: P3,
		p4: P4,
		p5: P5,
		p6: P6,
		p7: P7,
		p8: P8,
		p9: P9,
		p10: P10,
		p11: P11,
		p12: P12,
		p13: P13,
		p14: P14,
		p15: P15,
		p16: P16,
		p17: P17,
		p18: P18,
		p19: P19,
		p20: P20,
		p21: P21,
		p22: P22,
		p23: P23,
	)
}

/**
 * 接收 24 个参数且带返回值的函数式接口，参数类型依次为 P、P1 至 P23，返回值类型为 R。
 */
@FunctionalInterface
fun interface P24RFunction<P, P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21, P22, P23, R> {
	/**
	 * 执行函数调用，参数依次为 p、p1 至 p23。
	 *
	 * @return 函数执行结果
	 */
	fun call(
		p: P,
		p1: P1,
		p2: P2,
		p3: P3,
		p4: P4,
		p5: P5,
		p6: P6,
		p7: P7,
		p8: P8,
		p9: P9,
		p10: P10,
		p11: P11,
		p12: P12,
		p13: P13,
		p14: P14,
		p15: P15,
		p16: P16,
		p17: P17,
		p18: P18,
		p19: P19,
		p20: P20,
		p21: P21,
		p22: P22,
		p23: P23,
	): R
}
