package commands;

public class CommandFactory {

	public Command getCommand(String input) {
		if (Command.isCommand(new SetStateCommand(), input))
			return new SetStateCommand();

		if (Command.isCommand(new RandomizeStateCommmand(), input))
			return new RandomizeStateCommmand();

		if (Command.isCommand(new PrintStateCommand(), input))
			return new PrintStateCommand();

		if (Command.isCommand(new MoveCommand(), input))
			return new MoveCommand();

		if (Command.isCommand(new SolveAStarCommand(), input))
			return new SolveAStarCommand();

		if (Command.isCommand(new SolveBeamCommand(), input))
			return new SolveBeamCommand();

		if (Command.isCommand(new MaxNodeCommand(), input))
			return new MaxNodeCommand();

		if (Command.isCommand(new PrintSolutionCommand(), input))
			return new PrintSolutionCommand();

		if (Command.isCommand(new RunExperimentsCommand(), input))
			return new RunExperimentsCommand();

		return new NullCommand();

	}

}
