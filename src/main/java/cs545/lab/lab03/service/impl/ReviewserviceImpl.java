package cs545.lab.lab03.service.impl;

import cs545.lab.lab03.entity.Review;
import cs545.lab.lab03.repo.ReviewRepo;
import cs545.lab.lab03.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewserviceImpl implements ReviewService {

    private final ReviewRepo reviewRepo;

    @Override
    public Review addReview(Review review) {
        return reviewRepo.saveAndFlush(review);
    }

    @Override
    public List<Review> getAllReviews() {
        return reviewRepo.findAll();
    }

    @Override
    public Optional<Review> getReviewById(int id) {
        return reviewRepo.findById(id);
    }

    @Override
    public void deleteReview(int id) {
        reviewRepo.deleteById(id);
    }

    @Override
    public List<Review> findByProductId(int productId) {
        return reviewRepo.findByProductId(productId);
    }


}
