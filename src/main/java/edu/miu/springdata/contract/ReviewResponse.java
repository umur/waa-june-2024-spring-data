package edu.miu.springdata.contract;

import lombok.Data;

@Data
public class ReviewResponse {
    private Long   id;
    private String comment;
    private Long   userId;
    private Long   productId;
}
