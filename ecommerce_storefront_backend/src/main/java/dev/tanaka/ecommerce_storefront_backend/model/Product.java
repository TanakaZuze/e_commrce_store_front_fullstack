package dev.tanaka.ecommerce_storefront_backend.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String product_name;
    private String product_description;
    private double product_price;
    private String product_image_url;



}
