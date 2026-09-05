import java.util.*;

public class FirstUniqueCharacter {

    public static int firstUniqChar(String s) {

        // Count frequency of every character
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            count[ch - 'a']++;
        }

        // Find first character whose count is 1
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (count[ch - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        int result = firstUniqChar(s);

        System.out.println("First unique character index = " + result);

        if (result != -1) {
            System.out.println("First unique character = " + s.charAt(result));
        } else {
            System.out.println("No unique character found.");
        }

        sc.close();
    }
}