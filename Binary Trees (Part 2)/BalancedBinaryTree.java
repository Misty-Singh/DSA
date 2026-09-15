import java.util.*;

public class BalancedBinaryTree {

    // User-defined Node
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Create tree using level order
    static Node createTree(int[] values) {

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

    // Find height
    static int height(Node root) {

        // Empty tree has height 0
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    // Check balanced tree
    static boolean isBalanced(Node root) {

        // Empty tree is balanced
        if (root == null) {
            return true;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // Difference should not be more than 1
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        // Check left subtree
        if (!isBalanced(root.left)) {
            return false;
        }

        // Check right subtree
        if (!isBalanced(root.right)) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] values = new int[n];

        System.out.println("Enter tree values in level order (-1 for null):");

        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        // Create tree
        Node root = createTree(values);

        // Check balance
        boolean result = isBalanced(root);

        System.out.println("Is the tree balanced? " + result);

        sc.close();
    }
}
