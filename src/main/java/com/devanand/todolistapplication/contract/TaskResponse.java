package com.devanand.todolistapplication.contract;


import ch.qos.logback.core.status.Status;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskResponse {

    private int id;
    private String name;
    private String description;


    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDate dueDate;

    public enum Status {
        PENDING,
        COMPLETED,
        IN_PROGRESS
    }
}
