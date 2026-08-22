import java.util.Scanner;

public class ReverseWords {

    static class Solution {

        public String ReverseWords(String s) {

            String[] words = s.trim().split("\\s+");

            StringBuilder result = new StringBuilder();

            for (int i = words.length - 1; i >= 0; i--) {

                result.append(words[i]);

                if (i != 0) {
                    result.append(" ");
                }
            }

            return result.toString();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        Solution obj = new Solution();

        String result = obj.ReverseWords(s);

        System.out.println("Reversed words: " + result);

        sc.close();
    }
}