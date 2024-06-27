package com.example.springdata.controller;

import com.example.springdata.entity.Address;
import com.example.springdata.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {
	private final AddressService addressService;

	@GetMapping
	public ResponseEntity<List<Address>> getAll() {
		return ResponseEntity.ok().body(addressService.getAll());
	}

	@PutMapping("")
	public ResponseEntity<Address> updateUserAddress(@RequestBody Address address) {
		Address item = addressService.update(address);
		return ResponseEntity.ok().body(item);
	}
}
