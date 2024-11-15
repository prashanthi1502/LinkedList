import java.util.HashSet;
import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class RemoveDuplicatesFromLinkedList {

    // Function to remove duplicates
    public static void removeDuplicates(Node head) {
        if (head == null) return;

        HashSet<Integer> seen = new HashSet<>();
        Node current = head;
        Node prev = null;

        while (current != null) {
            if (seen.contains(current.data)) {
                prev.next = current.next;
            } else {
                seen.add(current.data);
                prev = current;
            }
            current = current.next;
        }
    }
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Function to create a linked list from user input
    public static Node createLinkedList(Scanner scanner) {
        System.out.println("Enter the number of elements:");
        int n = scanner.nextInt();

        if (n == 0) {
            return null;
        }

        System.out.println("Enter the elements:");
        Node head = new Node(scanner.nextInt());
        Node current = head;

        for (int i = 1; i < n; i++) {
            current.next = new Node(scanner.nextInt());
            current = current.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create linked list from user input
        Node head = createLinkedList(scanner);

        System.out.println("Original list:");
        printList(head);

        // Remove duplicates
        removeDuplicates(head);

        System.out.println("List after removing duplicates:");
        printList(head);
    }
}