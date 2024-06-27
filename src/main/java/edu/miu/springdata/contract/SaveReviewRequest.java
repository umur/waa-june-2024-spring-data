package edu.miu.springdata.contract;

import lombok.Data;

@Data
public class SaveReviewRequest {
    private String comment;
    private Long   userId;
    private Long   productId;
}
