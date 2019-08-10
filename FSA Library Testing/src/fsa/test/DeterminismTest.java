package fsa.test;

import mjy.fsa.DFA;
import mjy.fsa.Edge;
import mjy.fsa.State;

public class DeterminismTest {

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
		
		
		State dfa2_q0init = new State("q0", false);
		State dfa2_q1 = new State("q1", true);
		
		State[] dfa2states = {dfa2_q0init, dfa2_q1};
		
		DFA dfa2 = new DFA("dfa2", dfa2_q0init, dfa2states);
		
		Edge[] dfa2q0edges = {new Edge('a', () -> {
			System.out.print("a");
		}, dfa2_q1)};
		dfa2.setEdges(dfa2_q0init, dfa2q0edges);
		
		Edge[] dfa2q1edges = {new Edge('a', () -> {
			System.out.print("a");
		}, dfa2_q0init),
				new Edge('a', () -> {
			System.out.println("a");
		}, dfa2_q1)};
		dfa2.setEdges(dfa2_q1, dfa2q1edges);
		
	}
	
}
