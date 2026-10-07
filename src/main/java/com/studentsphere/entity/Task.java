package com.studentsphere.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    private String title;

    private String description;

    private Integer reward;

    private String difficulty;

    private String icon;

    public Task() {
    }

    public Task(
            String title,
            String description,
            Integer reward,
            String difficulty,
            String icon
    ) {
        this.title = title;
        this.description = description;
        this.reward = reward;
        this.difficulty = difficulty;
        this.icon = icon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(
            String title
    ) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(
            String description
    ) {
        this.description = description;
    }

    public Integer getReward() {
        return reward;
    }

    public void setReward(
            Integer reward
    ) {
        this.reward = reward;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(
            String difficulty
    ) {
        this.difficulty = difficulty;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(
            String icon
    ) {
        this.icon = icon;
    }
}