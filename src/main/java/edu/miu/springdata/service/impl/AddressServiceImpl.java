package edu.miu.springdata.service.impl;

import edu.miu.springdata.contract.AddressResponse;
import edu.miu.springdata.contract.SaveAddressRequest;
import edu.miu.springdata.domain.Address;
import edu.miu.springdata.exception.ResourceNotFoundException;
import edu.miu.springdata.repository.AddressRepository;
import edu.miu.springdata.service.AddressService;
import edu.miu.springdata.util.AddressErrorMessages;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final ModelMapper modelMapper;

    public AddressServiceImpl(AddressRepository addressRepository, ModelMapper modelMapper) {
        this.addressRepository = addressRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public AddressResponse updateAddress(Long addressId, SaveAddressRequest addressRequest) {
        Address currentAddress = addressRepository.findById(addressId).orElseThrow(
                () -> new ResourceNotFoundException(AddressErrorMessages.addressNotFound(addressId))
        );

        modelMapper.map(addressRequest, currentAddress);
        addressRepository.save(currentAddress);

        return modelMapper.map(currentAddress, AddressResponse.class);
    }
}
