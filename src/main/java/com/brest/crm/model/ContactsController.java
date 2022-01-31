package com.brest.crm.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class ContactsController {

    private ContactRepo contactRepo;

    public ContactsController(ContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    @GetMapping("/contacts")
    Collection<Contact> contacts() {
        return (Collection<Contact>) contactRepo.findAll();
    }

    @PostMapping("/contacts")
    ResponseEntity<Contact> createContact(@Validated @RequestBody Contact contact) {
        Contact result = contactRepo.save(contact);
        return ResponseEntity.ok().body(result);
    }
}
