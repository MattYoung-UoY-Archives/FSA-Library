package mjy.fsa;

/**
 * Represents an edge to a state using a given transition function and consuming 
 * a given character.
 * 
 * @since 08/07/2019
 * @author Matt
 */
public abstract class Edge {

	/**
	 * The symbol consumed when transitioning to the next state.
	 */
	private char transitionSymbol;
	/**
	 * The transition function to execute during the transition between states.
	 */
	private TransitionFunction transition;
	//To be added when the State class is implemented
	//private State NextState;
	
	/**
	 * Creates a new edge that consumes the given symbol and executes the given 
	 * transition function during the transition between states.
	 * @param transitionSymbol The symbol to consume.
	 * @param transition The transition function to execute.
	 */
	public Edge(char transitionSymbol, TransitionFunction transition) {
		this.transitionSymbol = transitionSymbol;
		this.transition = transition;
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
	
}
