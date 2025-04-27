package com.example.product_service.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class CategoryDTO {
    public String categoryName;
    public Integer parentId;
}
