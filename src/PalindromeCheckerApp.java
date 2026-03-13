import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PalindromeCheckerApp import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class PalindromeCheckerApp {

    // Stack-based
    public static boolean stackPalindrome(String input) {
        String str = input.toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) stack.push(ch);
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) != stack.pop()) return false;
        return true;
    }

    // Deque-based
    public static boolean dequePalindrome(String input) {
        String str = input.toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : str.toCharArray()) deque.addLast(ch);
        while (deque.size() > 1)
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        return true;
    }

    // Recursive
    public static boolean recursivePalindrome(String str, int start, int end) {
        if (start >= end) return true;
        if (str.charAt(start) != str.charAt(end)) return false;
        return recursivePalindrome(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        String testString = "AmanaplanacanalPanama".toLowerCase();

        long start, end;

        // Stack
        start = System.nanoTime();
        boolean stackResult = stackPalindrome(testString);
        end = System.nanoTime();
        System.out.println("Stack: " + stackResult + ", Time: " + (end - start) + " ns");

        // Deque
        start = System.nanoTime();
        boolean dequeResult = dequePalindrome(testString);
        end = System.nanoTime();
        System.out.println("Deque: " + dequeResult + ", Time: " + (end - start) + " ns");

        // Recursive
        start = System.nanoTime();
        boolean recResult = recursivePalindrome(testString, 0, testString.length() - 1);
        end = System.nanoTime();
        System.out.println("Recursive: " + recResult + ", Time: " + (end - start) + " ns");
    }
}