
---

# Maze Solver

This project is a simple maze solver implemented in Java using depth-first search. The program takes a maze as input and finds a path from the start to the end using a depth-first search algorithm.


## Usage

Heres some explantino to better understand maze solver:

1. The text file each number in the maze represents a different type of cell:
   - `0`: Open path
   - `1`: Wall
   - `3`: Start cell
   - `4`: End cell

   Example:
   ```
   4 6
   1 1 3 1 1 1
   0 1 1 0 0 1
   1 0 1 0 1 1
   1 1 0 0 4 0
   ```
Additionally, the first line of the file should specify the dimensions of the maze, with the number of rows followed by the number of columns.
Maze Solver Project



## Files

- **Maze.java**: Defines the `Maze` class representing the maze structure.
- **MazeCell.java**: Defines the `MazeCell` class representing individual cells in the maze.
- **Program.java**: Contains the main program that reads the maze from a file, initializes the maze solver, and outputs the result.

## Example

Open the project in your preferred Integrated Development Environment , such as Visual Studio Code or IntelliJ IDEA.
Locate the Program.java file in the project structure.
In the Program.java file, find the line that specifies the path to the maze.txt file.
Update the file path to point to the actual location of your maze.txt file.
Run the Program class to execute the maze solver.
Output:
```
Start: (0,2)
End: (0,5)
Path found:
(0,2)
(1,1)
(2,1)
(3,2)
(3,3)
(2,3)
(1,4)
(0,5)
```

## Author

This maze solver was written by Gabe VanderKlok. 

---
