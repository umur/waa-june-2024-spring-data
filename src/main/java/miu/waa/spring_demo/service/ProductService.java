package miu.waa.spring_demo.service;

import miu.waa.spring_demo.entity.Product;
import miu.waa.spring_demo.entity.Review;

import java.util.List;

public interface ProductService extends CRUDService<Product, Integer> {
    Review addReview(int productId, Review review, int userId);
    List<Product> findByPriceGreaterThan(double minPrice);
    List<Product> findByCategoryAndMaxPrice(String category, double maxPrice);
    List<Product> findByNameContaining(String firstName);
}
