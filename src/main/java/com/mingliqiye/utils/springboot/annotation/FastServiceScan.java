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
 * CurrentFile FastServiceScan.java
 * LastUpdate 2026-11-23 14:44:48
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.springboot.annotation;

import com.mingliqiye.utils.springboot.autoconfigure.FastServiceScanRegistrar;
import org.springframework.context.annotation.Import;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * 扫描继承自 {@code com.mingliqiye.utils.mybatisplus.FastBaseIService} 或
 * {@code com.mingliqiye.utils.mybatisplus.FastBaseIServiceNew3518} 的具体类并注册为 Spring Bean。
 * 两个基类分别对应旧版 {@code mybatis-plus-extension} 与新版 {@code mybatis-plus-spring}，
 * 子类都会被扫描到；行为与 {@code @MapperScan} 类似：只有标注了本注解的启动类/配置类才会触发扫描。
 *
 * <p>扫描由 {@link FastServiceScanRegistrar} 注册的
 * {@code com.mingliqiye.utils.springboot.autoconfigure.FastServiceScannerProcessor} 完成，
 * 后者是 {@code BeanFactoryPostProcessor}，会在所有 {@code BeanDefinitionRegistryPostProcessor}
 * （包括 {@code @MapperScan} 的 {@code MapperScannerConfigurer}）之后执行，
 * 因此扫描注册时机在 mapper 之后，服务里的 {@code baseMapper} 可以正常注入。</p>
 *
 * <p>已经标注 {@code @Component} / {@code @Service} 的类会被跳过，交给普通组件扫描处理，避免重复注册。</p>
 *
 * <p>Java 用法：</p>
 * <pre>{@code
 * @SpringBootApplication
 * @MapperScan(basePackages = "com.example.mapper")
 * @FastServiceScan(basePackages = "com.example.service")
 * public class ExampleApplication {
 * }
 * }</pre>
 *
 * <p>Kotlin 用法：</p>
 * <pre>{@code
 * @SpringBootApplication
 * @MapperScan(basePackages = ["com.example.mapper"])
 * @FastServiceScan(basePackages = ["com.example.service"])
 * class ExampleApplication
 * }</pre>
 *
 * <p>不指定扫描包时，默认扫描标注类所在包。</p>
 * <p>{@code Kotlin} 请指定 {@code Service} 为 {@code open}</p>
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(FastServiceScanRegistrar.class)
public @interface FastServiceScan {

    /**
     * 要扫描的包，等价于 {@link #basePackages()}。
     *
     * @return 要扫描的包
     */
    @AliasFor("basePackages")
    String[] value() default {};

    /**
     * 要扫描的包。
     *
     * @return 要扫描的包
     */

    @AliasFor("value")
    String[] basePackages() default {};

    /**
     * 以这些类所在包作为扫描包。
     *
     * @return 用于推导扫描包的类
     */
    Class<?>[] basePackageClasses() default {};
}
