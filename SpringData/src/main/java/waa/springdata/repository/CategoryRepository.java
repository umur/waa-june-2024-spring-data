package waa.springdata.repository;

import org.springframework.data.repository.ListCrudRepository;
import waa.springdata.entity.Category;
public interface CategoryRepository extends ListCrudRepository<Category,Integer> {
}
