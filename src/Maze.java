import java.util.ArrayList;
import java.util.List;


public class Maze {
    private int rows;
    private int columns;
    private int[][] grid;
    private MazeCell[][] cells;
    private List<MazeCell> pathList;


    public Maze(int[][] data) {
        rows = data.length;
        columns = data[0].length;
        grid = data;
        cells = new MazeCell[rows][columns];


        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                cells[row][column] = new MazeCell(row, column);
            }
        }


        pathList = new ArrayList<>();
    }


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


    public boolean depthFirstSearch(MazeCell current, MazeCell end) {
        //Check if the current cell is the end cell
        if (current == end) {
            return true;
        }


        // Step 2: Mark the current cell as visited.
        current.setVisited(true);


        // Step 3: Explore neighboring cells.
        for (MazeCell neighbor : current.getNeighbors(this)) {
            if (!neighbor.isVisited()) {
                // Recursively search for a path starting from the neighbor cell.
                pathList.add(neighbor);
                if (depthFirstSearch(neighbor, end)) {
                    return true;
                }
                //If no path is found we remove that neighbor from pathlist
                else{
                    pathList.remove(pathList.size() - 1);
                }
                }
            }



        // Step 4: If no path was found return false
        return false;
    }
}
