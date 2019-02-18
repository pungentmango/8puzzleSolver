package model;

import algorithm.Action;

public class Index implements Action {

	public int row;
	public int col;
	private static final int COST = 1;

	public int getCost() {
		return COST;
	}

	public Index getIndex() {
		return this;
	}

	public Index() {
		this.row = -1;
		this.col = -1;
	}

	public Index(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public Index plus(Index index) {
		Index newIndex = new Index();
		newIndex.row = this.row + index.row;
		newIndex.col = this.col + index.col;
		return newIndex;
	}

	public Index minus(Index index) {
		Index newIndex = new Index();
		newIndex.row = this.row - index.row;
		newIndex.col = this.col - index.col;
		return newIndex;
	}

	public boolean equals(Index index) {
		return this.row == index.row && this.col == index.col;
	}

}
