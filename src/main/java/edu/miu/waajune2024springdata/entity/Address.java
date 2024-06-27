package edu.miu.waajune2024springdata.entity;

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
public class Address implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String street;
    private String zip;
    private String city;
    @OneToOne(fetch = FetchType.LAZY)
    private User user;
}
