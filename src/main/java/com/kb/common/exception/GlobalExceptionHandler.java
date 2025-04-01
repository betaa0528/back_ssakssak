package com.kb.common.exception;

import com.kb.member.exception.PasswordMissmatchException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SsakssakApplicationException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> applicationHandler(RuntimeException e) {
        log.error("Error occurs {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorResponse.error(ErrorCode.INTERNAL_ERROR.name()));
    }

    @ExceptionHandler(PasswordMissmatchException.class)
    public ResponseEntity<?> handlePasswordError(Exception ex) {
        return ResponseEntity.status(400)
                .header(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8")
                .body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleError(Exception ex) {
        ex.printStackTrace();
        log.error(ex.getMessage());
        return ResponseEntity.status(500)
                .header(HttpHeaders.CONTENT_TYPE, "application/json; charset=utf-8")
                .body(ex.getMessage());
    }

}
