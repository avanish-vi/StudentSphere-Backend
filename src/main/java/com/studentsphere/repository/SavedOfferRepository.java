package com.studentsphere.repository;

import com.studentsphere.entity.SavedOffer;
import com.studentsphere.entity.User;
import com.studentsphere.entity.Offer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SavedOfferRepository
        extends JpaRepository<SavedOffer, Long> {

    List<SavedOffer> findByUser(User user);

    Optional<SavedOffer> findByUserAndOffer(
            User user,
            Offer offer
    );

    boolean existsByUserAndOffer(
            User user,
            Offer offer
    );

    void deleteByUserAndOffer(
            User user,
            Offer offer
    );
}