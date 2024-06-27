package edu.miu.cs545.lab3.lab3.service.impl;

import edu.miu.cs545.lab3.lab3.entity.Category;
import edu.miu.cs545.lab3.lab3.repository.CategoryRepo;
import edu.miu.cs545.lab3.lab3.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepo.findById(id);
    }

    @Override
    public void save(Category category) {
        categoryRepo.save(category);
    }

    @Override
    public void delete(Long id) {
        categoryRepo.deleteById(id);
    }

    @Override
    public void update(Category category) {
        categoryRepo.save(category);
    }
}
