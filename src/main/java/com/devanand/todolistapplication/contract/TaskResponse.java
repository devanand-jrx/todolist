package com.devanand.todolistapplication.contract;

import com.devanand.todolistapplication.model.Status;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
public class TaskResponse {

    private int id;
    private String name;
    private String description;
    private Status status;
    private LocalDate dueDate;
}
