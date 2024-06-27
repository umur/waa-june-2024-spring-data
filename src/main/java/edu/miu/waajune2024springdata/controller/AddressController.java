package edu.miu.waajune2024springdata.controller;

import edu.miu.waajune2024springdata.dto.AddressDto;
import edu.miu.waajune2024springdata.entity.Address;
import edu.miu.waajune2024springdata.entity.Address;
import edu.miu.waajune2024springdata.service.AddressService;
import edu.miu.waajune2024springdata.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author kush
 */

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService service;

    @GetMapping
    public List<AddressDto> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public AddressDto getById(@PathVariable Long id){
        return service.getById(id);
    }

    @PostMapping
    public AddressDto save(@RequestBody AddressDto address){
        return service.save(address);
    }

    @PutMapping("/{id}")
    public AddressDto update(@RequestBody AddressDto address,@PathVariable Long id){
        return service.update(id,address);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id){
        return service.delete(id);
    }
}


