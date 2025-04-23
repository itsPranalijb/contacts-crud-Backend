package com.crm.crm.model;

import java.net.URISyntaxException;
import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
class ContactsController {
    private final ContactRepository contactRepository;

    public ContactsController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    // Get all contacts
    @GetMapping("/contacts")
    Collection<Contact> contacts() {
        return (Collection<Contact>) contactRepository.findAll();
    }

    // Create a new contact
    @PostMapping("/contacts")
    ResponseEntity<Contact> createContact(@Valid @RequestBody Contact contact) throws URISyntaxException {
        Contact result = contactRepository.save(contact);
        return ResponseEntity.ok().body(result);
    }

    // Delete a contact by ID
    @DeleteMapping("/contacts/{id}")
    ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        // Check if the contact exists
        if (!contactRepository.existsById(id)) {
            return ResponseEntity.notFound().build(); // Return 404 if not found
        }

        // Delete the contact
        contactRepository.deleteById(id);
        return ResponseEntity.noContent().build(); // Return 204 No Content after deletion
    }
}
