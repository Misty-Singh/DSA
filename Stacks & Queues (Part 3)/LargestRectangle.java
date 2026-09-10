import java.util.*;

public class LargestRectangle {

    public static int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i <= heights.length; i++) {

            int currentHeight;

            if (i == heights.length) {
                currentHeight = 0;
            } else {
                currentHeight = heights[i];
            }

            while (!stack.isEmpty() &&
                   currentHeight < heights[stack.peek()]) {

                int height = heights[stack.pop()];

                int width;

                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }

                int area = height * width;

                maxArea = Math.max(maxArea, area);
            }

            if (i < heights.length) {
                stack.push(i);
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] heights = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }

        int result = largestRectangleArea(heights);

        System.out.println("Largest Rectangle Area = " + result);

        sc.close();
    }
}