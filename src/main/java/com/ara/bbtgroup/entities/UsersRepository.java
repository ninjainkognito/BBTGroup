package com.ara.bbtgroup.entities;

import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface UsersRepository extends CrudRepository<Users, Integer> {
    Users findByFirstname(String firstname);
}
