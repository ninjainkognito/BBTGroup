package com.ara.bbtgroup.entities;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByFirstname(String firstname);
}
