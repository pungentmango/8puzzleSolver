package util;

import model.Index;
import model._8PuzzleModel;

public class Movement {

	public static final Index UP = new Index(-1, 0);
	public static final Index DOWN = new Index(1, 0);
	public static final Index LEFT = new Index(0, -1);
	public static final Index RIGHT = new Index(0, 1);

	public static String getMovement(String currentState, String parentState) {
		Index i1 = new _8PuzzleModel().setState(currentState).getIndex(0);
		Index i2 = new _8PuzzleModel().setState(parentState).getIndex(0);
		Index diff = i1.minus(i2);
		return indexToString(diff);
	}

	public static String indexToString(Index index) {
		if (index.equals(UP)) {
			return "UP";
		}
		if (index.equals(DOWN)) {
			return "DOWN";
		}
		if (index.equals(LEFT)) {
			return "LEFT";
		}
		if (index.equals(RIGHT)) {
			return "RIGHT";
		} else {
			return "UNKNOWN MOVE";
		}
	}

}
