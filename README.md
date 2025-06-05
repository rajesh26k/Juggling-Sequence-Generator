# Juggling-Sequence-Generator
 This project explores and generates juggling sequences using recursive algorithms, combinatorics, and Java. It was inspired by a mathematical problem involving modular juggling patterns and uses concepts like grid-based rook placements, modular arithmetic, and recursive enumeration to count and expand juggling sequences under given constraints.
# ![image](https://github.com/user-attachments/assets/7144b8e7-0e80-4fff-9063-6142ea22de72) 
This is a visual illustration of a juggling sequence from [www.plus.maths.org](url)
# What Are Juggling Sequences?
A juggling sequence is a list of non-negative integers such that if you add each element’s index to its value, then take each result modulo the length of the list, the resulting sequence is a permutation of the indices. This ensures each throw lands on a unique beat (no two balls collide mid-air). These patterns are core to the math behind juggling tricks.
# What This Project Does
- Generates all valid modular sequences using a grid-based recursive rook placement strategy (no two rooks land on the same time index!)
- Counts the number of valid height expansions for each mod sequence, given a maximum throw height 
- Lists all possible full juggling sequences that land according to a selected modular pattern
- Allows for custom exploration of specific mod sequences and parameter ranges via a simple interface
# Features
Grid-Based Rook Placement
- The core logic uses a generated matrix where cell (i,j) represents (j-i) mod d
- A recursive algorithm explores all permutations of these values like placing non-attacking rooks
- This generates all mod sequences (landing permutations) for juggling patterns of a given length
Expansion Counter
- For each valid mod sequence, the code calculates how many full-height sequences exist given a max height
- It uses efficient arithmetic to avoid brute force counting
Sequence Explorer
- Input a specific mod sequence such as [1, 2, 0] and input a max height such as 6
- See all corresponding full juggling sequences (like [4, 2, 0] and [1, 5, 3]) whose values will be less than the max height
# Example Usage
// Create a generator for sequences of minimum length 2, maximum length 3, and max height 7
Juggling c = new Juggling(2, 3, 7);

// Show the juggling array for sequences of length 3 (mod matrix)
int[][] matrix = c.jugglingArray(3); 
c.printArray(matrix);

// Generate all mod sequences and count valid expansions
c.createSequences();

// Explore all full juggling sequences that land in the pattern [1, 2, 0]
c.listExpansions(Arrays.asList(1, 2, 0));
# Tech
- Java: All core logic is implemented in Java
- Python (Colab UI): An optional Colab notebook adds a GUI layer using Python widgets
- Google Colab: Lets users run the code interactively without installing anything
# Files
- Juggling.java - Core logic: generation, counting, expansion
- juggling_gui.ipynb - Google Colab notebook with inputs, buttons, and live output
- README.md - This file
# How to Run
1. In Java locally (ex: javac Juggling.java, java Juggling 3 3 7)
2. In Google Colab (recommended for interactive use): [![Open In Colab](https://colab.research.google.com/assets/colab-badge.svg)](https://colab.research.google.com/github/rajesh26k/Juggling-Sequence-Generator/blob/main/juggling_gui.ipynb)

# Ideas for Future Work
- Add visualization of throwing arcs or landing animations
- Build a web app version
- Export sequences to CSV or animate patterns
# Author's Note
This project was inspired from a math research question about juggling sequences and their intricacies. It then evolved into this coding project blending math with CS in a wonderful way.


