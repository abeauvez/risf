package com.risf.SalesTaxes.service;

import com.risf.SalesTaxes.domain.Basket;
import com.risf.SalesTaxes.domain.Item;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BasketService {

	public double calculateTotalTaxes(final Basket basket) {
		return basket.getItems()
			.stream()
			.mapToDouble(Item::getTax)
			.sum();
	}

	public double calculateTotalAmount(final Basket basket) {
		return basket.getItems()
			.stream()
			.mapToDouble(item -> (item.getPrice() * item.getQuantity()) + item.getTax())
			.sum();
	}

}
