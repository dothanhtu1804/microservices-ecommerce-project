package com.example.product_service.dto;

import com.example.product_service.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long id;

    private Category category;

    private List<ProductStockDTO> productStocks = new ArrayList<>();

    private List<ProductVariantDTO> productVariants = new ArrayList<>();

    private List<ProductPriceDTO> productPrices = new ArrayList<>();

    private String productName;

    private String productDesc;

    private String imageUrl;

    private String brand;

    private String createdBy;

    private LocalDateTime createdAt;

    private String updatedBy;

    private LocalDateTime updatedAt;
}
