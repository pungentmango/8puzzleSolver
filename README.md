# 8puzzleSolver
Implements a solver for the classic 8 puzzle game using A* with different heuristics and beam search. 

# How to run
to use command line, run
java io.App

additional commands that are defined: 
printSolution -- will print the solution path after the algorithm runs
runExperiments <trials>,<randomizeState> -- will run specified trials, and randomize set times between each trial. 

to use an input file, run 
java io.App <filename>
e.g. 
java io.App ..\res\basicTest
