package com.devanand.todolistapplication.exception;

public class TaskAlreadyExistsException extends RuntimeException{
    public TaskAlreadyExistsException(String name) {
        super("Task "+name+" already exists ");
    }
}
