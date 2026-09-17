import java.util.*;

public class ConstructBinaryTree {

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

    // Map to store inorder positions
    static HashMap<Integer, Integer> map = new HashMap<>();

    // Variable for postorder
    static int postIndex;

    // Build tree
    static TreeNode buildTree(int[] inorder, int[] postorder,
                              int left, int right) {

        // No elements
        if (left > right) {
            return null;
        }

        // Take root from postorder
        int rootValue = postorder[postIndex];

        postIndex--;

        TreeNode root = new TreeNode(rootValue);

        // Find root position in inorder
        int rootPosition = map.get(rootValue);

        // IMPORTANT:
        // Build RIGHT first
        root.right = buildTree(
                inorder,
                postorder,
                rootPosition + 1,
                right
        );

        // Then build LEFT
        root.left = buildTree(
                inorder,
                postorder,
                left,
                rootPosition - 1
        );

        return root;
    }

    // Print preorder
    static void preorder(TreeNode root) {

        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");

        preorder(root.left);
        preorder(root.right);
    }

    // Print inorder
    static void inorder(TreeNode root) {

        if (root == null) {
            return;
        }

        inorder(root.left);

        System.out.print(root.data + " ");

        inorder(root.right);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        int[] inorderArray = new int[n];
        int[] postorderArray = new int[n];

        // Input inorder
        System.out.println("Enter inorder traversal:");

        for (int i = 0; i < n; i++) {
            inorderArray[i] = sc.nextInt();
        }

        // Input postorder
        System.out.println("Enter postorder traversal:");

        for (int i = 0; i < n; i++) {
            postorderArray[i] = sc.nextInt();
        }

        // Store inorder positions
        for (int i = 0; i < n; i++) {
            map.put(inorderArray[i], i);
        }

        // Start from last element of postorder
        postIndex = n - 1;

        // Build tree
        TreeNode root = buildTree(
                inorderArray,
                postorderArray,
                0,
                n - 1
        );

        // Display result
        System.out.print("Preorder of constructed tree: ");
        preorder(root);

        System.out.println();

        System.out.print("Inorder of constructed tree: ");
        inorder(root);

        System.out.println();

        sc.close();
    }
}