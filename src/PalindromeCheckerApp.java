import java.util.Stack;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String inputUC5 = "Radar";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < inputUC5.length(); i++) {
            stack.push(inputUC5.charAt(i));
        }

        String reversedUC5 = "";
        while (!stack.isEmpty()) {
            reversedUC5 += stack.pop();
        }

        if (inputUC5.equalsIgnoreCase(reversedUC5)) {
            System.out.println("The string '" + inputUC5 + "' is a palindrome.");
        } else {
            System.out.println("The string '" + inputUC5 + "' is NOT a palindrome.");
        }

    }
}