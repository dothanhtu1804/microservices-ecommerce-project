package com.example.product_service.service.Impl;

import com.example.product_service.dto.CategoryDTO;
import com.example.product_service.entity.Category;
import com.example.product_service.entity.Product;
import com.example.product_service.repository.CategoryRepository;
import com.example.product_service.repository.ProductRepository;
import com.example.product_service.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    public Category createCategory(CategoryDTO categoryDTO) {
        Category category = new Category();
//        category.setCategoryName(categoryDTO.getCategoryName());
//        category.setParentId(categoryDTO.getParentId());
        return null;
//        return categoryRepository.save(category);
    }
}
