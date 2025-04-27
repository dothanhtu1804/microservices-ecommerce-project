package com.example.product_service.service;

import com.example.product_service.dto.CategoryDTO;
import com.example.product_service.entity.Category;
import com.example.product_service.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();

    Product getProductById(Long id);

    Product createProduct(Product product);

    List<Category> getCategories();

    Category createCategory(CategoryDTO categoryDTO);
}
