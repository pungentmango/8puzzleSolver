package experiment;

import java.util.ArrayList;
import java.util.List;

import algorithm.SearchAlgorithm;
import algorithm.Solution;
import problem.Problem;

public class Experiment {

	private SearchAlgorithm algorithm;
	private List<Solution> solutions;
	private String algorithmName;

	public Experiment() {
		solutions = new ArrayList<Solution>();
	}

	public SearchAlgorithm getAlgorithm() {
		return algorithm;
	}

	public void setAlgorithm(SearchAlgorithm algorithm) {
		this.algorithm = algorithm;
	}

	public List<Solution> getSolutions() {
		return solutions;
	}

	public void execute(Problem problem) {
		Solution solution = algorithm.search(problem, problem.getLimit());
		solutions.add(solution);
	}

	public String getAlgorithmName() {
		return algorithmName;
	}

	public void setAlgorithmName(String algorithmName) {
		this.algorithmName = algorithmName;
	}

}
