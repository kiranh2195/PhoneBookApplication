package com.phonebook.repository;

import com.phonebook.entity.ContactDetailsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactDetailsRepository extends JpaRepository<ContactDetailsEntity,Integer> {
}
