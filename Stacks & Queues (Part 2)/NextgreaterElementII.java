
import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;

        int[] next = new int[n];

        // Initially assume no greater element exists
        Arrays.fill(next, -1);

        Stack<Integer> stack = new Stack<>();

        // Traverse array twice
        for (int i = 0; i < 2 * n; i++) {

            int num = nums[i % n];

            // Find next greater element
            while (!stack.isEmpty() &&
                   nums[stack.peek()] < num) {

                next[stack.pop()] = num;
            }

            // Push only during first traversal
            if (i < n) {
                stack.push(i);
            }
        }

        return next;
    }
}