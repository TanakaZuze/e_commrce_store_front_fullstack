package dev.tanaka.ecommerce_storefront_backend.service.product_service;

import dev.tanaka.ecommerce_storefront_backend.model.Product;
import dev.tanaka.ecommerce_storefront_backend.repository.ProductRepository;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements ProductServiceI{

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public String deleteProduct(Long id) {
        Product productToBeDeleted =productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        productRepository.delete(productToBeDeleted);
        return "Product deleted with id: " + id ;
    }
}
