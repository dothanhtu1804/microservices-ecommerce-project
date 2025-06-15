package com.example.product_service.exception;

import com.example.product_service.exception.body.ExceptionMessage;
import com.example.product_service.exception.wrapper.CategoryException;
import com.example.product_service.exception.wrapper.ProductException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class APIExceptionHandler {

    @ExceptionHandler(value = {ProductException.class, CategoryException.class})
    public <T extends RuntimeException> ResponseEntity<ExceptionMessage> handleApiRequestException(final T e) {
        return new ResponseEntity<>(
                ExceptionMessage.builder()
                        .message(e.getCause().getMessage())
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .build(), HttpStatus.BAD_REQUEST);
    }
}
