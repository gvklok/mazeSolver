import java.util.List;
import java.util.ArrayList;


public class MazeCell
{
    private int row;
    private int column;
    private boolean visited;
    private MazeCell parent;


    public MazeCell(int row, int column)
    {
        this.row = row;
        this.column = column;
        this.visited = false;
        this.parent = null;
    }


    public MazeCell()
    {
        this.row = -1;
        this.column = -1;
        this.visited = false;
        this.parent = null;
    }
    public List<MazeCell> getNeighbors(Maze maze) {
        List<MazeCell> neighbors = new ArrayList<>();
        int x = this.column;
        int y = this.row;


        // Define relative positions for neighbors (up, down, left, right, and diagonals)
        int[] dRow = { -1, 1, 0, 0, -1, -1, 1, 1 };
        int[] dColumn = { 0, 0, -1, 1, -1, 1, -1, 1 };


        for (int i = 0; i < dRow.length; i++) {
            int newY = y + dRow[i];
            int newX = x + dColumn[i];


            // Check if the neighbor is within bounds and has a value of 0
            if (newX >= 0 && newX < maze.getColumns() && newY >= 0 && newY < maze.getRows() && (maze.getGrid()[newY][newX] == 4 || maze.getGrid()[newY][newX] == 0)) {
                MazeCell neighbor = maze.getCells()[newY][newX];
                neighbors.add(neighbor);
            }
        }
        return neighbors;
    }




    public int getRow()
    {
        return row;
    }


    public int getColumn()
    {
        return column;
    }


    public boolean isVisited()
    {
        return visited;
    }


    public void setVisited(boolean visited)
    {
        this.visited = visited;
    }


    public MazeCell getParent()
    {
        return parent;
    }


    public void setParent(MazeCell parent)
    {
        this.parent = parent;
    }


    @Override
    public String toString()
    {
        return "(" + row + "," + column + ")";
    }
}
