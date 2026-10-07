package com.studentsphere.controller;

import com.studentsphere.entity.Internship;
import com.studentsphere.service.InternshipService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/internships")
@CrossOrigin(origins = "http://localhost:5173")
public class InternshipController {

    private final InternshipService internshipService;

    public InternshipController(
            InternshipService internshipService
    ) {
        this.internshipService =
                internshipService;
    }

    @GetMapping
    public List<Internship> getAllInternships() {

        return internshipService
                .getAllInternships();
    }

    @GetMapping("/{id}")
    public Internship getInternshipById(
            @PathVariable Long id
    ) {

        return internshipService
                .getInternshipById(id);
    }
}