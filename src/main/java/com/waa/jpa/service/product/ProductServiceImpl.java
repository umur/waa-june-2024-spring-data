package com.waa.jpa.service.product;

import com.waa.jpa.dao.ProductDAO;
import com.waa.jpa.entities.Category;
import com.waa.jpa.entities.Product;
import com.waa.jpa.service.CrudServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl extends CrudServiceImpl<Product, Long> implements ProductService {


    private final ProductDAO repository;

    public ProductServiceImpl(ProductDAO repository) {
        super(repository);
        this.repository = repository;
    }

    public List<Product> filterProductsByMoreThanMinPrice(double price) {
        return repository.findProductsByPriceGreaterThan(price);
    }

    @Override
    public List<Product> filterProductsByCategoryAndLessThanMaxPrice(Category category, double maxPrice) {
        return repository.findProductsByCategoryAndPriceIsLessThan(category, maxPrice);
    }

    @Override
    public List<Product> filterProductsByName(String keyword) {
        return repository.findProductsByNameContains(keyword);
    }
}
