package miu.waa.spring_demo.service.impl;

import lombok.RequiredArgsConstructor;
import miu.waa.spring_demo.entity.Category;
import miu.waa.spring_demo.entity.Product;
import miu.waa.spring_demo.entity.Review;
import miu.waa.spring_demo.entity.User;
import miu.waa.spring_demo.repository.ProductRepo;
import miu.waa.spring_demo.service.ProductService;
import miu.waa.spring_demo.service.UserService;
import miu.waa.spring_demo.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepo productRepo;
    private final UserService userService;
    private final ReviewService reviewService;

    @Override
    public List<Product> getAll() {
        return productRepo.findAll();
    }

    @Override
    public Product getById(Integer id) {
        return productRepo.findById(id).orElse(null);
    }

    @Override
    public Product create(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product update(Product product) {
        return productRepo.save(product);
    }

    @Override
    public void deleteById(Integer id) {
        productRepo.deleteById(id);
    }

    @Override
    public Review addReview(int productId, Review review, int userId) {
        Product product = productRepo.findById(productId).orElse(null);
        if (product == null) throw new RuntimeException("Invalid product!");
        User user = userService.getById(userId);
        if (user == null) throw new RuntimeException("Invalid user identity!");
        review.setUser(user);
        review.setProduct(product);

        return reviewService.create(review);
    }

    @Override
    public List<Product> findByPriceGreaterThan(double minPrice) {
        return productRepo.findByPriceGreaterThan(minPrice);
    }

    @Override
    public List<Product> findByCategoryAndMaxPrice(String category, double maxPrice) {
        return productRepo.findByCategoryNameAndPriceLessThanEqual(category, maxPrice);
    }

    @Override
    public List<Product> findByNameContaining(String firstName) {
        return productRepo.findByNameContaining(firstName);
    }
}
