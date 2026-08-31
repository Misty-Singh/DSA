import java.util.Scanner;

public class MergeTwoSortedLists {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Create linked list from user input
    static Node createList(Scanner sc, int n) {

        Node head = null;
        Node temp = null;

        for (int i = 0; i < n; i++) {

            int value = sc.nextInt();

            Node newNode = new Node(value);

            if (head == null) {
                head = newNode;
                temp = newNode;
            } else {
                temp.next = newNode;
                temp = newNode;
            }
        }

        return head;
    }

    // Merge two sorted lists
    static Node merge(Node list1, Node list2) {

        Node dummy = new Node(0);
        Node temp = dummy;

        while (list1 != null && list2 != null) {

            if (list1.data <= list2.data) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }

            temp = temp.next;
        }

        // Attach remaining nodes
        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }

        return dummy.next;
    }

    // Display linked list
    static void display(Node head) {

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes in List 1: ");
        int n1 = sc.nextInt();

        System.out.println("Enter elements of List 1:");
        Node list1 = createList(sc, n1);

        System.out.print("Enter number of nodes in List 2: ");
        int n2 = sc.nextInt();

        System.out.println("Enter elements of List 2:");
        Node list2 = createList(sc, n2);

        System.out.print("List 1: ");
        display(list1);

        System.out.print("List 2: ");
        display(list2);

        Node result = merge(list1, list2);

        System.out.print("Merged List: ");
        display(result);

        sc.close();
    }
}