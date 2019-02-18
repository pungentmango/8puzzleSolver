package commands;

import algorithm.AStarAlgorithm;
import algorithm.Solution;
import heuristic.Heuristic;
import heuristic.HeuristicMisplacedTilesCount;
import heuristic.HeuristicMisplacedTilesDistance;

public class SolveAStarCommand extends Command {

	public static final String HEURISTIC_1 = "h1";
	public static final String HEURISTIC_2 = "h2";

	private Heuristic heuristic;
	private static final String COMMAND_NAME = "solve A-star";

	@Override
	public Command parse(String input) {
		switch (input) {
		case HEURISTIC_1:
			heuristic = new HeuristicMisplacedTilesCount();
			break;
		case HEURISTIC_2:
			heuristic = new HeuristicMisplacedTilesDistance();
			break;
		default:
			System.out.println("invalid heuristic " + input);
			break;
		}
		return this;
	}

	@Override
	public Command execute() {
		if (isInitialized()) {
			System.out.println("Running A* algorithm");
			new AStarAlgorithm().setHeuristic(heuristic).search(problem, problem.getLimit());			
		}
		else {
			System.out.println("Algorithm has not been properly initialized. Please initialize all variables and try again.");
		}
		return this;
	}

	private boolean isInitialized() {
		return heuristic != null && problem.getGoalState() != null && problem.getInitialState() != null;
	}

	@Override
	public String getCommandName() {
		return COMMAND_NAME;
	}

}
