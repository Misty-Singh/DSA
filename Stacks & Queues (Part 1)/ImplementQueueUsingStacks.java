import java.util.*;

public class ImplementQueueUsingStacks {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    // Add element to queue
    public void push(int x) {
        s1.push(x);
    }

    // Remove element from front
    public int pop() {

        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        int ans = s2.pop();

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        return ans;
    }

    // Return front element
    public int peek() {

        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        int ans = s2.peek();

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        return ans;
    }

    // Check if empty
    public boolean empty() {
        return s1.isEmpty();
    }


    // MAIN METHOD
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ImplementQueueUsingStacks queue =
                new ImplementQueueUsingStacks();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " numbers:");

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            queue.push(x);
        }

        System.out.println("Front element = " + queue.peek());

        System.out.println("Removed element = " + queue.pop());

        System.out.println("New front = " + queue.peek());

        System.out.println("Is queue empty? " + queue.empty());

        sc.close();
    }
}