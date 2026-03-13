import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

// Strategy interface
interface PalindromeStrategy {
    boolean checkPalindrome(String input);
}

// Stack-based strategy
class StackStrategy implements PalindromeStrategy {
    public boolean checkPalindrome(String input) {
        String normalized = input.toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char ch : normalized.toCharArray()) stack.push(ch);
        for (int i = 0; i < normalized.length(); i++)
            if (normalized.charAt(i) != stack.pop()) return false;
        return true;
    }
}

// Deque-based strategy
class DequeStrategy implements PalindromeStrategy {
    public boolean checkPalindrome(String input) {
        String normalized = input.toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : normalized.toCharArray()) deque.addLast(ch);
        while (deque.size() > 1)
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        return true;
    }
}

// Context class
class PalindromeCheckerContext {
    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String input) {
        return strategy.checkPalindrome(input);
    }
}

public class PalindromeCheckerApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string for UC12: ");
        String inputUC12 = scanner.nextLine();

        PalindromeCheckerContext context = new PalindromeCheckerContext();

        // Example: choose strategy dynamically
        System.out.print("Choose strategy (1=Stack, 2=Deque): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        if (choice == 1) context.setStrategy(new StackStrategy());
        else context.setStrategy(new DequeStrategy());

        boolean result = context.check(inputUC12);

        if (result) System.out.println("The string '" + inputUC12 + "' is a palindrome.");
        else System.out.println("The string '" + inputUC12 + "' is NOT a palindrome.");

        scanner.close();
    }
}