package com.phonebook.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CONTACTS_TBL")
@Data
public class Contact {
    @Id
    @GeneratedValue
    private Integer contactId;
    private String name;
    private String email;
    private Long phoneNo;


}
