package com.risf.SalesTaxes;

import com.risf.SalesTaxes.domain.BasicItem;
import com.risf.SalesTaxes.domain.Basket;
import com.risf.SalesTaxes.domain.ImportItem;
import com.risf.SalesTaxes.domain.Item;
import com.risf.SalesTaxes.printer.ReceiptPrinter;
import com.risf.SalesTaxes.service.BasketService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SalestTaxesApplicationTests {

	@Resource
	private BasketService basketService;

	@Test
	public void firstInput() {
		List<Item> items = new ArrayList<>();
		items.add(new BasicItem("book", 12.49, true, 1));
		items.add(new BasicItem("music CD", 14.99, false, 1));
		items.add(new BasicItem("chocolate bar", 0.85, true, 1));

		Basket basket = new Basket(items);
		basket.setTotalAmount(basketService.calculateTotalAmount(basket));
		basket.setTotalTaxes(basketService.calculateTotalTaxes(basket));

		ReceiptPrinter receiptPrinter = new ReceiptPrinter(basket);
		receiptPrinter.print();
	}

	@Test
	public void secondInput() {
		List<Item> items = new ArrayList<>();
		items.add(new ImportItem("box of chocolates", 10, true, 1));
		items.add(new ImportItem("bottle of perfume", 47.50, false, 1));

		Basket basket = new Basket(items);
		basket.setTotalAmount(basketService.calculateTotalAmount(basket));
		basket.setTotalTaxes(basketService.calculateTotalTaxes(basket));

		ReceiptPrinter receiptPrinter = new ReceiptPrinter(basket);
		receiptPrinter.print();
	}

	@Test
	public void thirdInput() {
		List<Item> items = new ArrayList<>();
		items.add(new ImportItem("bottle of perfume", 27.99, false, 1));
		items.add(new BasicItem("bottle of perfume", 18.99, false, 1));
		items.add(new BasicItem("packet of headache pills", 9.75, true, 1));
		items.add(new ImportItem("box of chocolates", 11.25, true, 1));

		Basket basket = new Basket(items);
		basket.setTotalAmount(basketService.calculateTotalAmount(basket));
		basket.setTotalTaxes(basketService.calculateTotalTaxes(basket));

		ReceiptPrinter receiptPrinter = new ReceiptPrinter(basket);
		receiptPrinter.print();
	}

	@Test
	public void testTotalTaxesMultipleItems() {
		// Arrange
		List<Item> items = new ArrayList<>();
		items.add(new BasicItem("book", 12.49, true, 1));
		items.add(new BasicItem("perfume", 12.49, false, 1));
		Basket basket = new Basket(items);

		double totalTaxes = basketService.calculateTotalTaxes(basket);

		assertEquals(1.25, totalTaxes, 0.001);
	}

	@Test
	public void testTotalAmountMultipleItems() {
		// Arrange
		List<Item> items = new ArrayList<>();
		items.add(new BasicItem("book", 12.49, true, 1));
		items.add(new BasicItem("perfume", 12.49, false, 1));
		Basket basket = new Basket(items);

		double totalAmount = basketService.calculateTotalAmount(basket);

		assertEquals(26.23, totalAmount, 0.001);
	}

}
