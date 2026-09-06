

import java.util.*;

public class TimeNeededToBuyTickets {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of people: ");
        int n = sc.nextInt();

        int[] tickets = new int[n];

        System.out.println("Enter ticket values:");

        for (int i = 0; i < n; i++) {
            tickets[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        int time = timeRequiredToBuy(tickets, k);

        System.out.println("Time = " + time);
    }

    public static int timeRequiredToBuy(int[] tickets, int k) {

        int time = 0;
        int target = tickets[k];

        for (int i = 0; i < tickets.length; i++) {

            if (i <= k) {
                time += Math.min(tickets[i], target);
            } else {
                time += Math.min(tickets[i], target - 1);
            }
        }

        return time;
    }
}