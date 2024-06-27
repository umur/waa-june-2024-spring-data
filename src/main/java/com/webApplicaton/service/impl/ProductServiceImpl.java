package com.webApplicaton.service.impl;

import com.webApplicaton.entity.Product;
import com.webApplicaton.repository.ProductRepository;
import com.webApplicaton.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Data not found with id " + id));
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void update(Long id, Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> getProductsByMinPrice(Double minPrice) {
        return productRepository.findByPriceGreaterThan(minPrice);
    }

    @Override
    public List<Product> getProductsByCategoryAndMaxPrice(String category, Double maxPrice) {
        return productRepository.findByCategoryNameAndPriceLessThan(category,maxPrice);
    }

    @Override
    public List<Product> getProductsByNameKeyword(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }
}
