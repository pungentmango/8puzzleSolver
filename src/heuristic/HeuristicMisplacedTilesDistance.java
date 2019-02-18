package heuristic;

import model.Index;
import model.Model;
import model._8PuzzleModel;
import problem.Problem;

// "Heuristic 2"
public class HeuristicMisplacedTilesDistance implements Heuristic {

	@Override
	public int getHeuristicValue(Problem problem, String state1, String state2) {
		Model model1 = problem.getModel().setState(state1);
		Model model2 = problem.getModel().setState(state2);
		int totalDistance = 0;
		for (int tileCount = 0; tileCount < _8PuzzleModel.ROWS * _8PuzzleModel.COLS; tileCount++) {
			totalDistance += getDistance(model1.getIndex(tileCount), model2.getIndex(tileCount));
		}
		return totalDistance;
	}

	// uses Manhattan distance
	private static int getDistance(Index index1, Index index2) {
		return Math.abs(index1.row - index2.row) + Math.abs(index1.col - index2.col);
	}

}
