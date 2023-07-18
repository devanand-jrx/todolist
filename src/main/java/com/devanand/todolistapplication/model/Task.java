package com.devanand.todolistapplication.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;



@Data
@Entity
@Setter
@Getter
@ToString
@Table(name="Task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    @NotNull
    @Size(min=3, max=25)
    private String name;

    @NotNull
    @Size(min=1, message="Description must not be empty")
    private String description;


    @Enumerated(EnumType.STRING)
    private Status status;

    private LocalDate dueDate;
}