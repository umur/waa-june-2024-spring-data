package com.example.Spring_Data.service;

import com.example.Spring_Data.entity.Product;
import com.example.Spring_Data.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public Product getProductById(int id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
    public Product updateProduct(int id, Product productDetails) {
        Product product = getProductById(id);
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        product.setRating(productDetails.getRating());
        product.setCategory(productDetails.getCategory());
        return productRepository.save(product);
    }
    public void deleteProduct(int id) {
        Product product = getProductById(id);
        productRepository.delete(product);
    }

    public List<Product> findAllByPriceGreaterThan(int price) {
        return productRepository.findAllByPriceGreaterThan(price);
    }

    public List<Product> findAllByCategory_IdAndPriceLessThan(int categoryId, int price) {
        return productRepository.findAllByCategory_IdAndPriceLessThan(categoryId, price);
    }

    public List<Product> findAllByNameContains(String name) {
        return productRepository.findAllByNameContains(name);
    }

}
