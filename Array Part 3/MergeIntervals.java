import java.util.*;

class MergeIntervalsSolution {

    public int[][] merge(int[][] intervals) {

        // Sort according to starting value
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        ArrayList<int[]> result = new ArrayList<>();

        int start = intervals[0][0];
        int end = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            // Overlap
            if (intervals[i][0] <= end) {

                end = Math.max(end, intervals[i][1]);

            } else {

                // No overlap
                result.add(new int[]{start, end});

                start = intervals[i][0];
                end = intervals[i][1];
            }
        }

        // Add last interval
        result.add(new int[]{start, end});

        return result.toArray(new int[result.size()][]);
    }
}

public class MergeIntervals {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of intervals: ");
        int n = sc.nextInt();

        int[][] intervals = new int[n][2];

        System.out.println("Enter intervals:");

        for (int i = 0; i < n; i++) {

            System.out.print("Interval " + (i + 1) + ": ");

            intervals[i][0] = sc.nextInt();
            intervals[i][1] = sc.nextInt();
        }

        MergeIntervalsSolution obj = new MergeIntervalsSolution();

        int[][] result = obj.merge(intervals);

        System.out.println("Merged Intervals:");

        for (int i = 0; i < result.length; i++) {
            System.out.println(
                "[" + result[i][0] + ", " + result[i][1] + "]"
            );
        }

        sc.close();
    }
}