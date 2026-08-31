import java.util.*;

public class SubsetsII {

    // User-defined method for generating subsets
    public static void findSubsets(int[] nums, int start,
                                   ArrayList<Integer> current,
                                   ArrayList<ArrayList<Integer>> result) {

        // Add current subset to result
        result.add(new ArrayList<>(current));

        // Try all elements
        for (int i = start; i < nums.length; i++) {

            // Skip duplicate elements
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            // Choose
            current.add(nums[i]);

            // Recursive call
            findSubsets(nums, i + 1, current, result);

            // Undo choice
            current.remove(current.size() - 1);
        }
    }

    // User-defined method
    public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] nums) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        // Sort to bring duplicates together
        Arrays.sort(nums);

        ArrayList<Integer> current = new ArrayList<>();

        findSubsets(nums, 0, current, result);

        return result;
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        ArrayList<ArrayList<Integer>> result = subsetsWithDup(nums);

        System.out.println("All unique subsets:");

        for (ArrayList<Integer> subset : result) {
            System.out.println(subset);
        }

        sc.close();
    }
}