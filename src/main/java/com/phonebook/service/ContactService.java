package com.phonebook.service;

import com.phonebook.entity.Contact;

import java.util.List;


public interface ContactService {
    public String saveContact(Contact contact);
    public List<Contact> getALlContacts();
    public Contact getContactById(Integer contactId);
    public String updateContact(Contact contact);
    public String deleteContactById(Integer contactId);
}
