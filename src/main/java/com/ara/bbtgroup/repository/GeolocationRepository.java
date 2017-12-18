package com.ara.bbtgroup.repository;

import com.ara.bbtgroup.model.Geolocation;
import com.ara.bbtgroup.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeolocationRepository extends CrudRepository<Geolocation, Long> {

    Geolocation findByGeolocationId(Long id);
}
