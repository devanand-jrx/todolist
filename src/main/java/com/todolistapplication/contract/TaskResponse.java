package com.devanand.todolistapplication.contract;

import lombok.*;

import java.util.Date;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class TaskResponse {

    private int id;
    private String name;
    private String description;
    private String status;
    private Date dueDate;
}
