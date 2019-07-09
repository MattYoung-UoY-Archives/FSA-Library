package mjy.fsa;

import java.util.Arrays;

/**
 * Represents a state in the FSA.
 * 
 * @since 09/07/2019
 * @author Matt Young
 */
public class State {

	/**
	 * An array of all of the outgoing edges from this state.
	 */
	private Edge[] outgoingEdges = {};
	/**
	 * The label for this state.
	 */
	private String label;
	/**
	 * Represents if this state is a final state.
	 */
	private boolean finalState;
	
	/**
	 * Creates a new state that has the given label and final state status with
	 * an empty list of outgoing edges.
	 * @param label The label to assign to this state.
	 * @param finalState Represents if this state is a final state.
	 */
	public State(String label, boolean finalState) {
		this.label = label;
		this.finalState = finalState;
	}

	/**
	 * Sets the list of outgoing edges from this state.
	 * @param outgoingEdges
	 */
	protected void setOutgoingEdges(Edge[] outgoingEdges) {
		this.outgoingEdges = outgoingEdges;
	}
	
	/**
	 * Gets the array of outgoing edges.
	 * @return The array of outgoing edges.
	 */
	protected Edge[] getOutgoingEdges() {
		return outgoingEdges;
	}

	/**
	 * Gets the label of the state.
	 * @return The label of the state.
	 */
	protected String getLabel() {
		return label;
	}

	/**
	 * The final state status of this state
	 * @return The final state status
	 */
	protected boolean isFinalState() {
		return finalState;
	}
	
	@Override
	public String toString() {
		return label + ": Final=" + finalState + " Edges=" + Arrays.toString(outgoingEdges);
	}
	
}
