package com.studentsphere.repository;

import com.studentsphere.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository
        extends JpaRepository<Offer, Long> {
}