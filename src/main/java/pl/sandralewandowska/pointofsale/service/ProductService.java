package pl.sandralewandowska.pointofsale.service;

import java.util.List;
import java.util.Optional;

import pl.sandralewandowska.pointofsale.model.Product;

public interface ProductService {
	
	public Optional<Product> findProductByBarCode(String barCode);
	
	public List<Product> findAll();
}
