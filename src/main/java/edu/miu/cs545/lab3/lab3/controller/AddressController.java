package edu.miu.cs545.lab3.lab3.controller;

import edu.miu.cs545.lab3.lab3.entity.Address;
import edu.miu.cs545.lab3.lab3.service.AddressService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/addresses")
@Tag(name = "Address", description = "Address API")
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/")
    public List<Address> getAllAddresses() {
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public Address findById(@PathVariable Long id) {
        return addressService.findById(id).orElse(null);
    }

    @PostMapping("/")
    public void save(Address address) {
        addressService.save(address);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        addressService.delete(id);
    }

    @PutMapping("/")
    public void update(@RequestBody Address address) {
        addressService.update(address);
    }
}
