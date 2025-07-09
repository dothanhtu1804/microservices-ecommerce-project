package com.example.stock_service.exception.wrapper;

public class StockException extends RuntimeException {
    public StockException() {
        super();
    }

    public StockException(String message, Throwable cause) {
        super(message, cause);
    }

    public StockException(String message) {
        super(message);
    }

    public StockException(Throwable cause) {
        super(cause);
    }
}
