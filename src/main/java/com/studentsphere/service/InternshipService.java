package com.studentsphere.service;

import com.studentsphere.entity.Internship;
import com.studentsphere.repository.InternshipRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InternshipService {

    private final InternshipRepository internshipRepository;

    public InternshipService(
            InternshipRepository internshipRepository
    ) {
        this.internshipRepository =
                internshipRepository;
    }

    public List<Internship> getAllInternships() {

        return internshipRepository.findAll();
    }

    public Internship getInternshipById(
            Long id
    ) {

        return internshipRepository
                .findById(id)
                .orElseThrow(
                        () -> new RuntimeException(
                                "Internship not found."
                        )
                );
    }
}