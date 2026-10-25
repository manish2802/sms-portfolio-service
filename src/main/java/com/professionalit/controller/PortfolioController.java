package com.professionalit.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.professionalit.entity.PortfolioSummary;
import com.professionalit.service.PortfolioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/portfolio")
@RequiredArgsConstructor
public class PortfolioController {

    private final PortfolioService service;

    @GetMapping("/{userId}")
    public List<PortfolioSummary> getPortfolio(
            @PathVariable Long userId){

        return service.getPortfolio(userId);

    }

}