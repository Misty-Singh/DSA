import java.util.*;

public class FlattenBinaryTree {

    // Node of Binary Tree
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

    // Flatten Binary Tree
    static void flatten(TreeNode root) {

        if (root == null) {
            return;
        }

        // If left subtree exists
        if (root.left != null) {

            // Find rightmost node of left subtree
            TreeNode temp = root.left;

            while (temp.right != null) {
                temp = temp.right;
            }

            // Connect left subtree to original right subtree
            temp.right = root.right;

            // Move left subtree to right
            root.right = root.left;

            // Left should become null
            root.left = null;
        }

        // Continue with right side
        flatten(root.right);
    }

    // Print flattened tree
    static void printFlattened(TreeNode root) {

        while (root != null) {
            System.out.print(root.data + " ");

            // Move only through right
            root = root.right;
        }

        System.out.println();
    }

    // Preorder before flattening
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

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        int[] values = new int[n];

        System.out.println("Enter tree values in level order");
        System.out.println("Use -1 for NULL:");

        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        // Create tree
        TreeNode root = createTree(values);

        // Before flatten
        System.out.print("Before flattening (Preorder): ");
        preorder(root);

        System.out.println();

        // Flatten
        flatten(root);

        // After flatten
        System.out.print("After flattening: ");
        printFlattened(root);

        sc.close();
    }
}