package problem;

import java.util.List;

import algorithm.Action;
import algorithm.Limit;
import algorithm.Node;
import algorithm.Solution;
import model.Model;

public interface Problem {

	public String getInitialState();

	public void setInitialState(String state);

	public String getGoalState();

	public boolean goalTest(String state);

	public List<Action> getActions(String state);

	public Node getNode();

	public Model getModel();

	public Limit getLimit();

	public void setLimit(Limit limit);

	public Solution getSolution();

	public void setSolution(Solution solution);		

}
