package edu.miu.cs545.lab3.lab3.repository;

import edu.miu.cs545.lab3.lab3.entity.Product;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ProductRepo extends ListCrudRepository<Product, Long> {
    List<Product> findProductsByPriceGreaterThan(double price);

    List<Product> findProductsByCategoryNameAndPriceLessThan(String categoryName, double price);

    List<Product> findProductsByNameContains(String name);
}
