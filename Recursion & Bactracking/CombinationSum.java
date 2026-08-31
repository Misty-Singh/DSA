import java.util.*;

class CombinationSum {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Enter size of array
        System.out.print("Enter number of candidates: ");
        int n = sc.nextInt();

        int[] candidates = new int[n];

        // Enter candidates
        System.out.println("Enter candidates:");
        for (int i = 0; i < n; i++) {
            candidates[i] = sc.nextInt();
        }

        // Enter target
        System.out.print("Enter target: ");
        int target = sc.nextInt();

        List<List<Integer>> result = new ArrayList<>();

        // Generate combinations
        for (int i = 0; i < n; i++) {

            if (candidates[i] == target) {
                List<Integer> list = new ArrayList<>();
                list.add(candidates[i]);
                result.add(list);
            }
        }

        System.out.println("Result: " + result);

        sc.close();
    }
}