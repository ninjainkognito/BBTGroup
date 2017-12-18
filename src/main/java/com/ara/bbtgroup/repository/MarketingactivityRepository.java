package com.ara.bbtgroup.repository;

import com.ara.bbtgroup.model.Marketingactivity;
import com.ara.bbtgroup.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketingactivityRepository extends CrudRepository<Marketingactivity, Long> {
}
