package com.studentsphere.service;

import com.studentsphere.dto.AuthResponse;
import com.studentsphere.dto.LoginRequest;
import com.studentsphere.dto.RegisterRequest;
import com.studentsphere.entity.User;
import com.studentsphere.repository.UserRepository;
import com.studentsphere.security.JwtService;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }


    /* ========================================
       REGISTER
    ======================================== */

    public AuthResponse register(
            RegisterRequest request
    ) {

        /*
         * Check whether email already exists.
         */
        if (userRepository.existsByEmail(
                request.getEmail()
        )) {

            throw new RuntimeException(
                    "Email already registered."
            );
        }


        /*
         * Create new user.
         */
        User user = new User();

        user.setName(
                request.getName()
        );

        user.setEmail(
                request.getEmail()
        );


        /*
         * Never store the plain-text password.
         */
        user.setPassword(
                passwordEncoder.encode(
                        request.getPassword()
                )
        );


        /*
         * Optional profile information.
         */
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


        /*
         * Default values.
         */
        user.setVerified(false);
        user.setRewardPoints(0);


        /*
         * Save user to MySQL.
         */
        User savedUser =
                userRepository.save(user);


        /*
         * Generate JWT using email.
         *
         * This matches JwtService:
         *
         * generateToken(user.getEmail())
         */
        String token =
                jwtService.generateToken(
                        savedUser.getEmail()
                );


        /*
         * Return authentication response.
         */
        return new AuthResponse(
                token,
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail()
        );
    }


    /* ========================================
       LOGIN
    ======================================== */

    public AuthResponse login(
            LoginRequest request
    ) {

        /*
         * Find user by email.
         */
        User user =
                userRepository
                        .findByEmail(
                                request.getEmail()
                        )
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Invalid email or password."
                                )
                        );


        /*
         * Check password.
         */
        boolean passwordMatches =
                passwordEncoder.matches(
                        request.getPassword(),
                        user.getPassword()
                );


        if (!passwordMatches) {

            throw new RuntimeException(
                    "Invalid email or password."
            );
        }


        /*
         * Generate JWT.
         */
        String token =
                jwtService.generateToken(
                        user.getEmail()
                );


        /*
         * Return authentication response.
         */
        return new AuthResponse(
                token,
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}