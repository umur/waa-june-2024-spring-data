package waa.springdata.service;

import waa.springdata.entity.Product;
import java.util.List;

public interface ProductService {
    List<Product> findAll();

    List<Product> findByGreaterThanMinPrice(double price);
    List<Product> findByCategoryAndCostLessThan(String categoryName,double price);
    Product findById(int id);

    List<Product> findByNameKeyword(String name);
    Product save(Product product);
    Product update(int id,Product product);
    void deleteById(int id);
}
