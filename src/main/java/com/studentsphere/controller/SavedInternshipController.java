package com.studentsphere.controller;

import com.studentsphere.entity.Internship;
import com.studentsphere.service.SavedInternshipService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173")
public class SavedInternshipController {

    private final SavedInternshipService
            savedInternshipService;

    public SavedInternshipController(
            SavedInternshipService
                    savedInternshipService
    ) {
        this.savedInternshipService =
                savedInternshipService;
    }


    @GetMapping(
            "/{userId}/saved-internships"
    )
    public List<Internship> getSavedInternships(
            @PathVariable Long userId
    ) {

        return savedInternshipService
                .getSavedInternships(userId);
    }


    @PostMapping(
            "/{userId}/saved-internships/{internshipId}"
    )
    public Internship saveInternship(
            @PathVariable Long userId,
            @PathVariable Long internshipId
    ) {

        return savedInternshipService
                .saveInternship(
                        userId,
                        internshipId
                );
    }


    @DeleteMapping(
            "/{userId}/saved-internships/{internshipId}"
    )
    public void removeInternship(
            @PathVariable Long userId,
            @PathVariable Long internshipId
    ) {

        savedInternshipService
                .removeInternship(
                        userId,
                        internshipId
                );
    }
}