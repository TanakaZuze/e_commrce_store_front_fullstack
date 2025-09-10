package dev.tanaka.ecommerce_storefront_backend.controller.product_controller;

import dev.tanaka.ecommerce_storefront_backend.model.Product;
import dev.tanaka.ecommerce_storefront_backend.service.product_service.ProductService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping("/create-product")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }
    @GetMapping("/get-all-products")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @DeleteMapping("/delete-by-product-id/{productId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public String deleteByProductId(@PathVariable Long productId) {
        return productService.deleteProduct(productId);
    }
}
