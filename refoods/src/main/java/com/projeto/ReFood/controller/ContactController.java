package com.projeto.ReFood.controller;

import com.projeto.ReFood.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto.ReFood.dto.ContactDTO;

import java.util.List;

@RestController
@RequestMapping("/api/contacts")
public class ContactController {
    
    @Autowired
    private ContactService contactService;
    
    @GetMapping
    public List<ContactDTO> getAllContacts() {
        return contactService.getAllContacts();
    }
    
    @GetMapping("/{id_contact}")
    public ResponseEntity<ContactDTO> getContactById(@PathVariable int id_contact) {
        ContactDTO contactDTO = contactService.getContactById(id_contact);
        
        return contactDTO != null ? ResponseEntity.ok(contactDTO) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public ContactDTO createContact(@RequestBody ContactDTO contactDTO) {
        return contactService.createContact(contactDTO);
    }
    
    @PutMapping("/{id_contact}")
    public ResponseEntity<ContactDTO> updateContact(@PathVariable int id_contact, @RequestBody ContactDTO contactDTO) {
        ContactDTO updateContact = contactService.updateContact(id_contact, contactDTO);
        
        return updateContact != null ? ResponseEntity.ok(updateContact) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id_contact}")
    public ResponseEntity<Void> deleteContact(@PathVariable int id_contact) {
        contactService.deleteContact(id_contact);
        
        return ResponseEntity.noContent().build();
    }
}
