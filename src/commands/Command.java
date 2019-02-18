package commands;

import problem.Problem;

public abstract class Command {

	protected Problem problem;

	public Command setProblem(Problem problem) {
		this.problem = problem;
		return this;
	}

	public Problem getProblem() {
		return problem;
	}

	public abstract Command parse(String input);

	public abstract Command execute();

	public abstract String getCommandName();

	public static boolean isCommand(Command command, String input) {
		if (input.toLowerCase().replaceAll("\\s+", "")
				.startsWith(command.getCommandName().toLowerCase().replaceAll("\\s+", ""))) {
			return true;
		}
		return false;
	}

	public static String trimCommand(Command command, String input) {
		return input.toLowerCase().replaceAll("\\s+", "")
				.replaceFirst(command.getCommandName().toLowerCase().replaceAll("\\s+", ""), "");
	}

}
