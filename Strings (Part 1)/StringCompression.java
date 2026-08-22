import java.util.Scanner;

public class StringCompression {

    static class Solution {

        public int Compress(char[] chars) {

            int write = 0;
            int read = 0;

            while (read < chars.length) {

                char current = chars[read];
                int count = 0;

                // Count consecutive characters
                while (read < chars.length &&
                       chars[read] == current) {
                    read++;
                    count++;
                }

                // Store the character
                chars[write++] = current;

                // Store count if greater than 1
                if (count > 1) {

                    String countString = String.valueOf(count);

                    for (char c : countString.toCharArray()) {
                        chars[write++] = c;
                    }
                }
            }

            return write;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        char[] chars = new char[n];

        System.out.println("Enter characters:");

        for (int i = 0; i < n; i++) {
            chars[i] = sc.next().charAt(0);
        }

        Solution obj = new Solution();

        int newLength = obj.Compress(chars);

        System.out.print("Compressed array: ");

        for (int i = 0; i < newLength; i++) {
            System.out.print(chars[i]);

            if (i < newLength - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();

        System.out.println("New length: " + newLength);

        sc.close();
    }
}