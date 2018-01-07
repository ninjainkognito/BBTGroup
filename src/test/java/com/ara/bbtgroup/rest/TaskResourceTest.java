package com.ara.bbtgroup.rest;

import com.ara.bbtgroup.model.Task;
import com.ara.bbtgroup.repository.TaskRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static java.lang.Long.valueOf;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskResourceTest {

    @Autowired
    private TaskRepository taskRepository;

    private final Date STARTDATE = new Date(2018,01,01);
    private final Date ENDDATE = new Date(2018,01,31);
    private final Long OWNER = valueOf(1);

    @Test
    public void saveTask_whenFoundById_thenOk(){

        Task task = taskRepository.save(new Task("title",
                "description", 1,
                STARTDATE, ENDDATE, OWNER));

        Task foundTsk = taskRepository
                .findOne(task.getTaskId());

        assertNotNull(foundTsk);
        assertEquals(task.getTaskId(), foundTsk.getTaskId());
    }

    @Test
    public void saveMultipleTasks_AndFindAll_whenMultipleFound_thenOk(){

        Task task = new Task("title","description",
                1, STARTDATE, ENDDATE, OWNER);
        Task task1 = new Task("title","description",
                1, STARTDATE, ENDDATE, OWNER);
        Task task2 = new Task("title","description",
                1, STARTDATE, ENDDATE, OWNER);

        this.taskRepository.save(task);
        this.taskRepository.save(task1);
        this.taskRepository.save(task2);

        List<Task> taskList = taskRepository.findAll();

        assertNotNull(taskList);
        assertTrue(taskList.size() > 0);
    }

    @Test
    public void saveTaskAndDelete_whenDeleted_thenOk(){

        Long ownerTemp = valueOf(4194984);

        Task task = taskRepository
                .save(new Task("SaveTaskAndDelete","Testing", 1, STARTDATE, ENDDATE, ownerTemp));

        // check if data successfully written into database
        assertTrue(taskRepository.findAllByOwnerOfTheTask("4194984").size() > 0);

        Long lastInsertTask = taskRepository.findOne(task.getTaskId()).getTaskId();
        taskRepository.delete(lastInsertTask);
        assertNull(taskRepository.findOne(lastInsertTask));
    }

    @Test
    public void updateTask_whenUpdated_thenOk(){
        Task task = taskRepository
                .save(new Task("POST Task","POST Task", 1, STARTDATE, ENDDATE, OWNER));

        Task foundTsk = taskRepository.findOne(task.getTaskId());
        foundTsk.setTaskStatus(2);

        taskRepository.save(foundTsk);

        assertEquals(2, taskRepository.findOne(task.getTaskId()).getTaskStatus());
    }

}
