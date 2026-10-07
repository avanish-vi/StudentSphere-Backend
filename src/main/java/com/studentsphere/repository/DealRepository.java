package com.studentsphere.repository;

import com.studentsphere.entity.Deal;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DealRepository
        extends JpaRepository<Deal, Long> {
}