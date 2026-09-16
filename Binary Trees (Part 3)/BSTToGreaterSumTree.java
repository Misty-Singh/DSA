import java.util.*;

public class BSTToGreaterSumTree {

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

    // Sum of greater nodes
    static int sum = 0;

    // Reverse Inorder: Right -> Root -> Left
    static void inorder(Node root) {

        // Base case
        if (root == null) {
            return;
        }

        // First go to right side
        inorder(root.right);

        // Add previous greater sum
        root.data = root.data + sum;

        // Update sum
        sum = root.data;

        // Then go to left side
        inorder(root.left);
    }

    // Build tree using level order
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

    // Print tree in level order
    static void printTree(Node root) {

        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            Node current = queue.poll();

            System.out.print(current.data + " ");

            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
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

        // Build original BST
        Node root = buildTree(values);

        // Reset sum
        sum = 0;

        // Convert BST to Greater Sum Tree
        inorder(root);

        // Print result
        System.out.println("Greater Sum Tree (Level Order):");

        printTree(root);

        sc.close();
    }
}