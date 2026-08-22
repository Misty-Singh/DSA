import java.util.*;

public class RepeatMissingNumber {
    public int[] findRepeatMissingNumber(int[][] grid) {
        int n = grid.length;
        int[] freq = new int[n * n + 1];

        // Count frequency of every number
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                freq[grid[i][j]]++;
            }
        }

        int repeated = 0;
        int missing = 0;

        // Find repeated and missing
        for (int i = 1; i <= n * n; i++) {
            if (freq[i] == 2) repeated = i;
            if (freq[i] == 0) missing = i;
        }
        return new int[]{repeated, missing};
    }

    // ADD THIS
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        
        System.out.println("Enter " + n*n + " numbers:");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        RepeatMissingNumber obj = new RepeatMissingNumber();
        int[] ans = obj.findRepeatMissingNumber(grid);
        System.out.println("Repeated: " + ans[0] + ", Missing: " + ans[1]);
    }
}