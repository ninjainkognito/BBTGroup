package com.ara.bbtgroup.repository;

import com.ara.bbtgroup.model.Contact;
import com.ara.bbtgroup.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
}
