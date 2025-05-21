package com.example.product_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {

    @JsonProperty("categoryName")
    private String categoryName;

    @JsonProperty("parentId")
    private Integer parentId;
}
