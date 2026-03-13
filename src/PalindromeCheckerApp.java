import java.util.Scanner;

public class UseCase8PalindromeCheckerApp {

    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string for UC8: ");
        String inputUC8 = scanner.nextLine().toLowerCase();

        // Convert string to singly linked list
        Node head = null, tail = null;
        for (char ch : inputUC8.toCharArray()) {
            Node node = new Node(ch);
            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        // Find middle using slow and fast pointers
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        Node prev = null, curr = slow, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node secondHalfHead = prev;

        // Compare first half and reversed second half
        Node firstHalf = head;
        Node secondHalf = secondHalfHead;
        boolean isPalindromeUC8 = true;
        while (secondHalf != null) {
            if (firstHalf.data != secondHalf.data) {
                isPalindromeUC8 = false;
                break;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        if (isPalindromeUC8) {
            System.out.println("The string '" + inputUC8 + "' is a palindrome.");
        } else {
            System.out.println("The string '" + inputUC8 + "' is NOT a palindrome.");
        }

        scanner.close();
    }
}