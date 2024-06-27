package com.example.springdata.service_implement;

import com.example.springdata.model.Product;
import com.example.springdata.reponsitory.ProductRepository;
import com.example.springdata.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImplement implements ProductService {
    private final ProductRepository productRepository;
    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product update(Long id, Product product) {
        Optional<Product> productOptional = productRepository.findById(id);
        if(productOptional.isPresent()) {
            Product newProduct = productOptional.get();
            newProduct.setName(product.getName());
            newProduct.setPrice(product.getPrice());
            newProduct.setCategory(product.getCategory());
            productRepository.save(newProduct);
        }

        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAllByPriceGreaterThan(Double minPrice) {
        return productRepository.findAllByPriceGreaterThan(minPrice);
    }

    @Override
    public List<Product> findAllByCategoryNameAndPriceLessThan(String categoryName, Double maxPrice) {
        return productRepository.findAllByCategoryNameAndPriceLessThan(categoryName, maxPrice);
    }

    @Override
    public List<Product> findAllByNameContaining(String keyword) {
        return productRepository.findAllByNameContaining(keyword);
    }
}
