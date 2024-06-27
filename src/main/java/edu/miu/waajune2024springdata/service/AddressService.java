package edu.miu.waajune2024springdata.service;

import edu.miu.waajune2024springdata.dto.AddressDto;
import edu.miu.waajune2024springdata.entity.Address;

import java.util.List;

/**
 * @author kush
 */
public interface AddressService {
    List<AddressDto> getAll();

    AddressDto getById(Long id);

    Address getAddressById(Long id);

    AddressDto save(AddressDto address);

    AddressDto update(Long id, AddressDto address);

    boolean delete(Long id);
}
