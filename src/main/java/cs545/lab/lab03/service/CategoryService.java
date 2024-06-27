package cs545.lab.lab03.service;

import cs545.lab.lab03.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<Category> findAll();

    Optional<Category> findById(int id);

    Category save(Category category);

    void deleteById(int id);

}
