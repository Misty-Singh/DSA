import java.util.Scanner;

public class PermutationInString {

    static class Solution {

        public boolean CheckInclusion(String s1, String s2) {

            if (s1.length() > s2.length()) {
                return false;
            }

            int[] count = new int[26];

            // Count characters of s1
            for (char c : s1.toCharArray()) {
                count[c - 'a']++;
            }

            // First window
            for (int i = 0; i < s1.length(); i++) {
                count[s2.charAt(i) - 'a']--;
            }

            if (isZero(count)) {
                return true;
            }

            // Sliding window
            for (int i = s1.length(); i < s2.length(); i++) {

                // Add new character
                count[s2.charAt(i) - 'a']--;

                // Remove old character
                count[s2.charAt(i - s1.length()) - 'a']++;

                if (isZero(count)) {
                    return true;
                }
            }

            return false;
        }

        public boolean isZero(int[] count) {

            for (int value : count) {
                if (value != 0) {
                    return false;
                }
            }

            return true;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String s2 = sc.nextLine();

        Solution obj = new Solution();

        boolean result = obj.CheckInclusion(s1, s2);

        System.out.println("Permutation exists: " + result);

        sc.close();
    }
}