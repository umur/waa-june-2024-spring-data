package com.example.lab2.service.impl;

import com.example.lab2.dto.CategoryDTO;
import com.example.lab2.entity.Category;
import com.example.lab2.mapper.DtoMapper;
import com.example.lab2.repository.CategoryRepository;
import com.example.lab2.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repo;
    @Override
    public List<CategoryDTO> getAll() {
        return repo.findAll().stream().map(DtoMapper.MAPPER::entityToDto).toList();
    }

    @Override
    public CategoryDTO getById(Long id) {
        return DtoMapper.MAPPER.entityToDto(getCategoryById(id));
    }

    @Override
    public Category getCategoryById(Long id) {
        Optional<Category> categoryOpt=repo.findById(id);
        if(categoryOpt.isEmpty()){
            throw new RuntimeException("No category Found");
        }
        return categoryOpt.get();
    }

    @Override
    public CategoryDTO save(CategoryDTO categoryDto) {
        Category category=DtoMapper.MAPPER.dtoToEntity(categoryDto);
        repo.save(category);
        return DtoMapper.MAPPER.entityToDto(category);
    }

    @Override
    public CategoryDTO update(Long id, CategoryDTO categoryDto) {
        Optional<Category> categoryOpt=repo.findById(id);
        if(categoryOpt.isEmpty()){
            throw new RuntimeException("No category Found");
        }
        Category savedCategory=categoryOpt.get();
        savedCategory.setName(categoryDto.getName());
        repo.save(savedCategory);
        return DtoMapper.MAPPER.entityToDto(savedCategory);
    }

    @Override
    public boolean delete(Long id) {
        Optional<Category> categoryOpt=repo.findById(id);
        if(categoryOpt.isEmpty()){
            throw new RuntimeException("No category Found");
        }
        repo.delete(categoryOpt.get());
        return true;
    }
}
