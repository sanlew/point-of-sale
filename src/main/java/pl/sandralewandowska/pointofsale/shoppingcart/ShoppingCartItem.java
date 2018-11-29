package pl.sandralewandowska.pointofsale.shoppingcart;

import java.math.BigDecimal;

import pl.sandralewandowska.pointofsale.model.Product;
import pl.sandralewandowska.pointofsale.tool.CalculatingAmount;

public class ShoppingCartItem {
	
	private Product product;
	private int quantity;
	private BigDecimal amountItem;
	
	public ShoppingCartItem(Product product) {
		this.product = product;
		this. quantity = 1;
		this.amountItem = product.getPrice();
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getAmountItem() {
		return amountItem;
	}
	public void setAmountItem(BigDecimal amountItem) {
		this.amountItem = amountItem;
	}

	public String toMessageString() {
		return this.product.getName() + " " + this.quantity + " * " + CalculatingAmount.roundPrice(this.product.getPrice());
	}
}
