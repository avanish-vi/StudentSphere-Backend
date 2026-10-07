package com.studentsphere.repository;

import com.studentsphere.entity.Internship;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InternshipRepository
        extends JpaRepository<Internship, Long> {
}