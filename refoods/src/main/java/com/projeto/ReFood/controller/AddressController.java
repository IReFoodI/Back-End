package com.projeto.ReFood.controller;

import com.projeto.ReFood.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto.ReFood.dto.AddressDTO;

import java.util.List;

@RestController
@RequestMapping("/api/enderecos")
public class AddressController {
    
    @Autowired
    private AddressService addressService;
    
    @GetMapping
    public List<AddressDTO> getAllEnderecos() {
        return addressService.getAllEnderecos();
    }
    
    @GetMapping("/{id_endereco}")
    public ResponseEntity<AddressDTO> getEnderecoById(@PathVariable int id_endereco) {
        AddressDTO addressDTO = addressService.getEnderecoById(id_endereco);
        
        return addressDTO != null ? ResponseEntity.ok(addressDTO) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public AddressDTO createEndereco(@RequestBody AddressDTO addressDTO) {
        return addressService.createEndereco(addressDTO);
    }
    
    @PutMapping("/{id_endereco}")
    public ResponseEntity<AddressDTO> updateEndereco(@PathVariable int id_endereco, @RequestBody AddressDTO addressDTO) {
        AddressDTO updateEndereco = addressService.updateEndereco(id_endereco, addressDTO);
        
        return updateEndereco != null ? ResponseEntity.ok(updateEndereco) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id_endereco}")
    public ResponseEntity<Void> deleteEndereco(@PathVariable int id_endereco) {
        addressService.deleteEndereco(id_endereco);
        
        return ResponseEntity.noContent().build();
    }
}
