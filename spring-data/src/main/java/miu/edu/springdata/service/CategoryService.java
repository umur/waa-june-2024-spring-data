package miu.edu.springdata.service;

import lombok.RequiredArgsConstructor;
import miu.edu.springdata.domain.Category;
import miu.edu.springdata.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }
    public void removeCategory(int id){
        Category category = categoryRepository.findById(id).orElse(null);
        if (category == null){
            throw new IllegalArgumentException("Category not found");
        }
        categoryRepository.delete(category);
    }
    public Category getCategory(int id){
        return categoryRepository.findById(id).orElse(null);
    }
    public List<Category> getAllCategory(){
        return categoryRepository.findAll();
    }
    public Category updateCategory(int id, Category category){
        Category oldCategory = categoryRepository.findById(id).orElse(null);
        if (oldCategory == null){
            throw new IllegalArgumentException("Category not found");
        }
        oldCategory.setName(category.getName());
        oldCategory.setProducts(category.getProducts());

        return categoryRepository.save(oldCategory);
    }
}
