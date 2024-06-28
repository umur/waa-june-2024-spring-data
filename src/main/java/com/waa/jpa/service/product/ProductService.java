package com.waa.jpa.service.product;

import com.waa.jpa.dao.ProductDAO;
import com.waa.jpa.entities.Product;
import com.waa.jpa.service.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends CrudServiceImpl<Product, Long> {

    public ProductService(ProductDAO repository) {
        super(repository);
    }
}
