package waa.springdata.dto;

import waa.springdata.entity.Review;

public class ReviewAdapter {

    public static ReviewDTO toDTO(Review review) {
        if (review == null) {
            return null;
        }
        ReviewDTO dto = new ReviewDTO();
        dto.setId(review.getId());
        dto.setComment(review.getComment());
        dto.setProductId(review.getProduct().getId());
        dto.setUserId(review.getUser().getId());
        return dto;
    }

    public static Review toEntity(ReviewDTO dto) {
        if (dto == null) {
            return null;
        }
        Review review = new Review();
        review.setId(dto.getId());
        review.setComment(dto.getComment());
        // Assuming you will set Product and User in the service layer or elsewhere
        return review;
    }
}
