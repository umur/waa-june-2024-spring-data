package com.example.lab2.service.impl;
import com.example.lab2.dto.ProductDTO;
import com.example.lab2.entity.Category;
import com.example.lab2.entity.Product;
import com.example.lab2.mapper.DtoMapper;
import com.example.lab2.repository.ProductRepository;
import com.example.lab2.service.CategoryService;
import com.example.lab2.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repo;
    private final CategoryService categoryService;

    @Override
    public List<ProductDTO> getAll() {
        return repo.findAll().stream().map(DtoMapper.MAPPER::entityToDto).toList();
    }

    @Override
    public ProductDTO getById(Long id) {
        return DtoMapper.MAPPER.entityToDto(getProductById(id));
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> productOpt = repo.findById(id);
        if (productOpt.isEmpty()) {
            throw new RuntimeException("No product Found");
        }
        return productOpt.get();
    }

    @Override
    public ProductDTO save(ProductDTO productDto) {
        Category category = categoryService.getCategoryById(productDto.getCategory().getId());
        Product product = DtoMapper.MAPPER.dtoToEntity(productDto);
        product.setCategory(category);
        return DtoMapper.MAPPER.entityToDto(repo.save(product));
    }

    @Override
    public ProductDTO update(Long id, ProductDTO productDto) {
        Optional<Product> productOpt = repo.findById(id);
        if (productOpt.isEmpty()) {
            throw new RuntimeException("No productDto Found");
        }
        Category category = categoryService.getCategoryById(productDto.getCategory().getId());
        Product savedProduct = productOpt.get();
        savedProduct.setCategory(category);
        savedProduct.setName(productDto.getName());
        savedProduct.setCategory(category);
        savedProduct.setRating(productDto.getRating());

        return DtoMapper.MAPPER.entityToDto(repo.save(savedProduct));
    }

    @Override
    public boolean delete(Long id) {
        Optional<Product> productOpt = repo.findById(id);
        if (productOpt.isEmpty()) {
            throw new RuntimeException("No product Found");
        }
        repo.delete(productOpt.get());
        return true;
    }

    @Override
    public List<ProductDTO> findGreaterThanPrice(double minPrice) {
        return repo.findByPriceGreaterThan(minPrice).stream().map(DtoMapper.MAPPER::entityToDto).toList();
    }

    @Override
    public List<ProductDTO> findInCategoryCostingLessThan(Long categoryId, double maxPrice) {
        return repo.findByCategory_IdAndPriceLessThan(categoryId, maxPrice).stream().map(DtoMapper.MAPPER::entityToDto).toList();
    }

    @Override
    public List<ProductDTO> findProductsLike(String keyword) {
        return repo.findByNameContainingIgnoreCase(keyword).stream().map(DtoMapper.MAPPER::entityToDto).toList();
    }
}