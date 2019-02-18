package heuristic;

import problem.Problem;

public interface Heuristic {

	public int getHeuristicValue(Problem problem, String state1, String state2);

}
