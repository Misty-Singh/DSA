-import java.util.Scanner;

class ContainerSolution {

    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;

        int maxWater = 0;

        while (left < right) {

            int width = right - left;

            int h = Math.min(height[left], height[right]);

            int area = width * h;

            maxWater = Math.max(maxWater, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}

public class ContainerWithMostWater {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] height = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }

        ContainerSolution obj = new ContainerSolution();

        int result = obj.maxArea(height);

        System.out.println("Maximum Water = " + result);

        sc.close();
    }
}