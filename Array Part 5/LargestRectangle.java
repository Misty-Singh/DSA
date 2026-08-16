import java.util.Scanner;

class Solution {

    public int LargestRectangleArea(int[] heights) {

        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {

            int minHeight = heights[i];

            for (int j = i; j < heights.length; j++) {

                if (heights[j] < minHeight) {
                    minHeight = heights[j];
                }

                int width = j - i + 1;

                int area = minHeight * width;

                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }

        return maxArea;
    }
}

public class LargestRectangle {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] heights = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }

        Solution obj = new Solution();

        int result = obj.LargestRectangleArea(heights);

        System.out.println("Largest Rectangle Area = " + result);

        sc.close();
    }
}