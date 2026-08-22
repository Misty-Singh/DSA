import java.util.Scanner;

public class LongestCommonPrefix {

    public static String findLongestCommonPrefix(String[] strs) {

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {

            int j = 0;

            // Compare characters of prefix and current string
            while (j < prefix.length()
                    && j < strs[i].length()
                    && prefix.charAt(j) == strs[i].charAt(j)) {
                j++;
            }

            // Keep only the matching part
            prefix = prefix.substring(0, j);

            if (prefix.isEmpty()) {
                return "";
            }
        }

        return prefix;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of strings: ");
        int n = sc.nextInt();

        sc.nextLine(); // consume newline

        String[] strs = new String[n];

        System.out.println("Enter strings:");

        for (int i = 0; i < n; i++) {
            strs[i] = sc.nextLine();
        }

        String result = findLongestCommonPrefix(strs);

        if (result.isEmpty()) {
            System.out.println("No common prefix found.");
        } else {
            System.out.println("Longest Common Prefix: " + result);
        }

        sc.close();
    }
}