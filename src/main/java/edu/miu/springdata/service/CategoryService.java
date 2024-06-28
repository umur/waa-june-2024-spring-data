package edu.miu.springdata.service;

import edu.miu.springdata.contract.CategoryResponse;
import edu.miu.springdata.contract.SaveCategoryRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {
    Page<CategoryResponse> findAll(Pageable pageable);

    CategoryResponse findById(Long id);

    CategoryResponse save(SaveCategoryRequest request);

    CategoryResponse updateCategory(Long id, SaveCategoryRequest request);

    void deleteById(Long id);
}
