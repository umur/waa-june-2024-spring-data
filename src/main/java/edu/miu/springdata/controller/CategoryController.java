package edu.miu.springdata.controller;

import edu.miu.springdata.contract.CategoryResponse;
import edu.miu.springdata.contract.SaveCategoryRequest;
import edu.miu.springdata.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Product Categories", description = "Product Categories can be managed here.")
@RestController
@RequestMapping("/product-categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Operation(description = "Get all reviews in a manageable way.")
    @GetMapping
    public ResponseEntity<Page<CategoryResponse>> getAllCategories(Pageable pageable) {
        return ResponseEntity.ok(categoryService.findAll(pageable));
    }

    @Operation(description = "Get category by id.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "404")})
    @GetMapping("/{category-id}")
    public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable("category-id") Long id) {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @Operation(description = "Add a category.")
    @ApiResponses(value = {@ApiResponse(responseCode = "201"), @ApiResponse(responseCode = "404")})
    @PostMapping
    public ResponseEntity<CategoryResponse> addCategory(@RequestBody SaveCategoryRequest request) {
        return new ResponseEntity<>(categoryService.save(request), HttpStatus.CREATED);
    }

    @Operation(description = "Update category by id.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "404")})
    @PutMapping("/{category-id}")
    public ResponseEntity<CategoryResponse> updateCategory(
            @PathVariable("category-id") Long id,
            @RequestBody SaveCategoryRequest request
                                                          ) {
        return ResponseEntity.ok(categoryService.updateCategory(id, request));
    }

    @Operation(description = "Delete category by id.")
    @ApiResponses(value = {@ApiResponse(responseCode = "204"), @ApiResponse(responseCode = "404")})
    @DeleteMapping("/{category-id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("category-id") Long id) {
        categoryService.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
