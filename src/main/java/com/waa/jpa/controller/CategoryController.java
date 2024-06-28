package com.waa.jpa.controller;

import com.waa.jpa.entities.Category;
import com.waa.jpa.service.category.CategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController extends CrudController<Category, Long> {

    public CategoryController(CategoryService service) {
        super(service);
    }
}
