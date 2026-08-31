import java.util.Scanner;

public class FlattenMultilevelList {

    static class Node {
        int data;
        Node prev;
        Node next;
        Node child;

        Node(int data) {
            this.data = data;
        }
    }

    static Node flatten(Node head) {

        Node current = head;

        while (current != null) {

            if (current.child != null) {

                Node child = current.child;
                Node next = current.next;

                // Connect current to child
                current.next = child;
                child.prev = current;

                // Find end of child list
                Node temp = child;

                while (temp.next != null) {
                    temp = temp.next;
                }

                // Connect child list to original next
                temp.next = next;

                if (next != null) {
                    next.prev = temp;
                }

                current.child = null;
            }

            current = current.next;
        }

        return head;
    }

    static void display(Node head) {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // MAIN LIST
        System.out.print("Enter number of main nodes: ");
        int n = sc.nextInt();

        Node[] main = new Node[n];

        System.out.println("Enter main node values:");

        for (int i = 0; i < n; i++) {
            main[i] = new Node(sc.nextInt());
        }

        // Automatically connect main list
        for (int i = 0; i < n - 1; i++) {
            main[i].next = main[i + 1];
            main[i + 1].prev = main[i];
        }

        // CHILD LISTS
        System.out.print("Enter number of child connections: ");
        int c = sc.nextInt();

        for (int i = 0; i < c; i++) {

            System.out.print("Enter parent index: ");
            int parent = sc.nextInt();

            System.out.print("Enter child value: ");
            int value = sc.nextInt();

            Node child = new Node(value);

            main[parent].child = child;

            System.out.print("Enter number of nodes in child list after this: ");
            int count = sc.nextInt();

            Node temp = child;

            for (int j = 0; j < count; j++) {

                System.out.print("Enter child node value: ");
                Node newNode = new Node(sc.nextInt());

                temp.next = newNode;
                newNode.prev = temp;

                temp = newNode;
            }
        }

        System.out.print("Before flattening: ");
        display(main[0]);

        Node result = flatten(main[0]);

        System.out.print("After flattening: ");
        display(result);

        sc.close();
    }
}