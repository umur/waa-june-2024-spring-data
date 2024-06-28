package lab2.pra.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProductDto implements Serializable {
    private Integer id;
    private String name;
    private double price;
    private double rating;
    private CategoryDto category;

}
