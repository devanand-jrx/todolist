package com.devanand.todolistapplication.controller;


import com.devanand.todolistapplication.contract.TaskResponse;
import com.devanand.todolistapplication.model.Task;
import com.devanand.todolistapplication.service.TaskService;
//import lombok.AllArgsConstructor;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//import java.util.Optional;


@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/getAllTasks")
    public ResponseEntity<List<TaskResponse>> getAllTasks() {
        return new ResponseEntity<>(taskService.getAllTasks(), HttpStatus.OK);
    }

    @GetMapping("/getTaskById/{id}")
    public TaskResponse getTaskById(@PathVariable int id) {
        return taskService.getTaskById(id);
    }

    @PostMapping("/createTask")
    @ResponseStatus(HttpStatus.CREATED)
    public TaskResponse createTask(@RequestBody @Valid Task task) {
        return taskService.createTask(task);
    }

    @PutMapping("/updateTask/{id}")
    public TaskResponse updateTask(@PathVariable int id, @RequestBody @Valid Task updatedTask) {
        return taskService.updateTask(id, updatedTask);
    }

    @DeleteMapping("/deleteTask/{id}")
    public void deleteTask(@PathVariable int id) {
        taskService.deleteTask(id);
    }
}
