package lab2.pra.repository;

import lab2.pra.domain.Product;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface ProductRepository extends ListCrudRepository<Product, Integer> {
    List<Product> findByPriceGreaterThan(Double minPrice);
    List<Product>findByCategoryAndPriceLessThan(Integer categoryId, Double price);
    List<Product> findByNameContaining(String keyword);
}
