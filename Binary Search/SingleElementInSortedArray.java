import java.util.Scanner;

public class SingleElementInSortedArray {

    static int singleNonDuplicate(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            // Make mid even
            if (mid % 2 == 1) {
                mid--;
            }

            // Pair is correct: nums[mid] == nums[mid + 1]
            if (nums[mid] == nums[mid + 1]) {
                left = mid + 2;
            } 
            else {
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter sorted array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = singleNonDuplicate(nums);

        System.out.println("Single Element: " + result);

        sc.close();
    }
}