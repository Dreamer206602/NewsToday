package com.booboomx.todaynews.model;

/**
 * Created by booboomx on 17/4/5.
 */

public class ResultResponse<T> {
    public String has_more;
    public String message;
    public T data;

    public ResultResponse(String more, String _message, T result) {
        has_more = more;
        message = _message;
        data = result;
    }
}
