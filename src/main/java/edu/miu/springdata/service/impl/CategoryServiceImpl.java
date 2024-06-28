package edu.miu.springdata.service.impl;

import edu.miu.springdata.contract.CategoryResponse;
import edu.miu.springdata.contract.SaveCategoryRequest;
import edu.miu.springdata.domain.Category;
import edu.miu.springdata.domain.Product;
import edu.miu.springdata.exception.ResourceAlreadyExistsException;
import edu.miu.springdata.exception.ResourceAlreadyInUseException;
import edu.miu.springdata.exception.ResourceNotFoundException;
import edu.miu.springdata.repository.CategoryRepository;
import edu.miu.springdata.repository.ProductRepository;
import edu.miu.springdata.service.CategoryService;
import edu.miu.springdata.util.CategoryErrorMessages;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper        modelMapper;
    private final ProductRepository  productRepository;

    public CategoryServiceImpl(
            CategoryRepository categoryRepository, ModelMapper modelMapper,
            ProductRepository productRepository
                              ) {
        this.categoryRepository = categoryRepository;
        this.modelMapper        = modelMapper;
        this.productRepository  = productRepository;
    }

    @Override
    public Page<CategoryResponse> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable).map(category -> modelMapper.map(category, CategoryResponse.class));
    }

    @Override
    public CategoryResponse findById(Long id) {
        return categoryRepository.findById(id)
                                 .map(category -> modelMapper.map(category, CategoryResponse.class))
                                 .orElseThrow(() -> new ResourceNotFoundException(
                                         CategoryErrorMessages.categoryNotFound(id)
                                 ));
    }

    @Override
    public CategoryResponse save(SaveCategoryRequest request) {
        Optional<Category> categoryOptional = categoryRepository.findByName(request.getName());

        if (categoryOptional.isPresent()) {
            throw new ResourceAlreadyExistsException(CategoryErrorMessages.categoryAlreadyExists(request.getName()));
        }

        Category category = modelMapper.map(request, Category.class);
        category = categoryRepository.save(category);

        return modelMapper.map(category, CategoryResponse.class);
    }

    @Override
    public CategoryResponse updateCategory(Long id, SaveCategoryRequest request) {
        Category category =
                categoryRepository.findById(id)
                                  .orElseThrow(() -> new ResourceNotFoundException(
                                          CategoryErrorMessages.categoryNotFound(id)));

        Optional<Category> categoryOptional = categoryRepository.findByName(request.getName());

        if (categoryOptional.isPresent()) {
            throw new ResourceAlreadyExistsException(CategoryErrorMessages.categoryAlreadyExists(request.getName()));
        }

        category.setName(request.getName());
        category = categoryRepository.save(category);

        return modelMapper.map(category, CategoryResponse.class);
    }

    @Override
    public void deleteById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(CategoryErrorMessages.categoryNotFound(id))
                                                                       );

        Optional<Product> productOptional = productRepository.findDistinctFirstByCategoryId(id);

        if (productOptional.isPresent()) {
            throw new ResourceAlreadyInUseException(CategoryErrorMessages.categoryInUseByProduct(
                    id,
                    productOptional.get().getId()
                                                                                                ));
        }

        categoryRepository.delete(category);
    }
}
