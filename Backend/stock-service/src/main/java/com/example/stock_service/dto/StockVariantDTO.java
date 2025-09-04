package com.example.stock_service.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StockVariantDTO {

    private Integer id;

    private Integer productId;

    private String sku;

    private String size;

    private String color;

    private String storage;

    private String imgUrl;

    private String slug;

    private String content;

    private String attributesDetail;

    private String createdBy;

    private LocalDateTime createdAt;

    private String updatedBy;

    private LocalDateTime updatedAt;
}
