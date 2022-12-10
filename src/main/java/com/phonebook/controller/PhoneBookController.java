package com.phonebook.controller;

import com.phonebook.entity.ContactDetailsEntity;
import com.phonebook.service.PhoneBookService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class PhoneBookController {
    /*
     * Logger
     **/
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(PhoneBookController.class);
    /*
     * Service
     **/
    @Autowired
    private PhoneBookService phoneBookService;

    @PostMapping(value = "/save",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public String setPhoneBookDetails(@RequestBody ContactDetailsEntity entity) {
        logger.debug("error occured in setPhoneBookDetails");
        return phoneBookService.saveContactInfo(entity);
    }

    @GetMapping(value = "/getAll",produces = MediaType.APPLICATION_JSON_VALUE)
    public java.util.List<ContactDetailsEntity> getPhoneBookResponse() {
        logger.debug("error occured in getPhoneBookResponse");
        return phoneBookService.viewAllContactInfo();
    }

    @DeleteMapping(value = "/delete/{id}" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteContactById(@PathVariable  Integer id){
        logger.debug("error occured in deleteContactById");
        return phoneBookService.deleteContactById(id);
    }
    @PatchMapping(value = "/update",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public String updateContactInfo(@RequestBody ContactDetailsEntity entity){
        logger.debug("error occured in updateContactInfo");
        return phoneBookService.updateContactInfo(entity);
    }

}
