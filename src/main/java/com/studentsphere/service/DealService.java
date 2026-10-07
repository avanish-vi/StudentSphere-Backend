package com.studentsphere.service;

import com.studentsphere.entity.Deal;
import com.studentsphere.repository.DealRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealService {

    private final DealRepository dealRepository;

    public DealService(
            DealRepository dealRepository
    ) {
        this.dealRepository =
                dealRepository;
    }

    public List<Deal> getAllDeals() {

        return dealRepository.findAll();
    }

    public Deal getDealById(
            Long id
    ) {

        return dealRepository
                .findById(id)
                .orElseThrow(
                        () -> new RuntimeException(
                                "Deal not found."
                        )
                );
    }
}