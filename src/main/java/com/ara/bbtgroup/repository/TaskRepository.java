package com.ara.bbtgroup.repository;

import com.ara.bbtgroup.model.Task;
import com.ara.bbtgroup.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
}
