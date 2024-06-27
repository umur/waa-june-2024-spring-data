package edu.miu.waajune2024springdata.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author kush
 */
@Data
@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private double price;
    private double rating;
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    private List<Review> reviews;
}
