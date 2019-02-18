package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import commands.Command;
import commands.CommandFactory;
import problem.Problem;

public class FileParser {

	File file;
	Problem problem;
	CommandFactory commandFactory;

	public FileParser(File file, Problem problem) {
		this.file = file;
		this.problem = problem;
		this.commandFactory = new CommandFactory();
	}

	public void execute() {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {

				Command command = commandFactory.getCommand(line);
				command.setProblem(problem);
				command.parse(Command.trimCommand(command, line));
				command.execute();

			}
		} catch (IOException e) {
			System.out.println("Error reading file " + file.getAbsolutePath());
			e.printStackTrace();
		}

	}

}
