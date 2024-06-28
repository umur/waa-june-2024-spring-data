package lab2.pra.service.address;

import lab2.pra.adapter.DtoAdapter;
import lab2.pra.domain.Address;
import lab2.pra.domain.User;
import lab2.pra.dto.AddressDto;
import lab2.pra.repository.AddressRepository;
import lab2.pra.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final UserService userService;

    @Override
    public List<AddressDto> findAll() {
        return addressRepository.findAll()
                .stream()
                .map(DtoAdapter.MAPPER::entityToDto)
                .toList();
    }

    @Override
    public AddressDto save(AddressDto addressDto) {
        Address address = DtoAdapter.MAPPER.dtoToEntity(addressDto);
        User user = userService.findUserById(address.getUser().getId());
        address.setUser(user);
        return DtoAdapter.MAPPER.entityToDto(addressRepository.save(address));
    }

    @Override
    public AddressDto update(Integer id, AddressDto addressDto) {
        Optional<Address> addressOpt = addressRepository.findById(id);
        if (addressOpt.isEmpty()) {
            throw new RuntimeException("No address Found");
        }
        User user = userService.findUserById(addressDto.getUser().getId());
        Address newAddress = getAddress(addressDto, addressOpt, user);
        addressRepository.save(newAddress);
        return DtoAdapter.MAPPER.entityToDto(newAddress);
    }

    private static Address getAddress(AddressDto addressDto, Optional<Address> addressOpt, User user) {
        Address newAddress = addressOpt.get();
        newAddress.setUser(user);
        newAddress.setCity(addressDto.getCity());
        newAddress.setStreet(addressDto.getStreet());
        newAddress.setZip(addressDto.getZip());
        return newAddress;
    }

    @Override
    public boolean delete(Integer id) {
        Optional<Address> addressOpt = addressRepository.findById(id);
        addressOpt.ifPresentOrElse(
                (address) -> addressRepository.delete(address),
                () -> {
                    throw new RuntimeException("No address Found");
                }
        );
        return true;
    }

    @Override
    public AddressDto findById(Integer id) {
        Optional<Address> addresOpt = addressRepository.findById(id);
        if (addresOpt.isEmpty()) {
            throw new RuntimeException("No address found");
        }
        return DtoAdapter.MAPPER.entityToDto(addresOpt.get());
    }

    @Override
    public Address findAddressById(Integer id) {
        Optional<Address> addresOpt = addressRepository.findById(id);
        if (addresOpt.isEmpty()) {
            throw new RuntimeException("No address found");
        }
        return addresOpt.get();
    }
}
