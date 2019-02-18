package algorithm;

import java.util.List;

import util.Movement;

public class Solution {

	private boolean success;
	private int numMoves = 0;

	private int numNodes = 0;
	private List<Node> actions;

	public Solution setSolution(List<Node> actions) {
		this.actions = actions;
		this.numMoves = actions.size();
		return this;
	}

	public int getNumMoves() {
		return numMoves;
	}

	public int getNumNodes() {
		return numNodes;
	}

	public void setNumNodes(int numNodes) {
		this.numNodes = numNodes;
	}

	public List<Node> getSolution() {
		return actions;
	}

	public Solution setSuccess(boolean success) {
		this.success = success;
		return this;
	}

	public boolean getSuccess() {
		return success;
	}

	public Solution printSolution() {
		if (success) {
			for (Node node : actions) {
				if (node.getParentState() != null) {
					System.out.print(Movement.getMovement(node.getState(), node.getParentState()) + "\t");
				} else {
					System.out.print("INIT\t");
				}
				System.out.println(node.getState());
			}
		} else {
			System.out.println("no solution found!!");
		}
		return this;
	}

	public Solution printSolutionSize() {
		if (success) {
			System.out.println("moves to solve= " + actions.size());
		}
		return this;
	}
}
