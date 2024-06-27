package edu.miu.cs545.lab3.lab3.repository;

import edu.miu.cs545.lab3.lab3.entity.Category;
import org.springframework.data.repository.ListCrudRepository;

public interface CategoryRepo extends ListCrudRepository<Category, Long> {
}
