package mjy.fsa;

import java.util.Arrays;
import java.util.List;

import mjy.fsa.exceptions.InvalidStateException;

/**
 * This class implements a Deterministic FSA.
 * 
 * @since 10/08/2019
 * @author Matt Young
 */
public class DFA extends FSA{

	/**
	 * Sets the Initial State and the list of states as well as the Label.
	 * @param initialState Initial State of the DFA.
	 * @param states List of states in the DFA.
	 * @param label Label for the DFA.
	 */
	public DFA(String label, State initialState, State[] states) {
		super(label, initialState, states);
	}
	
	@Override
	public void setEdges(State state, Edge[] edges) {
		if(causesNonDeterminism(edges)) throw new IllegalArgumentException("Adding the edges " + Arrays.toString(edges) + " to " + state.getLabel() + " will cause non-determinism!");
		try {
			List<State> temp = Arrays.asList(states);
			int index = temp.indexOf(state);
			if (index < 0)
				throw new InvalidStateException("State (" + state + ") not in the FSA " + label + "!\n" + this);
			for (Edge edge : edges) {
				if (!(temp.contains(edge.getNextState()))) {
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
	
}
