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
 * CurrentFile ApplicationStartedRunner.java
 * LastUpdate 2026-11-18 08:21:57
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.springboot.annotation;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.AliasFor;
import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

/**
 * 应用启动完成事件监听注解。
 *
 * <p>标注在 Spring Bean 的方法上，当 Spring Boot 应用完成启动并就绪
 * （{@link ApplicationReadyEvent} 发布）时自动调用该方法。</p>
 *
 * @deprecated 已弃用，请改用 {@link ApplicationReadyEventListener}（功能完全一致，命名更规范）。
 * @see ApplicationReadyEventListener
 * @see EventListener
 * @see ApplicationReadyEvent
 */
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EventListener(ApplicationReadyEvent.class)
@Order
@Deprecated(since = "use ApplicationReadyEventListener")
public @interface ApplicationStartedRunner {
    /**
     * SpEL 条件表达式，仅当表达式求值为 true 时才执行监听方法。
     *
     * @return 条件表达式，默认为空字符串（无条件执行）
     */
    @AliasFor(annotation = EventListener.class, attribute = "condition")
    String condition() default "";

    /**
     * 当事件不是 {@link ApplicationReadyEvent} 类型时是否仍默认执行监听方法。
     *
     * @return 是否默认执行，默认为 true
     */
    @AliasFor(annotation = EventListener.class, attribute = "defaultExecution")
    boolean defaultExecution() default true;

    /**
     * 监听器的唯一标识，用于注册可指定 id 的监听器。
     *
     * @return 监听器 id，默认为空字符串（自动生成）
     */
    @AliasFor(annotation = EventListener.class, attribute = "id")
    String id() default "";


    /**
     * 监听器的执行顺序，值越小优先级越高。
     *
     * @return 顺序值，默认为 {@link Ordered#LOWEST_PRECEDENCE}
     * @see Ordered#getOrder()
     */
    @AliasFor(annotation = Order.class, attribute = "value")
    int order() default Ordered.LOWEST_PRECEDENCE;
}
