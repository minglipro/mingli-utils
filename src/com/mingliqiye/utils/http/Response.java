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
