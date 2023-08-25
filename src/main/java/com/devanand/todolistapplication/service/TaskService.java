package com.devanand.todolistapplication.service;

import com.devanand.todolistapplication.contract.TaskResponse;
import com.devanand.todolistapplication.exception.TaskAlreadyExistsException;
import com.devanand.todolistapplication.exception.TaskNotFoundException;
import com.devanand.todolistapplication.model.Task;
import com.devanand.todolistapplication.repository.TaskRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
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
        Task task =
                this.taskRepository
                        .findById(id)
                        .orElseThrow(
                                () -> {
                                    log.error("Book with id: {} not found", id);
                                    return new TaskNotFoundException(id);
                                });
        return modelMapper.map(task, TaskResponse.class);
    }

    public TaskResponse createTask(TaskResponse task) {
        boolean courseExists = taskRepository.existsByName(task.getName());
        if (courseExists) {
            throw new TaskAlreadyExistsException(task.getName());
        }
        Task createdTask = taskRepository.save(modelMapper.map(task, Task.class));
        return modelMapper.map(createdTask, TaskResponse.class);
    }

    public TaskResponse updateTask(int id, TaskResponse task) {
        Task existingTask =
                taskRepository
                        .findById(id)
                        .orElseThrow(
                                () -> {
                                    log.error("Task with id: {} not found", id);
                                    return new TaskNotFoundException(id);
                                });
        modelMapper.map(task, existingTask);
        Task updatedTask = taskRepository.save(existingTask);
        return modelMapper.map(updatedTask, TaskResponse.class);
    }

    public void deleteTask(int id) {
        if (!taskRepository.existsById(id)) {
            throw new TaskNotFoundException(id);
        }
        taskRepository.deleteById(id);
    }
}
