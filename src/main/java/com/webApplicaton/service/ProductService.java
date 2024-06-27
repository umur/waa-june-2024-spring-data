package com.webApplicaton.service;

import com.webApplicaton.entity.Product;

import java.util.List;

public interface ProductService {

    public void save(Product product);
    public List<Product> findAll();
    public Product findById(Long id);
    public void delete(Long id);
    public void update(Long id,Product product);
    public List<Product> getProductsByMinPrice(Double minPrice);
    public List<Product> getProductsByCategoryAndMaxPrice(String category, Double maxPrice);
    public List<Product> getProductsByNameKeyword(String name);
}
