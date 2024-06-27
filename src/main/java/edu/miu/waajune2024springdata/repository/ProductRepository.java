package edu.miu.waajune2024springdata.repository;

import edu.miu.waajune2024springdata.entity.Category;
import edu.miu.waajune2024springdata.entity.Product;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

/**
 * @author kush
 */
public interface ProductRepository extends ListCrudRepository<Product,Long> {
    List<Product> findByPriceGreaterThan(double minPrice);

    List<Product> findByCategory_IdAndPriceLessThan(Long categoryId, double price);

    List<Product> findByNameLikeIgnoreCase(String keyword);
}
