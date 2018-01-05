package com.ara.bbtgroup.repository;

import com.ara.bbtgroup.model.Marketingactivity;
import com.ara.bbtgroup.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarketingactivityRepository extends CrudRepository<Marketingactivity, Long> {

    @Query(value = "select * from dbo.marketingactivity where employee_id = ?1 AND status = '1'", nativeQuery = true)
    List<Marketingactivity> getAllByEmployeeIdAndStatusEqualsTodo(String ownerId);

    @Query(value = "select * from dbo.marketingactivity where employee_id = ?1 AND status = '2'", nativeQuery = true)
    List<Marketingactivity> getAllByEmployeeIdAndStatusEqualsInProgress(String ownerId);

    @Query(value = "select * from dbo.marketingactivity where employee_id = ?1 AND status = '3'", nativeQuery = true)
    List<Marketingactivity> getAllByEmployeeIdAndStatusEqualsCompleted(String ownerId);

}
