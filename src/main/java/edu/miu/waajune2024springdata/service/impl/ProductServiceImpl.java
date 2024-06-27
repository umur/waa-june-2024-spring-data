package edu.miu.waajune2024springdata.service.impl;

import edu.miu.waajune2024springdata.dto.ProductDto;
import edu.miu.waajune2024springdata.entity.Category;
import edu.miu.waajune2024springdata.entity.Product;
import edu.miu.waajune2024springdata.mapper.DtoMapper;
import edu.miu.waajune2024springdata.repository.ProductRepository;
import edu.miu.waajune2024springdata.service.CategoryService;
import edu.miu.waajune2024springdata.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author kush
 */
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository repo;
    private final CategoryService categoryService;
    @Override
    public List<ProductDto> getAll() {
        return repo.findAll().stream().map(DtoMapper.MAPPER::entityToDto).toList();
    }

    @Override
    public ProductDto getById(Long id) {
        return DtoMapper.MAPPER.entityToDto(getProductById(id));
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> productOpt=repo.findById(id);
        if(productOpt.isEmpty()){
            throw new RuntimeException("No product Found");
        }
        return productOpt.get();
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        Category category=categoryService.getCategoryById(productDto.getCategory().getId());
        Product product=DtoMapper.MAPPER.dtoToEntity(productDto);
        product.setCategory(category);
        return DtoMapper.MAPPER.entityToDto(repo.save(product));
    }

    @Override
    public ProductDto update(Long id, ProductDto productDto) {
        Optional<Product> productOpt=repo.findById(id);
        if(productOpt.isEmpty()){
            throw new RuntimeException("No productDto Found");
        }
        Category category=categoryService.getCategoryById(productDto.getCategory().getId());
        Product savedProduct=productOpt.get();
        savedProduct.setCategory(category);
        savedProduct.setName(productDto.getName());
        savedProduct.setCategory(category);
        savedProduct.setRating(productDto.getRating());

        return DtoMapper.MAPPER.entityToDto(repo.save(savedProduct));
    }

    @Override
    public boolean delete(Long id) {
        Optional<Product> productOpt=repo.findById(id);
        if(productOpt.isEmpty()){
            throw new RuntimeException("No product Found");
        }
        repo.delete(productOpt.get());
        return true;
    }

    @Override
    public List<ProductDto> findGreaterThanPrice(double minPrice) {
        return repo.findByPriceGreaterThan(minPrice).stream().map(DtoMapper.MAPPER::entityToDto).toList();
    }

    @Override
    public List<ProductDto> findInCategoryCostingLessThan(Long categoryId, double maxPrice) {
        return repo.findByCategory_IdAndPriceLessThan(categoryId,maxPrice).stream().map(DtoMapper.MAPPER::entityToDto).toList();
    }

    @Override
    public List<ProductDto> findProductsLike(String keyword) {
        return repo.findByNameLikeIgnoreCase(keyword).stream().map(DtoMapper.MAPPER::entityToDto).toList();
    }
}

