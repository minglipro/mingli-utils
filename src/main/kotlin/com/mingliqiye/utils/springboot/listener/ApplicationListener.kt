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
 * CurrentFile ApplicationListener.kt
 * LastUpdate 2026-03-11 08:20:37
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.springboot.listener


import com.mingliqiye.utils.logger.MingLiLoggerFactory
import com.mingliqiye.utils.springboot.annotation.ApplicationDestroyedRunner
import com.mingliqiye.utils.springboot.annotation.ApplicationStartedRunner
import com.mingliqiye.utils.springboot.annotation.Listener
import org.springframework.beans.factory.ListableBeanFactory
import org.springframework.boot.context.event.ApplicationStartedEvent
import org.springframework.context.event.ContextClosedEvent
import org.springframework.context.event.EventListener


@Listener
class ApplicationListener {

    val runningMap = HashMap<String, MutableList<ApplicationRunnerData>>()

    companion object {
        private val log = MingLiLoggerFactory.getLogger<ApplicationListener>()
    }

    fun init(applicationContext: ListableBeanFactory) {
        runningMap.clear()
        for (beanName in applicationContext.beanDefinitionNames) {
            val bean: Any = applicationContext.getBean(beanName)
            val beanClass: Class<*> = bean.javaClass
            if (beanClass.getName().startsWith("org.springframework")) {
                continue
            }
            for (method in beanClass.getDeclaredMethods()) {
                val annotation: Any =
                    method.getAnnotation(ApplicationStartedRunner::class.java) ?: method.getAnnotation(
                        ApplicationDestroyedRunner::class.java
                    ) ?: continue
                var order: Int
                var key: Class<out Annotation>
                when (annotation) {
                    is ApplicationStartedRunner -> {
                        order = annotation.order
                        key = ApplicationStartedRunner::class.java
                    }

                    is ApplicationDestroyedRunner -> {
                        order = annotation.order
                        key = ApplicationDestroyedRunner::class.java
                    }

                    else -> continue
                }
                log.debug("ApplicationListener Scaned [{} - {}] order: {} ", bean.javaClass.name, method, order)
                val d = runningMap.getOrPut(key.name) {
                    ArrayList()
                }
                d.add(
                    ApplicationRunnerData(
                        beanName = beanName, order = order, bean = bean, method = method
                    )
                )
            }
        }
        runningMap.forEach { (string, data) ->
            data.sortWith(compareBy(ApplicationRunnerData::order))
        }
    }

    @EventListener(ApplicationStartedEvent::class)
    fun applicationStarted(event: ApplicationStartedEvent) {
        init(event.applicationContext)
        runningMap[ApplicationStartedRunner::class.java.name]?.forEach {
            log.debug("Started Event Running {} {} {} - {}", it.beanName, it.bean, it.method, it.order)
            it.run()
        }
    }

    @EventListener(ContextClosedEvent::class)
    fun applicationClosed() {
        runningMap[ApplicationDestroyedRunner::class.java.name]?.forEach {
            log.debug("Closed Event Running {} {} {} - {}", it.beanName, it.bean, it.method, it.order)
            it.run()
        }
    }
}
