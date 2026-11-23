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
 * CurrentFile RedisLockTimeoutException.kt
 * LastUpdate 2026-11-23 10:21:41
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.exception

/**
 * Redis 分布式锁等待超时异常。
 *
 * @param lockKey 未获取到的完整锁 key（含前缀）
 * @param waitMillis 等待时长（毫秒）
 */
class RedisLockTimeoutException(
	val lockKey: String,
	val waitMillis: Long,
) : MingLiUtilsBaseException("获取 Redis 分布式锁超时: $lockKey，等待 ${waitMillis}ms")
