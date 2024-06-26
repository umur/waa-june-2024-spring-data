package edu.miu.springdata.repository;

import edu.miu.springdata.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("SELECT c FROM Category c JOIN FETCH c.products p WHERE p.id = :productId")
    Category findByProductId(@Param("productId") Long productId);
}
