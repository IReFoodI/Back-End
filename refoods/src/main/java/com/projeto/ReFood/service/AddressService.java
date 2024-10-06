package com.projeto.ReFood.service;

import com.projeto.ReFood.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.ReFood.dto.AddressDTO;
import com.projeto.ReFood.model.Address;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressService {
    
    @Autowired
    private AddressRepository addressRepository;
    
    public List<AddressDTO> getAllAddresss() {
        return addressRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public AddressDTO getEddressById(int idAddress) {
        Optional<Address> address = addressRepository.findById(idAddress);
        return address.map(this::convertToDTO).orElse(null);
    }
    
    public AddressDTO createAddress(AddressDTO addressDTO) {
        Address address = new Address();
        
        address.setStreet(addressDTO.getStreet());
        address.setNumber(addressDTO.getNumber());
        address.setDistrict(addressDTO.getDistrict());
        addressRepository.save(address);
        return convertToDTO(address);
    }
    
    public AddressDTO updateEddress(int idEddress, AddressDTO addressDTO) {
        Optional<Address> eddressOptional = addressRepository.findById(idEddress);
        
        if (eddressOptional.isPresent()) {
            Address address = eddressOptional.get();
            
            address.setStreet(addressDTO.getStreet());
            address.setNumber(addressDTO.getNumber());
            address.setDistrict(addressDTO.getDistrict());
            
            addressRepository.save(address);
            
            return convertToDTO(address);
        }
        
        return null;
    }
    
    public void deleteAddress(int idAddress) {
        addressRepository.deleteById(idAddress);
    }
    
    private AddressDTO convertToDTO(Address address) {
        AddressDTO addressDTO = new AddressDTO();
        
        addressDTO.setId_address(address.getId_address());
        addressDTO.setStreet(address.getStreet());
        addressDTO.setNumber(address.getNumber());
        addressDTO.setDistrict(address.getDistrict());
        
        return addressDTO;
    }
}
