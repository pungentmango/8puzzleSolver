package io;

import java.io.File;

import model._8PuzzleModelGoalState;
import problem.Problem;
import problem._8PuzzleProblem;

public class App {

	private static Problem problem = new _8PuzzleProblem(_8PuzzleModelGoalState.getGoalState().getState());

	public static void main(String[] args) {

		if (args.length == 1) {
			File file = new File(args[0]);
			if (file.exists()) {
				new FileParser(file, problem).execute();
			} else {
				System.out.println("Could not find file " + file.getAbsolutePath());
			}
		} else {
			new CommandLineParser(problem).execute();
		}

	}

}
