package edu.miu.springdata.service.impl;

import edu.miu.springdata.contract.ReviewResponse;
import edu.miu.springdata.contract.SaveReviewRequest;
import edu.miu.springdata.domain.Product;
import edu.miu.springdata.domain.Review;
import edu.miu.springdata.domain.User;
import edu.miu.springdata.exception.ResourceNotFoundException;
import edu.miu.springdata.repository.ProductRepository;
import edu.miu.springdata.repository.ReviewRepository;
import edu.miu.springdata.repository.UserRepository;
import edu.miu.springdata.service.ReviewService;
import edu.miu.springdata.util.ProductErrorMessages;
import edu.miu.springdata.util.ReviewErrorMessages;
import edu.miu.springdata.util.UserErrorMessages;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository  reviewRepository;
    private final ModelMapper       modelMapper;
    private final UserRepository    userRepository;
    private final ProductRepository productRepository;

    public ReviewServiceImpl(
            ReviewRepository reviewRepository,
            ModelMapper modelMapper,
            UserRepository userRepository,
            ProductRepository productRepository
                            ) {
        this.reviewRepository  = reviewRepository;
        this.modelMapper       = modelMapper;
        this.userRepository    = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Page<ReviewResponse> findAll(Pageable pageable) {
        return reviewRepository.findAll(pageable).map(review -> modelMapper.map(review, ReviewResponse.class));
    }

    @Override
    public ReviewResponse findById(Long id) {
        return reviewRepository.findById(id)
                               .map(review -> modelMapper.map(review, ReviewResponse.class))
                               .orElseThrow(
                                       () -> new ResourceNotFoundException(ReviewErrorMessages.reviewNotFound(id)));
    }

    @Override
    public ReviewResponse save(SaveReviewRequest request) {
        Review review = modelMapper.map(request, Review.class);

        User user =
                userRepository.findById(request.getUserId())
                              .orElseThrow(() -> new ResourceNotFoundException(
                                      UserErrorMessages.userNotFound(request.getUserId())));

        Product product =
                productRepository.findById(request.getProductId())
                                 .orElseThrow(() -> new ResourceNotFoundException(
                                         ProductErrorMessages.productNotFound(request.getProductId())));

        review.setProduct(product);
        review.setUser(user);

        Review savedReview = reviewRepository.save(review);

        return modelMapper.map(savedReview, ReviewResponse.class);
    }

    @Override
    public void deleteById(Long id) {
        Review review = reviewRepository.findById(id)
                                        .orElseThrow(() -> new ResourceNotFoundException(
                                                ReviewErrorMessages.reviewNotFound(id)));

        reviewRepository.delete(review);
    }

    @Override
    public ReviewResponse updateReview(Long id, SaveReviewRequest request) {
        Review review = reviewRepository.findById(id)
                                        .orElseThrow(() -> new ResourceNotFoundException(
                                                ReviewErrorMessages.reviewNotFound(id)));

        User user =
                userRepository.findById(request.getUserId())
                              .orElseThrow(() -> new ResourceNotFoundException(
                                      UserErrorMessages.userNotFound(request.getUserId())));

        Product product =
                productRepository.findById(request.getProductId())
                                 .orElseThrow(() -> new ResourceNotFoundException(
                                         ProductErrorMessages.productNotFound(request.getProductId())));


        modelMapper.map(request, review);

        review.setProduct(product);
        review.setUser(user);

        reviewRepository.save(review);

        return modelMapper.map(review, ReviewResponse.class);
    }
}
