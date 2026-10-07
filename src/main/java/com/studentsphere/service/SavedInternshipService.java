package com.studentsphere.service;

import com.studentsphere.entity.Internship;
import com.studentsphere.entity.SavedInternship;
import com.studentsphere.entity.User;

import com.studentsphere.repository.InternshipRepository;
import com.studentsphere.repository.SavedInternshipRepository;
import com.studentsphere.repository.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SavedInternshipService {

    private final SavedInternshipRepository
            savedInternshipRepository;

    private final UserRepository userRepository;

    private final InternshipRepository
            internshipRepository;

    public SavedInternshipService(
            SavedInternshipRepository
                    savedInternshipRepository,
            UserRepository userRepository,
            InternshipRepository
                    internshipRepository
    ) {
        this.savedInternshipRepository =
                savedInternshipRepository;

        this.userRepository =
                userRepository;

        this.internshipRepository =
                internshipRepository;
    }


    public List<Internship> getSavedInternships(
            Long userId
    ) {

        User user =
                userRepository
                        .findById(userId)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "User not found."
                                )
                        );

        return savedInternshipRepository
                .findByUser(user)
                .stream()
                .map(
                        SavedInternship::getInternship
                )
                .collect(
                        Collectors.toList()
                );
    }


    @Transactional
    public Internship saveInternship(
            Long userId,
            Long internshipId
    ) {

        User user =
                userRepository
                        .findById(userId)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "User not found."
                                )
                        );

        Internship internship =
                internshipRepository
                        .findById(internshipId)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Internship not found."
                                )
                        );

        boolean alreadySaved =
                savedInternshipRepository
                        .existsByUserAndInternship(
                                user,
                                internship
                        );

        if (!alreadySaved) {

            SavedInternship saved =
                    new SavedInternship(
                            user,
                            internship
                    );

            savedInternshipRepository.save(
                    saved
            );
        }

        return internship;
    }


    @Transactional
    public void removeInternship(
            Long userId,
            Long internshipId
    ) {

        User user =
                userRepository
                        .findById(userId)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "User not found."
                                )
                        );

        Internship internship =
                internshipRepository
                        .findById(internshipId)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Internship not found."
                                )
                        );

        savedInternshipRepository
                .deleteByUserAndInternship(
                        user,
                        internship
                );
    }
}