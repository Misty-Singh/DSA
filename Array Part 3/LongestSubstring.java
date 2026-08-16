import java.util.Scanner;

class LongestSubstringSolution {

    public int lengthOfLongestSubstring(String s) {

        int left = 0;
        int maxLength = 0;

        boolean[] seen = new boolean[256];

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            while (seen[ch]) {
                seen[s.charAt(left)] = false;
                left++;
            }

            seen[ch] = true;

            int length = right - left + 1;

            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }
}

public class LongestSubstring {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = sc.nextLine();

        LongestSubstringSolution obj =
                new LongestSubstringSolution();

        int result = obj.lengthOfLongestSubstring(s);

        System.out.println("Length of longest substring: " + result);

        sc.close();
    }
}