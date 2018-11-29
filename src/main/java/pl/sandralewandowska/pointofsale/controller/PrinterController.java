package pl.sandralewandowska.pointofsale.controller;

import pl.sandralewandowska.pointofsale.device.output.InfoPrinter;
import pl.sandralewandowska.pointofsale.device.output.LcdDisplay;
import pl.sandralewandowska.pointofsale.device.output.Printer;
import pl.sandralewandowska.pointofsale.device.output.SummaryPrinter;
import pl.sandralewandowska.pointofsale.shoppingcart.ShoppingCart;

public class PrinterController {

	private InfoPrinter infoPrinterLcd = LcdDisplay.getLcdDisplay();
	private SummaryPrinter sumaryPrinterDevice = Printer.getPrinter();
	private SummaryPrinter sumaryPrinterLcd = LcdDisplay.getLcdDisplay();
	
	public void printInfoLcd(String message) {
		infoPrinterLcd.printMessage(message);
	}
	
	public void printSummaryLcd(ShoppingCart shoppingCart) {
		sumaryPrinterLcd.printSummary(shoppingCart);
	}
	
	public void printSummaryPrinter(ShoppingCart shoppingCart) {
		sumaryPrinterDevice.printSummary(shoppingCart);
	}
}
