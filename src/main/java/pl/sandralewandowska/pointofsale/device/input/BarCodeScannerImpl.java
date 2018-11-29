package pl.sandralewandowska.pointofsale.device.input;

import java.util.Optional;

import pl.sandralewandowska.pointofsale.controller.PrinterController;
import pl.sandralewandowska.pointofsale.controller.ProductController;
import pl.sandralewandowska.pointofsale.controller.ShoppingCartController;
import pl.sandralewandowska.pointofsale.exception.InvalidBarCodeException;
import pl.sandralewandowska.pointofsale.model.Product;
import pl.sandralewandowska.pointofsale.service.ProductServiceImpl;

public class BarCodeScannerImpl implements BarCodeScanner{

	private ProductController productController = new ProductController(new ProductServiceImpl());
	private PrinterController printerController = new PrinterController();
	private ShoppingCartController shoppingCartController = new ShoppingCartController();
	
	private static final String MESSAGE = "Invalid bar-code";
	
	@Override
	public void scan(String barCode) {
		
		try {
			
		if(barCode!=null && !barCode.isEmpty()) {
			
			Optional<Product> product = productController.findProductByBarCode(barCode);
			product.ifPresent(p -> addProduct(product.get()));

		}
		else {
			 throw new InvalidBarCodeException(MESSAGE);
		}
		}catch(Exception e) {
			printerController.printInfoLcd(e.getMessage());
	        //e.printStackTrace();
		}
        
	}
	
	private void addProduct(Product product){
		shoppingCartController.addToShoppingCart(product);	
		printerController.printInfoLcd(product.toMessageString());
	}

}