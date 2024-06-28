package com.waa.jpa.service.product;

import com.waa.jpa.entities.Category;
import com.waa.jpa.entities.Product;

import java.util.List;

public interface ProductService {

    List<Product> filterProductsByMoreThanMinPrice(double price);
    List<Product> filterProductsByCategoryAndLessThanMaxPrice(Category category, double maxPrice);
    List<Product> filterProductsByName(String keyword);
}
