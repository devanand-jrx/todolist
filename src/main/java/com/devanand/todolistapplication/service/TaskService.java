package com.devanand.todolistapplication.service;


import com.devanand.todolistapplication.contract.TaskResponse;
import com.devanand.todolistapplication.exception.TaskNotFoundException;
import com.devanand.todolistapplication.model.Task;
import com.devanand.todolistapplication.repository.TaskRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;


    @Autowired
    public TaskService(TaskRepository taskRepository, ModelMapper modelMapper) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;

    }

    public List<TaskResponse> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        return tasks.stream()
                .map(task -> modelMapper.map(task, TaskResponse.class))
                .collect(Collectors.toList());
    }

    public TaskResponse getTaskById(int id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id));
        return convertToTaskResponse(task);
    }

    public TaskResponse createTask(Task task) {
        Task createdTask = taskRepository.save(task);
        return convertToTaskResponse(createdTask);
    }


    public TaskResponse updateTask(int id, Task updatedTask) {
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id));
        updatedTask.setId(existingTask.getId());
        Task savedTask = taskRepository.save(updatedTask);
        return convertToTaskResponse(savedTask);
    }


    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }

    private TaskResponse convertToTaskResponse(Task task) {
        return modelMapper.map(task, TaskResponse.class);
    }

}
