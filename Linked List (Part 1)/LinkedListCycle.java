import java.util.Scanner;

public class LinkedListCycle {

    // User-defined Node
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Check whether cycle exists
    static boolean hasCycle(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;          // 1 step
            fast = fast.next.next;     // 2 steps

            // Both pointers meet
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        Node head = null;
        Node temp = null;

        // Store nodes for creating cycle
        Node[] nodes = new Node[n];

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {

            int value = sc.nextInt();

            Node newNode = new Node(value);

            nodes[i] = newNode;

            if (head == null) {
                head = newNode;
                temp = newNode;
            } else {
                temp.next = newNode;
                temp = newNode;
            }
        }

        System.out.print("Enter pos (-1 for no cycle): ");
        int pos = sc.nextInt();

        // Create cycle
        if (pos >= 0 && pos < n) {
            temp.next = nodes[pos];
        }

        // Check cycle
        boolean result = hasCycle(head);

        System.out.println("Cycle exists: " + result);

        sc.close();
    }
}