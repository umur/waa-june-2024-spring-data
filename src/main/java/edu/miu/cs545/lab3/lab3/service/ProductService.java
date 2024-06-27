package edu.miu.cs545.lab3.lab3.service;


import edu.miu.cs545.lab3.lab3.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();

    Optional<Product> findById(Long id);

    void save(Product product);

    void delete(Long id);

    void update(Product product);

    List<Product> findByPriceGreaterThan(double price);

    List<Product> findByCategoryNameAndPriceLessThan(String categoryName, double price);

    List<Product> findByNameContains(String name);
}
