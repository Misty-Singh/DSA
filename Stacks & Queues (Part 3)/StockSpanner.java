import java.util.*;

public class StockSpanner {

    Stack<int[]> stack;

    // Constructor
    public StockSpanner() {
        stack = new Stack<>();
    }

    // Returns the span for today's price
    public int next(int price) {

        int span = 1;

        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }

        stack.push(new int[]{price, span});

        return span;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StockSpanner obj = new StockSpanner();

        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        System.out.println("Enter stock prices:");

        for (int i = 0; i < n; i++) {

            int price = sc.nextInt();

            int result = obj.next(price);

            System.out.println("Price = " + price + " , Span = " + result);
        }

        sc.close();
    }
}