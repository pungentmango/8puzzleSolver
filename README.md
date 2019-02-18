# 8puzzleSolver
Implements a solver for the classic N-puzzle game for a 3x3 puzzle using A* with different heuristics and beam search. 

https://en.wikipedia.org/wiki/15_puzzle

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

# Commands
setstate <state>
  initialize the game to have the state specified by String of length 9. 
  use 'b' to represent the empty space in the puzzle
 
printState :
  prints the current state of the puzzle

randomize <n> :
  performs n random moves to scramble the puzzle.
     
move <direction> :
  move the blank space in the specified direction. Direction is either up, left, down, or right.

maxNodes <n> :
  limits the maximum number of search nodes allowed by the search algorithms. 
  Suggested value of 10000 for A* search, 1000 for beam search
  
solve A-star <heuristic type> :
  solves the puzzle using an A* implementation and one of the following heuristics:
    h1 - heuristic function based on the number of misplaced tiles
    h2 - heuristic function based on the sum of tile distances from their goal state

solve beam <beam width> :
  solves the puzzle using a beam search implementation with the specified beam width
  beam width suggested between 4 and 32

printSolution :
  prints the list of moves needed to solve the given puzzle
  
runExperiments <n> , <m> :
  prints a summary of n instances of the algorithm being run.
  the puzzle is randomized by m random moves after each experiment.
