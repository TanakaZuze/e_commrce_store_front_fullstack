package dev.tanaka.ecommerce_storefront_backend.repository;

import dev.tanaka.ecommerce_storefront_backend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
