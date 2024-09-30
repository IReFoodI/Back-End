package com.projeto.ReFood.service;

import com.projeto.ReFood.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.ReFood.dto.ContatoDTO;
import com.projeto.ReFood.model.Contato;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContatoService {
    
    @Autowired
    private ContatoRepository contatoRepository;
    
    public List<ContatoDTO> getAllContatos() {
        return contatoRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public ContatoDTO getContatoById(int idContato) {
        Optional<Contato> contato = contatoRepository.findById(idContato);
        return contato.map(this::convertToDTO).orElse(null);
    }
    
    public ContatoDTO createContato(ContatoDTO contatoDTO) {
        Contato contato = new Contato();
        
        contato.setLogin(contatoDTO.getLogin());
        contato.setEmail(contatoDTO.getEmail());
        contato.setFuncao(contatoDTO.getFuncao());
        contatoRepository.save(contato);
        return convertToDTO(contato);
    }
    
    public ContatoDTO updateContato(int idContato, ContatoDTO contatoDTO) {
        Optional<Contato> contatoOptional = contatoRepository.findById(idContato);
        
        if (contatoOptional.isPresent()) {
            Contato contato = contatoOptional.get();
            
            contato.setLogin(contatoDTO.getLogin());
            contato.setEmail(contatoDTO.getEmail());
            contato.setFuncao(contatoDTO.getFuncao());
            
            contatoRepository.save(contato);
            
            return convertToDTO(contato);
        }
        
        return null;
    }
    
    public void deleteContato(int idContato) {
        contatoRepository.deleteById(idContato);
    }
    
    private ContatoDTO convertToDTO(Contato contato) {
        ContatoDTO contatoDTO = new ContatoDTO();
        
        contatoDTO.setIdContato(contato.getIdContato());
        contatoDTO.setLogin(contato.getLogin());
        contatoDTO.setEmail(contato.getEmail());
        contatoDTO.setFuncao(contato.getFuncao());
        
        return contatoDTO;
    }
}
