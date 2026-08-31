import java.util.*;

class NQueens {

    static void solve(int row, int n, char[][] board,
                      List<List<String>> result) {

        // All queens are placed
        if (row == n) {
            List<String> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                list.add(new String(board[i]));
            }

            result.add(list);
            return;
        }

        // Try placing queen in every column
        for (int col = 0; col < n; col++) {

            if (isSafe(board, row, col, n)) {

                // Place queen
                board[row][col] = 'Q';

                // Move to next row
                solve(row + 1, n, board, result);

                // Remove queen - backtracking
                board[row][col] = '.';
            }
        }
    }

    static boolean isSafe(char[][] board, int row, int col, int n) {

        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check upper-left diagonal
        int i = row - 1;
        int j = col - 1;

        while (i >= 0 && j >= 0) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j--;
        }

        // Check upper-right diagonal
        i = row - 1;
        j = col + 1;

        while (i >= 0 && j < n) {
            if (board[i][j] == 'Q') {
                return false;
            }
            i--;
            j++;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // User enters n
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        char[][] board = new char[n][n];

        // Fill board with '.'
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        List<List<String>> result = new ArrayList<>();

        solve(0, n, board, result);

        System.out.println("Solutions:");

        for (List<String> solution : result) {
            System.out.println(solution);
        }

        System.out.println("Total solutions = " + result.size());

        sc.close();
    }
}