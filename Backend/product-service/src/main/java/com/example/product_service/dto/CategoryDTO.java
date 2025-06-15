package com.example.product_service.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {

    private Long id;

    private String categoryName;

    private Integer parentId;
}
