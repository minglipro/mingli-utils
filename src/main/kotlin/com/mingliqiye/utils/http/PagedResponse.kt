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
 * ProjectName FastBaseMapper.kt
 * ModuleName mingli-utils.main
 * CurrentFile PagedResponse.kt
 * LastUpdate 2026-10-26 23:22:18
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.http

import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.mingliqiye.utils.time.DateTime

data class PagedResponse<T>(
	override val time: String,      // 响应时间，一旦创建不可修改
	override var message: String,   // 响应消息，可通过setter修改
	override var data: PageData<T>,          // 响应数据，可通过setter修改
	override var statusCode: Int,   // HTTP状态码，可通过setter修改
) : BaseResponse<PageData<T>>(
	time,
	message,
	data,
	statusCode
) {
	companion object {
		/**
		 * 创建一个默认的成功响应对象
		 * 使用默认消息"操作成功"，无数据，状态码200
		 *
		 * @return Response<Nothing> 默认的成功响应对象
		 */
		fun ok() = ok("操作成功")


		/**
		 * 创建一个默认的错误响应对象
		 * 使用默认消息"服务器错误"，无数据，状态码500
		 *
		 * @return Response<Nothing> 默认的成功响应对象
		 */
		fun error() = error("服务器错误")

		/**
		 * 创建一个成功的响应对象（仅包含消息）
		 *
		 * @param message 响应消息
		 * @return Response<Any> 成功的响应对象，数据为null
		 */
		@JvmStatic
		fun ok(message: String) = PagedResponse(
			time = DateTime.now().format(), message = message, data = PageData<Nothing>(), statusCode = 200
		)

		/**
		 * 创建一个错误的响应对象
		 *
		 * @param message 错误消息，默认为"服务器错误"
		 * @param statusCode HTTP状态码，默认为500
		 * @return Response<Any> 错误的响应对象
		 */
		fun error(message: String = "服务器错误", statusCode: Int = 500) = ok(message).withStatusCode(statusCode)

		/**
		 * 创建一个成功的响应对象（仅包含数据）
		 * 使用默认消息"操作成功"
		 *
		 * @param T 响应数据的类型
		 * @param data 响应数据
		 * @return Response<T> 成功的响应对象，包含数据
		 */
		@JvmStatic
		fun <T> okData(data: PageData<T>) = PagedResponse(
			time = DateTime.now().format(), message = "操作成功", data = data, statusCode = 200
		)

		/**
		 * 从mybatisplus的page构建
		 */
		@JvmOverloads
		fun <T> okPgae(
			page: Page<T>,
			time: String = DateTime.now().format(),
			message: String = "操作成功",
			statusCode: Int = 200,
		): PagedResponse<T> {

			return PagedResponse(
				time = time, message = message, data = PageData.of(page), statusCode = statusCode
			)
		}

		/**
		 * 创建一个成功的响应对象（包含数据和消息）
		 *
		 * @param T 响应数据的类型
		 * @param data 响应数据
		 * @param message 响应消息
		 * @return Response<T> 成功的响应对象，包含数据和消息
		 */
		@JvmStatic
		fun <T> okData(data: PageData<T>, message: String) = PagedResponse(
			time = DateTime.now().format(), message = message, data = data, statusCode = 200
		)

		/**
		 * 创建一个指定状态码的响应对象（仅包含状态码）
		 * 使用默认消息"操作成功"，无数据
		 *
		 * @param statusCode HTTP状态码
		 * @return Response<Any> 指定状态码的响应对象
		 */
		@JvmStatic
		fun code(statusCode: Int) = PagedResponse(
			time = DateTime.now().format(), message = "操作成功", data = PageData<Nothing>(), statusCode = statusCode
		)

		/**
		 * 创建一个指定状态码的响应对象（包含状态码和消息）
		 * 无数据
		 *
		 * @param statusCode HTTP状态码
		 * @param message 响应消息
		 * @return Response<Any> 指定状态码和消息的响应对象
		 */
		@JvmStatic
		fun code(statusCode: Int, message: String) = PagedResponse(
			time = DateTime.now().format(), message = message, data = PageData<Nothing>(), statusCode = statusCode
		)
	}

	/**
	 * 默认构造函数，创建一个默认的成功响应对象
	 * 使用当前时间、默认消息"操作成功"、状态码200、无数据
	 */
	constructor() : this(
		time = DateTime.now().format(), message = "操作成功", statusCode = 200, data = PageData()
	)


	/**
	 * 设置响应数据
	 *
	 * 该方法允许修改响应数据，并返回当前对象以支持链式调用。
	 *
	 * @param data 新的响应数据
	 * @return Response<T> 当前响应对象（支持链式调用）
	 */
	fun setData(data: PageData<T>): PagedResponse<T> {
		this.data = data
		return this
	}

	/**
	 * 创建一个新的Response对象，使用指定的时间
	 *
	 * 该方法用于创建具有新时间的响应对象，遵循不可变对象的设计模式。
	 * 如果时间相同，则返回原对象避免不必要的对象创建。
	 *
	 * @param time 新的响应时间
	 * @return Response<T> 新的响应对象（如果时间相同则返回原对象）
	 */
	fun withTime(time: String): PagedResponse<T> =
		if (this.time == time) this else PagedResponse(time, message, data, statusCode)

	/**
	 * 创建一个新的Response对象，使用指定的数据
	 *
	 * 该方法允许改变响应数据的类型，创建一个新的响应对象。
	 * 适用于需要在保持其他字段不变的情况下更新数据类型的场景。
	 *
	 * @param D 新的数据类型
	 * @param data 新的响应数据
	 * @return Response<D> 新的响应对象，数据类型为D
	 */
	fun <D> withData(data: PageData<D>): PagedResponse<D> =
		PagedResponse(this.time, this.message, data, this.statusCode)

	/**
	 * 创建一个新的Response对象，使用指定的消息
	 *
	 * 该方法用于创建具有新消息的响应对象，遵循不可变对象的设计模式。
	 * 如果消息相同，则返回原对象避免不必要的对象创建。
	 *
	 * @param message 新的响应消息
	 * @return Response<T> 新的响应对象（如果消息相同则返回原对象）
	 */
	fun withMessage(message: String): PagedResponse<T> =
		if (this.message == message) this else PagedResponse(time, message, data, statusCode)

	/**
	 * 创建一个新的Response对象，使用指定的状态码
	 *
	 * 该方法用于创建具有新状态码的响应对象，遵循不可变对象的设计模式。
	 * 如果状态码相同，则返回原对象避免不必要的对象创建。
	 *
	 * @param statusCode 新的状态码
	 * @return Response<T> 新的响应对象（如果状态码相同则返回原对象）
	 */
	fun withStatusCode(statusCode: Int): PagedResponse<T> =
		if (this.statusCode == statusCode) this else PagedResponse(time, message, data, statusCode)

}
