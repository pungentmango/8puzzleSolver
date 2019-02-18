package experiment;

import java.util.ArrayList;
import java.util.List;

import algorithm.AStarAlgorithm;
import algorithm.BeamSearchAlgorithm;
import algorithm.Solution;
import commands.RandomizeStateCommmand;
import heuristic.HeuristicMisplacedTilesCount;
import heuristic.HeuristicMisplacedTilesDistance;
import problem.Problem;

public class Experiments {

	private Problem problem;
	private List<Experiment> experiments;
	private int numRuns;
	private int randomization;

	public Experiments() {
		experiments = new ArrayList<Experiment>();
		Experiment exp1 = new Experiment();
		AStarAlgorithm alg1 = new AStarAlgorithm();
		alg1.setHeuristic(new HeuristicMisplacedTilesCount());
		exp1.setAlgorithm(alg1);
		exp1.setAlgorithmName("A*(h1)");

		Experiment exp2 = new Experiment();
		AStarAlgorithm alg2 = new AStarAlgorithm();
		alg2.setHeuristic(new HeuristicMisplacedTilesDistance());
		exp2.setAlgorithm(alg2);
		exp2.setAlgorithmName("A*(h2)");

		Experiment exp3 = new Experiment();
		BeamSearchAlgorithm alg3 = new BeamSearchAlgorithm();
		alg3.setHeuristic(new HeuristicMisplacedTilesDistance());
		alg3.setBeamWidth(16);
		exp3.setAlgorithm(alg3);
		exp3.setAlgorithmName("beam(k=16)");
		
		Experiment exp4 = new Experiment();
		BeamSearchAlgorithm alg4 = new BeamSearchAlgorithm();
		alg4.setHeuristic(new HeuristicMisplacedTilesDistance());
		alg4.setBeamWidth(100);
		exp4.setAlgorithm(alg4);
		exp4.setAlgorithmName("beam(k=100)");

		experiments.add(exp1);
		experiments.add(exp2);
		experiments.add(exp3);
		experiments.add(exp4);
	}

	public Experiments setNumRuns(int numRuns) {
		this.numRuns = numRuns;
		return this;
	}

	public Experiments setRandomization(int randomization) {
		this.randomization = randomization;
		return this;
	}

	public Experiments setProblem(Problem problem) {
		this.problem = problem;
		return this;
	}

	public void execute() {

		problem.setInitialState(problem.getGoalState());
		RandomizeStateCommmand randomizeState = new RandomizeStateCommmand();
		for (int run = 0; run < numRuns; run++) {
			randomizeState.setProblem(problem);
			randomizeState.parse("" + randomization);
			randomizeState.execute();
			// run problem with all algorithms
			for (Experiment experiment : experiments) {
				experiment.execute(randomizeState.getProblem());
			}
		}
		printResults();
	}

	private void printResults() {
		String delim = ",";
		// headers
		System.out.println("Num Moves"+delim+delim+delim+"Num Nodes");
		int numFeatures = 2;
		for (int i = 0; i < numFeatures; i++) {
			for (Experiment experiment : experiments) {
				System.out.print(experiment.getAlgorithmName() + delim);
			}
		}
		System.out.println();

		// data
		for (int run = 0; run < numRuns; run++) {
			for (Experiment experiment : experiments) {
				Solution s = experiment.getSolutions().get(run);
				System.out.print(s.getNumMoves() + delim);
			}
			for (Experiment experiment : experiments) {
				Solution s = experiment.getSolutions().get(run);
				System.out.print(s.getNumNodes() + delim);
			}
			System.out.println();
		}
	}

}
