package edu.miu.springdata.service;

import edu.miu.springdata.contract.ProductResponse;
import edu.miu.springdata.contract.ReviewResponse;
import edu.miu.springdata.contract.SaveProductRequest;
import edu.miu.springdata.contract.SaveProductReviewRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;

public interface ProductService {
    ProductResponse findById(Long id);

    Page<ProductResponse> findAll(Pageable pageable);

    ProductResponse updateById(Long id, SaveProductRequest productRequest);

    ProductResponse save(SaveProductRequest productRequest);

    void deleteById(Long id);

    void updateProductCategoryById(Long id, Long newCategoryId);

    Page<ReviewResponse> findAllReviews(Long productId, Pageable pageable);

    ReviewResponse addProductReview(Long productId, SaveProductReviewRequest saveReviewRequest);

    ReviewResponse updateProductReview(
            Long productId,
            Long reviewId,
            SaveProductReviewRequest saveProductReviewRequest
                                      );

    void deleteProductReview(Long productId, Long reviewId);

    Page<ProductResponse> findAllByPriceGreaterThanEqual(BigDecimal minPrice, Pageable pageable);

    Page<ProductResponse> findAllByPriceLessThanEqualAndCategoryId(
            BigDecimal maxPrice,
            Long categoryId,
            Pageable pageable
                                                                  );

    Page<ProductResponse> findAllByKeyword(String keyword, Pageable pageable);

}
