package com.example.springdata.service;

import com.example.springdata.entity.Product;
import com.example.springdata.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
	private final ProductRepository productRepository;

	public List<Product> getAll() {
		return productRepository.findAll();
	}

	public Product createOne(Product p) {
		return productRepository.save(p);
	}

	public Optional<Product> updateOne(String id, Product product) {
		Product item = productRepository.findById(id).orElse(null);
		if (item == null) {
			return Optional.empty();
		}

		item.setName(product.getName());
		item.setRating(product.getRating());
		item.setPrice(product.getPrice());
		return Optional.of(productRepository.save(item));
	}

	public Optional<Product> deleteById(String id) {
		Product item = productRepository.findById(id).orElse(null);
		if (item == null) {
			return Optional.empty();
		}
		productRepository.deleteById(id);
		return Optional.of(item);
	}

	public List<Product> getProductsByPriceGreaterThan(Double minPrice) {
		return productRepository.getProductsByPriceGreaterThan(minPrice);
	}

	public List<Product> getProductsContainKeyword(String keyword) {
		return productRepository.getProductsByNameContains(keyword);
	}

	public List<Product> getProductsInCategoryAndCostLessThan(String categoryId, Double maxPrice) {
		return productRepository.getProductsByCategoryIdAndPriceLessThan(categoryId, maxPrice);
	}
}
