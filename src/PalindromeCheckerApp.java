import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string for UC10: ");
        String inputUC10 = scanner.nextLine();

        // Normalize: remove spaces and convert to lowercase
        String normalized = inputUC10.replaceAll("\\s+", "").toLowerCase();

        boolean isPalindromeUC10 = true;
        int n = normalized.length();

        for (int i = 0; i < n / 2; i++) {
            if (normalized.charAt(i) != normalized.charAt(n - 1 - i)) {
                isPalindromeUC10 = false;
                break;
            }
        }

        if (isPalindromeUC10) {
            System.out.println("The string '" + inputUC10 + "' is a palindrome (case-insensitive, spaces ignored).");
        } else {
            System.out.println("The string '" + inputUC10 + "' is NOT a palindrome (case-insensitive, spaces ignored).");
        }

        scanner.close();
    }
}