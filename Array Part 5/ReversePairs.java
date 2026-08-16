import java.util.Scanner;

class ReversePairsSolution {

    public int ReversePairs(int[] nums) {

        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if ((long) nums[i] > 2L * nums[j]) {
                    count++;
                }
            }
        }

        return count;
    }
}

public class ReversePairs {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        ReversePairsSolution obj = new ReversePairsSolution();

        int result = obj.ReversePairs(nums);

        System.out.println("Number of Reverse Pairs = " + result);

        sc.close();
    }
}