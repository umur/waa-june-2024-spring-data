package com.example.springdata.service;

import com.example.springdata.entity.Category;
import com.example.springdata.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
	private final CategoryRepository categoryRepository;

	public List<Category> getAll() {
		return categoryRepository.findAll();
	}

	public Category createOne(Category c) {
		return categoryRepository.save(c);
	}

	public Optional<Category> updateOne(String id, Category c) {
		Category item = categoryRepository.findById(id).orElse(null);
		if (item == null) return Optional.empty();
		item.setName(c.getName());
		return Optional.of(categoryRepository.save(c));
	}

	public Optional<Category> findById(String id) {
		return categoryRepository.findById(id);
	}

	public Optional<Category> deleteById(String id) {
		Category item = categoryRepository.findById(id).orElse(null);
		if (item == null) {
			return Optional.empty();
		}
		categoryRepository.deleteById(id);
		return Optional.of(item);
	}
}
