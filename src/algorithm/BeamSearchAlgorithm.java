package algorithm;

import java.util.PriorityQueue;

import heuristic.Heuristic;
import problem.Problem;

public class BeamSearchAlgorithm extends AbstractSearchAlgorithm {

	private PriorityQueue<Node> children = new PriorityQueue<Node>();
	private Heuristic heuristic;
	private int beamWidth;

	public BeamSearchAlgorithm setHeuristic(Heuristic heuristic) {
		this.heuristic = heuristic;
		return this;
	}

	public BeamSearchAlgorithm setBeamWidth(int beamWidth) {
		this.beamWidth = beamWidth;
		return this;
	}

	public BeamSearchAlgorithm() {

	}

	public BeamSearchAlgorithm(Heuristic heuristic, int cutoff) {
		this.heuristic = heuristic;
		this.beamWidth = cutoff;
	}

	@Override
	public Solution search(Problem problem, Limit limit) {
		String state = problem.getInitialState();
		model = problem.getModel();// .setState(state);
		limit.reset();
		nodeMap.clear();
		// set initial node
		// evaluate the node
		// add node to the queue
		Node node = makeNode(state, problem);
		queue.clear();
		queue.add(node);
		Solution solution = recursiveSearch(problem, limit);
		problem.setSolution(solution);
		return solution;
	}

	private Solution recursiveSearch(Problem problem, Limit limit) {

		Solution solution = new Solution();
		solution.setSuccess(false);
		Node node;
		while (!limit.isLimit(nodeMap.size())) {
			// exhaust this level of the tree
			while (!queue.isEmpty()) {
				node = queue.remove();
				// check if any of the nodes are the goal state
				if (problem.goalTest(node.getState())) {
					nodeMap.put(node.getState(), node);
					// found a solution
					System.out.println("Found solution in " + nodeMap.size() + " nodes");
					solution.setNumNodes(nodeMap.size());
					solution.setSuccess(true);
					solution.setSolution(getActions(problem));
					return solution;
				}
				// add all children to a queue for the next level in the search
				// tree
				for (Action action : problem.getActions(node.getState())) {
					addAction(problem, node, action);
				}
			}
			// prune descendants, continue on next level of search
			pruneQueue();
			if (queue.isEmpty()) {
				return solution;
			}
		}
		return solution;

	}

	private void pruneQueue() {
		while (!children.isEmpty() && queue.size() < beamWidth) {
			// transfer node from children to current
			// once cutoff is reached, flush children and continue search
			Node child = children.remove();
			queue.add(child);
		}
		children.clear();
		return;
	}

	private void addAction(Problem problem, Node node, Action action) {
		// see what state the action results in
		String childState = model.setState(node.getState()).performAction(action.getIndex());
		// get the path cost
		// get the heuristic cost
		int heuristicCost = heuristic.getHeuristicValue(problem, childState, problem.getGoalState());

		if (!nodeMap.containsKey(childState)) {
			// add node
			Node childNode = problem.getNode();
			childNode.setState(childState);
			childNode.setCost(heuristicCost);
			childNode.setParentState(node.getState());
			children.add(childNode);
			nodeMap.put(node.getState(), node);
		}
	}

}
