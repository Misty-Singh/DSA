import java.util.Scanner;

public class MinimizedMaximum {

    static boolean canDistribute(int[] quantities, int n, int maxProducts) {

        int storesNeeded = 0;

        for (int quantity : quantities) {
            storesNeeded += (quantity + maxProducts - 1) / maxProducts;

            if (storesNeeded > n) {
                return false;
            }
        }

        return true;
    }

    static int minimizedMaximum(int n, int[] quantities) {

        int left = 1;
        int right = 0;

        // Find the maximum quantity
        for (int quantity : quantities) {
            right = Math.max(right, quantity);
        }

        int answer = right;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (canDistribute(quantities, n, mid)) {
                // mid is possible, try a smaller maximum
                answer = mid;
                right = mid - 1;
            } 
            else {
                // mid is too small
                left = mid + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of stores: ");
        int n = sc.nextInt();

        System.out.print("Enter number of product types: ");
        int m = sc.nextInt();

        int[] quantities = new int[m];

        System.out.println("Enter product quantities:");
        for (int i = 0; i < m; i++) {
            quantities[i] = sc.nextInt();
        }

        int result = minimizedMaximum(n, quantities);

        System.out.println("Minimized Maximum: " + result);

        sc.close();
    }
}