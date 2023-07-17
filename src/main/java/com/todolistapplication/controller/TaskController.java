package com.devanand.todolistapplication.controller;


import com.devanand.todolistapplication.contract.TaskResponse;
//import com.devanand.todolistapplication.exception.TaskNotFoundException;
import com.devanand.todolistapplication.model.Task;
//import com.devanand.todolistapplication.repository.TaskRepository;
import com.devanand.todolistapplication.service.TaskService;
//import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//import java.util.Optional;


@RestController
@RequestMapping
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/getAllTasks")
    public List<TaskResponse> getAllTasks() {
        return taskService.getAllTasks();
    }
    @GetMapping("/getTaskById/{id}")
    public ResponseEntity<TaskResponse> getTaskById(@PathVariable int id) {
        TaskResponse task = taskService.getTaskById(id);
        return ResponseEntity.ok(task);
    }
    @PostMapping("/createTask")
    public ResponseEntity<TaskResponse> createTask(@RequestBody Task task) {
        TaskResponse createdTask = taskService.createTask(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTask);
    }
    @PutMapping("/updateTask/{id}")
    public ResponseEntity<TaskResponse> updateTask(@PathVariable int id, @RequestBody Task task) {
        TaskResponse updatedTask = taskService.updateTask(id, task);
        return ResponseEntity.ok(updatedTask);
    }
    @DeleteMapping("/deleteTask/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }


}