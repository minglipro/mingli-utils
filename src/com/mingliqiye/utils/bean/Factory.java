package com.mingliqiye.utils.bean;

import com.mingliqiye.utils.bean.annotation.ComponentBean;
import com.mingliqiye.utils.bean.annotation.InjectBean;
import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 类似于SpringBoot的Bean管理器
 *
 * @author MingLiPro
 */
public class Factory {

	/**
	 * 存储所有已注册的Bean实例，键为Bean名称，值为Bean实例
	 */
	public static final ConcurrentMap<String, Object> BEANS =
		new ConcurrentHashMap<>();

	/**
	 * 存储按类型查找的Bean实例，键为Bean的Class对象，值为Bean实例
	 */
	private static final ConcurrentMap<Class<?>, Object> TYPE_BEANS =
		new ConcurrentHashMap<>();

	/**
	 * 私有构造函数，防止外部实例化该类
	 */
	private Factory() {}

	/**
	 * 自动扫描指定类所在包下的所有类并注册为Bean
	 *
	 * @param c 指定的类，用于获取其所在的包
	 * @throws IllegalArgumentException 如果传入的类为null或位于默认包中
	 */
	public static void autoScan(Class<?> c) {
		if (c == null) {
			throw new IllegalArgumentException("Class cannot be null");
		}
		Package pkg = c.getPackage();
		if (pkg == null) {
			throw new IllegalArgumentException(
				"Class is in the default package"
			);
		}
		scan(pkg.getName());
	}

	/**
	 * 扫描指定包路径下的所有类文件，并注册其中带有@ComponentBean注解的类为Bean
	 *
	 * @param basePackage 要扫描的基础包名
	 * @throws RuntimeException 如果在扫描过程中发生异常
	 */
	public static void scan(String basePackage) {
		try {
			String path = basePackage.replace('.', '/');
			ClassLoader classLoader =
				Thread.currentThread().getContextClassLoader();
			Enumeration<URL> resources = null;
			resources = classLoader.getResources(path);
			while (resources.hasMoreElements()) {
				URL resource = resources.nextElement();
				File file = new File(resource.toURI());
				scanDirectory(file, basePackage);
			}
			injectDependencies();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 递归扫描目录中的所有类文件，并注册符合条件的类为Bean
	 *
	 * @param directory   当前要扫描的目录
	 * @param packageName 当前目录对应的包名
	 * @throws Exception 如果在扫描或类加载过程中发生异常
	 */
	private static void scanDirectory(File directory, String packageName)
		throws Exception {
		File[] files = directory.listFiles();
		if (files == null) {
			return;
		}

		for (File file : files) {
			if (file.isDirectory()) {
				scanDirectory(file, packageName + "." + file.getName());
			} else if (file.getName().endsWith(".class")) {
				String className =
					packageName + '.' + file.getName().replace(".class", "");
				registerComponent(Class.forName(className));
			}
		}
	}

	/**
	 * 注册一个带有@ComponentBean注解的类为Bean实例
	 *
	 * @param clazz 要注册的类
	 * @throws Exception 如果在实例化类或处理注解时发生异常
	 */
	private static void registerComponent(Class<?> clazz) throws Exception {
		if (clazz.isAnnotationPresent(ComponentBean.class)) {
			ComponentBean component = clazz.getAnnotation(ComponentBean.class);
			String name = component.value().isEmpty()
				? clazz.getName()
				: component.value();
			Object instance = clazz.getDeclaredConstructor().newInstance();
			BEANS.put(name, instance);
			TYPE_BEANS.put(clazz, instance);

			for (Class<?> interfaceClass : clazz.getInterfaces()) {
				TYPE_BEANS.putIfAbsent(interfaceClass, instance);
			}
		}
	}

	/**
	 * 对所有已注册的Bean进行依赖注入处理
	 *
	 * @throws Exception 如果在注入过程中发生异常
	 */
	private static void injectDependencies() throws Exception {
		for (Object bean : BEANS.values()) {
			for (Field field : bean.getClass().getDeclaredFields()) {
				if (field.isAnnotationPresent(InjectBean.class)) {
					InjectBean inject = field.getAnnotation(InjectBean.class);
					Object dependency = findDependency(
						field.getType(),
						inject.value()
					);
					if (dependency == null) {
						throw new IllegalStateException(
							"No suitable dependency found for field " +
							field.getName() +
							" in class " +
							bean.getClass().getName()
						);
					}
					field.setAccessible(true);
					field.set(bean, dependency);
				}
			}
		}
	}

	/**
	 * 根据类型和名称查找对应的依赖实例
	 *
	 * @param type 依赖的类型
	 * @param name 依赖的名称（可为空）
	 * @return 找到的依赖实例，未找到则返回null
	 */
	private static Object findDependency(Class<?> type, String name) {
		if (!name.isEmpty()) {
			return BEANS.get(name);
		}

		Object dependency = TYPE_BEANS.get(type);
		if (dependency != null) {
			return dependency;
		}

		for (Class<?> interfaceType : TYPE_BEANS.keySet()) {
			if (type.isAssignableFrom(interfaceType)) {
				return TYPE_BEANS.get(interfaceType);
			}
		}

		return null;
	}

	/**
	 * 将一个对象添加到Bean容器中，使用其类名作为键
	 *
	 * @param object 要添加的对象
	 * @throws RuntimeException 如果在注入依赖时发生异常
	 */
	public static void add(Object object) {
		Class<?> clazz = object.getClass();
		String name = clazz.getName();
		BEANS.put(name, object);
		TYPE_BEANS.put(clazz, object);
		try {
			injectDependencies();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 将一个对象以指定名称添加到Bean容器中
	 *
	 * @param name   Bean的名称
	 * @param object 要添加的对象
	 * @throws RuntimeException 如果在注入依赖时发生异常
	 */
	public static void add(String name, Object object) {
		BEANS.put(name, object);
		TYPE_BEANS.put(object.getClass(), object);
		try {
			injectDependencies();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 根据类型获取对应的Bean实例
	 *
	 * @param objclass Bean的类型
	 * @param <T>      Bean的泛型类型
	 * @return 对应类型的Bean实例，未找到则返回null
	 */
	public static <T> T get(Class<T> objclass) {
		return objclass.cast(TYPE_BEANS.get(objclass));
	}

	/**
	 * 根据名称和类型获取对应的Bean实例
	 *
	 * @param name     Bean的名称
	 * @param objclass Bean的类型
	 * @param <T>      Bean的泛型类型
	 * @return 对应名称和类型的Bean实例，未找到则返回null
	 */
	public static <T> T get(String name, Class<T> objclass) {
		return objclass.cast(BEANS.get(name));
	}

	/**
	 * 根据名称获取对应的Bean实例
	 *
	 * @param name Bean的名称
	 * @return 对应名称的Bean实例，未找到则返回null
	 */
	public static Object get(String name) {
		return BEANS.get(name);
	}
}
