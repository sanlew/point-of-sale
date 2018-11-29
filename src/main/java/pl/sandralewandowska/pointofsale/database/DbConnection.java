package pl.sandralewandowska.pointofsale.database;

import java.util.List;

import pl.sandralewandowska.pointofsale.model.Product;

public abstract class DbConnection {

	
	public final void mockData() {
		//conectDb()
		insertData();
		}
	
	 public abstract void insertData();
	 public abstract List<Product> getProducts();
	
}
