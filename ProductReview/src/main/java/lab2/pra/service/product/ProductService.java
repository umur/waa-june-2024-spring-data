package lab2.pra.service.product;

import lab2.pra.domain.Product;
import lab2.pra.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAll();

    ProductDto save(ProductDto product);

    ProductDto update(Integer id, ProductDto product);

    boolean delete(Integer id);

    ProductDto findById(Integer id);

    Product findProductById(Integer id);

    List<ProductDto> findGreaterThanPrice(double minPrice);

    List<ProductDto> findInCategoryCostingLessThan(Integer categoryId, double maxPrice);

    List<ProductDto> findProductsLike(String keyword);
}
