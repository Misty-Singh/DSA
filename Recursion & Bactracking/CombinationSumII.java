import java.util.*;

class CombinationSumII {

    static void findCombinations(int[] arr, int target, int start,
                                 List<Integer> current,
                                 List<List<Integer>> result) {

        // Target achieved
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < arr.length; i++) {

            // Skip duplicate elements
            if (i > start && arr[i] == arr[i - 1]) {
                continue;
            }

            // No need to continue
            if (arr[i] > target) {
                break;
            }

            // Choose
            current.add(arr[i]);

            // i + 1 = element can be used only once
            findCombinations(arr, target - arr[i], i + 1,
                             current, result);

            // Backtrack
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        // Sort the array
        Arrays.sort(arr);

        List<List<Integer>> result = new ArrayList<>();

        findCombinations(arr, target, 0,
                         new ArrayList<>(), result);

        System.out.println("Combinations:");

        for (List<Integer> list : result) {
            System.out.println(list);
        }

        sc.close();
    }
}