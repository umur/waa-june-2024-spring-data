package com.waa.jpa.service.category;

import com.waa.jpa.dao.CategoryDAO;
import com.waa.jpa.entities.Category;
import com.waa.jpa.service.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends CrudServiceImpl<Category, Long> {

    public CategoryService(CategoryDAO repository) {
        super(repository);
    }
}
