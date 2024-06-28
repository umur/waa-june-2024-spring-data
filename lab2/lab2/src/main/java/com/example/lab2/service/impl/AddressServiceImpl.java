package com.example.lab2.service.impl;

import com.example.lab2.dto.AddressDTO;
import com.example.lab2.entity.Address;
import com.example.lab2.entity.User;
import com.example.lab2.exception.ResourceNotFoundException;
import com.example.lab2.mapper.DtoMapper;
import com.example.lab2.repository.AddressRepository;
import com.example.lab2.service.AddressService;
import com.example.lab2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private  final UserService userService;
    @Override
    public List<AddressDTO> getAll() {
        return addressRepository.findAll()
                .stream().map(DtoMapper.MAPPER::entityToDto).toList();
    }

    @Override
    public AddressDTO getById(Long id) {
        return DtoMapper.MAPPER.entityToDto(getAddressById(id));
    }

    @Override
    public Address getAddressById(Long id) {
        Optional<Address> addressOpt=addressRepository.findById(id);
        if(addressOpt.isEmpty()){
            throw new RuntimeException("No address Found");
        }
        return addressOpt.get();
    }

    @Override
    public AddressDTO createAddress(AddressDTO addressDTO) {
        Address address=DtoMapper.MAPPER.dtoToEntity(addressDTO);
        User user=userService.getUserById(address.getUser().getId());
        address.setUser(user);
        return DtoMapper.MAPPER.entityToDto(addressRepository.save(address));
    }

    @Override
    public AddressDTO updateAddress(Long id, AddressDTO addressDto) {
        Optional<Address> addressOpt=addressRepository.findById(id);
        if(addressOpt.isEmpty()){
            throw new RuntimeException("No address Found");
        }
        User user=userService.getUserById(addressDto.getUser().getId());
        Address savedAddr=addressOpt.get();
        savedAddr.setUser(user);
        savedAddr.setCity(addressDto.getCity());
        savedAddr.setStreet(addressDto.getStreet());
        savedAddr.setZip(addressDto.getZip());
        addressRepository.save(savedAddr);
        return DtoMapper.MAPPER.entityToDto(savedAddr);
    }

    @Override
    public void deleteAddress(Long id) {
        Address address = addressRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Address not found"));
        addressRepository.delete(address);
    }
}

