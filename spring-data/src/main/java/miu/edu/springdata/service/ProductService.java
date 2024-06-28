package miu.edu.springdata.service;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import miu.edu.springdata.domain.Category;
import miu.edu.springdata.domain.Product;
import miu.edu.springdata.domain.Review;
import miu.edu.springdata.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public void removeProduct(int id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null) {
            throw new RuntimeException("Product not found");
        }
        productRepository.delete(product);
    }

    public Optional<Product> getProduct(int id) {
        Optional<Product> product =productRepository.findById(id);
        if (product.isEmpty()) {
            throw new RuntimeException("Product not found");
        }
        return product;
    }

    public Product updateProduct(int id, Product product) {
        Product product1 = productRepository.findById(id).orElse(null);
        if (product1 == null) {
            throw new RuntimeException("Product not found");
        }
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        product1.setReviews(product.getReviews());
        product1.setRating(product.getRating());
        return productRepository.save(product1);
    }
    public List<Product> getProductsByPriceGreaterThan(double price) {
        return productRepository.findProductsByPriceGreaterThan(price);
    }
    public List<Product> getProductsByCategoryAndPriceLessThan(String category, double price) {
        return productRepository.findProductsByCategory_NameAndPriceLessThan(category, price);
    }
    public List<Product> getProductsByProductNameContains(String name) {
        return productRepository.findByNameContains(name);
    }

    public List<Review> getReviewOfProduct(int id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null) {
            throw new IllegalArgumentException("Product not found");
        }
        return product.getReviews();
    }
}
