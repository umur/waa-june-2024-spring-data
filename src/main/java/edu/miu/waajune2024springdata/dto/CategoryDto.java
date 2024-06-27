package edu.miu.waajune2024springdata.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author kush
 */
@Data
public class CategoryDto implements Serializable {
    private Long id;
    private String name;
}
