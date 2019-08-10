package mjy.fsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mjy.fsa.exceptions.InvalidStateException;
import mjy.fsa.exceptions.InvalidStructureException;

/**
 * This is the template class for a FSA.
 * 
 * @since 10/08/2019
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
	 * Sets the Initial State and the list of states as well as the Label.
	 * @param initialState Initial State of the FSA.
	 * @param states List of states in the FSA.
	 * @param label  Label for the FSA.
	 * @throws InvalidStructureException if the initial state is not specified in the list of states provided.
	 */
	protected FSA(String label, State initialState, State[] states) {
		this.initialState = initialState;
		this.states = states;
		if(!Arrays.asList(states).contains(initialState)) {
			try{
				throw new InvalidStructureException("The Initial State (" + initialState + ") is not contained in the list of states " + Arrays.toString(states));
			}catch (InvalidStructureException e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
		this.label = label;
	}

	/**
	 * Sets the state's edges.
	 * @param state State to set the edges to.
	 * @param edges Edges to set.
	 * @throws InvalidStateException if the state is not contained in the FSA or an edge leads to a state not in the FSA.
	 * @throws IllegalArgumentException if the FSA should be deterministic, and adding the edges to the state would cause non-determinism.
	 */
	public void setEdges(State state, Edge[] edges) {
		try {
			List<State> temp = Arrays.asList(states);
			int index = temp.indexOf(state);
			if (index < 0)
				throw new InvalidStateException("State (" + state + ") not in the FSA " + label + "!\n" + this);
			for (Edge edge : edges) {
				if (!(Arrays.asList(states).contains(edge.getNextState()))) {
					throw new InvalidStateException(
							"State (" + edge.getNextState() + ") is not in the FSA " + label + "!");
				}
			}
			states[index].setOutgoingEdges(edges);
		} catch (InvalidStateException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	public String toString() {
		return "FSA: " + label + "\nInitial State: " + initialState + "\nStates: " + Arrays.toString(states);
	}

	/**
	 * Tests if the edges will cause non-determinism.
	 * @param edges Edges to test.
	 * @return True if these edges will cause non-determinism.
	 */
	protected static boolean causesNonDeterminism(Edge[] edges) {
		List<Character> symbols;
			symbols = new ArrayList<Character>();
			for(Edge edge: edges) {
				if(symbols.contains(edge.getTransitionSymbol())) return true;
				symbols.add(edge.getTransitionSymbol());
			}
		return false;
	}
	
}
