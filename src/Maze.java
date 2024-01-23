import java.util.List;
import java.util.ArrayList;

// Maze class represents the maze structure and provides methods for solving it
public class Maze {
    private int rows;
    private int columns;
    private int[][] grid;
    private MazeCell[][] cells;
    private List<MazeCell> pathList;

    // Constructor initializes the maze using the provided data
    public Maze(int[][] data) {
        rows = data.length;
        columns = data[0].length;
        grid = data;
        cells = new MazeCell[rows][columns];

        // Initialize MazeCell objects for each cell in the maze
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                cells[row][column] = new MazeCell(row, column);
            }
        }

        pathList = new ArrayList<>();
    }

    // Getter methods for maze properties
    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int[][] getGrid() {
        return grid;
    }

    public MazeCell[][] getCells() {
        return cells;
    }

    public List<MazeCell> getPathList() {
        return pathList;
    }

    // Depth-first search algorithm to find a path from current to end cell
    public boolean depthFirstSearch(MazeCell current, MazeCell end) {
        if (current == end) {
            return true; // Path found
        }

        current.setVisited(true); // Mark the current cell as visited

        // Explore neighboring cells
        for (MazeCell neighbor : current.getNeighbors(this)) {
            if (!neighbor.isVisited()) {
                // Recursively search for a path starting from the neighbor cell
                pathList.add(neighbor);
                if (depthFirstSearch(neighbor, end)) {
                    return true;
                } else {
                    // If no path is found, remove the neighbor from the path list
                    pathList.remove(pathList.size() - 1);
                }
            }
        }

        // If no path was found, return false
        return false;
    }
}