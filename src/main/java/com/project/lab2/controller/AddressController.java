package com.project.lab2.controller;

import com.project.lab2.entity.Address;
import com.project.lab2.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping
    public List<Address> getAddresses() {
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Address> getAddressById(@PathVariable Long id) {
        return addressService.findByAddressId(id);
    }

    @PostMapping
    public Address  addAddress(@RequestBody Address address) {
        return addressService.save(address);
    }

    @DeleteMapping("/{id}")
    public void  deleteAddress(@PathVariable Long id) {
        addressService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Address updateAddress(@PathVariable Long id, @RequestBody Address address) {
            return addressService.update(address, id);

    }
}
