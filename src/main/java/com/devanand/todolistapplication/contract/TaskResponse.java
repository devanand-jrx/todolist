package com.devanand.todolistapplication.contract;

import com.devanand.todolistapplication.validation.ValidDate;
import com.devanand.todolistapplication.validation.ValidName;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.time.LocalDate;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaskResponse {

    private int id;

    @ValidName private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ValidDate private LocalDate dueDate;

    public enum Status {
        PENDING,
        COMPLETED,
        IN_PROGRESS
    }
}
