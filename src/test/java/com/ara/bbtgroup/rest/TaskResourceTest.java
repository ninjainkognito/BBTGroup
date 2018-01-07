package com.ara.bbtgroup.rest;

import com.ara.bbtgroup.model.Task;
import com.ara.bbtgroup.repository.TaskRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static java.lang.Long.valueOf;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskResourceTest {

    @Autowired
    private TaskRepository taskRepository;

    private final Date STARTDATE = new Date(2018,01,01);
    private final Date ENDDATE = new Date(2018,01,31);

    private final Long OWNER = valueOf(1);


    @Before
    public void initDataIntoDatabase(){

        Task task = new Task("title","description", 1, STARTDATE, ENDDATE, OWNER);
        Task task1 = new Task("title","description", 1, STARTDATE, ENDDATE, OWNER);
        Task task2 = new Task("title","description", 1, STARTDATE, ENDDATE, OWNER);

        this.taskRepository.save(task);
        this.taskRepository.save(task1);
        this.taskRepository.save(task2);
    }

    @Test
    public void saveTaskAndFoundById(){

        Task task = taskRepository
                .save(new Task("title","description", 1, STARTDATE, ENDDATE, OWNER));

        Task foundTsk = taskRepository
                .findOne(task.getTaskId());

        assertNotNull(foundTsk);
    }

    @Test
    public void saveMultipleTasks_AndFindAll_whenMultipleFound_thenOk(){

        // saving multiple Tasks is automatically done with the @Before class

        List<Task> taskList = taskRepository.findAll();

        assertNotNull(taskList);
        assertTrue(taskList.size() > 0);
    }

    @Test
    public void saveTaskAndDelete_whenDeleted_thenOk(){

        Long ownerTemp = valueOf(4194984);

        Task task = taskRepository
                .save(new Task("SaveTaskAndDelete","Testing", 1, STARTDATE, ENDDATE, ownerTemp));

        taskRepository.findAllByOwnerOfTheTask("4194984").size();

        // check if data successfully written into database
        assertTrue(taskRepository.findAllByOwnerOfTheTask("4194984").size() > 0);

        int lastInsertTask = taskRepository.findAll().size();

        taskRepository.delete(valueOf(lastInsertTask));

        assertTrue(taskRepository.findAll().size() != lastInsertTask);

    }

}
