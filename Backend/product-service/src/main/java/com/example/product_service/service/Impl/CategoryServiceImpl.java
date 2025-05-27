package com.example.product_service.service.Impl;

import com.example.product_service.dto.CategoryDTO;
import com.example.product_service.entity.Category;
import com.example.product_service.exception.wrapper.CategoryException;
import com.example.product_service.repository.CategoryRepository;
import com.example.product_service.service.CategoryService;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class CategoryServiceImpl implements CategoryService {

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(CategoryDTO categoryDTO) {
        return categoryRepository.findById(categoryDTO.getId())
                .orElseThrow(() -> {
                    log.error("Product Service - Get Category By Id - error with id {}", categoryDTO.getId());
                    return new CategoryException("Error category not found with id: " + categoryDTO.getId());
                });
    }

    @Override
    @Transactional
    public Category createCategory(CategoryDTO categoryDTO) {
        try {
            Category category = modelMapper.map(categoryDTO, Category.class);
            return categoryRepository.save(category);
        } catch (Exception e) {
            log.error("Product Service - Saving Category - error with id {} with error {}", categoryDTO.getId(), e.getMessage());
            throw new CategoryException("Error saving category with id " + categoryDTO.getId(), e);
        }
    }

    @Override
    @Transactional
    public Category updateCategory(CategoryDTO categoryDTO) {
        try {
            Category existingCategory = getCategoryById(categoryDTO);
            Category category = modelMapper.map(categoryDTO, Category.class);
            category.setId(existingCategory.getId());
            return categoryRepository.save(category);
        } catch (Exception e) {
            log.error("Product Service - Update Category - error with id {} with error {}", categoryDTO.getId(), e.getMessage());
            throw new CategoryException("Error update category with id " + categoryDTO.getId(), e);
        }
    }
}
