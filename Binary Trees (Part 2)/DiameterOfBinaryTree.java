import java.util.Scanner;

public class DiameterOfBinaryTree {

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

    static int diameter = 0;

    // Find height and diameter
    static int height(Node root) {

        // If no node
        if (root == null) {
            return 0;
        }

        // Find left height
        int leftHeight = height(root.left);

        // Find right height
        int rightHeight = height(root.right);

        // Diameter passing through current node
        int currentDiameter = leftHeight + rightHeight;

        // Update maximum diameter
        diameter = Math.max(diameter, currentDiameter);

        // Return height
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter root value: ");
        int rootValue = sc.nextInt();

        System.out.print("Enter left child of root: ");
        int leftValue = sc.nextInt();

        System.out.print("Enter right child of root: ");
        int rightValue = sc.nextInt();

        System.out.print("Enter left child of " + leftValue + ": ");
        int leftLeftValue = sc.nextInt();

        System.out.print("Enter right child of " + leftValue + ": ");
        int leftRightValue = sc.nextInt();

        // Create nodes
        Node root = new Node(rootValue);
        Node left = new Node(leftValue);
        Node right = new Node(rightValue);
        Node leftLeft = new Node(leftLeftValue);
        Node leftRight = new Node(leftRightValue);

        // Connect nodes
        root.left = left;
        root.right = right;

        left.left = leftLeft;
        left.right = leftRight;

        // Calculate diameter
        height(root);

        System.out.println("Diameter of Binary Tree: " + diameter);

        sc.close();
    }
}
