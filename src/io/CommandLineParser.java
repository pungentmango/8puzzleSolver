package io;

import java.io.Console;

import commands.Command;
import commands.CommandFactory;
import model._8PuzzleModelGoalState;
import problem.Problem;
import problem._8PuzzleProblem;

public class CommandLineParser {

	private static final String EXIT = "exit";
	private Problem problem;
	private Console c = System.console();

	public CommandLineParser(Problem problem) {
		this();
		this.problem = problem;
	}

	private CommandFactory commandFactory;

	public CommandLineParser() {
		commandFactory = new CommandFactory();
	}

	public void execute() {
		boolean continueCommand = true;
		while (continueCommand) {

			System.out.print("Please enter a command: ");
			String line = c.readLine();

			if (line.equals(EXIT)) {
				continueCommand = false;
				continue;
			}

			Command command = commandFactory.getCommand(line);
			command.setProblem(problem);
			command.parse(Command.trimCommand(command, line));
			command.execute();

		}

	}

	public Command getCommand(String s) {
		return commandFactory.getCommand(s);
	}

	public static void main(String[] args) {

		CommandLineParser parser = new CommandLineParser();

		Problem problem = new _8PuzzleProblem(_8PuzzleModelGoalState.getGoalState().getState());

		String[] lines = { "setState b12 345 678", "printState", "randomizeState 1000", "printState", "runExperiments 1,10" };

		for (String line : lines) {

			if (line.equals(EXIT)) {
				continue;
			}

			Command command = parser.getCommand(line);
			command.setProblem(problem);
			command.parse(Command.trimCommand(command, line));
			command.execute();

		}
	}

}
