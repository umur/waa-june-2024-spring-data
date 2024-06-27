package com.example.springdata.model;

import com.example.springdata.entity.Review;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class CreateOrUpdateReviewRequest {
	Review review;
	@JsonProperty("product_id")
	String productId;
	@JsonProperty("user_id")
	String userId;
}
