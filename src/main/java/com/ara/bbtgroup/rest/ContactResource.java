package com.ara.bbtgroup.rest;

import com.ara.bbtgroup.model.Contact;
import com.ara.bbtgroup.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/contacts")
public class ContactResource {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Autowired
    private ContactRepository contactRepository;

    // ======================================
    // =             GET METHOD             =
    // ======================================

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody List<Contact> getAllContacts() {

        return (List<Contact>) contactRepository.findAll();
    }

    @GetMapping(path = "/{header}")
    public ResponseEntity<Contact> getContactByHeader(@PathVariable String header) {
        return new ResponseEntity<>(contactRepository.findByHeader(header), HttpStatus.OK);
    }

    // ======================================
    // =             POST METHOD            =
    // ======================================

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Contact> createContact(@RequestBody Contact contactRequest){

        contactRepository.save(contactRequest);
        return new ResponseEntity<Contact>(contactRequest, HttpStatus.CREATED);
    }

    // ======================================
    // =             PUT METHOD             =
    // ======================================

    @RequestMapping(path = "", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Contact> updateContact(@RequestBody Contact contactRequest) {
        contactRepository.save(contactRequest);
        return new ResponseEntity<>(contactRequest, HttpStatus.OK);
    }

    // ======================================
    // =          DELETE METHOD             =
    // ======================================

    @RequestMapping(path = "/{contactId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteContact(@PathVariable Long contactId) {
        contactRepository.delete(contactId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
