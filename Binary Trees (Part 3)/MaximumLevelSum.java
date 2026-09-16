import java.util.*;

public class MaximumLevelSum {

    // Node class
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    // Build binary tree using level order
    static Node buildTree(int[] values) {

        if (values.length == 0 || values[0] == -1) {
            return null;
        }

        Node root = new Node(values[0]);

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while (!queue.isEmpty() && i < values.length) {

            Node current = queue.poll();

            // Left child
            if (i < values.length && values[i] != -1) {
                current.left = new Node(values[i]);
                queue.add(current.left);
            }
            i++;

            // Right child
            if (i < values.length && values[i] != -1) {
                current.right = new Node(values[i]);
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }

    // Find level having maximum sum
    static int maxLevelSum(Node root) {

        if (root == null) {
            return 0;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        int level = 1;
        int answer = 1;

        int maxSum = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {

            int size = queue.size();
            int sum = 0;

            // Process one complete level
            for (int i = 0; i < size; i++) {

                Node current = queue.poll();

                sum += current.data;

                // Add left child
                if (current.left != null) {
                    queue.add(current.left);
                }

                // Add right child
                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            // Check maximum sum
            if (sum > maxSum) {
                maxSum = sum;
                answer = level;
            }

            level++;
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] values = new int[n];

        System.out.println(
            "Enter tree values in level order (-1 for null):"
        );

        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        // Build tree
        Node root = buildTree(values);

        // Find maximum level
        int answer = maxLevelSum(root);

        System.out.println("Level with Maximum Sum: " + answer);

        sc.close();
    }
}
