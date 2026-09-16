import java.util.*;

public class LowestCommonAncestor {

    // Node class
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    // Pair class for building tree
    static class Pair {
        TreeNode node;
        int index;

        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    // Build binary tree using level order
    static TreeNode buildTree(int[] values) {

        if (values.length == 0 || values[0] == -1) {
            return null;
        }

        TreeNode root = new TreeNode(values[0]);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while (!queue.isEmpty() && i < values.length) {

            TreeNode current = queue.poll();

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

    // Find path from root to target
    static boolean getPath(TreeNode root, int target,
                           ArrayList<TreeNode> path) {

        // If node is null
        if (root == null) {
            return false;
        }

        // Add current node
        path.add(root);

        // Target found
        if (root.val == target) {
            return true;
        }

        // Search left or right
        if (getPath(root.left, target, path)
                || getPath(root.right, target, path)) {
            return true;
        }

        // Backtracking
        path.remove(path.size() - 1);

        return false;
    }

    // Find LCA
    static TreeNode lowestCommonAncestor(TreeNode root,
                                         int p, int q) {

        ArrayList<TreeNode> path1 = new ArrayList<>();
        ArrayList<TreeNode> path2 = new ArrayList<>();

        // Path root -> p
        getPath(root, p, path1);

        // Path root -> q
        getPath(root, q, path2);

        int i = 0;

        // Compare both paths
        while (i < path1.size()
                && i < path2.size()
                && path1.get(i) == path2.get(i)) {

            i++;
        }

        // Last common node
        return path1.get(i - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of elements
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
        TreeNode root = buildTree(values);

        // Enter p and q
        System.out.print("Enter p: ");
        int p = sc.nextInt();

        System.out.print("Enter q: ");
        int q = sc.nextInt();

        // Find LCA
        TreeNode answer = lowestCommonAncestor(root, p, q);

        System.out.println("Lowest Common Ancestor: " + answer.val);

        sc.close();
    }
}