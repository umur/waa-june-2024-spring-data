package miu.waa.spring_demo.service;

import miu.waa.spring_demo.entity.Review;

import java.util.List;

public interface ReviewService extends CRUDService<Review, Integer> {
    List<Review> findByProductId(int id);
}
