package com.springdatai.controller;

import com.springdatai.domain.Address;
import com.springdatai.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping
    private List<Address> getAllAddresses(){
        return addressService.getAllAddress();
    }

    @GetMapping("/{id}")
    private Optional<Address> getAddressById(@PathVariable int id){
        return addressService.getAddressById(id);
    }

    @PostMapping
    private Address createAddress(@RequestBody Address address){
        return addressService.createAddress(address);
    }

    @PutMapping("/{id}")
    private Address updateAddressById(@PathVariable int id, @RequestBody Address address){
        return addressService.updateAddressById(id,address);
    }

    @DeleteMapping("/{id}")
    private void deleteAddressById(@PathVariable int id){
        addressService.deleteAddressById(id);
    }
}
