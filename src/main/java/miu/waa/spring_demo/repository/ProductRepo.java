package miu.waa.spring_demo.repository;

import miu.waa.spring_demo.entity.Category;
import miu.waa.spring_demo.entity.Product;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ProductRepo extends ListCrudRepository<Product, Integer> {
    List<Product> findByPriceGreaterThan(double minPrice);
    List<Product> findByCategoryNameAndPriceLessThanEqual(String category, double price);
    List<Product> findByNameContaining(String firstName);
}
