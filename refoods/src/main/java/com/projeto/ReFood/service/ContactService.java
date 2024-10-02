package com.projeto.ReFood.service;

import com.projeto.ReFood.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.ReFood.dto.ContactDTO;
import com.projeto.ReFood.model.Contato;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactService {
    
    @Autowired
    private ContactRepository contactRepository;
    
    public List<ContactDTO> getAllContatos() {
        return contactRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public ContactDTO getContatoById(int idContato) {
        Optional<Contato> contato = contactRepository.findById(idContato);
        return contato.map(this::convertToDTO).orElse(null);
    }
    
    public ContactDTO createContato(ContactDTO contactDTO) {
        Contato contato = new Contato();
        
        contato.setLogin(contactDTO.getLogin());
        contato.setEmail(contactDTO.getEmail());
        contato.setFuncao(contactDTO.getFuncao());
        contactRepository.save(contato);
        return convertToDTO(contato);
    }
    
    public ContactDTO updateContato(int id_contato, ContactDTO contactDTO) {
        Optional<Contato> contatoOptional = contactRepository.findById(id_contato);
        
        if (contatoOptional.isPresent()) {
            Contato contato = contatoOptional.get();
            
            contato.set(contactDTO.getLogin());
            contato.setEmail(contactDTO.getEmail());
            contato.setFuncao(contactDTO.getFuncao());
            
            contactRepository.save(contato);
            
            return convertToDTO(contato);
        }
        
        return null;
    }
    
    public void deleteContato(int id_contato) {
        contactRepository.deleteById(id_contato);
    }
    
    private ContactDTO convertToDTO(Contato contato) {
        ContactDTO contactDTO = new ContactDTO();
        
        contactDTO.setIdContato(contato.getIdContato());
        contactDTO.setLogin(contato.getLogin());
        contactDTO.setEmail(contato.getEmail());
        contactDTO.setFuncao(contato.getFuncao());
        
        return contactDTO;
    }
}
