package pl.sandralewandowska.pointofsale.device.output;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.SimpleDoc;

import pl.sandralewandowska.pointofsale.shoppingcart.ShoppingCart;
import pl.sandralewandowska.pointofsale.tool.CalculatingAmount;

public class Printer implements SummaryPrinter{

	private static Printer printer;

	private Printer(){}
	
	public static Printer getPrinter(){
	        if(printer == null){
	        	printer = new Printer();
	        }
	        return printer;
	    }
	private String receiptString = "\nReceipt\n";
	
	public String getReceiptString() {
		return receiptString;
	}

	public void setReceiptString(String receiptString) {
		this.receiptString = receiptString;
	}

	public void printSummary(ShoppingCart shoppingCart) {
		
		readData(shoppingCart);
		Doc myDoc = prepareDocumet();
		print(myDoc);
		
	}
	
	private void print(Doc doc) {
		// create a print job
		System.out.println(getReceiptString());
		
	}

	private Doc prepareDocumet() {
		DocFlavor myFormat = DocFlavor.INPUT_STREAM.TEXT_PLAIN_UTF_8;
		InputStream inputStream = new ByteArrayInputStream(getReceiptString().getBytes());
		return new SimpleDoc(inputStream, myFormat, null); 
	}

	private String readData(ShoppingCart shoppingCart) {
		
		
		shoppingCart.getShoppingCartItems().forEach(((k,v)->{
			addToReceiptString(v.toMessageString()+"\n");
			}));
		receiptString+="------------\nTOTAL: "+CalculatingAmount.roundPrice(shoppingCart.getAmountTotal());
		
		return receiptString;
		
	}

	private void addToReceiptString(String string) {
		receiptString+=string;
		
	}

}
