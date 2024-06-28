package lab2.pra.controller;

import lab2.pra.dto.AddressDto;
import lab2.pra.service.address.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/address")
public class AddressController {
    private final AddressService addressService;
    @GetMapping
    public List<AddressDto> getAll() {
        return addressService.findAll();
    }
    @GetMapping("/{id}")
    public AddressDto getById(@PathVariable Integer id){
        return addressService.findById(id);
    }
    @PostMapping
    public AddressDto save(@RequestBody AddressDto addressDto){
        return addressService.save(addressDto);
    }

    @PutMapping("{/id}")
    public AddressDto update(@PathVariable Integer id, @RequestBody AddressDto addressDto){
        return addressService.update(id, addressDto);
    }
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        return addressService.delete(id);
    }
}
