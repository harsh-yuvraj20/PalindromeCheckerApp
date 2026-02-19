import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {
    public PalindromeCheckerApp() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\n===== Palindrome Checker App =====");
            System.out.println("1. Simple Palindrome Check");
            System.out.println("2. Case-Insensitive Palindrome Check");
            System.out.println("3. Ignore Special Characters Check");
            System.out.println("4. Stack-Based Palindrome Check");
            System.out.println("5. Recursive Palindrome Check");
            System.out.println("6. Exit");
            System.out.print("Choose an option (1-6): ");
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice >= 1 && choice <= 5) {
                System.out.print("Enter a string: ");
                String input = scanner.nextLine();
                boolean result = false;
                switch (choice) {
                    case 1:
                        result = isSimplePalindrome(input);
                        break;
                    case 2:
                        result = isCaseInsensitivePalindrome(input);
                        break;
                    case 3:
                        result = isCleanPalindrome(input);
                        break;
                    case 4:
                        result = isPalindromeUsingStack(input);
                        break;
                    case 5:
                        String cleaned = input.toLowerCase().replaceAll("[^a-z0-9]", "");
                        result = isRecursivePalindrome(cleaned, 0, cleaned.length() - 1);
                }

                if (result) {
                    System.out.println("Result: The string IS a palindrome.");
                } else {
                    System.out.println("Result: The string is NOT a palindrome.");
                }
            }
        } while(choice != 6);

        System.out.println("Exiting application. Goodbye!");
        scanner.close();
    }

    public static boolean isSimplePalindrome(String str) {
        int left = 0;

        for(int right = str.length() - 1; left < right; --right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            ++left;
        }

        return true;
    }

    public static boolean isCaseInsensitivePalindrome(String str) {
        return isSimplePalindrome(str.toLowerCase());
    }

    public static boolean isCleanPalindrome(String str) {
        str = str.toLowerCase().replaceAll("[^a-z0-9]", "");
        return isSimplePalindrome(str);
    }

    public static boolean isPalindromeUsingStack(String str) {
        Stack<Character> stack = new Stack();
        str = str.toLowerCase().replaceAll("[^a-z0-9]", "");

        int i;
        for(i = 0; i < str.length(); ++i) {
            stack.push(str.charAt(i));
        }

        for(i = 0; i < str.length(); ++i) {
            if (str.charAt(i) != (Character)stack.pop()) {
                return false;
            }
        }

        return true;
    }

    public static boolean isRecursivePalindrome(String str, int left, int right) {
        if (left >= right) {
            return true;
        } else {
            return str.charAt(left) != str.charAt(right) ? false : isRecursivePalindrome(str, left + 1, right - 1);
        }
    }
}