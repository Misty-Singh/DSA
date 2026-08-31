import java.util.*;

class PalindromePartitioning {

    static void partition(String s, int start,
                          List<String> current,
                          List<List<String>> result) {

        // If we reached the end of string
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Try every possible substring
        for (int end = start; end < s.length(); end++) {

            String part = s.substring(start, end + 1);

            // Check if substring is palindrome
            if (isPalindrome(part)) {

                // Choose
                current.add(part);

                // Move to next part
                partition(s, end + 1, current, result);

                // Backtrack
                current.remove(current.size() - 1);
            }
        }
    }

    static boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // User enters string
        System.out.print("Enter string: ");
        String s = sc.nextLine();

        List<List<String>> result = new ArrayList<>();

        partition(s, 0, new ArrayList<>(), result);

        System.out.println("Palindrome partitions:");

        for (List<String> list : result) {
            System.out.println(list);
        }

        sc.close();
    }
}