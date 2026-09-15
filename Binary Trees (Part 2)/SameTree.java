import java.util.Scanner;

public class SameTree {

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

    // Check whether two trees are same
    static boolean isSameTree(Node p, Node q) {

        // Both are empty
        if (p == null && q == null) {
            return true;
        }

        // One is empty OR values are different
        if (p == null || q == null || p.data != q.data) {
            return false;
        }

        // Check left and right subtree
        return isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // -------- FIRST TREE --------

        System.out.println("Enter values for first tree:");

        System.out.print("Enter root: ");
        int pRoot = sc.nextInt();

        System.out.print("Enter left child: ");
        int pLeft = sc.nextInt();

        System.out.print("Enter right child: ");
        int pRight = sc.nextInt();

        Node p = new Node(pRoot);

        if (pLeft != -1) {
            p.left = new Node(pLeft);
        }

        if (pRight != -1) {
            p.right = new Node(pRight);
        }


        // -------- SECOND TREE --------

        System.out.println("\nEnter values for second tree:");

        System.out.print("Enter root: ");
        int qRoot = sc.nextInt();

        System.out.print("Enter left child: ");
        int qLeft = sc.nextInt();

        System.out.print("Enter right child: ");
        int qRight = sc.nextInt();

        Node q = new Node(qRoot);

        if (qLeft != -1) {
            q.left = new Node(qLeft);
        }

        if (qRight != -1) {
            q.right = new Node(qRight);
        }


        // Check
        boolean result = isSameTree(p, q);

        System.out.println("\nAre both trees same? " + result);

        sc.close();
    }
}