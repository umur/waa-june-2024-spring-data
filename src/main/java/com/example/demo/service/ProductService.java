package com.example.demo.service;

import com.example.demo.enity.Category;
import com.example.demo.enity.Product;
import com.example.demo.enity.Review;
import com.example.demo.repository.CategoryRepo;
import com.example.demo.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepo productRepo;
    private final CategoryRepo CategoryRepo;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product getProductById(Long id) {
        return productRepo.findById(id).orElse(null);
    }

    public Product addProduct(Product product) {
        Category category = CategoryRepo.findById(product.getCategory().getId()).orElse(null);
        product.setCategory(category);
        return productRepo.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        Product existingProduct = productRepo.findById(id).orElse(null);
        Category category = CategoryRepo.findById(product.getCategory().getId()).orElse(null);
        List<Review> reviews = existingProduct.getReviews();
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setCategory(category);
            if (reviews != null) {
                existingProduct.setReviews(reviews);
            }
            return productRepo.save(existingProduct);
        } else {
            return null;
        }
    }

    public void deleteProduct(Long id) {
        productRepo.deleteById(id);
    }

    public List<Product> getProductsByPriceMoreThan(double price) {
        return productRepo.findProductByPriceGreaterThan(price);
    }

    public List<Product> getProductsByCategoryAndCostLessThan(String category, double minPrice) {
        return productRepo.findProductByCategoryNameAndPriceLessThan(category, minPrice);
    }

    public List<Product> searchProduct(String keyword) {
        return productRepo.findProductByNameContaining(keyword);
    }
}
