package pl.sandralewandowska.pointofsale.device.output;

import pl.sandralewandowska.pointofsale.shoppingcart.ShoppingCart;

public interface SummaryPrinter {

	public void printSummary(ShoppingCart shoppingCart);
}
