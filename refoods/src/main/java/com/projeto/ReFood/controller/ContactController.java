package com.projeto.ReFood.controller;

import com.projeto.ReFood.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto.ReFood.dto.ContactDTO;

import java.util.List;

@RestController
@RequestMapping("/api/contatos")
public class ContactController {
    
    @Autowired
    private ContactService contactService;
    
    @GetMapping
    public List<ContactDTO> getAllContatos() {
        return contactService.getAllContatos();
    }
    
    @GetMapping("/{id_contato}")
    public ResponseEntity<ContactDTO> getContatoById(@PathVariable int id_contato) {
        ContactDTO contactDTO = contactService.getContatoById(id_contato);
        
        return contactDTO != null ? ResponseEntity.ok(contactDTO) : ResponseEntity.notFound().build();
    }
    
    @PostMapping
    public ContactDTO createContato(@RequestBody ContactDTO contactDTO) {
        return contactService.createContato(contactDTO);
    }
    
    @PutMapping("/{id_contato}")
    public ResponseEntity<ContactDTO> updateContato(@PathVariable int id_contato, @RequestBody ContactDTO contactDTO) {
        ContactDTO updateContato = contactService.updateContato(id_contato, contactDTO);
        
        return updateContato != null ? ResponseEntity.ok(updateContato) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id_contato}")
    public ResponseEntity<Void> deleteContato(@PathVariable int id_contato) {
        contactService.deleteContato(id_contato);
        
        return ResponseEntity.noContent().build();
    }
}
