package mjy.fsa.exceptions;

/**
 * This exception is used when invalid symbols are passed into a FSA.
 * 
 * @since 09/07/2019
 * @author Matt Young
 */
public class InvalidInputException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Sets the detail message to be displayed alongside the Stack Trace.
	 * @param message Message to be displayed alongside the Stack Trace.
	 */
	public InvalidInputException(String message) {
		super(message);
	}
	
}
