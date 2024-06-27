package edu.miu.waajune2024springdata.service.impl;

import edu.miu.waajune2024springdata.dto.AddressDto;
import edu.miu.waajune2024springdata.entity.Address;
import edu.miu.waajune2024springdata.entity.User;
import edu.miu.waajune2024springdata.mapper.DtoMapper;
import edu.miu.waajune2024springdata.repository.AddressRepository;
import edu.miu.waajune2024springdata.service.AddressService;
import edu.miu.waajune2024springdata.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author kush
 */
@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository repo;
    private final UserService userService;
    @Override
    public List<AddressDto> getAll() {
        return repo.findAll()
                .stream().map(DtoMapper.MAPPER::entityToDto).toList();
    }

    @Override
    public AddressDto getById(Long id) {
        return DtoMapper.MAPPER.entityToDto(getAddressById(id));
    }
    @Override
    public Address getAddressById(Long id) {
        Optional<Address> addressOpt=repo.findById(id);
        if(addressOpt.isEmpty()){
            throw new RuntimeException("No address Found");
        }
        return addressOpt.get();
    }

    @Override
    public AddressDto save(AddressDto addressDto) {
        Address address=DtoMapper.MAPPER.dtoToEntity(addressDto);
        User user=userService.getUserById(address.getUser().getId());
        address.setUser(user);
        return DtoMapper.MAPPER.entityToDto(repo.save(address));
    }

    @Override
    public AddressDto update(Long id, AddressDto addressDto) {
        Optional<Address> addressOpt=repo.findById(id);
        if(addressOpt.isEmpty()){
            throw new RuntimeException("No address Found");
        }
        User user=userService.getUserById(addressDto.getUser().getId());
        Address savedAddr=addressOpt.get();
        savedAddr.setUser(user);
        savedAddr.setCity(addressDto.getCity());
        savedAddr.setStreet(addressDto.getStreet());
        savedAddr.setZip(addressDto.getZip());
        repo.save(savedAddr);
        return DtoMapper.MAPPER.entityToDto(savedAddr);
    }

    @Override
    public boolean delete(Long id) {
        Optional<Address> addressOpt=repo.findById(id);
        if(addressOpt.isEmpty()){
            throw new RuntimeException("No address Found");
        }
        repo.delete(addressOpt.get());
        return true;
    }
}
