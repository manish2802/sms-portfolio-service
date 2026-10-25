package com.professionalit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name="PORTFOLIO_SUMMARY")
@Data
public class PortfolioSummary {	

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "portfolio_seq")
    @SequenceGenerator(name = "portfolio_seq",
            sequenceName = "portfolio_seq",
            allocationSize = 1)
    private Long id;
			
    private Long userId;

    private String stockSymbol;

    private Integer quantity;

    private Double avgPrice;

    private Double currentPrice;

    private Double profitLoss;
}