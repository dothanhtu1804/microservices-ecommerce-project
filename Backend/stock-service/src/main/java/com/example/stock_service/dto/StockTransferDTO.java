package com.example.stock_service.dto;

import com.example.stock_service.entity.StockVariant;
import com.example.stock_service.entity.Store;
import com.example.stock_service.entity.Warehouse;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;

@Data
public class StockTransferDTO {

    private Integer id;

    private StockVariant variant;

    private Warehouse fromWarehouse;

    private Store fromStore;

    private Warehouse toWarehouse;

    private Store toStore;

    private Integer quantity;

    private String transferStatus;

    private Instant transferDate;

    private String createdBy;

    private LocalDateTime createdAt;

    private String updatedBy;

    private LocalDateTime updatedAt;
}
