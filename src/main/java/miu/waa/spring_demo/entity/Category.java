package miu.waa.spring_demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "category")
    @JsonManagedReference
    private List<Product> products;

    @PreRemove
    private void preRemove() {
        for (Product p : getProducts()) {
            p.setCategory(null);
        }
    }

    public void addProduct(Product product) {
        products.add(product);
        product.setCategory(this);
    }
}
