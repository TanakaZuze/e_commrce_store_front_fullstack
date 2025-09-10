package dev.tanaka.ecommerce_storefront_backend.service.product_service;

import dev.tanaka.ecommerce_storefront_backend.model.Product;

import java.util.List;

public interface ProductServiceI {
    Product createProduct(Product product);
    List<Product> getAllProducts();
    String deleteProduct(Long id);
}
