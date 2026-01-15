# GameOfLife
## notes for my understanding
### Rules of the game
for each cell in the grid -> its next state is determined by the number of live neighbors
Its broadly classified into 4 rules::
1) underpopulation -> Any live cell with fewer than 2 live neghbors dies
2) overcrowding -> any live cell with more than 3 live neighbors dies
3) reporudction -> any dead cell with exactly 3 live neighbors becomes alive
4) nextgen -> any live cell with 2/3 live neighbors lives on 

The rules however continue to be applied repeatedly to create next generations -> so per generation state transitions occur simultaneously

### Design approach - rough note
I will consider the game board as 2D array for simplicity
Each cell can be represented using a boolean or integer value,say, 1 -> alive and 0 -> dead sort of..
A bounded grid is assumed for now - meaning... no wrap-around behavior

Since each of the cell's state is interlinked with other cell and its transition.. let me have another grid.
this new grid is created to store the next generation -- yeah, this will have additional space complexity.
Preferring this only to priortize, clarity over in-place optimization. Hope, that should be fine for now.

basically, the original grid remains unchanged while computing the next state => after computation => new grid replace the old grid
Should be working fine - let me see

to proceed further, I am now assuming one generation update is executed method call.

### for later
multiple generations
in-place updates
... I could think of these 2 for now.

### rough algo thought
simple -->
Iterate through each cell in the grid!
for each cell, count the number of live neighbors
apply the rules

store the computed result in a new grid
replace the current grid with the new grid

Catch is that, as a preqreuisite, I will use predefined directional offsets.
This will help determine the neighbor positions are within boundary checks.

That is, {-1, -1}, {-1,0}, {-1,1}, {0,-1), {0,1}, {1,-1}, {1,0}, {1,1}
this array of positions will cover all possible 8 directions.

### Big O
Time Comp -> O(m*n) per generation
Space Comp -> O(m*n)
Can be further refined but this is for a full grid simulation approach.

### Instructions to run the code
Added code as per the thought process explained above.
Also added a test class to validate bear minimum 4 rules that were set.

Assuming you are downloading this in your root folder, else replace ~ accordingly
```bash
javac -d out ~/GameOfLife/src/gameoflife/GameOfLife.java  ~/GameOfLife/src/gameoflife/GameOfLifeTest.java
```

run to get the output
```bash
java -cp out gameoflife.GameOfLife
java -cp out gameoflife.GameOfLifeTest
```
