package miu.waa.spring_demo.controller;

import lombok.RequiredArgsConstructor;
import miu.waa.spring_demo.entity.Address;
import miu.waa.spring_demo.service.AddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;

    @GetMapping
    public List<Address> getAll() { return addressService.getAll(); }

    @GetMapping("/{id}")
    public Address getById(@PathVariable int id) {
        return addressService.getById(id);
    }

    @PutMapping
    public Address update(@RequestBody Address address) {
        return addressService.update(address);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        addressService.deleteById(id);
    }
}
