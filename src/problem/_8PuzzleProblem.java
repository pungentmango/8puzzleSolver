package problem;

import java.util.ArrayList;
import java.util.List;

import algorithm.Action;
import algorithm.Limit;
import algorithm.Node;
import algorithm.Solution;
import model.Index;
import model.Model;
import model._8PuzzleModel;
import util.Movement;

public class _8PuzzleProblem implements Problem {

	private String initialState;
	private String goalState;
	private Limit limit;
	private Solution solution;

	private static List<Index> possibleActions = new ArrayList<Index>();
	static {
		possibleActions.add(Movement.UP);
		possibleActions.add(Movement.DOWN);
		possibleActions.add(Movement.LEFT);
		possibleActions.add(Movement.RIGHT);
	}

	public _8PuzzleProblem(String goalState) {
		this.goalState = goalState;
		this.limit = new Limit(10000);
	}

	@Override
	public String getInitialState() {
		return initialState;
	}

	@Override
	public String getGoalState() {
		return goalState;
	}

	@Override
	public boolean goalTest(String state) {
		return goalState.equals(state);
	}

	@Override
	public List<Action> getActions(String state) {
		List<Action> validActions = new ArrayList<Action>();
		// get list of all actions
		// for each action, determine if valid
		for (Index action : possibleActions) {
			if (getModel().setState(state).canMove(action)) {
				validActions.add(action);
			}
		}
		// return actions
		return validActions;
	}

	@Override
	public Node getNode() {
		return new _8PuzzleNode();
	}

	@Override
	public Model getModel() {
		return new _8PuzzleModel();
	}

	@Override
	public void setLimit(Limit limit) {
		this.limit = limit;
	}

	@Override
	public Limit getLimit() {
		return limit;
	}

	@Override
	public void setInitialState(String state) {
		this.initialState = getModel().setState(state).getState();
	}

	@Override
	public Solution getSolution() {
		return this.solution;
	}

	@Override
	public void setSolution(Solution solution) {
		this.solution = solution;
	}

}
