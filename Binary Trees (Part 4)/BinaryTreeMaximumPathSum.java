import java.util.*;

public class BinaryTreeMaximumPathSum {

    // TreeNode class
    static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    // Create tree using level order
    static TreeNode createTree(int[] values) {

        if (values.length == 0 || values[0] == -1) {
            return null;
        }

        TreeNode root = new TreeNode(values[0]);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while (i < values.length) {

            TreeNode current = queue.remove();

            // Left child
            if (i < values.length && values[i] != -1) {
                current.left = new TreeNode(values[i]);
                queue.add(current.left);
            }

            i++;

            // Right child
            if (i < values.length && values[i] != -1) {
                current.right = new TreeNode(values[i]);
                queue.add(current.right);
            }

            i++;
        }

        return root;
    }

    // Variable to store maximum path sum
    static int maxSum = Integer.MIN_VALUE;

    // Find maximum path sum
    static int findMaxPath(TreeNode root) {

        if (root == null) {
            return 0;
        }

        // Maximum sum coming from left side
        int left = findMaxPath(root.left);

        // Maximum sum coming from right side
        int right = findMaxPath(root.right);

        // Ignore negative paths
        left = Math.max(0, left);
        right = Math.max(0, right);

        // Path passing through current node
        int currentPath = root.data + left + right;

        // Update maximum answer
        maxSum = Math.max(maxSum, currentPath);

        // Return only one side to parent
        return root.data + Math.max(left, right);
    }

    // Preorder display
    static void preorder(TreeNode root) {

        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");

        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of values: ");
        int n = sc.nextInt();

        int[] values = new int[n];

        System.out.println("Enter tree values in level order:");
        System.out.println("Use -1 for NULL:");

        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        // Create tree
        TreeNode root = createTree(values);

        System.out.print("Tree (Preorder): ");
        preorder(root);

        System.out.println();

        // Calculate maximum path sum
        findMaxPath(root);

        System.out.println("Maximum Path Sum: " + maxSum);

        sc.close();
    }
}