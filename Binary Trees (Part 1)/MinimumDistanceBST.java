import java.util.*;

public class MinimumDistanceBST {

    // Tree Node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Build BST from array
    static TreeNode insert(TreeNode root, int value) {

        if (root == null) {
            return new TreeNode(value);
        }

        if (value < root.val) {
            root.left = insert(root.left, value);
        } else {
            root.right = insert(root.right, value);
        }

        return root;
    }

    // Inorder traversal
    static void inorder(TreeNode root, ArrayList<Integer> result) {

        if (root == null) {
            return;
        }

        // Left
        inorder(root.left, result);

        // Root
        result.add(root.val);

        // Right
        inorder(root.right, result);
    }

    // Find minimum difference
    static int minDiffInBST(TreeNode root) {

        ArrayList<Integer> result = new ArrayList<>();

        // BST inorder gives sorted values
        inorder(root, result);

        int min = Integer.MAX_VALUE;

        for (int i = 1; i < result.size(); i++) {

            int difference = result.get(i) - result.get(i - 1);

            if (difference < min) {
                min = difference;
            }
        }

        return min;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter BST elements:");

        TreeNode root = null;

        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();

            root = insert(root, value);
        }

        // Show inorder
        ArrayList<Integer> result = new ArrayList<>();
        inorder(root, result);

        System.out.println("Inorder Traversal: " + result);

        // Minimum difference
        int answer = minDiffInBST(root);

        System.out.println("Minimum Difference: " + answer);

        sc.close();
    }
}