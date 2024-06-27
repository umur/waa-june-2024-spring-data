package edu.miu.waajune2024springdata.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

/**
 * @author kush
 */
@Data
@Entity
public class Review implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String comment;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
}
