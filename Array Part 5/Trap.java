import java.util.Scanner;

class Solution {

    public int Trap(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;
        int water = 0;

        while (left < right) {

            if (height[left] <= height[right]) {

                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }

                left++;

            } else {

                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }

                right--;
            }
        }

        return water;
    }
}

public class Trap {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] height = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }

        Solution obj = new Solution();

        int result = obj.Trap(height);

        System.out.println("Trapped Rain Water = " + result);

        sc.close();
    }
}