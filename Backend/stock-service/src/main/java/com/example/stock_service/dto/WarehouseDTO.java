package com.example.stock_service.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WarehouseDTO {
    private Long id;

    private Long countryId;

    private String warehouseCode;

    private String warehouseName;

    private String address;

    private String city;

    private String phone;

    private String createdBy;

    private LocalDateTime createdAt;

    private String updatedBy;

    private LocalDateTime updatedAt;
}
