package com.ara.bbtgroup.repository;

import com.ara.bbtgroup.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
    User findByUserId(Integer id);

}
