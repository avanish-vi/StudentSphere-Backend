package com.studentsphere.entity;

import jakarta.persistence.*;

@Entity
@Table(
        name = "saved_offer",
        uniqueConstraints = {
                @UniqueConstraint(
                        columnNames = {"user_id", "offer_id"}
                )
        }
)
public class SavedOffer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "user_id",
            nullable = false
    )
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(
            name = "offer_id",
            nullable = false
    )
    private Offer offer;

    public SavedOffer() {
    }

    public SavedOffer(
            User user,
            Offer offer
    ) {
        this.user = user;
        this.offer = offer;
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

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }
}