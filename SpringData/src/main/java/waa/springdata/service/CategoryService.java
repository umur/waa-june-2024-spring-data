package waa.springdata.service;

import waa.springdata.entity.Category;
import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findById(int id);
    Category save(Category category);
    Category update(int id,Category category);
    void deleteById(int id);
}
