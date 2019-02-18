package commands;

public class NullCommand extends Command {

	private static String COMMAND_NAME = "";

	@Override
	public Command parse(String input) {
		System.out.println("Invalid command " + input);
		return this;
	}

	@Override
	public Command execute() {
		return this;
	}

	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}

}
