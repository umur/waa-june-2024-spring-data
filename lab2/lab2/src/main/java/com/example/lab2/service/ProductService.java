package com.example.lab2.service;

import com.example.lab2.dto.ProductDTO;
import com.example.lab2.entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAll();

    ProductDTO getById(Long id);

    Product getProductById(Long id);

    ProductDTO save(ProductDTO product);

    ProductDTO update(Long id, ProductDTO product);

    boolean delete(Long id);

    List<ProductDTO> findGreaterThanPrice(double minPrice);

    List<ProductDTO> findInCategoryCostingLessThan(Long categoryId, double maxPrice);

    List<ProductDTO> findProductsLike(String keyword);
}
