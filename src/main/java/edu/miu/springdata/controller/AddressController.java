package edu.miu.springdata.controller;

import edu.miu.springdata.contract.AddressResponse;
import edu.miu.springdata.contract.SaveAddressRequest;
import edu.miu.springdata.service.AddressService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/addresses")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity<Page<AddressResponse>> getAllAddresses(Pageable pageable) {
        return ResponseEntity.ok(addressService.findAll(pageable));
    }

    @ApiResponses(value = {@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "404")})
    @GetMapping("/{address-id}")
    public ResponseEntity<AddressResponse> getAddressById(@PathVariable("address-id") Long addressId) {
        return ResponseEntity.ok(addressService.findById(addressId));
    }

    @ApiResponses(value = {@ApiResponse(responseCode = "201")})
    @PostMapping
    public ResponseEntity<AddressResponse> addAddress(@RequestBody SaveAddressRequest addressRequest) {
        return new ResponseEntity<>(addressService.addAddress(addressRequest), HttpStatus.CREATED);
    }

    @ApiResponses(value = {@ApiResponse(responseCode = "200"), @ApiResponse(responseCode = "404")})
    @PutMapping("/{address-id}")
    public ResponseEntity<AddressResponse> updateAddress(
            @PathVariable("address-id") Long addressId, @RequestBody SaveAddressRequest addressRequest
                                                        ) {
        return new ResponseEntity<>(addressService.updateAddress(addressId, addressRequest), HttpStatus.OK);
    }

    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "204"),
                    @ApiResponse(responseCode = "404"),
                    @ApiResponse(responseCode = "409")
            }
    )
    @DeleteMapping("/{address-id}")
    public ResponseEntity<AddressResponse> deleteAddress(@PathVariable("address-id") Long addressId) {
        addressService.deleteById(addressId);

        return ResponseEntity.noContent().build();
    }
}
