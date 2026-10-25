package com.professionalit.event;

import java.time.LocalDateTime;

public record TradeExecutedEvent(

		Long tradeId, Long userId, String stockSymbol, Integer quantity, Double price, String tradeType,
		LocalDateTime tradeDate

) {
}