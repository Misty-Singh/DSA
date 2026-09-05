import java.util.*;

class MyStack {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Push
    public void push(int x) {

        // Put new element in q2
        q2.add(x);

        // Move all old elements behind it
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }

        // Swap q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Pop
    public int pop() {
        return q1.remove();
    }

    // Top
    public int top() {
        return q1.peek();
    }

    // Empty
    public boolean empty() {
        return q1.isEmpty();
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MyStack stack = new MyStack();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " numbers:");

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            stack.push(x);
        }

        System.out.println("Top element = " + stack.top());

        System.out.println("Popped element = " + stack.pop());

        System.out.println("New top = " + stack.top());

        System.out.println("Is stack empty? " + stack.empty());

        sc.close();
    }
}