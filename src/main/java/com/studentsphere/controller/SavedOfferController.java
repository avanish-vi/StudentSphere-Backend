package com.studentsphere.controller;

import com.studentsphere.entity.Offer;
import com.studentsphere.service.SavedOfferService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173")
public class SavedOfferController {

    private final SavedOfferService savedOfferService;

    public SavedOfferController(
            SavedOfferService savedOfferService
    ) {
        this.savedOfferService =
                savedOfferService;
    }

    @GetMapping(
            "/{userId}/saved-offers"
    )
    public List<Offer> getSavedOffers(
            @PathVariable Long userId
    ) {

        return savedOfferService
                .getSavedOffers(userId);
    }

    @PostMapping(
            "/{userId}/saved-offers/{offerId}"
    )
    public Offer saveOffer(
            @PathVariable Long userId,
            @PathVariable Long offerId
    ) {

        return savedOfferService
                .saveOffer(
                        userId,
                        offerId
                );
    }

    @DeleteMapping(
            "/{userId}/saved-offers/{offerId}"
    )
    public void removeSavedOffer(
            @PathVariable Long userId,
            @PathVariable Long offerId
    ) {

        savedOfferService
                .removeOffer(
                        userId,
                        offerId
                );
    }
}