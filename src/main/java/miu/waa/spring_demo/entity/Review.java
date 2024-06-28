package miu.waa.spring_demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String comment;
    private int rating;

    @ManyToOne
    @JsonBackReference("prod-back-ref")
    private Product product;

    @ManyToOne
    @JsonBackReference("user-back-ref")
    private User user;
}
