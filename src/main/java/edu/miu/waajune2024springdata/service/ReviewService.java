package edu.miu.waajune2024springdata.service;

import edu.miu.waajune2024springdata.dto.ProductDto;
import edu.miu.waajune2024springdata.dto.ReviewDto;
import edu.miu.waajune2024springdata.entity.Review;

import java.util.List;

/**
 * @author kush
 */
public interface ReviewService {
    List<ReviewDto> getAll();

    ReviewDto getById(Long id);

    Review getReviewById(Long id);

    ReviewDto save(ReviewDto review);

    ReviewDto update(Long id, ReviewDto review);

    boolean delete(Long id);

    List<ReviewDto> findByProduct(Long productId);

}
