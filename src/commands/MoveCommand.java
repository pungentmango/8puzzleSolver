package commands;

import model.Index;
import model.Model;
import util.Movement;

public class MoveCommand extends Command {

	public static final String UP = "up";
	public static final String DOWN = "down";
	public static final String LEFT = "left";
	public static final String RIGHT = "right";

	private Index moveIndex = null;
	private static final String COMMAND_NAME = "move";

	@Override
	public Command parse(String input) {
		switch (input.toLowerCase()) {
		case UP:
			moveIndex = Movement.UP;
			System.out.println("Attempting to move UP");
			break;
		case DOWN:
			moveIndex = Movement.DOWN;
			System.out.println("Attempting to move DOWN");
			break;
		case LEFT:
			moveIndex = Movement.LEFT;
			System.out.println("Attempting to move LEFT");
			break;
		case RIGHT:
			moveIndex = Movement.RIGHT;
			System.out.println("Attempting to move RIGHT");
			break;
		default:
			System.out.println("invalid direction " + input);
			break;
		}
		return this;
	}

	@Override
	public Command execute() {
		if (moveIndex == null) {
			return this;
		}
		// verify that the index is in the limits
		Model model = problem.getModel().setState(problem.getInitialState());
		Index index = model.getIndex(0);
		if (index != null) {
			Index swapIndex = index.plus(moveIndex);
			if (model.inBounds(swapIndex)) {
				model.swap(index, swapIndex);
			} else {
				System.out.println("Invalid move at state " + model);
			}
		}
		problem.setInitialState(model.getState());
		return this;
	}

	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}

}
