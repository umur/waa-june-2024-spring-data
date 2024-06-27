package edu.miu.cs545.lab3.lab3.service.impl;

import edu.miu.cs545.lab3.lab3.entity.Product;
import edu.miu.cs545.lab3.lab3.repository.ProductRepo;
import edu.miu.cs545.lab3.lab3.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;

    @Override
    public List<Product> findAll() {
        return productRepo.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepo.findById(id);
    }

    @Override
    public void save(Product product) {
        productRepo.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepo.deleteById(id);
    }

    @Override
    public void update(Product product) {
        productRepo.save(product);
    }

    @Override
    public List<Product> findByPriceGreaterThan(double price) {
        return productRepo.findProductsByPriceGreaterThan(price);
    }

    @Override
    public List<Product> findByCategoryNameAndPriceLessThan(String categoryName, double price) {
        return productRepo.findProductsByCategoryNameAndPriceLessThan(categoryName, price);
    }

    @Override
    public List<Product> findByNameContains(String name) {
        return productRepo.findProductsByNameContains(name);
    }
}
