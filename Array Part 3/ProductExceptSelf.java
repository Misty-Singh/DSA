import java.util.Scanner;

class ProductExceptSelfSolution {

    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];

        // Left product
        int leftProduct = 1;

        for (int i = 0; i < n; i++) {
            result[i] = leftProduct;
            leftProduct = leftProduct * nums[i];
        }

        // Right product
        int rightProduct = 1;

        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * rightProduct;
            rightProduct = rightProduct * nums[i];
        }

        return result;
    }
}

public class ProductExceptSelf {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        ProductExceptSelfSolution obj =
                new ProductExceptSelfSolution();

        int[] result = obj.productExceptSelf(nums);

        System.out.println("Product Except Self:");

        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }

        sc.close();
    }
}