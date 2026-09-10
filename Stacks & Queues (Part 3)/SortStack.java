import java.util.*;

public class SortStack {

    // Function to sort the stack
    public static void sortStack(Stack<Integer> st) {

        Stack<Integer> temp = new Stack<>();

        while (!st.isEmpty()) {

            int current = st.pop();

            // Move larger elements back to original stack
            while (!temp.isEmpty() && temp.peek() > current) {
                st.push(temp.pop());
            }

            temp.push(current);
        }

        // Put elements back into original stack
        // without reversing the sorted order
        st.clear();

        for (int x : temp) {
            st.push(x);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take number of elements
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        Stack<Integer> st = new Stack<>();

        // Take stack elements
        System.out.println("Enter " + n + " elements:");

        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            st.push(value);
        }

        // Display original stack
        System.out.println("Original Stack: " + st);

        // Sort stack
        sortStack(st);

        // Display sorted stack
        System.out.println("Sorted Stack: " + st);

        sc.close();
    }
}