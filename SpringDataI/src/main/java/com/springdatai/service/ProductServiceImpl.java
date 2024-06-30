package com.springdatai.service;

import com.springdatai.domain.Category;
import com.springdatai.domain.Product;
import com.springdatai.domain.Review;
import com.springdatai.repository.CategoryRepository;
import com.springdatai.repository.ProductRepository;
import com.springdatai.service.DTO.ProductDTO;
import com.springdatai.service.DTO.ReviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ReviewService reviewService;

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        if (productDTO == null) {
            throw new RuntimeException("ProductDTO should not be null");
        }

        Product product = convertToEntity(productDTO);

        // Initialize reviews list if it's null (to handle cases where reviews are not provided)
        if (productDTO.getReviews() != null) {
            List<ReviewDTO> reviewDTOs = productDTO.getReviews();
            for (ReviewDTO reviewDTO : reviewDTOs) {
                Review review = reviewService.convertToEntity(reviewDTO);
                review.setProduct(product); // Set the product for each review
                product.getReviews().add(review); // Add review to product
            }
        }

        // Save the product
        Product savedProduct = productRepository.save(product);

        // Convert saved product back to DTO and return
        return convertToDTO(savedProduct);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<ProductDTO> getProductById(int id) {
        Optional<Product> product = productRepository.findById(id);
        return product.map(this::convertToDTO);
    }

    @Override
    public ProductDTO updateProductById(int id, ProductDTO productDTO) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()) {
            throw new RuntimeException("Product ID: " + id + " is not found");
        }

        Product existingProduct = productOptional.get();
        updateProductFromDTO(existingProduct, productDTO);

        // Save the updated product
        Product updatedProduct = productRepository.save(existingProduct);
        return convertToDTO(updatedProduct);
    }

    @Override
    public void deleteProductById(int id) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()) {
            throw new RuntimeException("Product ID: " + id + " is not found");
        }
        productRepository.deleteById(id);
    }

    @Override
    public List<ProductDTO> findAllByPriceGreaterThan(double minPrice) {
        List<Product> products = productRepository.findAllByPriceGreaterThan(minPrice);
        return products.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findAllByNameAndPriceLessThan(double maxPrice) {
        List<Product> products = productRepository.findAllByCategoryNameAndPriceLessThan("cat",maxPrice);
        return products.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findAllByNameContaining(String keyword) {
        List<Product> products = productRepository.findAllByNameContaining(keyword);
        return products.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private Product convertToEntity(ProductDTO productDTO) {
        Product product = new Product();
        updateProductFromDTO(product, productDTO); // Update product fields from DTO

        // Initialize the reviews list to avoid NullPointerException
        product.setReviews(new ArrayList<>());

        return product;
    }

    private void updateProductFromDTO(Product product, ProductDTO productDTO) {
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setRating(productDTO.getRating());

        // Link to Category if categoryName is provided
        if (productDTO.getCategoryName() != null) {
            Optional<Category> categoryOptional = categoryRepository.findByName(productDTO.getCategoryName());
            if (categoryOptional.isPresent()) {
                product.setCategory(categoryOptional.get());
            } else {
                throw new RuntimeException("Category: " + productDTO.getCategoryName() + " is not found");
            }
        }

        // Initialize the reviews list if it's null
        if (productDTO.getReviews() != null) {
            List<ReviewDTO> reviewDTOs = productDTO.getReviews();
            for (ReviewDTO reviewDTO : reviewDTOs) {
                Review review = reviewService.convertToEntity(reviewDTO);
                review.setProduct(product); // Set the product for each review
                product.getReviews().add(review); // Add review to product
            }
        }
    }

    private ProductDTO convertToDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setRating(product.getRating());

        // Convert reviews to DTOs if needed
        // Assuming ReviewDTO is used to represent reviews
        List<ReviewDTO> reviewDTOs = product.getReviews().stream()
                .map(reviewService::convertToDTO)
                .collect(Collectors.toList());
        productDTO.setReviews(reviewDTOs);

        // Set category name
        if (product.getCategory() != null) {
            productDTO.setCategoryName(product.getCategory().getName());
        }

        return productDTO;
    }
}
