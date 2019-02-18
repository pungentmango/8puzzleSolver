package commands;

public class PrintSolutionCommand extends Command {

	private static final String COMMAND_NAME = "printSolution";
	
	@Override
	public Command parse(String input) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public Command execute() {
		
		problem.getSolution().printSolutionSize().printSolution();
		return this;
	}
	

	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}

}
