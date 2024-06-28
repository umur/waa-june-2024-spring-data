package miu.edu.springdata.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Product {
    @Id
    private int id;
    private String name;
    private double price;
    private int rating;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "review_id")
    private List<Review> reviews= new ArrayList<>();
    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;

    public Review addReview(Review review) {
        reviews.add(review);
        return review;
    }

}
