package com.example.product_service.controller;

import com.example.product_service.dto.CategoryDTO;
import com.example.product_service.entity.Category;
import com.example.product_service.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="api/v1/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> getCategories() {
        return ResponseEntity.ok(categoryService.getCategories());
    }

    @PostMapping(value = "/category")
    public ResponseEntity<Category> save(@RequestBody CategoryDTO request) {
        Category categoryCreated = categoryService.createCategory(request);
        return ResponseEntity.ok(categoryCreated);
    }

    @RequestMapping(value = "/category", method = RequestMethod.PUT)
    public ResponseEntity<Category> update(@RequestBody CategoryDTO request) {
        Category categoryCreated = categoryService.updateCategory(request);
        return ResponseEntity.ok(categoryCreated);
    }
}
