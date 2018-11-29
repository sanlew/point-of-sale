package pl.sandralewandowska.pointofsale.service;

import java.util.List;
import java.util.Optional;

import pl.sandralewandowska.pointofsale.database.DbConnection;
import pl.sandralewandowska.pointofsale.database.DbMock;
import pl.sandralewandowska.pointofsale.exception.ProductNotFoundException;
import pl.sandralewandowska.pointofsale.model.Product;

public class ProductServiceImpl implements ProductService{

	private DbConnection dbConnection = DbMock.getDbMock();
	private static final String MESSAGE = "Product not found: ";
	@Override
	public Optional<Product> findProductByBarCode(String barCode) {
		Product productByBarCode = findAll().stream()
				  .filter(product -> barCode.equals(product.getBarCode()))
				  .findFirst()
				  .<ProductNotFoundException>orElseThrow(() -> 
				  		{throw new ProductNotFoundException(MESSAGE + barCode);});
		return Optional.ofNullable(productByBarCode);
		
	}

	@Override
	public List<Product> findAll() {
		return dbConnection.getProducts();
	}

	

}
