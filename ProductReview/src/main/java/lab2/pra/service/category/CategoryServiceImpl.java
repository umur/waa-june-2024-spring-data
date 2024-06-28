package lab2.pra.service.category;

import lab2.pra.adapter.DtoAdapter;
import lab2.pra.domain.Category;
import lab2.pra.dto.CategoryDto;
import lab2.pra.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;
    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(DtoAdapter.MAPPER::entityToDto)
                .toList();
    }

    @Override
    public CategoryDto findById(Integer id) {
        return DtoAdapter.MAPPER.entityToDto(findCategoryById(id));
    }

    @Override
    public Category findCategoryById(Integer id) {
        Optional<Category> byId = categoryRepository.findById(id);
        if(byId.isEmpty()){
            throw new RuntimeException("No category found");
        }
        return byId.get();
    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        Category category = DtoAdapter.MAPPER.dtoToEntity(categoryDto);
        categoryRepository.save(category);
        return DtoAdapter.MAPPER.entityToDto(category);
    }

    @Override
    public CategoryDto update(Integer id, CategoryDto categoryDto) {
        Category categoryById = findCategoryById(id);
        categoryById.setName(categoryDto.getName());
        categoryRepository.save(categoryById);
        return DtoAdapter.MAPPER.entityToDto(categoryById);
    }

    @Override
    public boolean delete(Integer id) {
        Category categoryById = findCategoryById(id);
        categoryRepository.delete(categoryById);
        return false;
    }
}
