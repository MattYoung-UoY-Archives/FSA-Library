package mjy.fsa.exceptions;

/**
 * This exception is used when an invalid state is used.
 * 
 * @since 09/07/2019
 * @author Matt Young
 */
public class InvalidStateException extends Exception{
	private static final long serialVersionUID = 1L;

	/**
	 * Sets the detail message to be displayed alongside the Stack Trace.
	 * @param message Message to be displayed alongside the Stack Trace.
	 */
	public InvalidStateException(String message) {
		super(message);
	}
	
}
