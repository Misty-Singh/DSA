import java.util.Scanner;

public class LinkedListCycleII {

    // User-defined Node
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Find the node where cycle begins
    static Node detectCycle(Node head) {

        Node slow = head;
        Node fast = head;

        // Step 1: Find whether a cycle exists
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        // No cycle
        if (fast == null || fast.next == null) {
            return null;
        }

        // Step 2: Find the starting node of cycle
        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        Node head = null;
        Node temp = null;

        // Store nodes so that we can use pos later
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

        // Enter position
        System.out.print("Enter pos (-1 for no cycle): ");
        int pos = sc.nextInt();

        // Create cycle
        if (pos >= 0 && pos < n) {
            temp.next = nodes[pos];
        }

        // Find cycle
        Node result = detectCycle(head);

        if (result == null) {
            System.out.println("No cycle");
        } else {
            System.out.println("Cycle starts at node: " + result.data);
        }

        sc.close();
    }
}