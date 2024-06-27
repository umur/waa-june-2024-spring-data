package edu.miu.waajune2024springdata.repository;

import edu.miu.waajune2024springdata.entity.Category;
import org.springframework.data.repository.ListCrudRepository;

/**
 * @author kush
 */
public interface CategoryRepository extends ListCrudRepository<Category,Long> {
}
