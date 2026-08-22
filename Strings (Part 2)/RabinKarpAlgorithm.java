import java.util.Scanner;

public class RabinKarpAlgorithm {

    public static void search(String text, String pattern) {

        int n = text.length();
        int m = pattern.length();

        if (m > n) {
            System.out.println("Pattern not found.");
            return;
        }

        int base = 256;
        int prime = 101;

        long patternHash = 0;
        long textHash = 0;
        long h = 1;

        // Calculate base^(m-1) % prime
        for (int i = 0; i < m - 1; i++) {
            h = (h * base) % prime;
        }

        // Calculate hash of pattern and first window of text
        for (int i = 0; i < m; i++) {
            patternHash = (base * patternHash + pattern.charAt(i)) % prime;
            textHash = (base * textHash + text.charAt(i)) % prime;
        }

        boolean found = false;

        // Slide the pattern over the text
        for (int i = 0; i <= n - m; i++) {

            // If hash values are same, compare characters
            if (patternHash == textHash) {

                boolean match = true;

                for (int j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    System.out.println("Pattern found at index: " + i);
                    found = true;
                }
            }

            // Calculate hash for the next window
            if (i < n - m) {

                textHash = (base * (textHash
                        - text.charAt(i) * h)
                        + text.charAt(i + m)) % prime;

                if (textHash < 0) {
                    textHash = textHash + prime;
                }
            }
        }

        if (!found) {
            System.out.println("Pattern not found.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.print("Enter pattern: ");
        String pattern = sc.nextLine();

        search(text, pattern);

        sc.close();
    }
}