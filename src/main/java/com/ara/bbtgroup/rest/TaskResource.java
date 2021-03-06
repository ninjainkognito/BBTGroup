package com.ara.bbtgroup.rest;

import com.ara.bbtgroup.model.Task;
import com.ara.bbtgroup.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskResource {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Autowired
    private TaskRepository taskRepository;

    // ======================================
    // =             GET METHOD             =
    // ======================================

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody List<Task> getAllTasks() {

        return taskRepository.findAll();
    }

    @GetMapping(path = "/{taskId}")
    public ResponseEntity<Task> getById(@PathVariable String taskId) {

        Long temp = Long.valueOf(taskId).longValue();

        return new ResponseEntity<>(taskRepository.findByTaskId(temp), HttpStatus.OK);
    }

    @GetMapping(path = "/owner/{ownerOfTheTask}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody List<Task> getTaskByOwnerId(@PathVariable String ownerOfTheTask) {

        return taskRepository.findAllByOwnerOfTheTask(ownerOfTheTask);
    }

    @GetMapping(path = "/todo/{ownerId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody List<Task> getAllDTodoTaskByUserId(@PathVariable String ownerId) {

        return taskRepository.findAllByOwnerOfTheTaskAndTaskStatusIsEqualToTodo(ownerId);
    }

    @GetMapping(path = "/progress/{ownerId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody List<Task> getAllProgressTaskByUserId(@PathVariable String ownerId) {

        return taskRepository.findAllByOwnerOfTheTaskAndTaskStatusIsEqualToProgress(ownerId);
    }

    @GetMapping(path = "/done/{ownerId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public @ResponseBody List<Task> getAllDoneTaskByUserId(@PathVariable String ownerId) {

        return taskRepository.findAllByOwnerOfTheTaskAndTaskStatusIsEqualToDone(ownerId);
    }

    // ======================================
    // =             POST METHOD            =
    // ======================================

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Task> createTask(@RequestBody Task taskRequest){

        taskRepository.save(taskRequest);
        return new ResponseEntity<>(taskRequest, HttpStatus.CREATED);
    }

    // ======================================
    // =             PUT METHOD             =
    // ======================================

    @PutMapping(path = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Task> updateTask(@RequestBody Task taskRequest) {
        taskRepository.save(taskRequest);
        return new ResponseEntity<>(taskRequest, HttpStatus.OK);
    }

    // ======================================
    // =          DELETE METHOD             =
    // ======================================

    @DeleteMapping(path = "/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId) {

        taskRepository.delete(taskId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
