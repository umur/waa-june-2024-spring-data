package cs545.lab.lab03.service;

import cs545.lab.lab03.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProducts();

    Optional<Product> getProductById(int id);

    Product addProduct(Product product);

    void deleteProductById(int id);

    List<Product> findByPriceGreaterThan(double minPrice);

    List<Product> findByNameAndPriceLessThan(String name, double maxPrice);

    List<Product> findByNameContaining(String keyword);

}
