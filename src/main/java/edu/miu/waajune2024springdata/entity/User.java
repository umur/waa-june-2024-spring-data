package edu.miu.waajune2024springdata.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author kush
 */
@Data
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    @OneToOne(mappedBy = "user",fetch = FetchType.LAZY)
    @JsonBackReference
    private Address address;
    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Review> review;
}
