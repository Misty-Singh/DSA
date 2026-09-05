import java.util.*;

public class ReverseFirstKQueue {

    public static void reverseFirstK(Queue<Integer> q, int k) {

        // If k is invalid
        if (q.size() < k || k <= 0) {
            return;
        }

        Stack<Integer> stack = new Stack<>();

        // Step 1: Remove first k elements
        // and put them into stack
        for (int i = 0; i < k; i++) {
            stack.push(q.remove());
        }

        // Step 2: Put them back into queue
        // Stack reverses their order
        while (!stack.isEmpty()) {
            q.add(stack.pop());
        }

        // Step 3: Move remaining elements
        // from front to back
        int remaining = q.size() - k;

        for (int i = 0; i < remaining; i++) {
            q.add(q.remove());
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Queue<Integer> q = new LinkedList<>();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " numbers:");

        for (int i = 0; i < n; i++) {
            q.add(sc.nextInt());
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        reverseFirstK(q, k);

        System.out.println("Queue after reversing first " + k + " elements:");
        System.out.println(q);

        sc.close();
    }
}