package model;

public interface Model extends Comparable<Model>  {

	public Model setState(String state);

	public String getState();
	
	public Index getIndex(int val);

	public boolean inBounds(Index index);
	
	public String performAction(Index index);

	void swap(Index i1, Index i2);
	
	public boolean equals(String state);

	public int getValue(int i, int j);

	public boolean canMove(Index action);

}
