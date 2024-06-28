package edu.miu.springdata.contract;

import lombok.Data;

@Data
public class SaveProductReviewRequest {
    private String comment;
    private Long   userId;
}
