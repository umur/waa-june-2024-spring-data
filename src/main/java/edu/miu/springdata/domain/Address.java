package edu.miu.springdata.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "street", nullable = false, length = 80)
    private String street;

    @Column(name = "zip", nullable = false, length = 8)
    private String zip;

    @Column(name = "city", nullable = false, length = 30)
    private String city;
}
