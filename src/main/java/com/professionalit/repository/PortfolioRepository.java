package com.professionalit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.professionalit.entity.PortfolioSummary;

@Repository
public interface PortfolioRepository
        extends JpaRepository<PortfolioSummary,Long>{

    List<PortfolioSummary> findByUserId(Long userId);

}