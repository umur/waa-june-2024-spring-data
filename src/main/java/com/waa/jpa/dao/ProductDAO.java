package com.waa.jpa.dao;

import com.waa.jpa.entities.Product;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDAO extends ListCrudRepository<Product, Integer> {
}
