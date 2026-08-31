import java.util.*;

public class RatInMaze {

    // User-defined method to check whether movement is possible
    public static boolean isSafe(int[][] maze, int row, int col,
                                 boolean[][] visited) {

        int n = maze.length;

        if (row < 0 || row >= n ||
            col < 0 || col >= n) {
            return false;
        }

        if (maze[row][col] == 0) {
            return false;
        }

        if (visited[row][col]) {
            return false;
        }

        return true;
    }

    // User-defined backtracking method
    public static void findPaths(int[][] maze, int row, int col,
                                 boolean[][] visited,
                                 String path,
                                 ArrayList<String> result) {

        int n = maze.length;

        // Destination reached
        if (row == n - 1 && col == n - 1) {
            result.add(path);
            return;
        }

        // Mark current cell
        visited[row][col] = true;

        // Down
        if (isSafe(maze, row + 1, col, visited)) {
            findPaths(maze, row + 1, col,
                      visited, path + "D", result);
        }

        // Left
        if (isSafe(maze, row, col - 1, visited)) {
            findPaths(maze, row, col - 1,
                      visited, path + "L", result);
        }

        // Right
        if (isSafe(maze, row, col + 1, visited)) {
            findPaths(maze, row, col + 1,
                      visited, path + "R", result);
        }

        // Up
        if (isSafe(maze, row - 1, col, visited)) {
            findPaths(maze, row - 1, col,
                      visited, path + "U", result);
        }

        // Backtrack
        visited[row][col] = false;
    }

    // User-defined method
    public static ArrayList<String> ratInMaze(int[][] maze) {

        ArrayList<String> result = new ArrayList<>();

        int n = maze.length;

        // Start or destination blocked
        if (maze[0][0] == 0 ||
            maze[n - 1][n - 1] == 0) {

            return result;
        }

        boolean[][] visited = new boolean[n][n];

        findPaths(maze, 0, 0,
                  visited, "", result);

        Collections.sort(result);

        return result;
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of maze: ");
        int n = sc.nextInt();

        int[][] maze = new int[n][n];

        System.out.println("Enter maze:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = sc.nextInt();
            }
        }

        ArrayList<String> result = ratInMaze(maze);

        System.out.println("Possible paths:");

        if (result.isEmpty()) {
            System.out.println("No path exists");
        } else {
            for (String path : result) {
                System.out.println(path);
            }
        }

        sc.close();
    }
}