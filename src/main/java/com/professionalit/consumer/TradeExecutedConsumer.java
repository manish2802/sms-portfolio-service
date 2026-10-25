package com.professionalit.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import com.professionalit.entity.PortfolioSummary;
import com.professionalit.event.TradeExecutedEvent;
import com.professionalit.repository.PortfolioRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TradeExecutedConsumer {

	private final PortfolioRepository repository;

	@KafkaListener(topics = "portfolio-updates", groupId = "portfolio-service")
	public void consume(TradeExecutedEvent event) {

		PortfolioSummary portfolio = repository.findByUserId(event.userId()).stream()
				.filter(p -> p.getStockSymbol().equals(event.stockSymbol())).findFirst().orElse(new PortfolioSummary());

		portfolio.setUserId(event.userId());
		portfolio.setStockSymbol(event.stockSymbol());
		portfolio.setQuantity(
				portfolio.getQuantity() == null ? event.quantity() : portfolio.getQuantity() + event.quantity());

		portfolio.setAvgPrice(event.price());

		repository.save(portfolio);

	}

}