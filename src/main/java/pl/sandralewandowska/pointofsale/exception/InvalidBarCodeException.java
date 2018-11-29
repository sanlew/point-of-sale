package pl.sandralewandowska.pointofsale.exception;

public class InvalidBarCodeException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5261219267331277801L;

	public InvalidBarCodeException(String message) {
		   super(message);
		}
}
