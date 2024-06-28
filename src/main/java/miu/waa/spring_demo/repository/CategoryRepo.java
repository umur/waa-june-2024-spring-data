package miu.waa.spring_demo.repository;

import miu.waa.spring_demo.entity.Category;
import org.springframework.data.repository.ListCrudRepository;

public interface CategoryRepo extends ListCrudRepository<Category, Integer> {
}
