package pl.sandralewandowska.pointofsale.controller;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pl.sandralewandowska.pointofsale.database.DbConnection;
import pl.sandralewandowska.pointofsale.database.DbMock;
import pl.sandralewandowska.pointofsale.model.Product;
import pl.sandralewandowska.pointofsale.shoppingcart.ShoppingCartItem;

public class ShoppingCartControllerTest {

	private ShoppingCartController shoppingCartController = new ShoppingCartController();
	private Product exampleProduct = new Product((long) 1,"112233", "mysz", new BigDecimal("30.00"));
	
	@Before
	public void initDb() {
		 DbConnection dbConnection = DbMock.getDbMock();
		 dbConnection.mockData();
	}
	
	@Test
	public void addToShoppingCartNewElementTest() {
		shoppingCartController.addToShoppingCart(exampleProduct);
		ShoppingCartItem actual = shoppingCartController.getShoppingCart().getShoppingCartItems().get(exampleProduct.getBarCode());
		Assert.assertNotNull(actual);
	}
	
	@Test
	public void addToShoppingCartIncreaseQuantity() {
		shoppingCartController.addToShoppingCart(exampleProduct);
		ShoppingCartItem actual = shoppingCartController.getShoppingCart().getShoppingCartItems().get(exampleProduct.getBarCode());
		Assert.assertEquals(2, actual.getQuantity());
	}
}
