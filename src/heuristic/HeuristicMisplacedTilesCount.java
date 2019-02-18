package heuristic;

import model.Model;
import model._8PuzzleModel;
import problem.Problem;

// "Heuristic 1"
public class HeuristicMisplacedTilesCount implements Heuristic {

	@Override
	public int getHeuristicValue(Problem problem, String state1, String state2) {
		Model model1 = problem.getModel().setState(state1);
		Model model2 = problem.getModel().setState(state2);
		int misplacedTiles = 0;
		for (int i = 0; i < _8PuzzleModel.ROWS; i++) {
			for (int j = 0; j < _8PuzzleModel.COLS; j++) {
				if (model1.getValue(i, j) != model2.getValue(i, j)) {
					misplacedTiles++;
				}
			}
		}
		return misplacedTiles;
	}

}
