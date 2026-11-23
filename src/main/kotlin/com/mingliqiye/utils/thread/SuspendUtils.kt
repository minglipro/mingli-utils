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
 * CurrentFile SuspendUtils.kt
 * LastUpdate 2026-11-23 09:14:46
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.suspend

import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.withContext
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract
import kotlin.coroutines.CoroutineContext


@OptIn(ExperimentalContracts::class)
suspend inline fun <T> CoroutineContext.withContext(noinline block: suspend CoroutineScope.() -> T): T {
	contract {
		callsInPlace(block, InvocationKind.EXACTLY_ONCE)
	}
	return withContext(this) {
		block(this)
	}
}

fun <T> T.asCompletableDeferred() = CompletableDeferred(this)


@OptIn(ExperimentalContracts::class)
fun <T> CoroutineContext.runBlocking(block: suspend CoroutineScope.() -> T): T {
	contract {
		callsInPlace(block, InvocationKind.EXACTLY_ONCE)
	}
	return kotlinx.coroutines.runBlocking(this) {
		block()
	}
}

/**
 * 在当前线程上阻塞运行协程，等价于 [kotlinx.coroutines.runBlocking]。
 *
 * 使用调用线程自己的事件循环，不占用 [com.mingliqiye.utils.thread.GlobalThreadPool] 的池线程，
 * 因此不会被池的并发度限制或关闭影响；需要在本线程之外执行时用 [CoroutineContext.runBlocking]。
 */
@OptIn(ExperimentalContracts::class)
fun <T> runBlocking(block: suspend CoroutineScope.() -> T): T {
	contract {
		callsInPlace(block, InvocationKind.EXACTLY_ONCE)
	}
	return kotlinx.coroutines.runBlocking {
		block()
	}
}
