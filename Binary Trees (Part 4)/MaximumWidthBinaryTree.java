import java.util.*;

public class MaximumWidthBinaryTree {

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

    // Pair class
    // Stores node + its position/index
    static class Pair {
        TreeNode node;
        long index;

        Pair(TreeNode node, long index) {
            this.node = node;
            this.index = index;
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

    // Find maximum width
    static int maxWidth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Queue<Pair> queue = new LinkedList<>();

        // Root has index 0
        queue.add(new Pair(root, 0));

        long maxWidth = 0;

        while (!queue.isEmpty()) {

            int levelSize = queue.size();

            // Index of first node in this level
            long firstIndex = queue.peek().index;

            long lastIndex = 0;

            for (int i = 0; i < levelSize; i++) {

                Pair current = queue.remove();

                TreeNode node = current.node;

                long index = current.index;

                lastIndex = index;

                // Left child index
                if (node.left != null) {
                    queue.add(
                        new Pair(node.left, 2 * index + 1)
                    );
                }

                // Right child index
                if (node.right != null) {
                    queue.add(
                        new Pair(node.right, 2 * index + 2)
                    );
                }
            }

            // Width of current level
            long width = lastIndex - firstIndex + 1;

            maxWidth = Math.max(maxWidth, width);
        }

        return (int) maxWidth;
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

        // Calculate maximum width
        int answer = maxWidth(root);

        System.out.println("Maximum Width: " + answer);

        sc.close();
    }
}