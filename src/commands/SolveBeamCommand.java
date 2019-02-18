package commands;

import algorithm.BeamSearchAlgorithm;
import algorithm.Node;
import algorithm.Solution;
import heuristic.Heuristic;
import heuristic.HeuristicMisplacedTilesDistance;

public class SolveBeamCommand extends Command {

	private Heuristic heuristic = new HeuristicMisplacedTilesDistance();
	private int beamWidth;

	private static final String COMMAND_NAME = "solve beam";

	@Override
	public Command parse(String input) {
		try {
			beamWidth = Integer.parseInt(input);
			if (beamWidth <= 0) {
				printError(input);
			}
		} catch (NumberFormatException e) {
			printError(input);
		}
		return this;
	}

	private void printError(String input) {

		System.out.println("Invalid beam width " + input);
	}

	@Override
	public Command execute() {
		if (isInitialized()) {
			System.out.println("Running beam search algorithm with beam width = " + beamWidth);
			new BeamSearchAlgorithm().setHeuristic(heuristic).setBeamWidth(beamWidth)
					.search(problem, problem.getLimit());
		}
		else {
			System.out.println("Algorithm has not been properly initialized. Please initialize all variables and try again.");
		}
		return this;
	}

	private boolean isInitialized() {
		return heuristic != null && problem.getGoalState() != null && problem.getInitialState() != null
				&& beamWidth > 0;
	}

	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}

}
