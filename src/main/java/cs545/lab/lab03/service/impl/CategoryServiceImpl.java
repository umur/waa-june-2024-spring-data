package cs545.lab.lab03.service.impl;

import cs545.lab.lab03.entity.Category;
import cs545.lab.lab03.repo.CategoryRepo;
import cs545.lab.lab03.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepo categoryRepo;

    @Override
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Optional<Category> findById(int id) {
        return categoryRepo.findById(id);
    }

    @Override
    public Category save(Category category) {
        return categoryRepo.save(category);
    }


    @Override
    public void deleteById(int id) {
        categoryRepo.deleteById(id);
    }
}
