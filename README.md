# Project Description

> Standalone java file that constructs the [optimal binary search tree](https://en.wikipedia.org/wiki/Optimal_binary_search_tree) (OBST) for a given sorted sequence of distinct keys (i.e. integers) using [dynamic programming](https://en.wikipedia.org/wiki/Dynamic_programming) [DP] strategy.

# Project Features

  - Input is provided via file and through the command line. Input files consist of the following format (see testOBST.txt):
    - First line of the input data file consists of an integer, which represents the number of keys. 
    - Second line consists of n-number of keys (int). 
    - Third line consists of n-number of probabilities (double).  
  - Outputs the cost matrix and root matrix of the OBST relevant to input it recieved. The OBST can be derived from the root matrix.
