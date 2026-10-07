package com.studentsphere.controller;

import com.studentsphere.dto.UpdateUserRequest;
import com.studentsphere.entity.User;
import com.studentsphere.service.UserService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    private final UserService userService;

    public UserController(
            UserService userService
    ) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public User getUser(
            @PathVariable Long id
    ) {
        return userService.getUser(id);
    }

    @PutMapping("/{id}")
    public User updateUser(
            @PathVariable Long id,
            @RequestBody UpdateUserRequest request
    ) {
        return userService.updateUser(
                id,
                request
        );
    }
}