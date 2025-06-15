package com.example.product_service.controller;

import com.example.product_service.dto.*;
import com.example.product_service.entity.*;
import com.example.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="api/v1")
public class ProductController {

    @Autowired
    private ProductService productService;

    //Product APIs
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public ResponseEntity<Product> createProduct(@RequestBody ProductDTO request) {
        return ResponseEntity.ok(productService.createProduct(request));
    }

    @RequestMapping(value = "/product", method = RequestMethod.PUT)
    public ResponseEntity<Product> updateProduct(@RequestBody ProductDTO request) {
        return ResponseEntity.ok(productService.updateProduct(request));
    }

    //Product Stock APIs
    @RequestMapping(value = "/product/stock", method = RequestMethod.GET)
    public ResponseEntity<List<ProductStock>> getProductStocks() {
        return ResponseEntity.ok(productService.getProductStocks());
    }

    @RequestMapping(value = "/product/stock/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProductStock> getProductStockById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductStockById(id));
    }

    @RequestMapping(value = "/product/stock", method = RequestMethod.POST)
    public ResponseEntity<ProductStock> createProductStock(@RequestBody ProductStockDTO request) {
        return ResponseEntity.ok(productService.createProductStock(request));
    }

    @RequestMapping(value = "/product/stock", method = RequestMethod.PUT)
    public ResponseEntity<ProductStock> updateProductStock(@RequestBody ProductStockDTO request) {
        return ResponseEntity.ok(productService.updateProductStock(request));
    }

    //Product Price APIs
    @RequestMapping(value = "/product/price", method = RequestMethod.GET)
    public ResponseEntity<List<ProductPrice>> getProductPrices() {
        return ResponseEntity.ok(productService.getProductPrices());
    }

    @RequestMapping(value = "/product/price/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProductPrice> getProductPriceById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductPriceById(id));
    }

    @RequestMapping(value = "/product/price", method = RequestMethod.POST)
    public ResponseEntity<ProductPrice> createProductPrice(@RequestBody ProductPriceDTO request) {
        return ResponseEntity.ok(productService.createProductPrice(request));
    }

    @RequestMapping(value = "/product/price", method = RequestMethod.PUT)
    public ResponseEntity<ProductPrice> updateProductPrice(@RequestBody ProductPriceDTO request) {
        return ResponseEntity.ok(productService.updateProductPrice(request));
    }

    //Product Variant APIs
    @RequestMapping(value = "/product/variant", method = RequestMethod.GET)
    public ResponseEntity<List<ProductVariant>> getProductVariants() {
        return ResponseEntity.ok(productService.getProductVariants());
    }

    @RequestMapping(value = "/product/variant/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProductVariant> getProductVariantById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.getProductVariantById(id));
    }

    @RequestMapping(value = "/product/variant", method = RequestMethod.POST)
    public ResponseEntity<ProductVariant> createProductVariant(@RequestBody ProductVariantDTO request) {
        return ResponseEntity.ok(productService.createProductVariant(request));
    }

    @RequestMapping(value = "/product/variant", method = RequestMethod.PUT)
    public ResponseEntity<ProductVariant> updateProductVariant(@RequestBody ProductVariantDTO request) {
        return ResponseEntity.ok(productService.updateProductVariant(request));
    }
}
