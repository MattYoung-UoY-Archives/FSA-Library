package mjy.fsa;

/**
 * Used to execute an action when transitioning between states.
 * 
 * @since 07/07/2019
 * @author Matt Young
 */
@FunctionalInterface
public interface TransitionFunction {

	/**
	 * Used to implement the transition function between states.
	 */
	public void transtion();
	
}
