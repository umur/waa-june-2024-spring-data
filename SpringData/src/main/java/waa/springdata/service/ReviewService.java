package waa.springdata.service;

import waa.springdata.dto.ReviewDTO;
import waa.springdata.entity.Review;
import java.util.List;

public interface ReviewService {
    List<ReviewDTO> findAll();
    List<ReviewDTO> findByProductId(int productId);
    ReviewDTO findById(int id);
    ReviewDTO save(ReviewDTO review);
    ReviewDTO update(int id,ReviewDTO review);
    void deleteById(int id);
}
