package com.mingliqiye.utils.bean.springboot;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Spring Bean工具类
 * 实现ApplicationContextAware接口，并加入Component注解，让spring扫描到该bean
 * 该类用于在普通Java类中注入bean,普通Java类中用@Autowired是无法注入bean的
 * <p>
 * 需要放入扫描类中
 *
 * @author MingLiPro
 */
@Component
public class SpringBeanUtil implements ApplicationContextAware {

    /**
     * 获取applicationContext
     */
    @Getter
    private static ApplicationContext applicationContext;

    /**
     * 通过bean名称获取Bean实例
     *
     * @param name bean名称
     * @return bean实例对象
     */
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    /**
     * 通过bean类型获取Bean实例
     *
     * @param clazz bean的Class类型
     * @param <T>   泛型类型
     * @return 指定类型的bean实例
     */
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    /**
     * 通过bean名称和类型获取指定的Bean实例
     *
     * @param name  bean名称
     * @param clazz bean的Class类型
     * @param <T>   泛型类型
     * @return 指定名称和类型的bean实例
     */
    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }

    /**
     * 设置ApplicationContext上下文对象
     * 当Spring容器初始化时会自动调用此方法，将ApplicationContext注入到本工具类中
     * 通过判断避免重复赋值，确保只设置一次ApplicationContext
     *
     * @param applicationContext Spring应用上下文对象
     * @throws BeansException bean异常
     */
    @Override
    public void setApplicationContext(
        @NotNull ApplicationContext applicationContext
    ) throws BeansException {
        // 避免重复赋值，确保只设置一次ApplicationContext
        if (SpringBeanUtil.applicationContext == null) {
            SpringBeanUtil.applicationContext = applicationContext;
        }
    }
}
