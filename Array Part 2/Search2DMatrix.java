import java.util.Scanner;

class Search2DMatrixSolution {

    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        // Binary search
        while (left <= right) {

            int mid = left + (right - left) / 2;

            // Convert 1D index into row and column
            int row = mid / cols;
            int col = mid % cols;

            if (matrix[row][col] == target) {
                return true;
            }

            else if (matrix[row][col] < target) {
                left = mid + 1;
            }

            else {
                right = mid - 1;
            }
        }

        return false;
    }
}

public class Search2DMatrix {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];

        System.out.println("Enter matrix elements:");

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        Search2DMatrixSolution obj = new Search2DMatrixSolution();

        boolean result = obj.searchMatrix(matrix, target);

        System.out.println("Target found: " + result);

        sc.close();
    }
}
