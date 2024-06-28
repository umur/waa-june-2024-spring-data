package com.example.lab2.mapper;
import com.example.lab2.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import com.example.lab2.entity.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DtoMapper {
    DtoMapper MAPPER =
            Mappers.getMapper(DtoMapper.class);
    AddressDTO entityToDto(Address address);
    CategoryDTO entityToDto(Category category);
    ProductDTO entityToDto(Product product);
    ReviewDTO entityToDto(Review review);
    UserDTO entityToDto(User user);

    Address dtoToEntity(AddressDTO addressDto);
    Category dtoToEntity(CategoryDTO categoryDto);
    Product dtoToEntity(ProductDTO productDto);
    Review dtoToEntity(ReviewDTO reviewDto);
    User dtoToEntity(UserDTO userDto);
}
