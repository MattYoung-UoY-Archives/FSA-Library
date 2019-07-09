package mjy.fsa;

/**
 * This class implements a Non-Deterministic FSA.
 * 
 * @since 09/07/2019
 * @author Matt Young
 */
public class NDFA extends FSA{

	/**
	 * Sets the Initial State and the list of states as well as the Label.
	 * @param initialState Initial State of the NDFA.
	 * @param states List of states in the NDFA.
	 * @param label Label for the NDFA.
	 */
	public NDFA(String label, State initialState, State[] states) {
		super(label, initialState, states);
	}

}
