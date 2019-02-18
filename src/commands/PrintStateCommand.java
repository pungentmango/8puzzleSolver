package commands;

public class PrintStateCommand extends Command {

	private static final String COMMAND_NAME = "printState";
	
	@Override
	public Command parse(String input) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public Command execute() {
		System.out.println(problem.getModel().setState(problem.getInitialState()));
		return this;
	}
	

	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}

}
