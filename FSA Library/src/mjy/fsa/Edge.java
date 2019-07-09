package mjy.fsa;

/**
 * Represents an edge to a state using a given transition function and consuming 
 * a given character.
 * 
 * @since 09/07/2019
 * @author Matt Young
 */
public class Edge {

	/**
	 * The symbol consumed when transitioning to the next state.
	 */
	private char transitionSymbol;
	/**
	 * The transition function to execute during the transition between states.
	 */
	private TransitionFunction transition;
	/**
	 * The next state to transition to.
	 */
	private State nextState;
	
	/**
	 * Creates a new edge that consumes the given symbol and executes the given 
	 * transition function during the transition between states.
	 * @param transitionSymbol The symbol to consume.
	 * @param transition The transition function to execute.
	 * @param nextState The next state to transition to.
	 */
	public Edge(char transitionSymbol, TransitionFunction transition, State nextState) {
		this.transitionSymbol = transitionSymbol;
		this.transition = transition;
		this.nextState = nextState;
	}

	/**
	 * @return The symbol consumed when using this edge.
	 */
	protected char getTransitionSymbol() {
		return transitionSymbol;
	}

	/**
	 * @return The transition function to execute when using this edge.
	 */
	protected TransitionFunction getTransition() {
		return transition;
	}

	/**
	 * @return The next state to transition to.
	 */
	protected State getNextState() {
		return nextState;
	}
	
	@Override
	public String toString() {
		return "(" + transitionSymbol + ", " + nextState.getLabel() + ")";
	}
	
}
