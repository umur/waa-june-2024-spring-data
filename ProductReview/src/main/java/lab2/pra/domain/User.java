package lab2.pra.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private Address address;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Review> reviews;
}
