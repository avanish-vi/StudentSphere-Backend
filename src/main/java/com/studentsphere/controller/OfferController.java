package com.studentsphere.controller;

import com.studentsphere.entity.Offer;
import com.studentsphere.service.OfferService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/offers")
public class OfferController {

    private final OfferService offerService;

    public OfferController(
            OfferService offerService
    ) {
        this.offerService =
                offerService;
    }

    @GetMapping
    public List<Offer> getAllOffers() {

        return offerService.getAllOffers();
    }

    @GetMapping("/{id}")
    public Offer getOfferById(
            @PathVariable Long id
    ) {

        return offerService
                .getOfferById(id);
    }
}