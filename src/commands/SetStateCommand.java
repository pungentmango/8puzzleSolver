package commands;

public class SetStateCommand extends Command {

	private static final String COMMAND_NAME = "setState";

	@Override
	public Command parse(String input) {
		String stateString = input;
		if (stateString.matches("[b0-9]{9}")) {
			problem.setInitialState(stateString);
			System.out.println("set state to " + problem.getInitialState());
		}
		else {
			System.out.println("invalid state. Please enter a valid state" );
		}
		return this;
	}

	@Override
	public Command execute() {
		// do nothing; state is set in parse.
		return this;
	}


	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}
}
