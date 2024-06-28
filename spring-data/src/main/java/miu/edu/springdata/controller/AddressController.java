package miu.edu.springdata.controller;

import lombok.RequiredArgsConstructor;
import miu.edu.springdata.domain.Address;
import miu.edu.springdata.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService service;

    @GetMapping
    public ResponseEntity<?> getAddresses(int id){
        return ResponseEntity.ok(service.findAddressById(id));
    }

    @PostMapping
    public void addAddress(Address address){
        service.saveAddress(address);
    }

    @PutMapping
    public ResponseEntity<?> updateAddress(int id,Address address){
        return ResponseEntity.ok(service.updateAddress(id, address));
    }
    @DeleteMapping
    public void deleteAddress(int id){
        service.deleteAddress(id);
    }
}
