package com.example.lab2.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.context.annotation.Primary;
import java.util.List;

@Data
@Entity
public class User {
    @Id
    private Long id;
    private String email;
    private String password;
    private  String firstName;
    private String lastName;
    @OneToMany(mappedBy = "user")
    private List<Review> reviewList;
    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonManagedReference
    private  Address address;
}
