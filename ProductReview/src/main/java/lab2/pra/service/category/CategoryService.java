package lab2.pra.service.category;

import lab2.pra.domain.Category;
import lab2.pra.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> findAll();

    CategoryDto findById(Integer id);

    Category findCategoryById(Integer id);

    CategoryDto save(CategoryDto category);

    CategoryDto update(Integer id, CategoryDto category);

    boolean delete(Integer id);
}
