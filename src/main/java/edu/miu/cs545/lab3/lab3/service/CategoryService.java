package edu.miu.cs545.lab3.lab3.service;


import edu.miu.cs545.lab3.lab3.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<Category> findAll();

    Optional<Category> findById(Long id);

    void save(Category category);

    void delete(Long id);

    void update(Category category);
}
