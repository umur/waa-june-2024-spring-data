package miu.edu.springdata.repository;

import miu.edu.springdata.domain.Category;
import miu.edu.springdata.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findProductsByPriceGreaterThan(double price);
    List<Product> findProductsByCategory_NameAndPriceLessThan(String category, double price);
    List<Product> findByNameContains(String name);

}
