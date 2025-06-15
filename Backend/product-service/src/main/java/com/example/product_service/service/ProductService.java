package com.example.product_service.service;

import com.example.product_service.dto.ProductDTO;
import com.example.product_service.dto.ProductPriceDTO;
import com.example.product_service.dto.ProductStockDTO;
import com.example.product_service.dto.ProductVariantDTO;
import com.example.product_service.entity.Product;
import com.example.product_service.entity.ProductPrice;
import com.example.product_service.entity.ProductStock;
import com.example.product_service.entity.ProductVariant;

import java.util.List;

public interface ProductService {

    //Product APIs
    List<Product> getProducts();

    Product getProductById(Long id);

    Product createProduct(ProductDTO productDTO);

    Product updateProduct(ProductDTO productDTO);

    //Product Stock APIs
    List<ProductStock> getProductStocks();

    ProductStock getProductStockById(Long id);

    ProductStock createProductStock(ProductStockDTO productStockDTO);

    ProductStock updateProductStock(ProductStockDTO productStockDTO);

    //Product Price APIs
    List<ProductPrice> getProductPrices();

    ProductPrice getProductPriceById(Long id);

    ProductPrice createProductPrice(ProductPriceDTO productPriceDTO);

    ProductPrice updateProductPrice(ProductPriceDTO productPriceDTO);

    //Product Variant APIs
    List<ProductVariant> getProductVariants();

    ProductVariant getProductVariantById(Long id);

    ProductVariant createProductVariant(ProductVariantDTO productVariantDTO);

    ProductVariant updateProductVariant(ProductVariantDTO productVariantDTO);
}
