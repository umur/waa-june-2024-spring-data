package com.project.lab2.respository;

import com.project.lab2.entity.Product;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface ProductRepository extends ListCrudRepository<Product, Long> {
//    Optional<Product> findById(Long productId);
}
