package pl.sandralewandowska.pointofsale.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import pl.sandralewandowska.pointofsale.database.DbConnection;
import pl.sandralewandowska.pointofsale.database.DbMock;
import pl.sandralewandowska.pointofsale.exception.ProductNotFoundException;
import pl.sandralewandowska.pointofsale.model.Product;
import pl.sandralewandowska.pointofsale.service.ProductServiceImpl;

public class ProductControllerInitDbTest {

	private ProductController productController = new ProductController(new ProductServiceImpl());
	
	@Before
	public void initDb() {
		 DbConnection dbConnection = DbMock.getDbMock();
		 dbConnection.mockData();
	}
	
	@Test
	public void testFindAll() {
		List<Product> actual = productController.findAll();
		
		Assert.assertFalse(actual.isEmpty());
	}
	
	@Test(expected = ProductNotFoundException.class)
	public void testFindProductByBarCodeException() {
		productController.findProductByBarCode("123123");
	}
	
	@Test(expected = NullPointerException.class)
	public void testFindProductByBarCodeNull() {
		productController.findProductByBarCode(null);
	}
	
	@Test
	public void testFindProductByBarCode() {
		Optional<Product> actual = productController.findProductByBarCode("112233");
		Product expected = new Product((long) 1,"112233", "mysz", new BigDecimal("30.00"));
		Assert.assertEquals(actual, Optional.ofNullable(expected));
	}

}
