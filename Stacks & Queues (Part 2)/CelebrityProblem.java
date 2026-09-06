import java.util.*;

public class CelebrityProblem {

    public static int findCelebrity(int[][] matrix, int n) {

        int candidate = 0;

        // Step 1: Find a possible celebrity
        for (int i = 1; i < n; i++) {

            if (matrix[candidate][i] == 1) {
                candidate = i;
            }
        }

        // Step 2: Verify the candidate
        for (int i = 0; i < n; i++) {

            if (i == candidate) {
                continue;
            }

            // Celebrity should not know anyone
            // Everyone should know celebrity
            if (matrix[candidate][i] == 1 ||
                matrix[i][candidate] == 0) {

                return -1;
            }
        }

        return candidate;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of people: ");
        int n = sc.nextInt();

        int[][] matrix = new int[n][n];

        System.out.println("Enter the matrix:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int result = findCelebrity(matrix, n);

        if (result == -1) {
            System.out.println("No celebrity found");
        } else {
            System.out.println("Celebrity is person: " + result);
        }

        sc.close();
    }
}