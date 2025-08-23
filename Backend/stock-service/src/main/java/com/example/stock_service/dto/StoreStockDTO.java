package com.example.stock_service.dto;

import com.example.stock_service.entity.StockVariant;
import com.example.stock_service.entity.Store;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StoreStockDTO {

    private Integer id;

    private StockVariant variant;

    private Store store;

    private Integer quantity;

    private String createdBy;

    private LocalDateTime createdAt;

    private String updatedBy;

    private LocalDateTime updatedAt;
}
