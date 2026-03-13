import java.util.Scanner;
import java.util.Stack;

class PalindromeChecker {

    public boolean checkPalindrome(String input) {
        String normalized = input.toLowerCase();
        Stack<Character> stack = new Stack<>();

        for (char ch : normalized.toCharArray()) {
            stack.push(ch);
        }

        for (int i = 0; i < normalized.length(); i++) {
            if (normalized.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string for UC11: ");
        String inputUC11 = scanner.nextLine();

        PalindromeChecker checker = new PalindromeChecker();
        boolean result = checker.checkPalindrome(inputUC11);

        if (result) {
            System.out.println("The string '" + inputUC11 + "' is a palindrome.");
        } else {
            System.out.println("The string '" + inputUC11 + "' is NOT a palindrome.");
        }

        scanner.close();
    }
}