package com.professionalit.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.professionalit.entity.PortfolioSummary;
import com.professionalit.repository.PortfolioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PortfolioService {

    private final PortfolioRepository repository;

    public List<PortfolioSummary> getPortfolio(Long userId){

        return repository.findByUserId(userId);

    }

}