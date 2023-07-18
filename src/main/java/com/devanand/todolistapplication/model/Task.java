package com.devanand.todolistapplication.model;

import ch.qos.logback.core.status.Status;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;


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
    private String name;
    private String description;
    private String status;
    private Date dueDate;
}