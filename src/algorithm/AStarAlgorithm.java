package algorithm;

import java.util.HashMap;
import java.util.Map;

import heuristic.Heuristic;
import problem.Problem;

public class AStarAlgorithm extends AbstractSearchAlgorithm {

	Map<Node, Integer> visitedNodes = new HashMap<Node, Integer>();
	private Heuristic heuristic;

	public AStarAlgorithm setHeuristic(Heuristic heuristic) {
		this.heuristic = heuristic;
		return this;
	}

	@Override
	public Solution search(Problem problem, Limit limit) {
		String state = problem.getInitialState();
		model = problem.getModel().setState(state);
		limit.reset();
		visitedNodes.clear();
		nodeMap.clear();
		// set initial node
		// evaluate the node
		// add node to the queue
		Node node = makeNode(state, problem);
		queue.clear();
		queue.add(node);
		visitedNodes.put(node, node.getCost());
		nodeMap.put(node.getState(), node);
		Solution solution = recursiveSearch(problem, limit);
		problem.setSolution(solution);
		return solution;
	}

	private Solution recursiveSearch(Problem problem, Limit limit) {

		Solution solution = new Solution();
		solution.setSuccess(false);
		Node node = queue.remove();
		while (!limit.isLimit(visitedNodes.size())) {
			if (problem.goalTest(node.getState())) {
				nodeMap.put(node.getState(), node);
				// found a solution
				System.out.println("Found solution in " + visitedNodes.size() + " nodes");
				solution.setNumNodes(visitedNodes.size());
				solution.setSuccess(true);
				solution.setSolution(getActions(problem));
				return solution;
			}
			// get all actions for the current state.
			for (Action action : problem.getActions(node.getState())) {
				addAction(problem, node, action);
			}
			// get next node
			// if empty, then failed.
			if (queue.isEmpty()) {
				return solution;
			}
			node = queue.remove();
		}
		return solution;
	}

	private void addAction(Problem problem, Node node, Action action) {
		// see what state the action results in
		String neighborState = model.setState(node.getState()).performAction(action.getIndex());
		// get the path cost
		int pathCost = node.getPathCost() + action.getCost();
		// get the heuristic cost
		int heuristicCost = heuristic.getHeuristicValue(problem, neighborState, problem.getGoalState());
		int cost = pathCost + heuristicCost;
		// check whether the new state has already been visited
		Node neighbor = problem.getNode();
		neighbor.setState(neighborState);
		boolean containsState = visitedNodes.containsKey(neighbor);
		// add state if: not visited yet OR visited already and new cost is less
		if (!containsState || (containsState && visitedNodes.get(neighbor) > cost)) {
			neighbor.setCost(cost);
			neighbor.setPathCost(pathCost);
			neighbor.setParentState(node.getState());
			queue.add(neighbor);
			visitedNodes.put(neighbor, neighbor.getCost());
			nodeMap.put(node.getState(), node);
		}
	}

}
