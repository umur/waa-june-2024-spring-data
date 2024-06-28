package lab2.pra.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue
    private Integer id;
    private String street;
    private String zip;
    private String city;
    @OneToOne(fetch = FetchType.LAZY)
    private User user;
}
