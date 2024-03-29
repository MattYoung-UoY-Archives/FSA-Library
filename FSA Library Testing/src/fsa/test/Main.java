package fsa.test;

import mjy.fsa.DFA;
import mjy.fsa.Edge;
import mjy.fsa.State;

public class Main {

	public static void main(String[] args) {
		
		State dfa1_q0init = new State("q0", false);
		State dfa1_q1 = new State("q1", true);
		
		State[] dfa1states = {dfa1_q0init, dfa1_q1};
		
		DFA dfa1 = new DFA("dfa1", dfa1_q0init, dfa1states);
		
		Edge[] dfa1q0edges = {new Edge('a', () -> {}, dfa1_q1)};
		dfa1.setEdges(dfa1_q0init, dfa1q0edges);
		
		Edge[] dfa1q1edges = {new Edge('a', () -> {}, dfa1_q0init)};
		dfa1.setEdges(dfa1_q1, dfa1q1edges);
		
		System.out.println(dfa1);
		
		Edge[] faultyEdgesQ1 = {new Edge('a', () -> {}, new State("q2", false))};
		
		//dfa1.addEdges(dfa1_q1, faultyEdgesQ1);
		dfa1.setEdges(new State("q3", true),  dfa1q0edges);
		
	}
	
}
