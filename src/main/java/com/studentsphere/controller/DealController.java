package com.studentsphere.controller;

import com.studentsphere.entity.Deal;
import com.studentsphere.service.DealService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deals")
@CrossOrigin(origins = "http://localhost:5173")
public class DealController {

    private final DealService dealService;

    public DealController(
            DealService dealService
    ) {
        this.dealService =
                dealService;
    }

    @GetMapping
    public List<Deal> getAllDeals() {

        return dealService
                .getAllDeals();
    }

    @GetMapping("/{id}")
    public Deal getDealById(
            @PathVariable Long id
    ) {

        return dealService
                .getDealById(id);
    }
}