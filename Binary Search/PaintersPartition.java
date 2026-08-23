import java.util.Scanner;

public class PaintersPartition {

    static boolean canPaint(int[] boards, int painters, long maxTime) {

        int paintersUsed = 1;
        long currentSum = 0;

        for (int board : boards) {

            if (currentSum + board <= maxTime) {
                currentSum += board;
            } 
            else {
                paintersUsed++;
                currentSum = board;

                if (paintersUsed > painters) {
                    return false;
                }
            }
        }

        return true;
    }

    static long painterPartition(int[] boards, int painters) {

        long left = 0;
        long right = 0;

        for (int board : boards) {
            left = Math.max(left, board);
            right += board;
        }

        long answer = right;

        while (left <= right) {

            long mid = left + (right - left) / 2;

            if (canPaint(boards, painters, mid)) {
                // Possible, so try a smaller maximum
                answer = mid;
                right = mid - 1;
            } 
            else {
                // Not possible, need more time
                left = mid + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of boards: ");
        int n = sc.nextInt();

        int[] boards = new int[n];

        System.out.println("Enter board lengths:");
        for (int i = 0; i < n; i++) {
            boards[i] = sc.nextInt();
        }

        System.out.print("Enter number of painters: ");
        int painters = sc.nextInt();

        long result = painterPartition(boards, painters);

        System.out.println("Minimum Maximum Time: " + result);

        sc.close();
    }
}