package com.devanand.todolistapplication.repository;

import com.devanand.todolistapplication.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    boolean existsByName(@Param("name") String name);


}
