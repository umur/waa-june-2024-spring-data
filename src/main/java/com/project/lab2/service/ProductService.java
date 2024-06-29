package com.project.lab2.service;

import com.project.lab2.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();
    Optional<Product> findByProductId(Long id);
    void save(Product product);
    Product update(Product product);
    void delete(Long id);

}
