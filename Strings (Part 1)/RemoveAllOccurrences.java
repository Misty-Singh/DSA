import java.util.Scanner;

public class RemoveAllOccurrences {

    static class Solution {

        public String RemoveOccurrences(String s, String part) {

            while (s.contains(part)) {
                int index = s.indexOf(part);

                s = s.substring(0, index)
                  + s.substring(index + part.length());
            }

            return s;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String s = sc.nextLine();

        System.out.print("Enter the part to remove: ");
        String part = sc.nextLine();

        Solution obj = new Solution();

        String result = obj.RemoveOccurrences(s, part);

        System.out.println("After removing all occurrences: " + result);

        sc.close();
    }
}