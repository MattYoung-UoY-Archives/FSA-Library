package mjy.fsa;

@FunctionalInterface
/**
 * @author Matt
 *
 * Used to execute an action when transitioning between states.
 */
public interface TrasitionFunction {

	/**
	 * Used to implement the transition function between states.
	 */
	public void transtion();
	
}
