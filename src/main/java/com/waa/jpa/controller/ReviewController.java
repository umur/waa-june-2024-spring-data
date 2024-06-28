package com.waa.jpa.controller;

import com.waa.jpa.entities.Review;
import com.waa.jpa.service.review.ReviewService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
public class ReviewController extends CrudController<Review, Long> {

    public ReviewController(ReviewService service) {
        super(service);
    }
}
