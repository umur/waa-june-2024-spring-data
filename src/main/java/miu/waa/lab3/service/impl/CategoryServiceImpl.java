package miu.waa.lab3.service.impl;

import lombok.RequiredArgsConstructor;
import miu.waa.lab3.entity.Category;
import miu.waa.lab3.repository.CategoryRepository;
import miu.waa.lab3.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        Category existCategory = categoryRepository.findById(id).orElse(null);
        if(existCategory == null) return null;
        existCategory.setName(category.getName());
        return categoryRepository.save(existCategory);
    }

    @Override
    public void deleteCategoryById(Long id) {
        categoryRepository.deleteById(id);
    }
}
