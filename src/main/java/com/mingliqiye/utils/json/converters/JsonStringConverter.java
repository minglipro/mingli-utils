package com.mingliqiye.utils.json.converters;

/**
 * JSON转换器接口，提供对象与字符串之间的相互转换功能，并支持多种JSON库
 *
 * @param <T> 需要转换的对象类型
 */
public abstract class JsonStringConverter<T> {

	public abstract Class<T> getTClass();

	/**
	 * 将对象转换为字符串
	 *
	 * @param obj 待转换的对象
	 * @return 转换后的字符串
	 */
	abstract String convert(T obj);

	/**
	 * 将字符串转换为对象
	 *
	 * @param string 待转换的字符串
	 * @return 转换后的对象
	 */
	abstract T deConvert(String string);

	/**
	 * 获取 Fastjson 的适配器
	 * @return 适配器实例
	 */
	public FastjsonJsonStringConverterAdapter<
		JsonStringConverter<T>,
		T
	> getFastjsonJsonStringConverterAdapter() {
		return FastjsonJsonStringConverterAdapter.of(this);
	}

	/**
	 * 获取 Gson 的适配器
	 * @return 适配器实例
	 */
	public GsonJsonStringConverterAdapter<
		JsonStringConverter<T>,
		T
	> getGsonJsonStringConverterAdapter() {
		return GsonJsonStringConverterAdapter.of(this);
	}

	/**
	 * 获取 Jackson 的适配器
	 * @return 适配器实例
	 */
	public JacksonJsonStringConverterAdapter<
		JsonStringConverter<T>,
		T
	> getJacksonJsonStringConverterAdapter() {
		return JacksonJsonStringConverterAdapter.of(this);
	}
}
