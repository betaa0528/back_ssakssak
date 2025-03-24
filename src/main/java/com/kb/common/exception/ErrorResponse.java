package com.kb.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErrorResponse<T> {
    private String resultCode;
    private T result;

    public static ErrorResponse<Void> error(String errorCode) {
        return new ErrorResponse<>(errorCode, null);
    }

    public static <T> ErrorResponse<T> success() {
        return new ErrorResponse<>("SUCCESS", null);
    }

    public static <T> ErrorResponse<T> success(T result) {
        return new ErrorResponse<>("SUCCESS", result);
    }

    public String toStream() {
        if (result == null) {
            return "{" +
                    "\"resultCode\":" + "\"" + resultCode + "\"," +
                    "\"result\":" + null + "}";
        }

        return "{" +
                "\"resultCode\":" + "\"" + resultCode + "\"," +
                "\"result\":" + "\"" + result + "\"" + "}";
    }
}
