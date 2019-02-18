package model;

public class _8PuzzleModel implements Model, Comparable<Model> {

	public static final int ROWS = 3;
	public static final int COLS = 3;
	private int[][] puzzleRepresentation = new int[3][3];
	String state;

	public _8PuzzleModel() {
	}

	public _8PuzzleModel(String state) {
		setState(state);
	}

	@Override
	public Model setState(String state) {
		this.state = state;
		return parse();
	}

	private Model parse() {
		int index = 0;
		for (char c : state.toLowerCase().replaceAll("\\s+", "").toCharArray()) {
			switch (c) {
			case 'b':
				puzzleRepresentation[index / ROWS][index % ROWS] = 0;
				index++;
				break;
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
				int val = Integer.parseInt("" + c);
				puzzleRepresentation[index / ROWS][index % ROWS] = val;
				index++;
				break;
			default:
				System.out.println("invalid state " + c);
				break;
			}
		}
		return this;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				int val = puzzleRepresentation[i][j];
				String outputVal;
				if (val == 0) {
					outputVal = "b";
				} else {
					outputVal = String.valueOf(val);
				}
				builder.append(outputVal);
			}
			builder.append(" ");
		}
		return builder.toString();
	}

	@Override
	public void swap(Index i1, Index i2) {
		int tempVal = getValue(i1);
		setValue(i1, getValue(i2));
		setValue(i2, tempVal);
	}

	public int getValue(int row, int col) {
		return puzzleRepresentation[row][col];
	}

	public int getValue(Index index) {
		return getValue(index.row, index.col);
	}

	private void setValue(Index index, int val) {
		puzzleRepresentation[index.row][index.col] = val;
	}

	@Override
	public Index getIndex(int val) {
		Index index = new Index();
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				if (val == puzzleRepresentation[i][j]) {
					index.row = i;
					index.col = j;
					return index;
				}
			}
		}
		System.out.println("Could not find value " + val);
		return null;
	}

	@Override
	public boolean inBounds(Index index) {
		return (index.row >= 0 && index.col >= 0 && index.row < ROWS && index.col < COLS);
	}

	@Override
	public boolean equals(String state) {
		return this.state.equals(state);

	}

	@Override
	public String performAction(Index index) {
		_8PuzzleModel model = new _8PuzzleModel();
		model.setState(this.state);
		model.move(index);
		// System.out.println("new state " + state);
		return model.getState();
	}

	@Override
	public String getState() {
		return this.toString();
	}

	private void move(Index moveIndex) {
		Index index = getIndex(0);
		if (index != null) {
			Index swapIndex = index.plus(moveIndex);
			if (inBounds(swapIndex)) {
				swap(index, swapIndex);
			} else {
				System.out.println("Invalid move at state " + this.toString());
			}
		}
	}

	@Override
	public boolean canMove(Index moveIndex) {
		Index index = getIndex(0);
		if (index != null) {
			Index swapIndex = index.plus(moveIndex);
			if (inBounds(swapIndex)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int compareTo(Model o) {
		return o.toString().compareTo(this.toString());
	}

}
