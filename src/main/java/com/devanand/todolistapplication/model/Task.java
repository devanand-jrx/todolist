package com.devanand.todolistapplication.model;

import jakarta.persistence.*;

import java.time.LocalDate;

import lombok.*;

@Getter
@Entity
@Table(name = "task")
@NoArgsConstructor
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    private String name;
    private String description;

    private String status;

    private LocalDate dueDate;
}
