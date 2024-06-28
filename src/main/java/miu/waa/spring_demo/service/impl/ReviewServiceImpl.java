package miu.waa.spring_demo.service.impl;

import lombok.RequiredArgsConstructor;
import miu.waa.spring_demo.entity.Product;
import miu.waa.spring_demo.entity.Review;
import miu.waa.spring_demo.repository.ReviewRepo;
import miu.waa.spring_demo.service.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepo reviewRepo;

    @Override
    public List<Review> getAll() {
        return reviewRepo.findAll();
    }

    @Override
    public Review getById(Integer id) {
        return reviewRepo.findById(id).orElse(null);
    }

    @Override
    public Review create(Review review) {
        return reviewRepo.save(review);
    }

    @Override
    public Review update(Review review) {
        return reviewRepo.save(review);
    }

    @Override
    public void deleteById(Integer id) {
        reviewRepo.deleteById(id);
    }

    @Override
    public List<Review> findByProductId(int id) {
        return reviewRepo.findByProductId(id);
    }
}
