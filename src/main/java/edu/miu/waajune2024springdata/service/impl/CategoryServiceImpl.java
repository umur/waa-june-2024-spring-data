package edu.miu.waajune2024springdata.service.impl;

import edu.miu.waajune2024springdata.dto.CategoryDto;
import edu.miu.waajune2024springdata.entity.Category;
import edu.miu.waajune2024springdata.mapper.DtoMapper;
import edu.miu.waajune2024springdata.repository.CategoryRepository;
import edu.miu.waajune2024springdata.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author kush
 */
@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repo;
    @Override
    public List<CategoryDto> getAll() {
        return repo.findAll().stream().map(DtoMapper.MAPPER::entityToDto).toList();
    }

    @Override
    public CategoryDto getById(Long id) {
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
    public CategoryDto save(CategoryDto categoryDto) {
        Category category=DtoMapper.MAPPER.dtoToEntity(categoryDto);
        repo.save(category);
        return DtoMapper.MAPPER.entityToDto(category);
    }

    @Override
    public CategoryDto update(Long id, CategoryDto categoryDto) {
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
