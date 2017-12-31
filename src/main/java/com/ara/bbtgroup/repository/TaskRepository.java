package com.ara.bbtgroup.repository;

import com.ara.bbtgroup.model.Task;
import com.ara.bbtgroup.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    // All methods in a Interface are public
    // pubilc declaration of the methods are useless

    @Query(value = "select * from Task where owner_of_the_task = ?1", nativeQuery = true)
    List<Task> findAllByOwnerOfTheTask(String ownerOfTheTask);

    @Query(value = "select * from Task where owner_of_the_task = ?1 AND task_status = '1'", nativeQuery = true)
    List<Task> findAllByOwnerOfTheTaskAndTaskStatusIsEqualToTodo(String ownerId);

    @Query(value = "select * from Task where owner_of_the_task = ?1 AND task_status = '2'", nativeQuery = true)
    List<Task> findAllByOwnerOfTheTaskAndTaskStatusIsEqualToProgress(String ownerId);

    @Query(value = "select * from Task where owner_of_the_task = ?1 AND task_status = '3'", nativeQuery = true)
    List<Task> findAllByOwnerOfTheTaskAndTaskStatusIsEqualToDone(String ownerId);

    Task findByTaskId(Long taskId);
}
