package lab2.pra.service.product;

import lab2.pra.adapter.DtoAdapter;
import lab2.pra.domain.Category;
import lab2.pra.domain.Product;
import lab2.pra.dto.ProductDto;
import lab2.pra.repository.ProductRepository;
import lab2.pra.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    @Override
    public List<ProductDto> findAll() {
        return productRepository.findAll()
                .stream()
                .map(DtoAdapter.MAPPER::entityToDto)
                .toList();
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        Product product = DtoAdapter.MAPPER.dtoToEntity(productDto);
        Category category = categoryService.findCategoryById(product.getCategory().getId());
        product.setCategory(category);
        productRepository.save(product);
        return DtoAdapter.MAPPER.entityToDto(product);
    }

    @Override
    public ProductDto update(Integer id, ProductDto productDto) {
        Product prodById = findProductById(id);
        Product product = DtoAdapter.MAPPER.dtoToEntity(productDto);
        Category category = categoryService.findCategoryById(prodById.getId());
        product.setCategory(category);
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setRating(productDto.getRating());
        productRepository.save(product);
        return DtoAdapter.MAPPER.entityToDto(product);
    }

    @Override
    public boolean delete(Integer id) {
        Product product = findProductById(id);
        productRepository.delete(product);
        return true;
    }

    @Override
    public ProductDto findById(Integer id) {
        return DtoAdapter.MAPPER.entityToDto(findProductById(id));
    }

    @Override
    public Product findProductById(Integer id) {
        Optional<Product> productOpt = productRepository.findById(id);
        if(productOpt.isEmpty()){
            throw new RuntimeException("Product not found");
        }
        return productOpt.get();
    }

    @Override
    public List<ProductDto> findGreaterThanPrice(double minPrice) {
        return productRepository.findByPriceGreaterThan(minPrice)
                .stream()
                .map(DtoAdapter.MAPPER::entityToDto)
                .toList();
    }

    @Override
    public List<ProductDto> findInCategoryCostingLessThan(Integer categoryId, double maxPrice) {
        return productRepository.findByCategory_IdAndPriceLessThan(categoryId, maxPrice)
                .stream()
                .map(DtoAdapter.MAPPER::entityToDto)
                .toList();
    }

    @Override
    public List<ProductDto> findProductsLike(String keyword) {
        return productRepository.findByNameContaining(keyword)
                .stream()
                .map(DtoAdapter.MAPPER::entityToDto)
                .toList();
    }
}
