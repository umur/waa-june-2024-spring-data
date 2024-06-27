package edu.miu.springdata.contract;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductResponse {
    private Long             id;
    private String           name;
    private BigDecimal       price;
    private double           rating;
    private CategoryResponse category;
}
