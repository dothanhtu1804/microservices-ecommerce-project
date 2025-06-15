package com.example.product_service.service;

import com.example.product_service.dto.CategoryDTO;
import com.example.product_service.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();

    Category getCategoryById(Long id);

    Category createCategory(CategoryDTO request);

    Category updateCategory(CategoryDTO request);
}
