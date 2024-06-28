package miu.waa.spring_demo.service;

import miu.waa.spring_demo.entity.Category;
import miu.waa.spring_demo.entity.Product;

public interface CategoryService extends CRUDService<Category, Integer> {
    Product createProduct(int categoryId, Product product);
}
