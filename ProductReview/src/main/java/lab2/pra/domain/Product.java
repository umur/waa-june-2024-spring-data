package lab2.pra.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Double price;
    private Double rating;

    @ManyToOne
    private Category category;
    @OneToMany(mappedBy = "product", cascade = CascadeType.PERSIST)
    private List<Review> reviews;
}
