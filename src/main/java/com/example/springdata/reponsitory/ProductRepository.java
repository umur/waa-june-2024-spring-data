package com.example.springdata.reponsitory;

import com.example.springdata.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface ProductRepository extends ListCrudRepository<Product,Long> {
    List<Product> findAllByPriceGreaterThan(Double minPrice);
    @Query(name="SELECT p FROM product p JOIN p.category c WHERE c.name = :categoryName AND p.price < :maxPrice", nativeQuery = true)
    List<Product> findAllByCategoryNameAndPriceLessThan(String categoryName, Double maxPrice);
    @Query(name="SELECT p FROM product p WHERE p.name LIKE %:keyword%", nativeQuery = true)
    List<Product> findAllByNameContaining(String keyword);
}