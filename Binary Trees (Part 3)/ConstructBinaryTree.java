import java.util.*;

public class ConstructBinaryTree {

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

    // Index of current root in preorder
    static int preIndex = 0;

    // Construct Binary Tree
    static Node buildTree(int[] preorder, int[] inorder, int start, int end) {

        // No element
        if (start > end) {
            return null;
        }

        // Preorder gives the root
        int rootValue = preorder[preIndex];

        // Move to next preorder element
        preIndex++;

        // Create root node
        Node root = new Node(rootValue);

        // Find root in inorder
        int rootIndex = -1;

        for (int i = start; i <= end; i++) {
            if (inorder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }

        // Build left subtree
        root.left = buildTree(
                preorder,
                inorder,
                start,
                rootIndex - 1
        );

        // Build right subtree
        root.right = buildTree(
                preorder,
                inorder,
                rootIndex + 1,
                end
        );

        return root;
    }

    // Print tree in preorder
    static void printPreorder(Node root) {

        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");

        printPreorder(root.left);

        printPreorder(root.right);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Enter size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] preorder = new int[n];
        int[] inorder = new int[n];

        // Enter preorder
        System.out.println("Enter preorder elements:");

        for (int i = 0; i < n; i++) {
            preorder[i] = sc.nextInt();
        }

        // Enter inorder
        System.out.println("Enter inorder elements:");

        for (int i = 0; i < n; i++) {
            inorder[i] = sc.nextInt();
        }

        // Reset index
        preIndex = 0;

        // Build tree
        Node root = buildTree(
                preorder,
                inorder,
                0,
                n - 1
        );

        // Display result
        System.out.println("Constructed Tree Preorder:");

        printPreorder(root);

        sc.close();
    }
}