package com.studentsphere.service;

import com.studentsphere.dto.UpdateUserRequest;
import com.studentsphere.entity.User;
import com.studentsphere.repository.UserRepository;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(
            UserRepository userRepository
    ) {
        this.userRepository =
                userRepository;
    }

    public User getUser(Long id) {

        return userRepository
                .findById(id)
                .orElseThrow(
                        () -> new RuntimeException(
                                "User not found."
                        )
                );
    }

    public User updateUser(
            Long id,
            UpdateUserRequest request
    ) {

        User user = getUser(id);

        user.setName(
                request.getName()
        );

        user.setCollege(
                request.getCollege()
        );

        user.setCourse(
                request.getCourse()
        );

        user.setYear(
                request.getYear()
        );

        user.setCity(
                request.getCity()
        );

        return userRepository.save(user);
    }
}