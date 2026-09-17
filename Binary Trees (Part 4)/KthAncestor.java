import java.util.Scanner;

public class KthAncestor {

    // Find kth ancestor
    static int getKthAncestor(int[] parent, int node, int k) {

        // Move k times towards the root
        while (k > 0 && node != -1) {

            // Move to parent
            node = parent[node];

            // One ancestor completed
            k--;
        }

        // If no ancestor exists, node will be -1
        return node;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of nodes
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        // Parent array
        int[] parent = new int[n];

        System.out.println("Enter parent array:");

        for (int i = 0; i < n; i++) {
            parent[i] = sc.nextInt();
        }

        // Node
        System.out.print("Enter node: ");
        int node = sc.nextInt();

        // K
        System.out.print("Enter k: ");
        int k = sc.nextInt();

        // Find answer
        int answer = getKthAncestor(parent, node, k);

        System.out.println("Kth Ancestor: " + answer);

        sc.close();
    }
}