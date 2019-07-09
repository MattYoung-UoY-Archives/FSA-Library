package mjy.fsa;

import java.util.Arrays;
import java.util.List;

import mjy.fsa.exceptions.InvalidStateException;

/**
 * This is the template class for a FSA.
 * 
 * @since 09/07/2019
 * @author Matt Young
 */
abstract class FSA {
	
	/**
	 * This is the Initial State for the FSA.
	 */
	State initialState;
	/**
	 * This is the list of states in the FSA.
	 */
	State[] states;
	/**
	 * The label for the FSA.
	 */
	String label;
	
	/**
	 * Sets the Initial State and the list of states as well as the Label.	 * @param initialState Initial State of the FSA.
	 * @param states List of states in the FSA.
	 * @param label Label for the FSA.
	 */
	protected FSA(String label, State initialState, State[] states) {
		this.initialState = initialState;
		this.states = states;
		this.label = label;
	}
	
	/**
	 * Adds the edges to the state.
	 * @param state State to add the edges to.
	 * @param edges Edges to add to the state.
	 * @throws InvalidStateException if the state is not contained in the FSA.
	 */
	public void addEdges(State state, Edge[] edges) {
		List<State> temp = Arrays.asList(states);
		int index = temp.indexOf(state);
		if(index < 0)
			try {
				throw new InvalidStateException("State " + state + " not in the FSA " + label + "!\n" + this);
			} catch (InvalidStateException e) {
				e.printStackTrace();
			}
		else states[index].setOutgoingEdges(edges);
	}
	
	@Override
	public String toString() {
		return "FSA: " + label + "\nInitial State: " + initialState + "\nStates: " + Arrays.toString(states);
	}
	
}
