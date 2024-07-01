package com.project.lab2.service;

import com.project.lab2.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();
    Optional<Product> findByProductId(Long id);
    Product save(Product product);
    Product update(Product product, Long id);
    void delete(Long id);

    List<Product> findAllByMinPrice(double minPrice);
    List<Product> findAllByCategoryAndPriceLessThan(Long categoryId, Double price);
    List<Product> searchByName(String keyword);
}
