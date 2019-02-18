package commands;

import algorithm.Limit;

public class MaxNodeCommand extends Command {

	private static final String COMMAND_NAME = "maxnodes";

	@Override
	public Command parse(String input) {
		try {
			int maxNodes = Integer.parseInt(input);
			if (maxNodes <= 0) {
				printError(input);
			} else {
				System.out.println("Setting max nodes to " + maxNodes);
				problem.setLimit(new Limit(maxNodes));
			}
		} catch (NumberFormatException e) {
			printError(input);
		}
		return this;
	}

	private void printError(String input) {

		System.out.println("Invalid max nodes " + input);
	}

	@Override
	public Command execute() {
		// TODO Auto-generated method stub
		return this;

	}

	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}

}
