package waa.springdata.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import waa.springdata.entity.Category;
import waa.springdata.repository.CategoryRepository;
import waa.springdata.service.CategoryService;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }
    @Override
    public Category update(int id,Category category){
        if(categoryRepository.existsById(id)){
            return categoryRepository.save(category);
        }return null;
    }
    @Override
    public void deleteById(int id) {
        categoryRepository.deleteById(id);
    }
}
