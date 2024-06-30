package com.springdatai.service.DTO;

import lombok.Data;

@Data
public class ReviewDTO {

    private int id;
    private String comment;
    private int userId;
    private int productId;

    public ReviewDTO(){}
    public ReviewDTO(int id, String comment, int userId, int productId) {
        this.id = id;
        this.comment = comment;
        this.userId = userId;
        this.productId = productId;
    }
}
