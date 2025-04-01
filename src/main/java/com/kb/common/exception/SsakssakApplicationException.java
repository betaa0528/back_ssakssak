package com.kb.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SsakssakApplicationException extends RuntimeException {

    private ErrorCode errorCode;
    private String message;

    public SsakssakApplicationException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        if(message == null) {
            return errorCode.getMessage();
        }

        return String.format("%s, %s", errorCode.getMessage(), message);
    }




}
