package lab2.pra.adapter;

import lab2.pra.domain.*;
import lab2.pra.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DtoAdapter {
    DtoAdapter MAPPER = Mappers.getMapper(DtoAdapter.class);
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
