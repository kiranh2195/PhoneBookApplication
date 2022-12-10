package com.phonebook.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="CONTACT_TBL")
@Data
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer contactId;
    private String name;
    private String email;
    private Long phoneNo;


}
