package com.projeto.ReFood.controller;

import com.projeto.ReFood.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto.ReFood.dto.AddressDTO;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {
    
    @Autowired
    private AddressService addressService;
    
    @GetMapping
    public List<AddressDTO> getAllAddress() {
        return addressService.getAllAddress();
    }
    
    @GetMapping("/{id_address}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable int id_address) {
        AddressDTO addressDTO = addressService.getAddressById(id_address);
        
        return addressDTO != null ? ResponseEntity.ok(addressDTO) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public AddressDTO createAddress(@RequestBody AddressDTO addressDTO) {
        return addressService.createAddress(addressDTO);
    }
    
    @PutMapping("/{id_address}")
    public ResponseEntity<AddressDTO> updateAddress(@PathVariable int id_address, @RequestBody AddressDTO addressDTO) {
        AddressDTO updateAddress = addressService.updateAddress(id_address, addressDTO);
        
        return updateAddress != null ? ResponseEntity.ok(updateAddress) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id_address}")
    public ResponseEntity<Void> deleteAddress(@PathVariable int id_address) {
        addressService.deleteAddress(id_address);
        
        return ResponseEntity.noContent().build();
    }
}
