package com.example.Spring_Data.repository;

import com.example.Spring_Data.entity.Product;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends ListCrudRepository<Product, Integer>{
    List<Product> findAllByPriceGreaterThan(int price);
    List<Product> findAllByCategory_IdAndPriceLessThan(int categoryId, int price);
    List<Product> findAllByNameContains(String name);

}
