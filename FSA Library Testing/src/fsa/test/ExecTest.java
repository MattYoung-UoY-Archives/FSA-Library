package fsa.test;

import mjy.fsa.Acceptor;
import mjy.fsa.DFA;
import mjy.fsa.Edge;
import mjy.fsa.State;

public class ExecTest {

	public static void main(String[] args) {
		State dfa1_q0init = new State("q0", false);
		State dfa1_q1 = new State("q1", true);
		
		State[] dfa1states = {dfa1_q0init, dfa1_q1};
		
		DFA dfa1 = new DFA("dfa1", dfa1_q0init, dfa1states);
		
		Edge[] dfa1q0edges = {new Edge('a', () -> {
			System.out.print("a");
		}, dfa1_q1)};
		dfa1.setEdges(dfa1_q0init, dfa1q0edges);
		
		Edge[] dfa1q1edges = {new Edge('a', () -> {
			System.out.print("a");
		}, dfa1_q0init)};
		dfa1.setEdges(dfa1_q1, dfa1q1edges);
		
		System.out.println(dfa1 + "\n\n");
		
		System.out.println(Acceptor.execute(dfa1, "aaa", true));
		System.out.println(Acceptor.execute(dfa1, "aa", true));
	}
	
}
