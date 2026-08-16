import java.util.Scanner;

class Solution {

    public int[] MaxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] result = new int[n - k + 1];

        int index = 0;

        for (int i = 0; i <= n - k; i++) {

            int max = nums[i];

            for (int j = i; j < i + k; j++) {

                if (nums[j] > max) {
                    max = nums[j];
                }
            }

            result[index] = max;
            index++;
        }

        return result;
    }
}

public class SlidingWindowMaximum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter window size k: ");
        int k = sc.nextInt();

        Solution obj = new Solution();

        int[] result = obj.MaxSlidingWindow(nums, k);

 
        System.out.println("Sliding Window Maximum:");

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

        sc.close();
    }
}