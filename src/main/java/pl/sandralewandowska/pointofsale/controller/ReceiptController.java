package pl.sandralewandowska.pointofsale.controller;

import pl.sandralewandowska.pointofsale.shoppingcart.ShoppingCart;
import pl.sandralewandowska.pointofsale.tool.CalculatingAmount;

public class ReceiptController {
	
	private PrinterController printerController = new PrinterController();
	private ShoppingCartController shoppingCartController = new ShoppingCartController();
	
	
	public void prepareReceipt() {
		ShoppingCart shoppingCart = shoppingCartController.getShoppingCart();
		CalculatingAmount.sumAll(shoppingCart);
		printerController.printSummaryLcd(shoppingCart);
		printerController.printSummaryPrinter(shoppingCart);
	}
	
	
	

}
