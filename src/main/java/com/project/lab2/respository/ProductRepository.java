package com.project.lab2.respository;

import com.project.lab2.entity.Category;
import com.project.lab2.entity.Product;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends ListCrudRepository<Product, Long> {
    List<Product> findAllByPriceGreaterThan(double minPrice);
    List<Product> findByCategory_IdAndPriceLessThan(Long categoryId, double price);
    List<Product> findByNameContaining(String keyword);

}
