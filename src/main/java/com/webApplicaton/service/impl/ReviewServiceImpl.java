package com.webApplicaton.service.impl;

import com.webApplicaton.entity.Review;
import com.webApplicaton.repository.ReviewRepository;
import com.webApplicaton.service.ReviewService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public void save(Review review) {
        reviewRepository.save(review);
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public Review findById(Long id) {
        return reviewRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Data not found with id " + id));
    }

    @Override
    public void delete(Long id) {
        reviewRepository.deleteById(id);
    }

    @Override
    public void update(Long id, Review review) {
        reviewRepository.save(review);
    }

    @Override
    public List<Review> findAllByUserId(Long id) {
        return reviewRepository.findAllByUserId(id);
    }
}
