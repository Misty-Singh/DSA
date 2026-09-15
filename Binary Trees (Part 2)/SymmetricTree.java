import java.util.Scanner;

public class SymmetricTree {

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

    // Check whether two sides are mirror images
    static boolean isMirror(Node left, Node right) {

        // Both are empty
        if (left == null && right == null) {
            return true;
        }

        // Only one is empty
        if (left == null || right == null) {
            return false;
        }

        // Values are different
        if (left.data != right.data) {
            return false;
        }

        // Check mirror
        return isMirror(left.left, right.right)
                && isMirror(left.right, right.left);
    }

    // Check symmetric tree
    static boolean isSymmetric(Node root) {

        if (root == null) {
            return true;
        }

        return isMirror(root.left, root.right);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter root value: ");
        int rootValue = sc.nextInt();

        System.out.print("Enter left child: ");
        int leftValue = sc.nextInt();

        System.out.print("Enter right child: ");
        int rightValue = sc.nextInt();

        System.out.print("Enter left child of " + leftValue + ": ");
        int leftLeftValue = sc.nextInt();

        System.out.print("Enter right child of " + leftValue + ": ");
        int leftRightValue = sc.nextInt();

        System.out.print("Enter left child of " + rightValue + ": ");
        int rightLeftValue = sc.nextInt();

        System.out.print("Enter right child of " + rightValue + ": ");
        int rightRightValue = sc.nextInt();

        // Create nodes
        Node root = new Node(rootValue);

        root.left = new Node(leftValue);
        root.right = new Node(rightValue);

        root.left.left = new Node(leftLeftValue);
        root.left.right = new Node(leftRightValue);

        root.right.left = new Node(rightLeftValue);
        root.right.right = new Node(rightRightValue);

        // Check symmetry
        boolean result = isSymmetric(root);

        System.out.println("Is the tree symmetric? " + result);

        sc.close();
    }
}