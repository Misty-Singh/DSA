import java.util.Scanner;

public class AddTwoNumbers {

    // User-defined Node
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // Dummy node to build the result
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        int carry = 0;

        // Continue while either list has nodes or carry exists
        while (l1 != null || l2 != null || carry != 0) {

            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // Create new node with last digit
            temp.next = new ListNode(sum % 10);

            // Calculate carry
            carry = sum / 10;

            temp = temp.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // First linked list
        System.out.print("Enter number of nodes in List 1: ");
        int n1 = sc.nextInt();

        ListNode l1 = null;
        ListNode tail1 = null;

        System.out.println("Enter elements of List 1:");

        for (int i = 0; i < n1; i++) {

            int value = sc.nextInt();

            ListNode newNode = new ListNode(value);

            if (l1 == null) {
                l1 = newNode;
                tail1 = newNode;
            } else {
                tail1.next = newNode;
                tail1 = newNode;
            }
        }

        // Second linked list
        System.out.print("Enter number of nodes in List 2: ");
        int n2 = sc.nextInt();

        ListNode l2 = null;
        ListNode tail2 = null;

        System.out.println("Enter elements of List 2:");

        for (int i = 0; i < n2; i++) {

            int value = sc.nextInt();

            ListNode newNode = new ListNode(value);

            if (l2 == null) {
                l2 = newNode;
                tail2 = newNode;
            } else {
                tail2.next = newNode;
                tail2 = newNode;
            }
        }

        // Add both numbers
        ListNode result = addTwoNumbers(l1, l2);

        // Print result
        System.out.println("Sum:");

        ListNode temp = result;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

        sc.close();
    }
}