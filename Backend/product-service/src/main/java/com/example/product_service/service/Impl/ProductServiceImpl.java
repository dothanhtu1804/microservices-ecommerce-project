package com.example.product_service.service.Impl;

import com.example.product_service.dto.ProductDTO;
import com.example.product_service.dto.ProductPriceDTO;
import com.example.product_service.dto.ProductStockDTO;
import com.example.product_service.dto.ProductVariantDTO;
import com.example.product_service.entity.*;
import com.example.product_service.exception.wrapper.ProductException;
import com.example.product_service.repository.ProductPriceRepository;
import com.example.product_service.repository.ProductRepository;
import com.example.product_service.repository.ProductStockRepository;
import com.example.product_service.repository.ProductVariantRepository;
import com.example.product_service.service.CategoryService;
import com.example.product_service.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductStockRepository productStockRepository;

    @Autowired
    private ProductPriceRepository productPriceRepository;

    @Autowired
    private ProductVariantRepository productVariantRepository;

    @Autowired
    private CategoryService categoryService;

    //Product APIs
    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Product Service - Get Product By Id - error with id {}", id);
                    return new ProductException("Error product not found with id: " + id);
                });
    }

    @Override
    @Transactional
    public Product createProduct(ProductDTO productDTO) {
        try {
            Category category = categoryService.getCategoryById(1L);

            // Map ProductDTO to Product entity
            Product product = new Product();
            product.setProductName(productDTO.getProductName());
            product.setProductDesc(productDTO.getProductDesc());
            product.setImageUrl(productDTO.getImageUrl());
            product.setBrand(productDTO.getBrand());
            product.setCreatedBy(productDTO.getCreatedBy());
            product.setUpdatedBy(productDTO.getUpdatedBy());
            product.setCategory(category);

            // Map ProductStockDTO to ProductStock
            List<ProductStock> productStocks = productDTO.getProductStocks().stream().map(stockDTO -> {
                ProductStock stock = new ProductStock();
                stock.setProduct(product);
                stock.setQty(stockDTO.getQty());
                stock.setSku(stockDTO.getSku());
                stock.setCreatedBy(stockDTO.getCreatedBy());
                stock.setUpdatedBy(stockDTO.getUpdatedBy());
                return stock;
            }).collect(Collectors.toList());
            product.setProductStocks(productStocks);

            // Map ProductVariantDTO to ProductVariant
            List<ProductVariant> productVariants = productDTO.getProductVariants().stream().map(variantDTO -> {
                ProductVariant variant = new ProductVariant();
                variant.setProduct(product);
                variant.setSku(variantDTO.getSku());
                variant.setSize(variantDTO.getSize());
                variant.setColor(variantDTO.getColor());
                variant.setCreatedBy(variantDTO.getCreatedBy());
                variant.setUpdatedBy(variantDTO.getUpdatedBy());
                return variant;
            }).collect(Collectors.toList());
            product.setProductVariants(productVariants);

            // Map ProductPriceDTO to ProductPrice
            List<ProductPrice> productPrices = productDTO.getProductPrices().stream().map(priceDTO -> {
                ProductPrice price = new ProductPrice();
                price.setProduct(product);
                price.setPrice(priceDTO.getPrice());
                price.setSku(priceDTO.getSku());
                price.setRegion(priceDTO.getRegion());
                price.setCreatedBy(priceDTO.getCreatedBy());
                price.setUpdatedBy(priceDTO.getUpdatedBy());
                return price;
            }).collect(Collectors.toList());
            product.setProductPrices(productPrices);
//            Product product = modelMapper.map(productDTO, Product.class);
            return productRepository.save(product);
        } catch (Exception e) {
            log.error("Product Service - Saving Product - error with id {} with error {}", productDTO.getId(), e.getMessage());
            throw new ProductException("Error saving product with id " + productDTO.getId(), e);
        }
    }

    @Override
    @Transactional
    public Product updateProduct(ProductDTO productDTO) {
        try {
            Product existingCategory = getProductById(productDTO.getId());
            Product product = modelMapper.map(productDTO, Product.class);
            product.setId(existingCategory.getId());
            return productRepository.save(product);
        } catch (Exception e) {
            log.error("Product Service - Update Product - error with id {} with error {}", productDTO.getId(), e.getMessage());
            throw new ProductException("Error update product with id " + productDTO.getId(), e);
        }
    }

    //Product Stock APIs
    @Override
    public List<ProductStock> getProductStocks() {
        return productStockRepository.findAll();
    }

    @Override
    public ProductStock getProductStockById(Long id) {
        return productStockRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Product Service - Get Product Stock By Id - error with id {}", id);
                    return new ProductException("Error product stock not found with id: " + id);
                });
    }

    @Override
    public ProductStock createProductStock(ProductStockDTO productStockDTO) {
        try {
            ProductStock productStock = modelMapper.map(productStockDTO, ProductStock.class);
            return productStockRepository.save(productStock);
        } catch (Exception e) {
            log.error("Product Service - Saving Product Stock - error with id {} with error {}", productStockDTO.getId(), e.getMessage());
            throw new ProductException("Error saving stock with id " + productStockDTO.getId(), e);
        }
    }

    @Override
    @Transactional
    public ProductStock updateProductStock(ProductStockDTO productStockDTO) {
        try {
            ProductStock existingProductStock = getProductStockById(productStockDTO.getId());
            ProductStock product = modelMapper.map(productStockDTO, ProductStock.class);
            product.setId(existingProductStock.getId());
            return productStockRepository.save(product);
        } catch (Exception e) {
            log.error("Product Service - Update Product Stock - error with id {} with error {}", productStockDTO.getId(), e.getMessage());
            throw new ProductException("Error update stock with id " + productStockDTO.getId(), e);
        }
    }

    //Product Price APIs
    @Override
    public List<ProductPrice> getProductPrices() {
        return productPriceRepository.findAll();
    }

    @Override
    public ProductPrice getProductPriceById(Long id) {
        return productPriceRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Product Service - Get Product Price By Id - error with id {}", id);
                    return new ProductException("Error product price not found with id: " + id);
                });
    }

    @Override
    public ProductPrice createProductPrice(ProductPriceDTO productPriceDTO) {
        try {
            ProductPrice productPrice = modelMapper.map(productPriceDTO, ProductPrice.class);
            return productPriceRepository.save(productPrice);
        } catch (Exception e) {
            log.error("Product Service - Saving Product Price - error with id {} with error {}", productPriceDTO.getId(), e.getMessage());
            throw new ProductException("Error saving price with id " + productPriceDTO.getId(), e);
        }
    }

    @Override
    @Transactional
    public ProductPrice updateProductPrice(ProductPriceDTO productPriceDTO) {
        try {
            ProductPrice existingProductPrice = getProductPriceById(productPriceDTO.getId());
            ProductPrice productPrice = modelMapper.map(productPriceDTO, ProductPrice.class);
            productPrice.setId(existingProductPrice.getId());
            return productPriceRepository.save(productPrice);
        } catch (Exception e) {
            log.error("Product Service - Update Product Price - error with id {} with error {}", productPriceDTO.getId(), e.getMessage());
            throw new ProductException("Error update price with id " + productPriceDTO.getId(), e);
        }
    }

    //Product Variant APIs
    @Override
    public List<ProductVariant> getProductVariants() {
        return productVariantRepository.findAll();
    }

    @Override
    public ProductVariant getProductVariantById(Long id) {
        return productVariantRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Product Service - Get Product Variant By Id - error with id {}", id);
                    return new ProductException("Error product variant not found with id: " + id);
                });
    }

    @Override
    @Transactional
    public ProductVariant createProductVariant(ProductVariantDTO productVariantDTO) {
        try {
            ProductVariant productVariant = modelMapper.map(productVariantDTO, ProductVariant.class);
            return productVariantRepository.save(productVariant);
        } catch (Exception e) {
            log.error("Product Service - Saving Product Variant - error with id {} with error {}", productVariantDTO.getId(), e.getMessage());
            throw new ProductException("Error saving variant with id " + productVariantDTO.getId(), e);
        }
    }

    @Override
    @Transactional
    public ProductVariant updateProductVariant(ProductVariantDTO productVariantDTO) {
        try {
            ProductVariant existingProductVariant = getProductVariantById(productVariantDTO.getId());
            ProductVariant productVariant = modelMapper.map(productVariantDTO, ProductVariant.class);
            productVariant.setId(existingProductVariant.getId());
            return productVariantRepository.save(productVariant);
        } catch (Exception e) {
            log.error("Product Service - Update Product Variant - error with id {} with error {}", productVariantDTO.getId(), e.getMessage());
            throw new ProductException("Error update variant with id " + productVariantDTO.getId(), e);
        }
    }
}
