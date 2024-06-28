package edu.miu.springdata.service.impl;

import edu.miu.springdata.contract.ProductResponse;
import edu.miu.springdata.contract.ReviewResponse;
import edu.miu.springdata.contract.SaveProductRequest;
import edu.miu.springdata.contract.SaveProductReviewRequest;
import edu.miu.springdata.domain.Category;
import edu.miu.springdata.domain.Product;
import edu.miu.springdata.domain.Review;
import edu.miu.springdata.domain.User;
import edu.miu.springdata.exception.ResourceNotFoundException;
import edu.miu.springdata.repository.CategoryRepository;
import edu.miu.springdata.repository.ProductRepository;
import edu.miu.springdata.repository.ReviewRepository;
import edu.miu.springdata.repository.UserRepository;
import edu.miu.springdata.service.ProductService;
import edu.miu.springdata.util.CategoryErrorMessages;
import edu.miu.springdata.util.ProductErrorMessages;
import edu.miu.springdata.util.ReviewErrorMessages;
import edu.miu.springdata.util.UserErrorMessages;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository  productRepository;
    private final ModelMapper        modelMapper;
    private final CategoryRepository categoryRepository;
    private final ReviewRepository   reviewRepository;
    private final UserRepository     userRepository;

    public ProductServiceImpl(
            ProductRepository productRepository, ModelMapper modelMapper,
            CategoryRepository categoryRepository,
            ReviewRepository reviewRepository,
            UserRepository userRepository
                             ) {
        this.productRepository  = productRepository;
        this.modelMapper        = modelMapper;
        this.categoryRepository = categoryRepository;
        this.reviewRepository   = reviewRepository;
        this.userRepository     = userRepository;
    }

    @Override
    public ProductResponse findById(Long id) {
        Product product = productRepository.findById(id)
                                           .orElseThrow(() -> new ResourceNotFoundException(
                                                   ProductErrorMessages.productNotFound(id)));


        return modelMapper.map(product, ProductResponse.class);
    }

    @Override
    public Page<ProductResponse> findAll(Pageable pageable) {
        return productRepository.findAll(pageable)
                                .map(productResponse -> modelMapper.map(productResponse, ProductResponse.class));
    }

    @Override
    public ProductResponse updateById(Long id, SaveProductRequest productRequest) {
        Product product = productRepository.findById(id)
                                           .orElseThrow(() -> new ResourceNotFoundException(
                                                   ProductErrorMessages.productNotFound(id)));

        modelMapper.map(productRequest, product);

        productRepository.save(product);

        return modelMapper.map(product, ProductResponse.class);
    }

    @Override
    public ProductResponse save(SaveProductRequest productRequest) {
        Product product = modelMapper.map(productRequest, Product.class);
        productRepository.save(product);

        return modelMapper.map(product, ProductResponse.class);
    }

    @Override
    public void deleteById(Long id) {
        Product product = productRepository.findById(id)
                                           .orElseThrow(() -> new ResourceNotFoundException(
                                                   ProductErrorMessages.productNotFound(id)));

        productRepository.delete(product);
    }

    @Override
    public void updateProductCategoryById(Long id, Long newCategoryId) {
        Product product = productRepository.findById(id)
                                           .orElseThrow(() -> new ResourceNotFoundException(
                                                   ProductErrorMessages.productNotFound(id)));

        Category category = categoryRepository.findById(newCategoryId)
                                              .orElseThrow(() -> new ResourceNotFoundException(
                                                      CategoryErrorMessages.categoryNotFound(newCategoryId)));

        product.setCategory(category);

        productRepository.save(product);
    }

    @Override
    public Page<ReviewResponse> findAllReviews(Long productId, Pageable pageable) {
        productRepository.findById(productId)
                         .orElseThrow(() -> new ResourceNotFoundException(
                                 ProductErrorMessages.productNotFound(productId)));

        return reviewRepository.findAllByProductId(productId, pageable)
                               .map(reviewResponse -> modelMapper.map(reviewResponse, ReviewResponse.class));
    }

    @Override
    public ReviewResponse addProductReview(Long productId, SaveProductReviewRequest saveProductReviewRequest) {
        Product product = productRepository.findById(productId)
                                           .orElseThrow(
                                                   () -> new ResourceNotFoundException(
                                                           ProductErrorMessages.productNotFound(productId)));

        User user = userRepository.findById(saveProductReviewRequest.getUserId())
                                  .orElseThrow(() -> new ResourceNotFoundException(
                                          UserErrorMessages.userNotFound(saveProductReviewRequest.getUserId())));

        Review review = modelMapper.map(saveProductReviewRequest, Review.class);
        review.setProduct(product);
        review.setUser(user);

        reviewRepository.save(review);

        return modelMapper.map(review, ReviewResponse.class);

    }

    @Override
    public ReviewResponse updateProductReview(
            Long productId,
            Long reviewId,
            SaveProductReviewRequest saveProductReviewRequest
                                             ) {
        Product product = productRepository.findById(productId)
                                           .orElseThrow(
                                                   () -> new ResourceNotFoundException(
                                                           ProductErrorMessages.productNotFound(productId)));

        User user = userRepository.findById(saveProductReviewRequest.getUserId())
                                  .orElseThrow(() -> new ResourceNotFoundException(
                                          UserErrorMessages.userNotFound(saveProductReviewRequest.getUserId())));

        Review review = reviewRepository.findById(reviewId)
                                        .orElseThrow(() -> new ResourceNotFoundException(
                                                ReviewErrorMessages.reviewNotFound(reviewId)));

        modelMapper.map(saveProductReviewRequest, review);
        review.setProduct(product);
        review.setUser(user);

        reviewRepository.save(review);

        return modelMapper.map(review, ReviewResponse.class);
    }

    @Override
    public void deleteProductReview(Long productId, Long reviewId) {
        productRepository.findById(productId)
                         .orElseThrow(() -> new ResourceNotFoundException(
                                 ProductErrorMessages.productNotFound(productId)));

        Review review = reviewRepository.findById(reviewId)
                                        .orElseThrow(() -> new ResourceNotFoundException(
                                                ReviewErrorMessages.reviewNotFound(reviewId)));

        reviewRepository.delete(review);
    }
}
