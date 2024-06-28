package edu.miu.springdata.controller;

import edu.miu.springdata.contract.ProductResponse;
import edu.miu.springdata.contract.ReviewResponse;
import edu.miu.springdata.contract.SaveProductRequest;
import edu.miu.springdata.contract.SaveProductReviewRequest;
import edu.miu.springdata.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Products", description = "Operations related to products.")
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(description = "Get products in a fixed size.")
    @GetMapping
    public ResponseEntity<Page<ProductResponse>> getAllProducts(Pageable pageable) {
        return ResponseEntity.ok(productService.findAll(pageable));
    }

    @ApiResponses(value = {@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "404")})
    @GetMapping("/{product-id}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("product-id") long productId) {
        return ResponseEntity.ok(productService.findById(productId));
    }

    @ApiResponses(value = {@ApiResponse(responseCode = "201")})
    @PostMapping
    public ResponseEntity<ProductResponse> addProduct(@RequestBody SaveProductRequest saveProductRequest) {
        return new ResponseEntity<>(productService.save(saveProductRequest), HttpStatus.CREATED);
    }

    @ApiResponses(value = {@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "404")})
    @PutMapping("/{product-id}")
    public ResponseEntity<ProductResponse> updateProduct(
            @PathVariable("product-id") Long productId,
            @RequestBody SaveProductRequest saveProductRequest
                                                        ) {
        return ResponseEntity.ok(productService.updateById(productId, saveProductRequest));
    }

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "204"),
                    @ApiResponse(responseCode = "404"),
                    @ApiResponse(responseCode = "409")
            }
    )
    @DeleteMapping("/{product-id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("product-id") Long productId) {
        productService.deleteById(productId);

        return ResponseEntity.noContent().build();
    }

    @ApiResponses(value = {@ApiResponse(responseCode = "204"), @ApiResponse(responseCode = "404")})
    @PutMapping("/{product-id}/categories/{category-id}")
    public ResponseEntity<Void> updateProductCategory(
            @PathVariable("product-id") Long productId,
            @PathVariable("category-id") Long categoryId
                                                     ) {
        productService.updateProductCategoryById(productId, categoryId);

        return ResponseEntity.noContent().build();
    }

    @ApiResponses(value = {@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "404")})
    @GetMapping("/{product-id}/reviews")
    public ResponseEntity<Page<ReviewResponse>> getReviewsOfProduct(
            @PathVariable("product-id") Long productId,
            Pageable pageable
                                                                   ) {
        return ResponseEntity.ok(productService.findAllReviews(productId, pageable));
    }

    @ApiResponses(value = {@ApiResponse(responseCode = "201"), @ApiResponse(responseCode = "404")})
    @PostMapping("/{product-id}/reviews")
    public ResponseEntity<ReviewResponse> addProductReview(
            @PathVariable("product-id") Long productId,
            @RequestBody SaveProductReviewRequest saveProductReviewRequest
                                                          ) {
        return new ResponseEntity<>(
                productService.addProductReview(productId, saveProductReviewRequest), HttpStatus.CREATED);
    }

    @ApiResponses(value = {@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "404")})
    @PutMapping("/{product-id}/reviews/{review-id}")
    public ResponseEntity<ReviewResponse> updateProductReview(
            @PathVariable("product-id") Long productId,
            @PathVariable("review-id") Long reviewId,
            @RequestBody SaveProductReviewRequest saveProductReviewRequest
                                                             ) {
        return ResponseEntity.ok(productService.updateProductReview(productId, reviewId, saveProductReviewRequest));
    }

    @ApiResponses(value = {@ApiResponse(responseCode = "204"), @ApiResponse(responseCode = "404")})
    @DeleteMapping("/{product-id}/reviews/{review-id}")
    public ResponseEntity<Void> deleteProductReview(
            @PathVariable("product-id") Long productId,
            @PathVariable("review-id") Long reviewId
                                                   ) {
        productService.deleteProductReview(productId, reviewId);

        return ResponseEntity.noContent().build();
    }

}
