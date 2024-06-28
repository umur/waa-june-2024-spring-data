package lab2.pra.service.address;

import lab2.pra.domain.Address;
import lab2.pra.dto.AddressDto;

import java.util.List;

public interface AddressService {
    List<AddressDto> findAll();

    AddressDto save(AddressDto address);

    AddressDto update(Integer id, AddressDto address);

    boolean delete(Integer id);

    AddressDto findById(Integer id);

    Address findAddressById(Integer id);
}
