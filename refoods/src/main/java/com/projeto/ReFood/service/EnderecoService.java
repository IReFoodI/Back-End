package com.projeto.ReFood.service;

import com.projeto.ReFood.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.ReFood.dto.EnderecoDTO;
import com.projeto.ReFood.model.Endereco;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnderecoService {
    
    @Autowired
    private EnderecoRepository enderecoRepository;
    
    public List<EnderecoDTO> getAllEnderecos() {
        return enderecoRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public EnderecoDTO getEnderecoById(int idEndereco) {
        Optional<Endereco> endereco = enderecoRepository.findById(idEndereco);
        return endereco.map(this::convertToDTO).orElse(null);
    }
    
    public EnderecoDTO createEndereco(EnderecoDTO enderecoDTO) {
        Endereco endereco = new Endereco();
        
        endereco.setRua(enderecoDTO.getRua());
        endereco.setNumero(enderecoDTO.getNumero());
        endereco.setCidade(enderecoDTO.getCidade());
        enderecoRepository.save(endereco);
        return convertToDTO(endereco);
    }
    
    public EnderecoDTO updateEndereco(int idEndereco, EnderecoDTO enderecoDTO) {
        Optional<Endereco> enderecoOptional = enderecoRepository.findById(idEndereco);
        
        if (enderecoOptional.isPresent()) {
            Endereco endereco = enderecoOptional.get();
            
            endereco.setRua(enderecoDTO.getRua());
            endereco.setNumero(enderecoDTO.getNumero());
            endereco.setCidade(enderecoDTO.getCidade());
            
            enderecoRepository.save(endereco);
            
            return convertToDTO(endereco);
        }
        
        return null;
    }
    
    public void deleteEndereco(int idEndereco) {
        enderecoRepository.deleteById(idEndereco);
    }
    
    private EnderecoDTO convertToDTO(Endereco endereco) {
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        
        enderecoDTO.setIdEndereco(endereco.getIdEndereco());
        enderecoDTO.setRua(endereco.getRua());
        enderecoDTO.setNumero(endereco.getNumero());
        enderecoDTO.setCidade(endereco.getCidade());
        
        return enderecoDTO;
    }
}
