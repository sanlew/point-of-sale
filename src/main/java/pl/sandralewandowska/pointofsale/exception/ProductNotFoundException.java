package pl.sandralewandowska.pointofsale.exception;

public class ProductNotFoundException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1214198264233924465L;

	public ProductNotFoundException(String message) {
		   super(message);
		}
}
