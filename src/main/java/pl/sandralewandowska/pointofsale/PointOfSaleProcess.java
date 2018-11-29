package pl.sandralewandowska.pointofsale;

import java.util.Scanner;

import pl.sandralewandowska.pointofsale.controller.ReceiptController;
import pl.sandralewandowska.pointofsale.controller.ShoppingCartController;
import pl.sandralewandowska.pointofsale.database.DbConnection;
import pl.sandralewandowska.pointofsale.database.DbMock;
import pl.sandralewandowska.pointofsale.device.input.BarCodeScanner;
import pl.sandralewandowska.pointofsale.device.input.BarCodeScannerImpl;

public class PointOfSaleProcess {

	private static final String EXIT = "exit";
	public void start() {

		ReceiptController receiptController = new ReceiptController();
		ShoppingCartController shoppingCartController = new ShoppingCartController();
		
		conectDb();
		
		System.out.println("Point of Sale simulator\nEnter bar-code or word \"exit\"");

		scanProducts();
		
		receiptController.prepareReceipt();
		//clearObjects();
		shoppingCartController.clearShoppingCart();
		
	}

	private static void scanProducts() {
		Scanner scanner = new Scanner(System.in);
		BarCodeScanner barCodeScanner = new BarCodeScannerImpl();
		
		String inputString = scanner.nextLine();
		while(!inputString.equals(EXIT)) {
			barCodeScanner.scan(inputString);
			inputString = scanner.nextLine();
		}
		scanner.close();
	}

	private static void conectDb() {
	    DbConnection dbConnection = DbMock.getDbMock();
		dbConnection.mockData();
	}
}
