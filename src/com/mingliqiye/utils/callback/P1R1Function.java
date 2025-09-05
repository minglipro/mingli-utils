package com.mingliqiye.utils.callback;

/**
 * PRFunction接口表示一个接收参数P并返回结果R的函数式接口
 * <p>
 * 该接口使用@，表明它是一个函数式接口，
 * 只包含一个抽象方法FunctionalInterface注解标记call，可用于Lambda表达式和方法引用
 * </p>
 *
 * @author MingLiPro
 * @param <P> 函数接收的参数类型
 * @param <R> 函数返回的结果类型
 */
@FunctionalInterface
public interface P1R1Function<P, R> {
	/**
	 * 执行函数调用
	 *
	 * @param p 输入参数
	 * @return 函数执行结果
	 */
	R call(P p);
}
