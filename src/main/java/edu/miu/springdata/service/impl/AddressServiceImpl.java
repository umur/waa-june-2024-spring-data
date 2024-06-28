package edu.miu.springdata.service.impl;

import edu.miu.springdata.contract.AddressResponse;
import edu.miu.springdata.contract.SaveAddressRequest;
import edu.miu.springdata.domain.Address;
import edu.miu.springdata.domain.User;
import edu.miu.springdata.exception.ResourceAlreadyInUseException;
import edu.miu.springdata.exception.ResourceNotFoundException;
import edu.miu.springdata.repository.AddressRepository;
import edu.miu.springdata.repository.UserRepository;
import edu.miu.springdata.service.AddressService;
import edu.miu.springdata.util.AddressErrorMessages;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final ModelMapper       modelMapper;
    private final UserRepository    userRepository;

    public AddressServiceImpl(
            AddressRepository addressRepository, ModelMapper modelMapper,
            UserRepository userRepository
                             ) {
        this.addressRepository = addressRepository;
        this.modelMapper       = modelMapper;
        this.userRepository    = userRepository;
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

    @Override
    public Page<AddressResponse> findAll(Pageable pageable) {
        return addressRepository.findAll(pageable).map(address -> modelMapper.map(address, AddressResponse.class));
    }

    @Override
    public AddressResponse findById(Long addressId) {
        Address currentAddress = addressRepository.findById(addressId).orElseThrow(
                () -> new ResourceNotFoundException(AddressErrorMessages.addressNotFound(addressId))
                                                                                  );

        return modelMapper.map(currentAddress, AddressResponse.class);
    }

    @Override
    public void deleteById(Long addressId) {
        Address currentAddress = addressRepository.findById(addressId).orElseThrow(
                () -> new ResourceNotFoundException(AddressErrorMessages.addressNotFound(addressId))
                                                                                  );

        Optional<User> user = userRepository.findFirstByAddressId(addressId);

        if (user.isPresent()) {
            throw new ResourceAlreadyInUseException(
                    AddressErrorMessages.addressAlreadyInUse(user.get().getId(), addressId)
            );
        }

        addressRepository.delete(currentAddress);
    }

    @Override
    public AddressResponse addAddress(SaveAddressRequest addressRequest) {
        Address address = modelMapper.map(addressRequest, Address.class);

        address = addressRepository.save(address);

        return modelMapper.map(address, AddressResponse.class);
    }
}
