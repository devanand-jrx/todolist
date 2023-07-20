package com.devanand.todolistapplication.contract;


import ch.qos.logback.core.status.Status;
import com.devanand.todolistapplication.validation.ValidDate;
import com.devanand.todolistapplication.validation.ValidName;
import com.devanand.todolistapplication.validation.ValidStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskResponse {

    private int id;

    @ValidName
    private String name;

    private String description;


    @Enumerated(EnumType.STRING)
    @ValidStatus
    private Status status;

    @ValidDate
    private LocalDate dueDate;

    public enum Status {
        PENDING,
        COMPLETED,
        IN_PROGRESS
    }
}
