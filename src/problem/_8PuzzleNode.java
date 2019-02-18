package problem;

import algorithm.Node;

public class _8PuzzleNode implements Node, Comparable<Node> {

	private String state;
	private String parentState = null;
	private int cost;
	private int pathCost;

	@Override
	public String getState() {
		return this.state;
	}

	@Override
	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String getParentState() {
		return this.parentState;
	}

	@Override
	public void setParentState(String parentState) {
		this.parentState = parentState;
	}

	@Override
	public int getCost() {
		return cost;
	}

	@Override
	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		Integer oCost = o.getCost();
		Integer cost = getCost();
		return cost.compareTo(oCost);
	}

	@Override
	public int getPathCost() {
		return pathCost;
	}

	@Override
	public void setPathCost(int pathCost) {
		this.pathCost = pathCost;

	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof _8PuzzleNode)) {
			return false;
		}
		if (obj == this) {
			return true;

		}
		return getState().equals(((_8PuzzleNode) obj).getState());
	}

	@Override
	public int hashCode() {
		int hash = 17;
		hash = 31 * hash + (null == state ? 0 : state.hashCode());
		return hash;
	}

}
