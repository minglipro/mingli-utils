/*
 * Copyright 2025 mingliqiye
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
 * CurrentFile Response.java
 * LastUpdate 2025-09-09 08:37:33
 * UpdateUser MingLiPro
 */

package com.mingliqiye.utils.http;

import com.mingliqiye.utils.time.DateTime;
import com.mingliqiye.utils.time.Formatter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Getter
public class Response<T> {

	private final String time = DateTime.now().format(
		Formatter.STANDARD_DATETIME_MILLISECOUND7
	);
	private String message;
	private T data;
	private int statusCode;

	public Response(String message, T data, int statusCode) {
		this.message = message;
		this.data = data;
		this.statusCode = statusCode;
	}

	public static <T> Response<T> ok(T data) {
		return new Response<>("操作成功", data, 200);
	}

	public Response<T> setMessage(String message) {
		this.message = message;
		return this;
	}

	public Response<T> setData(T data) {
		this.data = data;
		return Response.ok(getData())
			.setMessage(getMessage())
			.setStatusCode(getStatusCode());
	}

	public Response<T> setStatusCode(int statusCode) {
		this.statusCode = statusCode;
		return this;
	}
}
