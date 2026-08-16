import java.util.Scanner;

class WordSearchSolution {

    public boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (board[i][j] == word.charAt(0)) {

                    if (search(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean search(char[][] board, String word,
                           int row, int col, int index) {

        // Word completely found
        if (index == word.length()) {
            return true;
        }

        // Boundary check
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length) {
            return false;
        }

        // Character does not match
        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        // Mark cell as visited
        char temp = board[row][col];
        board[row][col] = '#';

        // Search in 4 directions
        boolean found =
                search(board, word, row + 1, col, index + 1) ||
                search(board, word, row - 1, col, index + 1) ||
                search(board, word, row, col + 1, index + 1) ||
                search(board, word, row, col - 1, index + 1);

        // Restore cell
        board[row][col] = temp;

        return found;
    }
}

public class WordSearch {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        char[][] board = new char[rows][cols];

        System.out.println("Enter board characters:");

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                board[i][j] = sc.next().charAt(0);
            }
        }

        System.out.print("Enter word to search: ");
        String word = sc.next();

        WordSearchSolution obj = new WordSearchSolution();

        boolean result = obj.exist(board, word);

        System.out.println("Word exists: " + result);

        sc.close();
    }
}