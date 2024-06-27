package edu.miu.springdata.service;

import edu.miu.springdata.contract.AddressResponse;
import edu.miu.springdata.contract.SaveAddressRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AddressService {
    AddressResponse updateAddress(Long addressId, SaveAddressRequest addressRequest);

    Page<AddressResponse> findAll(Pageable pageable);

    AddressResponse findById(Long addressId);

    void deleteById(Long addressId);

    AddressResponse addAddress(SaveAddressRequest addressRequest);
}
