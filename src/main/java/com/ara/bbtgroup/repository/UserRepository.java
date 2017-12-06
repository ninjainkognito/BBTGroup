package com.ara.bbtgroup.repository;

import com.ara.bbtgroup.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findById(Integer userId);
    User findByUsername(String firstname);

}
