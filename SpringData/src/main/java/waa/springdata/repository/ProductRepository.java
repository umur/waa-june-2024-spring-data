package waa.springdata.repository;

import org.springframework.data.repository.ListCrudRepository;
import waa.springdata.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends ListCrudRepository<Product,Integer> {
    List<Product> findByPriceGreaterThan(double price);
    List<Product> findByCategoryNameAndPriceLessThan(String categoryName,double price);
    List<Product> findByNameContaining(String name);
}
