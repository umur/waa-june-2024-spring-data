package com.waa.jpa.service.review;

import com.waa.jpa.dao.ReviewDAO;
import com.waa.jpa.entities.Review;
import com.waa.jpa.service.CrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class ReviewService extends CrudServiceImpl<Review, Long> {

    public ReviewService(ReviewDAO repository) {
        super(repository);
    }
}
