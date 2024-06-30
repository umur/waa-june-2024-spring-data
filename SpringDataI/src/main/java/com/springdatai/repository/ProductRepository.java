package com.springdatai.repository;

import com.springdatai.domain.Category;
import com.springdatai.domain.Product;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends ListCrudRepository<Product, Integer> {
    List<Product> findAllByPriceGreaterThan(double minPrice);

    List<Product> findAllByCategoryNameAndPriceLessThan(String categoryName, double maxPrice);

    List<Product> findAllByNameContaining(String keyword);

}
