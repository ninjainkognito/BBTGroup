package com.ara.bbtgroup.repository;

import com.ara.bbtgroup.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

    @Query(value = "SELECT * FROM dbo.bbtgroup_user WHERE username = ?1 AND password = ?2", nativeQuery = true)
    User checkCredential(String username, String password);
}
