package pl.sandralewandowska.pointofsale.database;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import pl.sandralewandowska.pointofsale.model.Product;

public class DbMock extends DbConnection{
	
	
	private static DbMock dbMock;
	private List<Product> products = new ArrayList<Product>();

	private DbMock(){}
	
	public static DbMock getDbMock(){
	        if(dbMock == null){
	        	dbMock = new DbMock();
	        }
	        return dbMock;
	    }
	 
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public void insertData(){
		products.add(new Product((long) 1,"112233", "mysz", new BigDecimal("30.00")));
		products.add(new Product((long) 2,"112244", "sluchawki", new BigDecimal("50.00")));
		products.add(new Product((long) 3,"112255", "klawiatura", new BigDecimal("70.00")));
		products.add(new Product((long) 4,"112266", "zasilacz", new BigDecimal("123.99")));
		products.add(new Product((long) 5,"112277", "plyta CD", new BigDecimal("1.99")));
	}
	
}
