package com.example.product_service.dto;

import com.example.product_service.entity.ProductPrice;
import com.example.product_service.entity.ProductStock;
import com.example.product_service.entity.ProductVariant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long id;

    private List<ProductStock> productStocks = new ArrayList<>();

    private List<ProductVariant> productVariants = new ArrayList<>();

    private List<ProductPrice> productPrices = new ArrayList<>();

    private String productName;

    private BigDecimal priceOld;

    private BigDecimal priceNew;

    private String createdBy;

    private LocalDateTime createdAt;

    private String updatedBy;

    private LocalDateTime updatedAt;
}
