package com.studentsphere.controller;

import com.studentsphere.entity.Notification;
import com.studentsphere.repository.NotificationRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    private final NotificationRepository repository;


    public NotificationController(
            NotificationRepository repository
    ) {

        this.repository = repository;
    }


    @GetMapping("/{userId}")
    public List<Notification> getNotifications(
            @PathVariable Long userId
    ) {

        return repository
                .findByUserIdOrderByCreatedAtDesc(
                        userId
                );
    }
}