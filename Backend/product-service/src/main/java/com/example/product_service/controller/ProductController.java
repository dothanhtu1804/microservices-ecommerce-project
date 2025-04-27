package com.example.product_service.controller;

import com.example.product_service.dto.CategoryDTO;
import com.example.product_service.entity.Category;
import com.example.product_service.entity.Product;
import com.example.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="api/v1")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public Product getById(@RequestParam("id") Long id) {
        return productService.getProductById(id);
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public Product save(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @RequestMapping(value = "/category", method = RequestMethod.GET)
    public List<Category> getCategories() {
        return productService.getCategories();
    }

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    public Category save(@RequestBody CategoryDTO categoryDTO) {
        return productService.createCategory(categoryDTO);
    }
}
