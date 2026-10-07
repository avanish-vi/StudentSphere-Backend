package com.studentsphere.repository;

import com.studentsphere.entity.Internship;
import com.studentsphere.entity.SavedInternship;
import com.studentsphere.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SavedInternshipRepository
        extends JpaRepository<
        SavedInternship,
        Long
        > {

    List<SavedInternship> findByUser(
            User user
    );

    boolean existsByUserAndInternship(
            User user,
            Internship internship
    );

    void deleteByUserAndInternship(
            User user,
            Internship internship
    );
}