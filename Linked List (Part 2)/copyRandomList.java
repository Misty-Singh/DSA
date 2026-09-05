import java.util.HashMap;
import java.util.Scanner;

public class copyRandomList {

    // User-defined Node
    static class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {

        HashMap<Node, Node> map = new HashMap<>();

        Node temp = head;

        // Step 1: Create copy of every node
        while (temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }

        // Step 2: Connect next and random
        temp = head;

        while (temp != null) {

            Node newNode = map.get(temp);

            newNode.next = map.get(temp.next);
            newNode.random = map.get(temp.random);

            temp = temp.next;
        }

        return map.get(head);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        Node[] nodes = new Node[n];

        // Create nodes
        System.out.println("Enter node values:");

        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            nodes[i] = new Node(value);
        }

        // Connect next pointers
        for (int i = 0; i < n - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }

        // Enter random indexes
        System.out.println("Enter random indexes (-1 for null):");

        for (int i = 0; i < n; i++) {

            int randomIndex = sc.nextInt();

            if (randomIndex != -1) {
                nodes[i].random = nodes[randomIndex];
            }
        }

        Node head = nodes[0];

        // Copy the list
        Node newHead = copyRandomList(head);

        // Print copied list
        System.out.println("Copied Linked List:");

        Node temp = newHead;

        while (temp != null) {

            int randomValue;

            if (temp.random == null) {
                randomValue = -1;
            } else {
                randomValue = temp.random.val;
            }

            System.out.println(
                "Value = " + temp.val +
                ", Random = " + randomValue
            );

            temp = temp.next;
        }

        sc.close();
    }
}