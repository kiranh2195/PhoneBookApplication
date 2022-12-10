package com.phonebook.controller;

import com.phonebook.entity.Contact;
import com.phonebook.service.ContactService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class ContactController {
    /*
     * Logger
     **/
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ContactController.class);
    /*
     * Service
     **/
    @Autowired
    private ContactService contactService;

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String setPhoneBookDetails(@RequestBody Contact entity) {
        logger.debug("error occured in setPhoneBookDetails");
        return contactService.saveContact(entity);
    }

    @GetMapping(value = "/getAllContacts", produces = MediaType.APPLICATION_JSON_VALUE)
    public java.util.List<Contact> getPhoneBookResponse() {
        logger.debug("error occured in getPhoneBookResponse");
        return contactService.getALlContacts();
    }

    @GetMapping(value = "/getContact/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Contact getContactById(@PathVariable Integer id) {
        logger.debug("error occured in getContactById");
        return contactService.getContactById(id);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteContactById(@PathVariable Integer id) {
        logger.debug("error occured in deleteContactById");
        return contactService.deleteContactById(id);
    }

    @PatchMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String updateContactInfo(@RequestBody Contact entity) {
        logger.debug("error occured in updateContactInfo");
        return contactService.updateContact(entity);
    }


}
