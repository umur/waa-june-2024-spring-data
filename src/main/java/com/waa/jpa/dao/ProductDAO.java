package com.waa.jpa.dao;

import com.waa.jpa.entities.Category;
import com.waa.jpa.entities.Product;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDAO extends ListCrudRepository<Product, Long> {

    List<Product> findProductsByPriceGreaterThan(double price);
    List<Product> findProductsByCategoryAndPriceIsLessThan(Category cat, double price);
    List<Product> findProductsByNameContains(String keyword);
}
