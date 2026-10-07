package com.studentsphere.service;

import com.studentsphere.entity.Offer;
import com.studentsphere.entity.SavedOffer;
import com.studentsphere.entity.User;

import com.studentsphere.repository.OfferRepository;
import com.studentsphere.repository.SavedOfferRepository;
import com.studentsphere.repository.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SavedOfferService {

    private final SavedOfferRepository savedOfferRepository;
    private final UserRepository userRepository;
    private final OfferRepository offerRepository;

    public SavedOfferService(
            SavedOfferRepository savedOfferRepository,
            UserRepository userRepository,
            OfferRepository offerRepository
    ) {
        this.savedOfferRepository =
                savedOfferRepository;

        this.userRepository =
                userRepository;

        this.offerRepository =
                offerRepository;
    }

    public List<Offer> getSavedOffers(
            Long userId
    ) {

        User user =
                userRepository
                        .findById(userId)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "User not found."
                                )
                        );

        return savedOfferRepository
                .findByUser(user)
                .stream()
                .map(SavedOffer::getOffer)
                .collect(Collectors.toList());
    }

    @Transactional
    public Offer saveOffer(
            Long userId,
            Long offerId
    ) {

        User user =
                userRepository
                        .findById(userId)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "User not found."
                                )
                        );

        Offer offer =
                offerRepository
                        .findById(offerId)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Offer not found."
                                )
                        );

        boolean alreadySaved =
                savedOfferRepository
                        .existsByUserAndOffer(
                                user,
                                offer
                        );

        if (!alreadySaved) {

            SavedOffer savedOffer =
                    new SavedOffer(
                            user,
                            offer
                    );

            savedOfferRepository.save(
                    savedOffer
            );
        }

        return offer;
    }

    @Transactional
    public void removeOffer(
            Long userId,
            Long offerId
    ) {

        User user =
                userRepository
                        .findById(userId)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "User not found."
                                )
                        );

        Offer offer =
                offerRepository
                        .findById(offerId)
                        .orElseThrow(
                                () -> new RuntimeException(
                                        "Offer not found."
                                )
                        );

        savedOfferRepository
                .deleteByUserAndOffer(
                        user,
                        offer
                );
    }
}