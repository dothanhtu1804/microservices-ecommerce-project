package com.example.product_service.exception.wrapper;

public class CategoryException extends RuntimeException {

    public CategoryException() {
        super();
    }

    public CategoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public CategoryException(String message) {
        super(message);
    }

    public CategoryException(Throwable cause) {
        super(cause);
    }

}
