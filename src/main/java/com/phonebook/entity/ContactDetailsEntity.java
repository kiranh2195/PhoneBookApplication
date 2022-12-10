package com.phonebook.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Entity
@Table(name="tbl_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDetailsEntity {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer contactId;
    private String name;
    private String email;
    private Long phoneNo;


}
