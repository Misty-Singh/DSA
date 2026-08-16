import java.util.Scanner;
import java.util.Arrays;

class NextPermutationSolution {

    public void nextPermutation(int[] nums) {

        // Step 1: Find first decreasing element
        int i = nums.length - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // Step 2: Find element greater than nums[i]
        if (i >= 0) {

            int j = nums.length - 1;

            while (nums[j] <= nums[i]) {
                j--;
            }

            // Swap
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        // Step 3: Reverse remaining elements
        int left = i + 1;
        int right = nums.length - 1;

        while (left < right) {

            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}

public class NextPermuntation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        NextPermutationSolution obj = new NextPermutationSolution();

        obj.nextPermutation(nums);

        System.out.println("Next Permutation: "
                + Arrays.toString(nums));

        sc.close();
    }
}