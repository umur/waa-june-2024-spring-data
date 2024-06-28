package lab2.pra.service.review;

import lab2.pra.domain.Review;
import lab2.pra.dto.ReviewDto;

import java.util.List;

public interface ReviewService {
    List<ReviewDto> findAll();

    ReviewDto save(ReviewDto review);

    ReviewDto update(Integer id, ReviewDto review);

    boolean delete(Integer id);
    ReviewDto findById(Integer id);

    Review findReviewById(Integer id);

    List<ReviewDto> findByProduct(Integer productId);
}
