package edu.miu.waajune2024springdata.service;

import edu.miu.waajune2024springdata.dto.ProductDto;
import edu.miu.waajune2024springdata.entity.Product;

import java.util.List;

/**
 * @author kush
 */
public interface ProductService {
    List<ProductDto> getAll();

    ProductDto getById(Long id);

    Product getProductById(Long id);

    ProductDto save(ProductDto product);

    ProductDto update(Long id, ProductDto product);

    boolean delete(Long id);

    List<ProductDto> findGreaterThanPrice(double minPrice);

    List<ProductDto> findInCategoryCostingLessThan(Long categoryId, double maxPrice);

    List<ProductDto> findProductsLike(String keyword);
}
