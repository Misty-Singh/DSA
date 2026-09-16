import java.util.*;

public class TopViewBinaryTree {

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

    // Pair class
    static class Pair {
        Node node;
        int hd;

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
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

    // Top View
    static ArrayList<Integer> topView(Node root) {

        ArrayList<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<Pair> queue = new LinkedList<>();

        // TreeMap keeps HD in sorted order
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Root has HD = 0
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {

            Pair current = queue.poll();

            Node node = current.node;
            int hd = current.hd;

            // Only add the FIRST node at this HD
            if (!map.containsKey(hd)) {
                map.put(hd, node.data);
            }

            // Left child
            if (node.left != null) {
                queue.add(new Pair(node.left, hd - 1));
            }

            // Right child
            if (node.right != null) {
                queue.add(new Pair(node.right, hd + 1));
            }
        }

        // Left to right
        for (int value : map.values()) {
            result.add(value);
        }

        return result;
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] values = new int[n];

        System.out.println(
            "Enter tree values in level order (-1 for null):"
        );

        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        Node root = buildTree(values);

        ArrayList<Integer> answer = topView(root);

        System.out.println("Top View: " + answer);

        sc.close();
    }
}
