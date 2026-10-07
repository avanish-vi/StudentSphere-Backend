package com.studentsphere.repository;

import com.studentsphere.entity.Task;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository
        extends JpaRepository<Task, Long> {
}