package miu.waa.lab3.controller;

import lombok.RequiredArgsConstructor;
import miu.waa.lab3.entity.Address;
import miu.waa.lab3.service.impl.AddressServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/addresses")
public class AddressController {
    private final AddressServiceImpl addressService;

    @GetMapping
    public List<Address> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAddressById(@PathVariable Long id) {
        Address address = addressService.getAddressById(id);
        if(address == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Address not found!");
        return ResponseEntity.ok().body(address);
    }

    @PostMapping
    public Address createAddress(@RequestBody Address address) {
        return addressService.createAddress(address);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateAddress(@PathVariable Long id, @RequestBody Address address) {
        Address updatedAddress = addressService.updateAddress(id, address);
        if (updatedAddress == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot update address!");
        }
        return ResponseEntity.ok(updatedAddress);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Long id) {
        addressService.deleteAddressById(id);
    }
}
