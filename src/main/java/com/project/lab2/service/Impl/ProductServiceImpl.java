package com.project.lab2.service.Impl;

import com.project.lab2.entity.Product;
import com.project.lab2.respository.ProductRepository;
import com.project.lab2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Optional<Product> findByProductId(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);

    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);

    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);

    }
}
