
import java.util.*;

public class NextGreaterElement {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {

            int current = nums1[i];

            // Default answer
            result[i] = -1;

            // Find current element in nums2
            for (int j = 0; j < nums2.length; j++) {

                if (nums2[j] == current) {

                    // Search to the right
                    for (int k = j + 1; k < nums2.length; k++) {

                        if (nums2[k] > current) {
                            result[i] = nums2[k];
                            break;
                        }
                    }

                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // nums1
        System.out.print("Enter size of nums1: ");
        int n1 = sc.nextInt();

        int[] nums1 = new int[n1];

        System.out.println("Enter nums1 elements:");
        for (int i = 0; i < n1; i++) {
            nums1[i] = sc.nextInt();
        }

        // nums2
        System.out.print("Enter size of nums2: ");
        int n2 = sc.nextInt();

        int[] nums2 = new int[n2];

        System.out.println("Enter nums2 elements:");
        for (int i = 0; i < n2; i++) {
            nums2[i] = sc.nextInt();
        }

        // Call function
        int[] result = nextGreaterElement(nums1, nums2);

        // Print result
        System.out.println("Answer: " + Arrays.toString(result));

        sc.close();
    }
}