//this code was written by gabe vanderklok
//video https://www.loom.com/share/4d12be3536f54483894d5cc6e5330be0
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


public class Program
{


    public static void main(String[] args)
    {
        int rows = 0, cols = 0;
        int[][] grid;


        try (BufferedReader fin = new BufferedReader(new FileReader("/Users/gvklok/Documents/cst-201/MazeSolver4real/src/Maze.txt")))
        {
            if (fin.ready())
            {
                var dimensions = fin.readLine().split(" ");
                rows = Integer.parseInt(dimensions[0]);
                cols = Integer.parseInt(dimensions[1]);
            }
            else
            {
                System.out.println("File not found");
                System.exit(2);
            }


            grid = new int[rows][cols];


            for (var row = 0; row < rows; row ++)
            {
                var rowData = fin.readLine().split(" ");
                for (var Column = 0; Column < cols; Column ++)
                {
                    grid[row][Column] = Integer.parseInt(rowData[Column]);
                }
            }
        }

        catch (IOException e)
        {
            System.out.println("Error reading file: " + e.getMessage());
            return;
        }


        Maze maze = new Maze(grid);
        MazeCell current = null, end = null;


        for (var row = 0; row < maze.getRows(); row ++)
        {
            for (var Column = 0; Column < maze.getColumns(); Column ++)
            {
                if (maze.getGrid()[row][Column] == 3)
                {
                    current = maze.getCells()[row][Column];
                }


                if (maze.getGrid()[row][Column] == 4)
                {
                    end = maze.getCells()[row][Column];
                }
            }
        }


        System.out.println("Start: (" + current.getRow() + "," + current.getColumn() + ")");
        System.out.println("End: (" + end.getRow() + "," + end.getColumn() + ")");

        List<MazeCell> pathList = maze.getPathList();

        if (maze.depthFirstSearch(current, end))
        {


            System.out.println("Path found:");
            for (MazeCell cell : pathList)
            {
                System.out.println(cell.toString());
            }
        }
        else
        {
            System.out.println("No solution to the maze.");
            for (MazeCell cell : pathList)
            {
                System.out.println(cell.toString());
            }
        }
    }


}
