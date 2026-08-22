import java.util.Scanner;

public class ReverseWords {

    public static String reverseWords(String s) {

        // Remove extra spaces
        s = s.trim();

        // Split words using one or more spaces
        String[] words = s.split("\\s+");

        StringBuilder result = new StringBuilder();

        // Add words in reverse order
        for (int i = words.length - 1; i >= 0; i--) {

            result.append(words[i]);

            if (i != 0) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        String result = reverseWords(s);

        System.out.println("Reversed words: " + result);

        sc.close();
    }
}