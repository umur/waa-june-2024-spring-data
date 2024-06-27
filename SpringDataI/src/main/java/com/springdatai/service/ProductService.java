package com.springdatai.service;

import com.springdatai.service.DTO.ProductDTO;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    ProductDTO createProduct(ProductDTO productDTO);

    List<ProductDTO> getAllProducts();

    Optional<ProductDTO> getProductById(int id);

    ProductDTO updateProductById(int id, ProductDTO productDTO);

    void deleteProductById(int id);

    List<ProductDTO> findAllByPriceGreaterThan(double minPrice);

    List<ProductDTO> findAllByNameAndPriceLessThan(double maxPrice);

    List<ProductDTO> findAllByNameContaining(String keyword);
}
