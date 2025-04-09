package com.kb.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    INSUFFICIENT_SEED(HttpStatus.CONFLICT, "보유한 씨드가 부족합니다."),
    INSUFFICIENT_STOCK_QUANTITY(HttpStatus.CONFLICT, "잘못된 주식 수량입니다."),
    INSUFFICIENT_AMOUNT(HttpStatus.CONFLICT, "잘못된 수입/지출 금액 입력"),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "유효하지 않은 학생 ID 입니다."),
    INTERNAL_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal error")


    ;

    private final HttpStatus status;
    private final String message;
}
