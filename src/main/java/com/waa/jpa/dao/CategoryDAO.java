package com.waa.jpa.dao;

import com.waa.jpa.entities.Category;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryDAO extends ListCrudRepository<Category, Long> {
}
