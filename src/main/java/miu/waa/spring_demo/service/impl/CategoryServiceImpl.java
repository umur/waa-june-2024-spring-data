package miu.waa.spring_demo.service.impl;

import lombok.RequiredArgsConstructor;
import miu.waa.spring_demo.entity.Category;
import miu.waa.spring_demo.entity.Product;
import miu.waa.spring_demo.repository.CategoryRepo;
import miu.waa.spring_demo.service.CategoryService;
import miu.waa.spring_demo.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepo categoryRepo;
    private final ProductService productService;

    @Override
    public List<Category> getAll() {
        return categoryRepo.findAll();
    }

    @Override
    public Category getById(Integer id) {
        return categoryRepo.findById(id).orElse(null);
    }

    @Override
    public Category create(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public Category update(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public void deleteById(Integer id) {
        categoryRepo.deleteById(id);
    }

    @Override
    public Product createProduct(int categoryId, Product product) {
        Category category = categoryRepo.findById(categoryId).orElse(null);
        if (category == null) throw new RuntimeException("Invalid category!");
        category.addProduct(product);

        product = productService.create(product);
        return product;
    }
}
