package com.studentsphere.service;

import com.studentsphere.entity.Offer;
import com.studentsphere.repository.OfferRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferService {

    private final OfferRepository offerRepository;

    public OfferService(
            OfferRepository offerRepository
    ) {
        this.offerRepository =
                offerRepository;
    }

    public List<Offer> getAllOffers() {

        return offerRepository.findAll();
    }

    public Offer getOfferById(
            Long id
    ) {

        return offerRepository
                .findById(id)
                .orElseThrow(
                        () -> new RuntimeException(
                                "Offer not found."
                        )
                );
    }
}