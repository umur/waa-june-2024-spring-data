package miu.waa.lab3.service;

import miu.waa.lab3.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product createProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
    List<Product> getProductsByMinPrice(Double minPrice);
    List<Product> getProductsByCategoryNameAndMaxPrice(String categoryName, Double maxPrice);
    List<Product> getProductsByName(String name);
}
