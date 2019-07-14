package mjy.fsa.exceptions;

/**
 * This exception is used when an invalid structure for an FSA is specified.
 * 
 * @since 14/07/2019
 * @author Matt Young
 */
public class InvalidStructureException extends Exception {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Sets the detail message to be displayed alongside the Stack Trace.
	 * @param message Message to be displayed alongside the Stack Trace.
	 */
	public InvalidStructureException(String message) {
		super(message);
	}
	
}
