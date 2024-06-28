package cs545.lab.lab03.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    @OneToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private List<Review> reviews;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;
}
