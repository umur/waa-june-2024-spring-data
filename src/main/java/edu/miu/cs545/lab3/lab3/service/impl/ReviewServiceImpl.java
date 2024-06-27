package edu.miu.cs545.lab3.lab3.service.impl;

import edu.miu.cs545.lab3.lab3.entity.Review;
import edu.miu.cs545.lab3.lab3.repository.ReviewRepo;
import edu.miu.cs545.lab3.lab3.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepo reviewRepo;

    @Override
    public List<Review> findAll() {
        return reviewRepo.findAll();
    }

    @Override
    public Optional<Review> findById(Long id) {
        return reviewRepo.findById(id);
    }

    @Override
    public void save(Review review) {
        reviewRepo.save(review);
    }

    @Override
    public void delete(Long id) {
        reviewRepo.deleteById(id);
    }

    @Override
    public void update(Review review) {
        reviewRepo.save(review);
    }

    @Override
    public List<Review> findReviewsByProductId(Long productId) {
        return reviewRepo.findReviewsByProductId(productId);
    }
}
