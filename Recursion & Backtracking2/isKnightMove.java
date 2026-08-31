import java.util.Scanner;

public class isKnightMove {

    // User-defined method
    public static boolean isKnightMove(int r1, int c1, int r2, int c2) {

        int rowDiff = Math.abs(r1 - r2);
        int colDiff = Math.abs(c1 - c2);

        return (rowDiff == 2 && colDiff == 1) ||
               (rowDiff == 1 && colDiff == 2);
    }

    // User-defined method
    public static boolean checkValidGrid(int[][] grid) {

        int n = grid.length;

        // Must start from top-left
        if (grid[0][0] != 0) {
            return false;
        }

        // Store position of each number
        int[][] position = new int[n * n][2];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {

                int value = grid[row][col];

                position[value][0] = row;
                position[value][1] = col;
            }
        }

        // Check consecutive numbers
        for (int i = 0; i < n * n - 1; i++) {

            int r1 = position[i][0];
            int c1 = position[i][1];

            int r2 = position[i + 1][0];
            int c2 = position[i + 1][1];

            if (!isKnightMove(r1, c1, r2, c2)) {
                return false;
            }
        }

        return true;
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take size of matrix
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int[][] grid = new int[n][n];

        // Take matrix input
        System.out.println("Enter grid:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        // Check answer
        boolean result = checkValidGrid(grid);

        System.out.println("Valid Knight Tour: " + result);

        sc.close();
    }
}