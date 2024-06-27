package waa.springdata.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import waa.springdata.entity.Product;
import waa.springdata.service.ProductService;

import javax.print.attribute.standard.PrinterURI;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @GetMapping
    public List<Product> getAllProduct(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable int id){
       return service.findById(id);
    }

    @GetMapping("/greater-than-min-price")
    public List<Product> getProductGreaterThanMinPrice(@RequestParam double price){
        return service.findByGreaterThanMinPrice(price);
    }

    @GetMapping("/category-cost-less-than")
    public List<Product> getProductByCategoryCostLessThan(@RequestParam String categoryName,@RequestParam double price){
        return service.findByCategoryAndCostLessThan(categoryName,price);
    }

    @GetMapping("/filter")
    public List<Product> getProductByNameKeyWord(@RequestParam String name){
        return service.findByNameKeyword(name);
    }

    @PostMapping
    public Product save(@RequestBody Product product){
        return service.save(product);
    }

    @PutMapping("/{id}")
    public Product updateById(@PathVariable int id,@RequestBody Product product){
        return service.update(id,product);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        service.deleteById(id);
    }

}
