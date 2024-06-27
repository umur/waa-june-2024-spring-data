package waa.springdata.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import waa.springdata.entity.Address;
import waa.springdata.service.AddressService;

import java.util.List;

@RestController
@RequestMapping("/addresses")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService addressService;
    @GetMapping
    public List<Address> getAllCategory(){
        return addressService.findAll();
    }

    @GetMapping("/{id}")
    public Address getById(@PathVariable int id){
        return addressService.findById(id);
    }

    @PostMapping
    public Address save(@RequestBody Address address){
        return addressService.save(address);
    }

    @PutMapping("/{id}")
    public Address updateById(@PathVariable int id,@RequestBody Address address){
        return addressService.update(id,address);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id){
        addressService.deleteById(id);
    }
}
