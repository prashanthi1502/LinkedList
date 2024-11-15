import java.util.Scanner;

class Nodes {
    int data;
    Nodes next;

    Nodes(int data) {
        this.data = data;
        this.next = null;
    }
}

class Node3 {
    int data;
    Node3 next;

    Node3(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SplitLinkedList {
    Nodes head;

    void append(int data) {
        if (head == null) {
            head = new Nodes(data);
            return;
        }
        Nodes current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new Nodes(data);
    }

    void splitList() {
        if (head == null) return;

        Nodes slow = head, fast = head, secondHalf;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        secondHalf = slow.next;
        slow.next = null; // Split the list

        System.out.println("First half:");
        printList(head);
        System.out.println("Second half:");
        printList(secondHalf);
    }

    void printList(Nodes node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SplitLinkedList list = new SplitLinkedList();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter numbers to add to the linked list (0 to stop):");
        while (true) {
            int data = scanner.nextInt();
            if (data == 0) break;
            list.append(data);
        }

        list.splitList();

        // Example usage of Node3
        Node3 node3Head = new Node3(10);
        node3Head.next = new Node3(20);

        System.out.println("Node3 List:");
        printNode3List(node3Head);
    }

    static void printNode3List(Node3 node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}