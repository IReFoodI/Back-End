package com.projeto.ReFood.service;

import com.projeto.ReFood.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.ReFood.dto.AddressDTO;
import com.projeto.ReFood.model.Endereco;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressService {
    
    @Autowired
    private AddressRepository addressRepository;
    
    public List<AddressDTO> getAllEnderecos() {
        return addressRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public AddressDTO getEnderecoById(int idEndereco) {
        Optional<Endereco> endereco = addressRepository.findById(idEndereco);
        return endereco.map(this::convertToDTO).orElse(null);
    }
    
    public AddressDTO createEndereco(AddressDTO addressDTO) {
        Endereco endereco = new Endereco();
        
        endereco.setRua(addressDTO.getRua());
        endereco.setNumero(addressDTO.getNumero());
        endereco.setCidade(addressDTO.getCidade());
        addressRepository.save(endereco);
        return convertToDTO(endereco);
    }
    
    public AddressDTO updateEndereco(int idEndereco, AddressDTO addressDTO) {
        Optional<Endereco> enderecoOptional = addressRepository.findById(idEndereco);
        
        if (enderecoOptional.isPresent()) {
            Endereco endereco = enderecoOptional.get();
            
            endereco.setRua(addressDTO.getRua());
            endereco.setNumero(addressDTO.getNumero());
            endereco.setCidade(addressDTO.getCidade());
            
            addressRepository.save(endereco);
            
            return convertToDTO(endereco);
        }
        
        return null;
    }
    
    public void deleteEndereco(int idEndereco) {
        addressRepository.deleteById(idEndereco);
    }
    
    private AddressDTO convertToDTO(Endereco endereco) {
        AddressDTO addressDTO = new AddressDTO();
        
        addressDTO.setIdEndereco(endereco.getIdEndereco());
        addressDTO.setRua(endereco.getRua());
        addressDTO.setNumero(endereco.getNumero());
        addressDTO.setCidade(endereco.getCidade());
        
        return addressDTO;
    }
}
