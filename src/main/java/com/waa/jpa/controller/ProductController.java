package com.waa.jpa.controller;

import com.waa.jpa.entities.Product;
import com.waa.jpa.service.product.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController extends CrudController<Product, Long> {

    public ProductController(ProductService service) {
        super(service);
    }
}
