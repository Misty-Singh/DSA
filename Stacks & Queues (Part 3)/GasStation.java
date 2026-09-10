import java.util.*;

public class GasStation {

    public static int canCompleteCircuit(int[] gas, int[] cost) {

        int totalGas = 0;
        int totalCost = 0;

        int tank = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {

            totalGas += gas[i];
            totalCost += cost[i];

            tank += gas[i] - cost[i];

            // Cannot continue from current start
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        // If total gas is less than total cost,
        // completing the circuit is impossible
        if (totalGas < totalCost) {
            return -1;
        }

        return start;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of gas stations: ");
        int n = sc.nextInt();

        int[] gas = new int[n];
        int[] cost = new int[n];

        System.out.println("Enter gas values:");

        for (int i = 0; i < n; i++) {
            gas[i] = sc.nextInt();
        }

        System.out.println("Enter cost values:");

        for (int i = 0; i < n; i++) {
            cost[i] = sc.nextInt();
        }

        int result = canCompleteCircuit(gas, cost);

        System.out.println("Starting gas station index = " + result);

        sc.close();
    }
}