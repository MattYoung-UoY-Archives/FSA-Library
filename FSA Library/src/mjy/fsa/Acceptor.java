package mjy.fsa;

import java.util.ArrayList;
import java.util.List;

import mjy.fsa.exceptions.InvalidInputException;

/**
 * @since 10/08/2019
 * @author Matt
 *
 * Used to execute an FSA as a string acceptor.
 */
public class Acceptor {

	/**
	 * Executes a DFA as a string acceptor using the specified input.
	 * 
	 * @param dfa DFA to use as the acceptor.
	 * @param input Input string to the DFA.
	 * @param execIfAccepted Weather the transition function code should be executed during a transition or after the string has been accepted.
	 * @return True if the string is accepted.
	 */
	public static boolean execute(DFA dfa, String input, boolean execIfAccepted){
		String inputString = input;
		List<TransitionFunction> transitions = new ArrayList<TransitionFunction>();
		char currentSymbol;
		State currentState = dfa.initialState;
		while(!(inputString.equals(""))) {
			currentSymbol = inputString.charAt(0);
			inputString = inputString.replaceFirst(String.valueOf(currentSymbol), "");
			Edge next;
			try {
				next = nextEdge(currentState, currentSymbol);
			} catch (InvalidInputException e) {
				return false;
			}
			if(execIfAccepted) transitions.add(next.getTransition());
			else next.getTransition().transtion();
			currentState = next.getNextState();
		}
		if(!currentState.isFinalState()) return false;
		if(execIfAccepted) {
			for(TransitionFunction func: transitions) func.transtion();
		}
		return true;
	}
	
	private static Edge nextEdge(State currentState, char symbol) throws InvalidInputException {
		Edge[] edges = currentState.getOutgoingEdges();
		for(Edge currentEdge: edges) {
			if(currentEdge.getTransitionSymbol() == symbol) {
				return currentEdge;
			}
		}
		throw new InvalidInputException("Symbol " + symbol + " not on an outgoing edge from " + currentState + "!");
	}
	
}
