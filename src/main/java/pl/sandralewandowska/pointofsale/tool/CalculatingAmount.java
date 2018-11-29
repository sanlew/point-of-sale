package pl.sandralewandowska.pointofsale.tool;

import java.math.BigDecimal;
import java.util.Map;

import pl.sandralewandowska.pointofsale.shoppingcart.ShoppingCart;
import pl.sandralewandowska.pointofsale.shoppingcart.ShoppingCartItem;

public class CalculatingAmount {
	
	private CalculatingAmount(){}
	
	public static void sumAll(ShoppingCart shoppingCart) {
		BigDecimal amountTotal = sumAmountTotal(shoppingCart.getShoppingCartItems());
		shoppingCart.setAmountTotal(amountTotal);
	}
	
	private static BigDecimal sumAmountTotal(Map<String, ShoppingCartItem> map) {
		BigDecimal amountItem = BigDecimal.ZERO;
		BigDecimal amountTotal = BigDecimal.ZERO;
		
		for(ShoppingCartItem value:map.values()) {
			amountItem = sumAmountItem(value);
			value.setAmountItem(amountItem);
			amountTotal = amountTotal.add(amountItem);
		}
		return amountTotal;
	}

	private static BigDecimal sumAmountItem(ShoppingCartItem shoppingCartItem) {
		return shoppingCartItem.getProduct().getPrice().multiply(new BigDecimal(shoppingCartItem.getQuantity()));
	}
	
	public static BigDecimal roundPrice(BigDecimal bD) {
		 	return bD.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

}
