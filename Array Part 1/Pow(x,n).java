
import java.util.*;

class PowXN {

    // User-defined method
    public static double myPow(double x, int n) {

        long power = n;   // long is important for Integer.MIN_VALUE
        double result = 1;

        if (power < 0) {
            x = 1 / x;
            power = -power;
        }

        while (power > 0) {

            if (power % 2 == 1) {
                result = result * x;
            }

            x = x * x;
            power = power / 2;
        }

        return result;
    }

    // Main method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter x: ");
        double x = sc.nextDouble();

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        // Calling user-defined method
        double answer = myPow(x, n);

        System.out.println("Answer: " + answer);

        sc.close();
    }
}