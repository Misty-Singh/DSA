import java.util.*;

public class BinaryTreePostorder {

    // Tree Node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Build tree from level-order array
    static TreeNode buildTree(int[] arr) {

        if (arr.length == 0 || arr[0] == -1) {
            return null;
        }

        TreeNode root = new TreeNode(arr[0]);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;

        while (i < arr.length) {

            TreeNode current = queue.poll();

            // Left child
            if (i < arr.length && arr[i] != -1) {
                current.left = new TreeNode(arr[i]);
                queue.add(current.left);
            }

            i++;

            // Right child
            if (i < arr.length && arr[i] != -1) {
                current.right = new TreeNode(arr[i]);
                queue.add(current.right);
            }

            i++;
        }

        return root;
    }

    // Postorder = Left → Right → Root
    static void postorder(TreeNode root, ArrayList<Integer> result) {

        if (root == null) {
            return;
        }

        // 1. Left
        postorder(root.left, result);

        // 2. Right
        postorder(root.right, result);

        // 3. Root
        result.add(root.val);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements (-1 for null):");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Build tree
        TreeNode root = buildTree(arr);

        // Postorder traversal
        ArrayList<Integer> result = new ArrayList<>();

        postorder(root, result);

        System.out.println("Postorder Traversal: " + result);

        sc.close();
    }
}