package com.ara.bbtgroup.repository;

import com.ara.bbtgroup.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findById(Integer userId);
    User findByFirstname(String firstname);

}
