import java.util.*;

class Main {

    static boolean solve(char[][] board) {

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                if (board[row][col] == '.') {

                    for (char num = '1'; num <= '9'; num++) {

                        if (isSafe(board, row, col, num)) {

                            board[row][col] = num;

                            if (solve(board)) {
                                return true;
                            }

                            board[row][col] = '.';
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    static boolean isSafe(char[][] board, int row, int col, char num) {

        // Check row
        for (int j = 0; j < 9; j++) {
            if (board[row][j] == num) {
                return false;
            }
        }

        // Check column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // Check 3x3 box
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    static void printBoard(char[][] board) {

        System.out.println("+-------+-------+-------+");

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                if (j % 3 == 0) {
                    System.out.print("| ");
                }

                System.out.print(board[i][j] + " ");

            }

            System.out.println("|");

            if ((i + 1) % 3 == 0) {
                System.out.println("+-------+-------+-------+");
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[][] board = new char[9][9];

        System.out.println("================================");
        System.out.println("       SUDOKU SOLVER");
        System.out.println("================================");

        System.out.println("\nEnter Sudoku row by row.");
        System.out.println("Use '.' for empty cells.\n");

        for (int i = 0; i < 9; i++) {

            while (true) {

                System.out.print("Row " + (i + 1) + ": ");

                String row = sc.next();

                if (row.length() == 9) {

                    for (int j = 0; j < 9; j++) {
                        board[i][j] = row.charAt(j);
                    }

                    break;

                } else {
                    System.out.println(
                        "Invalid! Enter exactly 9 characters."
                    );
                }
            }
        }

        System.out.println("\n================================");
        System.out.println("       ORIGINAL SUDOKU");
        System.out.println("================================");

        printBoard(board);

        if (solve(board)) {

            System.out.println("\n================================");
            System.out.println("       SOLVED SUDOKU");
            System.out.println("================================");

            printBoard(board);

            System.out.println("✓ Sudoku solved successfully!");

        } else {

            System.out.println("\n✗ No solution exists.");
        }

        sc.close();
    }
}