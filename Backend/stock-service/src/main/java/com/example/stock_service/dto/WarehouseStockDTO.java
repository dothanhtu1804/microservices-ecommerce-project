package com.example.stock_service.dto;

import com.example.stock_service.entity.StockVariant;
import com.example.stock_service.entity.Warehouse;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WarehouseStockDTO {

    private Integer id;

    private StockVariant variant;

    private Warehouse warehouse;

    private Integer quantity;

    private String createdBy;

    private LocalDateTime createdAt;

    private String updatedBy;

    private LocalDateTime updatedAt;
}
