package pl.sandralewandowska.pointofsale.controller;

import java.util.List;
import java.util.Optional;

import pl.sandralewandowska.pointofsale.model.Product;
import pl.sandralewandowska.pointofsale.service.ProductService;

public class ProductController {
	
	private final ProductService  productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	public Optional<Product> findProductByBarCode(String barCode){
		return productService.findProductByBarCode(barCode);
	}
	
	public List<Product> findAll(){
		return productService.findAll();
	}
}
