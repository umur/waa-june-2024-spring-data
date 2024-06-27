package edu.miu.springdata.contract;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SaveProductRequest {
    private String     name;
    private BigDecimal price;
    private double     rating;
    private Long       categoryId;
}
