package com.example.springdata.reponsitory;

import com.example.springdata.model.Category;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository  extends ListCrudRepository<Category,Long> {
}
