package com.example.lab2.service.impl;

import com.example.lab2.dto.ReviewDTO;
import com.example.lab2.entity.Product;
import com.example.lab2.entity.Review;
import com.example.lab2.entity.User;
import com.example.lab2.exception.ResourceNotFoundException;
import com.example.lab2.mapper.DtoMapper;
import com.example.lab2.repository.ReviewRepository;
import com.example.lab2.service.ProductService;
import com.example.lab2.service.ReviewService;
import com.example.lab2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//
@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository repo;
    private final UserService userService;
    private final ProductService productService;
    @Override
    public List<ReviewDTO> getAll() {
        return repo.findAll().stream().map(DtoMapper.MAPPER::entityToDto).toList();
    }

    @Override
    public ReviewDTO getById(Long id) {
        return DtoMapper.MAPPER.entityToDto(getReviewById(id));
    }

    @Override
    public Review getReviewById(Long id) {
        Optional<Review> reviewOpt=repo.findById(id);
        if(reviewOpt.isEmpty()){
            throw new RuntimeException("No review Found");
        }
        return reviewOpt.get();
    }

    @Override
    public ReviewDTO save(ReviewDTO reviewDto) {
        Review review=DtoMapper.MAPPER.dtoToEntity(reviewDto);
        Product product=productService.getProductById(review.getProduct().getId());
        User user=userService.getUserById(review.getUser().getId());
        review.setProduct(product);
        review.setUser(user);
        return DtoMapper.MAPPER.entityToDto(repo.save(review));
    }

    @Override
    public ReviewDTO update(Long id, ReviewDTO reviewDto) {
        Optional<Review> reviewOpt=repo.findById(id);
        if(reviewOpt.isEmpty()){
            throw new RuntimeException("No reviewDto Found");
        }
        Product product=productService.getProductById(reviewDto.getProduct().getId());
        User user=userService.getUserById(reviewDto.getUser().getId());
        Review savedReview=reviewOpt.get();
        savedReview.setProduct(product);
        savedReview.setUser(user);
        savedReview.setComment(reviewDto.getComment());

        repo.save(savedReview);
        return DtoMapper.MAPPER.entityToDto(savedReview);
    }

    @Override
    public boolean delete(Long id) {
        Optional<Review> reviewOpt=repo.findById(id);
        if(reviewOpt.isEmpty()){
            throw new RuntimeException("No review Found");
        }
        repo.delete(reviewOpt.get());
        return true;
    }

    @Override
    public List<ReviewDTO> findByProduct(Long productId){
        Product product=productService.getProductById(productId);
        return repo.findByProduct(product).stream().map(DtoMapper.MAPPER::entityToDto).toList();
    }

}