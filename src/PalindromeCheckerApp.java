import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeCheckerAppUC7 {

    public static void main(String[] args) {

        String inputUC7 = "Radar";
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < inputUC7.length(); i++) {
            char ch = Character.toLowerCase(inputUC7.charAt(i));
            deque.addLast(ch);
        }

        boolean isPalindromeUC7 = true;

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                isPalindromeUC7 = false;
                break;
            }
        }

        if (isPalindromeUC7) {
            System.out.println("The string '" + inputUC7 + "' is a palindrome.");
        } else {
            System.out.println("The string '" + inputUC7 + "' is NOT a palindrome.");
        }

    }
}