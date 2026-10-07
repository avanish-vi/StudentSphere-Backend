package com.studentsphere.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "internship")
public class Internship {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    private String company;

    private String logo;

    private String role;

    private String category;

    private String stipend;

    private String duration;

    private String mode;

    private String location;

    @Column(length = 1000)
    private String skills;

    public Internship() {
    }

    public Internship(
            String company,
            String logo,
            String role,
            String category,
            String stipend,
            String duration,
            String mode,
            String location,
            String skills
    ) {
        this.company = company;
        this.logo = logo;
        this.role = role;
        this.category = category;
        this.stipend = stipend;
        this.duration = duration;
        this.mode = mode;
        this.location = location;
        this.skills = skills;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStipend() {
        return stipend;
    }

    public void setStipend(String stipend) {
        this.stipend = stipend;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
}