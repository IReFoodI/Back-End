package com.projeto.ReFood.service;

import com.projeto.ReFood.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.ReFood.dto.ContactDTO;
import com.projeto.ReFood.model.Contact;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactService {
    
    @Autowired
    private ContactRepository contactRepository;
    
    public List<ContactDTO> getAllContacts() {
        return contactRepository
                .findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    public ContactDTO getContactById(int idContact) {
        Optional<Contact> contact = contactRepository.findById(idContact);
        return contact.map(this::convertToDTO).orElse(null);
    }
    
    public ContactDTO createContact(ContactDTO contactDTO) {
        Contact contact = new Contact();
        
        contact.setId_contact(contactDTO.getId_contact());
        contact.setDescription(contactDTO.getDescription());
        contact.setPhone(contactDTO.getPhone());
        contactRepository.save(contact);
        return convertToDTO(contact);
    }
    
    public ContactDTO updateContact(int id_contact, ContactDTO contactDTO) {
        Optional<Contact> contactOptional = contactRepository.findById(id_contact);
        
        if (contactOptional.isPresent()) {
            Contact contact = contactOptional.get();
            
            contact.setId_contact(contactDTO.getId_contact());
            contact.setDescription(contactDTO.getDescription());
            contact.setPhone(contactDTO.getPhone());
            
            contactRepository.save(contact);
            
            return convertToDTO(contact);
        }
        
        return null;
    }
    
    public void deleteContact(int id_contact) {
        contactRepository.deleteById(id_contact);
    }
    
    private ContactDTO convertToDTO(Contact contact) {
        ContactDTO contactDTO = new ContactDTO();
        
        contactDTO.setId_contact(contact.getId_contact());
        contactDTO.setDescription(contact.getDescription());
        contactDTO.setPhone(contact.getPhone());
        
        return contactDTO;
    }
}
