import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String inputUC6 = "Radar";
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stackUC6 = new Stack<>();

        for (int i = 0; i < inputUC6.length(); i++) {
            char ch = Character.toLowerCase(inputUC6.charAt(i));
            queue.add(ch);
            stackUC6.push(ch);
        }

        boolean isPalindromeUC6 = true;

        while (!queue.isEmpty() && !stackUC6.isEmpty()) {
            if (!queue.remove().equals(stackUC6.pop())) {
                isPalindromeUC6 = false;
                break;
            }
        }

        if (isPalindromeUC6) {
            System.out.println("The string '" + inputUC6 + "' is a palindrome.");
        } else {
            System.out.println("The string '" + inputUC6 + "' is NOT a palindrome.");
        }

    }
}