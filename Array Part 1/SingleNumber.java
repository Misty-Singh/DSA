

import java.util.*;

public class SingleNumber {

    // User-defined method
    public static int singleNumber(int[] nums) {

        int result = 0;

        for (int num : nums) {
            result = result ^ num;
        }

        return result;
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter " + n + " elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Calling user-defined method
        int answer = singleNumber(nums);

        System.out.println("Single Number: " + answer);

        sc.close();
    }
}