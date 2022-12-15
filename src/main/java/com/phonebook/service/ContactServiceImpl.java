package com.phonebook.service;

import com.phonebook.entity.Contact;
import com.phonebook.repository.ContactRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {
    /*
     * Logger
     **/
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ContactServiceImpl.class);
    /*
     * Service
     **/
    @Autowired
    private ContactRepository repo;

    public String saveContact(Contact contact) {
        Contact save = repo.save(contact);
        logger.debug("error occurred in saveContact");
        if(save.getContactId()!= null){
            return "Contact saved Successfully";
        }
        return "Failed to save Contact";
    }

    @Override
    public List<Contact> getALlContacts() {
        logger.debug("error occurred in getALlContacts");
        return repo.findAll();
    }

    @Override
    public Contact getContactById(Integer contactId) {
        Optional<Contact> contactOptional = repo.findById(contactId); // to avoid null pointer exception optional is used
        if(contactOptional.isPresent()){
            logger.debug("error occurred in getContactById");
            return  contactOptional.get();
        }
        return null;
    }

    public String updateContact(Contact contact) {
        if (repo.existsById(contact.getContactId())) {
            repo.save(contact);
            logger.debug("error occurred in updateContact");
            return "Contact Updated Successfully";
        }else {
            return "failed to update contact";
        }
    }

    public String deleteContactById(Integer id){
        repo.deleteById(id);
        logger.debug("error occurred in deleteContactById");
        return "Contact Deleted Successfully";
    }
}
