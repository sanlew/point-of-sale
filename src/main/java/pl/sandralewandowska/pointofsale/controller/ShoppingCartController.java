package pl.sandralewandowska.pointofsale.controller;

import java.util.Map;

import pl.sandralewandowska.pointofsale.model.Product;
import pl.sandralewandowska.pointofsale.shoppingcart.ShoppingCart;
import pl.sandralewandowska.pointofsale.shoppingcart.ShoppingCartItem;

public class ShoppingCartController {

	private ShoppingCart shoppingCart = ShoppingCart.getShoppingCart();
	private Map<String,ShoppingCartItem> shoppingCartItems = shoppingCart.getShoppingCartItems();
	
	public void addToShoppingCart(Product product){
		ShoppingCartItem shoppingCartItem = findShopingCartItemByBarCode(product.getBarCode());
		if(shoppingCartItem == null) {
			addNewProduct(product);
		}
		else {
			increaseQuantity(shoppingCartItem);
		}
	}
	
	private void addNewProduct(Product product){
		ShoppingCartItem shoppingCartItem = new ShoppingCartItem(product);
		shoppingCartItems.put(product.getBarCode(), shoppingCartItem);
	}
	
	private void increaseQuantity(ShoppingCartItem item) {
		item.setQuantity(item.getQuantity()+1);
	}
	
	private ShoppingCartItem findShopingCartItemByBarCode(String barCode) {
		return shoppingCartItems.get(barCode);
	}
	
	public void clearShoppingCart() {
		shoppingCart = null;
	}
	public ShoppingCart getShoppingCart() {
		return this.shoppingCart;
	}
}
