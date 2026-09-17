import java.util.*;

public class BinaryTreeZigzag {

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

    // Zigzag traversal
    static void zigzag(TreeNode root) {

        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        boolean leftToRight = true;

        System.out.println("Zigzag Traversal:");

        while (!queue.isEmpty()) {

            int size = queue.size();

            ArrayList<Integer> level = new ArrayList<>();

            // Process current level
            for (int i = 0; i < size; i++) {

                TreeNode node = queue.remove();

                level.add(node.data);

                // Add children to queue
                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            // Reverse alternate level
            if (!leftToRight) {
                Collections.reverse(level);
            }

            System.out.println(level);

            // Change direction
            leftToRight = !leftToRight;
        }
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

        // Zigzag traversal
        zigzag(root);

        sc.close();
    }
}