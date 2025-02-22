import java.util.Scanner;

public class NumberOfIslands {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input grid dimensions
        System.out.println("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of columns: ");
        int cols = scanner.nextInt();

        // Input grid
        int[][] grid = new int[rows][cols];
        System.out.println("Enter the grid row by row (1 for land, 0 for water): ");
        for (int i = 0; i < rows; i++) {
            String row = scanner.next();
            for (int j = 0; j < cols; j++) {
                grid[i][j] = row.charAt(j) - '0';
            }
        }

        // Create an instance of the class and call the method
        NumberOfIslands solution = new NumberOfIslands();
        int numIslands = solution.countNumberOfIslands(grid);
        System.out.println("Number of islands: " + numIslands);
    }

    public int countNumberOfIslands(int[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                    markVisited(grid, i, j);
                }
            }
        }

        return count;
    }

    public void markVisited(int[][] grid, int i, int j) {
        // base condition checks
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
            return;
        }

        // Marking the current cell as visited
        grid[i][j] = 0;

        // Visiting all neighboring cells (up, down, left, right)
        markVisited(grid, i, j + 1);
        markVisited(grid, i + 1, j);
        markVisited(grid, i - 1, j);
        markVisited(grid, i, j - 1);
    }
}
