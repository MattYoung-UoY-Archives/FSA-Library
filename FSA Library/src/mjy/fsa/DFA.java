package mjy.fsa;

/**
 * This class implements a Deterministic FSA.
 * 
 * @since 09/07/2019
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

}
