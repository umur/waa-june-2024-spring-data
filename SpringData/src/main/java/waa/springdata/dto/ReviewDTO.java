package waa.springdata.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewDTO {
    private int id;
    private String comment;
    private int productId;
    private int userId;
}
