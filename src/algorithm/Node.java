package algorithm;

public interface Node extends Comparable<Node> {

	public String getState();

	public void setState(String state);

	public String getParentState();

	public void setParentState(String string);

	public int getCost();

	public int getPathCost();

	public void setCost(int cost);

	public void setPathCost(int pathCost);

	@Override
	public boolean equals(Object obj);

	@Override
	public int hashCode();
}
