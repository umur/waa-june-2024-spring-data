package com.project.lab2.service.Impl;

import com.project.lab2.entity.Category;
import com.project.lab2.entity.Product;
import com.project.lab2.entity.Review;
import com.project.lab2.respository.CategoryRepository;
import com.project.lab2.respository.ProductRepository;
import com.project.lab2.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {


    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
    @Autowired
    private  ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findByProductId(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
//        logger.info("Saving product: {}", product);
        log.info("Saving product: {}", product.toString());
        Category category = categoryRepository.findById(product.getCategory().getId()).orElse(null);
        product.setCategory(category);
        return productRepository.save(product);

    }

    @Override
    public Product update(Product product, Long id) {
        Product oldProduct = productRepository.findById(id).orElse(null);
        Category category = categoryRepository.findById(product.getCategory().getId()).orElse(null);
        if (oldProduct != null) {
            oldProduct.setName(product.getName());
            oldProduct.setPrice(product.getPrice());
            oldProduct.setCategory(category);
            return productRepository.save(oldProduct);
        } else {
            return null;
        }


    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);

    }

    @Override
    public List<Product> findAllByMinPrice(double minPrice) {
        return productRepository.findAllByPriceGreaterThan(minPrice).stream().filter(product -> product.getPrice() > minPrice )
                .toList();
    }

    @Override
    public List<Product> findAllByCategoryAndPriceLessThan(Long categoryId, Double price) {
        return productRepository.findByCategory_IdAndPriceLessThan(categoryId, price).stream()
                .filter(product ->product.getCategory().getId().equals(categoryId) && product.getPrice() < price).toList();
    }

    @Override
    public List<Product> searchByName(String keyword) {
        return productRepository.findByNameContaining(keyword).stream().filter(product -> product.getName().contains(keyword)).toList();
    }

}
