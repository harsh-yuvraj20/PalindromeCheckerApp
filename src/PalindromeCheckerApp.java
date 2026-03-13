import java.util.Scanner;

public class PalindromeCheckerApp {

    public static boolean isPalindrome(String str, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return isPalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string for UC9: ");
        String inputUC9 = scanner.nextLine().toLowerCase();

        boolean result = isPalindrome(inputUC9, 0, inputUC9.length() - 1);

        if (result) {
            System.out.println("The string '" + inputUC9 + "' is a palindrome.");
        } else {
            System.out.println("The string '" + inputUC9 + "' is NOT a palindrome.");
        }

        scanner.close();
    }
}