package com.webApplicaton.service;

import com.webApplicaton.entity.Category;

import java.util.List;

public interface CategoryService {

    public void save(Category category);
    public List<Category> findAll();
    public Category findById(Long id);
    public void delete(Long id);
    public void update(Long id,Category category);
}
