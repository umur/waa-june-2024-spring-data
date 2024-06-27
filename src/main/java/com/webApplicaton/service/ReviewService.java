package com.webApplicaton.service;

import com.webApplicaton.entity.Review;

import java.util.List;

public interface ReviewService {

    public void save(Review review);
    public List<Review> findAll();
    public Review findById(Long id);
    public void delete(Long id);
    public void update(Long id,Review review);
    public List<Review> findAllByUserId(Long id);
}
