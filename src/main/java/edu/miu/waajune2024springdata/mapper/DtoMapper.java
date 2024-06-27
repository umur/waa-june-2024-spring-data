package edu.miu.waajune2024springdata.mapper;

import edu.miu.waajune2024springdata.dto.*;
import edu.miu.waajune2024springdata.entity.*;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * @author kush
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DtoMapper {
    DtoMapper MAPPER =
            Mappers.getMapper(DtoMapper.class);

    AddressDto entityToDto(Address address);
    CategoryDto entityToDto(Category category);
    ProductDto entityToDto(Product product);
    ReviewDto entityToDto(Review review);
    UserDto entityToDto(User user);

    Address dtoToEntity(AddressDto addressDto);
    Category dtoToEntity(CategoryDto categoryDto);
    Product dtoToEntity(ProductDto productDto);
    Review dtoToEntity(ReviewDto reviewDto);
    User dtoToEntity(UserDto userDto);

}