package pl.sandralewandowska.pointofsale.shoppingcart;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

private static ShoppingCart shoppingCart;
    
    private ShoppingCart(){}
    
    private Map<String, ShoppingCartItem> shoppingCartItems = new HashMap<>();
	private BigDecimal amountTotal;
	
    public static ShoppingCart getShoppingCart(){
        if(shoppingCart == null){
            shoppingCart = new ShoppingCart();
        }
        return shoppingCart;
    }
	

	public Map<String, ShoppingCartItem> getShoppingCartItems() {
		return shoppingCartItems;
	}


	public void setShoppingCartItems(Map<String, ShoppingCartItem> shoppingCartItems) {
		this.shoppingCartItems = shoppingCartItems;
	}


	public BigDecimal getAmountTotal() {
		return amountTotal;
	}


	public void setAmountTotal(BigDecimal amountTotal) {
		this.amountTotal = amountTotal;
	}


}
