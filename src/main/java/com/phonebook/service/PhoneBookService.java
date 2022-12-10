package com.phonebook.service;

import com.phonebook.entity.ContactDetailsEntity;
import com.phonebook.repository.ContactDetailsRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PhoneBookService {
    /*
     * Logger
     **/
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(PhoneBookService.class);
    /*
     * Service
     **/
    @Autowired
    private ContactDetailsRepository repository;

    public String saveContactInfo(ContactDetailsEntity entity) {
        repository.save(entity);
        logger.info("error occured in saveContactInfo");
        return "Contact Saved Successfully";
    }

    public List<ContactDetailsEntity> viewAllContactInfo() {
        List<ContactDetailsEntity> list =repository.findAll();
        logger.info("error occured in viewAllContactInfo ");
        return list;
    }
    public String deleteContactById(Integer id){
        repository.deleteById(id);
        return "Contact Deleted Successfully";
    }
    public String updateContactInfo(ContactDetailsEntity entity){
        if(Objects.nonNull(repository.findById(entity.getContactId()))){
            repository.save(entity);
            return "Contact Updated Successfully";
        }

        return null;
    }
}
