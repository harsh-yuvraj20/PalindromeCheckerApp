import java.util.Stack;

public class U{

    public static void main(String[] args) {
        String input = "Radar";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));
        }

        String reversed = "";
        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        if (input.equalsIgnoreCase(reversed)) {
            System.out.println("The string '" + input + "' is a palindrome.");
        } else {
            System.out.println("The string '" + input + "' is NOT a palindrome.");
        }
    }
}
