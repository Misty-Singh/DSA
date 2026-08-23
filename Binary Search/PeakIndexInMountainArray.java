import java.util.Scanner;

public class PeakIndexInMountainArray {

    static int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < arr[mid + 1]) {
                // We are on the increasing side
                left = mid + 1;
            } else {
                // We are on the decreasing side
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = peakIndexInMountainArray(arr);

        System.out.println("Peak Index: " + result);

        sc.close();
    }
}