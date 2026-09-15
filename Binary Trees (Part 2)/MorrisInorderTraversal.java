import java.util.Scanner;

public class MorrisInorderTraversal {

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

    // Morris Inorder Traversal
    static void morrisInorder(Node root) {

        Node current = root;

        while (current != null) {

            // Case 1: No left child
            if (current.left == null) {

                // Visit current node
                System.out.print(current.data + " ");

                // Move to right
                current = current.right;
            }

            // Case 2: Left child exists
            else {

                // Find inorder predecessor
                Node predecessor = current.left;

                while (predecessor.right != null &&
                       predecessor.right != current) {

                    predecessor = predecessor.right;
                }

                // First time visiting predecessor
                if (predecessor.right == null) {

                    // Create temporary link
                    predecessor.right = current;

                    // Move to left subtree
                    current = current.left;
                }

                // Second time visiting predecessor
                else {

                    // Remove temporary link
                    predecessor.right = null;

                    // Visit current node
                    System.out.print(current.data + " ");

                    // Move to right subtree
                    current = current.right;
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create tree
        System.out.print("Enter root value: ");
        int rootValue = sc.nextInt();

        Node root = new Node(rootValue);

        System.out.print("Enter left child of root (-1 for no child): ");
        int leftValue = sc.nextInt();

        if (leftValue != -1) {
            root.left = new Node(leftValue);
        }

        System.out.print("Enter right child of root (-1 for no child): ");
        int rightValue = sc.nextInt();

        if (rightValue != -1) {
            root.right = new Node(rightValue);
        }

        System.out.print("Morris Inorder Traversal: ");

        morrisInorder(root);

        sc.close();
    }
}