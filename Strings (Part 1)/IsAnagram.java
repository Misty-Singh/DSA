import java.util.Scanner;

public class IsAnagram {

    static class Solution {

        public boolean IsAnagram(String s, String t) {

            if (s.length() != t.length()) {
                return false;
            }

            int[] count = new int[26];

            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            for (char c : t.toCharArray()) {
                count[c - 'a']--;

                if (count[c - 'a'] < 0) {
                    return false;
                }
            }

            return true;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s = sc.nextLine();

        System.out.print("Enter second string: ");
        String t = sc.nextLine();

        Solution obj = new Solution();

        boolean result = obj.IsAnagram(s, t);

        System.out.println("Is Anagram: " + result);

        sc.close();
    }
}