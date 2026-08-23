import java.util.Arrays;
import java.util.Scanner;

public class AggressiveCows {

    static boolean canPlaceCows(int[] stalls, int cows, int minDistance) {

        int count = 1;
        int lastPosition = stalls[0];

        for (int i = 1; i < stalls.length; i++) {

            if (stalls[i] - lastPosition >= minDistance) {
                count++;
                lastPosition = stalls[i];
            }

            if (count >= cows) {
                return true;
            }
        }

        return false;
    }

    static int aggressiveCows(int[] stalls, int cows) {

        Arrays.sort(stalls);

        int left = 1;
        int right = stalls[stalls.length - 1] - stalls[0];

        int answer = 0;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (canPlaceCows(stalls, cows, mid)) {
                // This distance is possible.
                // Try a bigger distance.
                answer = mid;
                left = mid + 1;
            } 
            else {
                // This distance is not possible.
                // Try a smaller distance.
                right = mid - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of stalls: ");
        int n = sc.nextInt();

        int[] stalls = new int[n];

        System.out.println("Enter stall positions:");
        for (int i = 0; i < n; i++) {
            stalls[i] = sc.nextInt();
        }

        System.out.print("Enter number of cows: ");
        int cows = sc.nextInt();

        int result = aggressiveCows(stalls, cows);

        System.out.println("Maximum Minimum Distance: " + result);

        sc.close();
    }
}