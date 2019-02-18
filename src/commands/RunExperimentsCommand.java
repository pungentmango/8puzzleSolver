package commands;

import experiment.Experiments;

public class RunExperimentsCommand extends Command {

	private int numRuns;
	private int randomization;
	private Experiments experiments;

	private static final String COMMAND_NAME = "runExperiments";

	@Override
	public Command parse(String input) {
		this.numRuns = Integer.parseInt(input.split(",")[0]);
		this.randomization = Integer.parseInt(input.split(",")[1]);
		return this;
	}

	@Override
	public Command execute() {
		System.out.println("Executing experiment " + numRuns + " times with randomization= " + randomization);
		experiments = new Experiments().setNumRuns(numRuns).setProblem(problem).setRandomization(randomization);
		experiments.execute();
		return this;

	}

	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}
}
