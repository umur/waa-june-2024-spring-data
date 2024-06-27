package edu.miu.springdata.service;

import edu.miu.springdata.contract.AddressResponse;
import edu.miu.springdata.contract.SaveAddressRequest;

public interface AddressService {
    AddressResponse updateAddress(Long addressId, SaveAddressRequest addressRequest);
}
