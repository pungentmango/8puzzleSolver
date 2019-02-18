package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import model.Model;
import problem.Problem;

public abstract class AbstractSearchAlgorithm implements SearchAlgorithm {

	protected PriorityQueue<Node> queue = new PriorityQueue<Node>();
	protected Map<String, Node> nodeMap = new HashMap<String, Node>();
	protected Model model;

	protected Node makeNode(String state, Problem problem) {
		Node node = problem.getNode();
		node.setState(state);
		node.setCost(0);
		node.setPathCost(0);
		node.setParentState(null);
		return node;
	}

	protected List<Node> getActions(Problem problem) {
		List<Node> bestPath = new ArrayList<Node>();
		Node node = nodeMap.get(problem.getGoalState());
		bestPath.add(node);
		while (node.getParentState() != null) {
			node = nodeMap.get(node.getParentState());
			bestPath.add(0, node);
		}
		return bestPath;

	}

	public abstract Solution search(Problem problem, Limit limit);

}
