package edu.miu.waajune2024springdata.service;

import edu.miu.waajune2024springdata.dto.CategoryDto;
import edu.miu.waajune2024springdata.entity.Category;

import java.util.List;

/**
 * @author kush
 */
public interface CategoryService {
    List<CategoryDto> getAll();

    CategoryDto getById(Long id);

    Category getCategoryById(Long id);

    CategoryDto save(CategoryDto category);

    CategoryDto update(Long id, CategoryDto category);

    boolean delete(Long id);
}
