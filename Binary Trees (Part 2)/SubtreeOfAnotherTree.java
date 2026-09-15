import java.util.*;

public class SubtreeOfAnotherTree {

    // Node
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

    // Check if two trees are same
    static boolean isSameTree(Node root, Node subRoot) {

        if (root == null && subRoot == null) {
            return true;
        }

        if (root == null || subRoot == null) {
            return false;
        }

        if (root.data != subRoot.data) {
            return false;
        }

        return isSameTree(root.left, subRoot.left)
                && isSameTree(root.right, subRoot.right);
    }

    // Check subtree
    static boolean isSubtree(Node root, Node subRoot) {

        if (root == null) {
            return false;
        }

        // Current node matches
        if (isSameTree(root, subRoot)) {
            return true;
        }

        // Search left and right
        return isSubtree(root.left, subRoot)
                || isSubtree(root.right, subRoot);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Root Tree
        System.out.print("Enter number of elements in Root Tree: ");
        int n1 = sc.nextInt();

        int[] rootValues = new int[n1];

        System.out.println("Enter Root Tree values in level order (-1 for null):");

        for (int i = 0; i < n1; i++) {
            rootValues[i] = sc.nextInt();
        }

        // SubTree
        System.out.print("Enter number of elements in SubTree: ");
        int n2 = sc.nextInt();

        int[] subValues = new int[n2];

        System.out.println("Enter SubTree values in level order (-1 for null):");

        for (int i = 0; i < n2; i++) {
            subValues[i] = sc.nextInt();
        }

        // Create trees
        Node root = createTree(rootValues);
        Node subRoot = createTree(subValues);

        // Check
        boolean result = isSubtree(root, subRoot);

        System.out.println();
        System.out.println("Is SubTree present? " + result);

        sc.close();
    }
}