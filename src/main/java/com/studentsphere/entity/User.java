package com.studentsphere.entity;

import jakarta.persistence.*;

@Entity
@Table(
        name = "users",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = "email"
                )
        }
)
public class User {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    private String name;

    @Column(
            nullable = false,
            unique = true
    )
    private String email;

    @Column(nullable = false)
    private String password;

    private String college;

    private String course;

    private String year;

    private String city;

    private boolean verified = false;

    @Column(
            name = "reward_points",
            nullable = false
    )
    private Integer rewardPoints = 0;


    /* ================================
       CONSTRUCTORS
    ================================= */

    public User() {
    }


    public User(
            String name,
            String email,
            String password,
            String college,
            String course,
            String year,
            String city
    ) {

        this.name = name;
        this.email = email;
        this.password = password;
        this.college = college;
        this.course = course;
        this.year = year;
        this.city = city;
        this.verified = false;
        this.rewardPoints = 0;
    }


    /* ================================
       ID
    ================================= */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    /* ================================
       NAME
    ================================= */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    /* ================================
       EMAIL
    ================================= */

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    /* ================================
       PASSWORD
    ================================= */

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    /* ================================
       COLLEGE
    ================================= */

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }


    /* ================================
       COURSE
    ================================= */

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }


    /* ================================
       YEAR
    ================================= */

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


    /* ================================
       CITY
    ================================= */

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    /* ================================
       VERIFIED
    ================================= */

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(
            boolean verified
    ) {
        this.verified = verified;
    }


    /* ================================
       REWARD POINTS
    ================================= */

    public Integer getRewardPoints() {
        return rewardPoints;
    }

    public void setRewardPoints(
            Integer rewardPoints
    ) {
        this.rewardPoints = rewardPoints;
    }
}