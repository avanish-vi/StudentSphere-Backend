package com.studentsphere.entity;

import jakarta.persistence.*;

@Entity
@Table(
        name = "saved_internship",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {
                                "user_id",
                                "internship_id"
                        }
                )
        }
)
public class SavedInternship {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "user_id",
            nullable = false
    )
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "internship_id",
            nullable = false
    )
    private Internship internship;

    public SavedInternship() {
    }

    public SavedInternship(
            User user,
            Internship internship
    ) {
        this.user = user;
        this.internship = internship;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Internship getInternship() {
        return internship;
    }

    public void setInternship(
            Internship internship
    ) {
        this.internship = internship;
    }
}