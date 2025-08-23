package com.example.stock_service.dto;

import com.example.stock_service.entity.Country;
import com.example.stock_service.entity.StockVariant;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StockPriceDTO {
    private Integer id;

    private StockVariant variant;

    private Country country;

    private String price;

    private String createdBy;

    private LocalDateTime createdAt;

    private String updatedBy;

    private LocalDateTime updatedAt;
}
