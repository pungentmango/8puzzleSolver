package commands;

import java.util.Random;

import model.Index;
import model.Model;
import util.Movement;

public class RandomizeStateCommmand extends Command {

	private static final Long seed = new Long(101123123119910504L);
	private Random random = new Random(seed);
	private int numMoves;
	private Index[] moves = { Movement.UP, Movement.DOWN, Movement.LEFT, Movement.RIGHT };
	private Model model;

	private static final String COMMAND_NAME = "randomizeState";

	@Override
	public Command parse(String input) {
		this.numMoves = Integer.parseInt(input);
		return this;
	}

	@Override
	public Command execute() {
		int moveCount = 0;
		model = problem.getModel().setState(problem.getInitialState());
		System.out.println("Randomizing with " + numMoves + " moves");
		while (moveCount < numMoves) {
			// get a random direction
			int moveDirection = random.nextInt(moves.length);
			// get the movement corresponding to the direction
			Index moveIndex = moves[moveDirection];
			// try to move, if move is successful, then increment move count
			if (move(moveIndex)) {
				moveCount++;
			}
		}
		problem.setInitialState(model.getState());
		System.out.println("State after randomization:\n" + problem.getInitialState());
		return this;

	}

	private boolean move(Index moveIndex) {
		Index index = model.getIndex(0);
		if (index != null) {
			Index swapIndex = index.plus(moveIndex);
			if (model.inBounds(swapIndex)) {
				model.swap(index, swapIndex);
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}
}
