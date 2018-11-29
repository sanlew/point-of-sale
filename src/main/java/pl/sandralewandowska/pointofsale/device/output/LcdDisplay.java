package pl.sandralewandowska.pointofsale.device.output;

import pl.sandralewandowska.pointofsale.shoppingcart.ShoppingCart;
import pl.sandralewandowska.pointofsale.tool.CalculatingAmount;

public class LcdDisplay implements SummaryPrinter, InfoPrinter{

	private static LcdDisplay lcdDisplay;

	private LcdDisplay(){}
	
	public static LcdDisplay getLcdDisplay(){
	        if(lcdDisplay == null){
	        	lcdDisplay = new LcdDisplay();
	        }
	        return lcdDisplay;
	    }
	
	private String messageToDisplay = "";
	
	@Override
	public void printSummary(ShoppingCart shoppingCart) {
		this.setMessageToDisplay("\nLCD Display:\n" +CalculatingAmount.roundPrice(shoppingCart.getAmountTotal()));
		print();
	}

	public void printMessage(String message) {
		this.setMessageToDisplay("\nLCD Display:\n" +message);
		print();
	}

	public String getMessageToDisplay() {
		return messageToDisplay;
	}

	public void setMessageToDisplay(String messageToDisplay) {
		this.messageToDisplay = messageToDisplay;
	}
	
	public void print() {
		System.out.println(getMessageToDisplay());
	}

}
