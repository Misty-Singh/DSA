import java.util.*;

public class SymmetricTree {

    // Tree Node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Build tree from level-order array
    static TreeNode buildTree(int[] arr) {

        if (arr.length == 0 || arr[0] == -1) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while (i < arr.length) {

            TreeNode current = queue.poll();

            // Left child
            if (i < arr.length && arr[i] != -1) {
                current.left = new TreeNode(arr[i]);
                queue.add(current.left);
            }

            i++;

            // Right child
            if (i < arr.length && arr[i] != -1) {
                current.right = new TreeNode(arr[i]);
                queue.add(current.right);
            }

            i++;
        }

        return root;
    }

    // Check whether two trees are mirror images
    static boolean isMirror(TreeNode left, TreeNode right) {

        // Both are empty
        if (left == null && right == null) {
            return true;
        }

        // One is empty, one is not
        if (left == null || right == null) {
            return false;
        }

        // Values must be same
        if (left.val != right.val) {
            return false;
        }

        // Check mirror sides
        return isMirror(left.left, right.right)
                && isMirror(left.right, right.left);
    }

    // Check symmetric tree
    static boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        return isMirror(root.left, root.right);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements (-1 for null):");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Build tree
        TreeNode root = buildTree(arr);

        // Check symmetry
        boolean answer = isSymmetric(root);

        System.out.println("Is Tree Symmetric? " + answer);

        sc.close();
    }
}