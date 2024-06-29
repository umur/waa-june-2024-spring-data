package com.project.lab2.service.Impl;

import com.project.lab2.entity.Product;
import com.project.lab2.entity.Review;
import com.project.lab2.respository.ReviewRepository;
import com.project.lab2.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private  ReviewRepository reviewRepository;

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public void save(Review review) {
        reviewRepository.save(review);

    }

    @Override
    public void deleteByReviewId(Long id) {
        reviewRepository.deleteById(id);
    }


    @Override
    public Review update(Review review) {
        return reviewRepository.save(review);

    }

    @Override
    public Optional<Review> findReviewById(Long id) {
        return reviewRepository.findById(id);
    }
}
