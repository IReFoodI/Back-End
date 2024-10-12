package com.projeto.ReFood.controller;

import com.projeto.ReFood.service.ContactService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.projeto.ReFood.dto.ContactDTO;
import com.projeto.ReFood.exception.NotFoundException;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    public ResponseEntity<List<ContactDTO>> listAllContacts() {
        List<ContactDTO> contacts = contactService.getAllContacts();
        return ResponseEntity.ok(contacts);
    }

    @GetMapping("/{contactId}")
    public ResponseEntity<ContactDTO> getContactById(@PathVariable Long contactId) throws NotFoundException {
        ContactDTO contactDTO = contactService.getContactById(contactId);
        return ResponseEntity.ok(contactDTO);
    }

    @PostMapping
    public ResponseEntity<ContactDTO> createContact(@Valid @RequestBody ContactDTO contactDTO) {
        ContactDTO createdContact = contactService.createContact(contactDTO);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{contactId}")
                .buildAndExpand(createdContact.contactId())
                .toUri();
        return ResponseEntity.created(location).body(createdContact);
    }

    @PutMapping("/{contactId}")
    public ResponseEntity<ContactDTO> updateContact(@PathVariable Long contactId, @Valid @RequestBody ContactDTO contactDTO)
            throws NotFoundException {
        ContactDTO updatedContact = contactService.updateContact(contactId, contactDTO);
        return ResponseEntity.ok(updatedContact);
    }

    @DeleteMapping("/{contactId}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long contactId) throws NotFoundException {
        contactService.deleteContact(contactId);
        return ResponseEntity.noContent().build();
    }
}