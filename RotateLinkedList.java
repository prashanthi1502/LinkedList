import java.util.Scanner;

class LinkedList {
    Node head;
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
    }


    public void rotate(int k) {
        if (head == null || head.next == null || k == 0) return;

        Node current = head;
        int length = 1;
        while (current.next != null) {
            current = current.next;
            length++;
        }

        current.next = head;

        k = k % length;
        int stepsToNewHead = length - k;

        Node newTail = head;
        for (int i = 1; i < stepsToNewHead; i++) {
            newTail = newTail.next;
        }

        head = newTail.next;

        newTail.next = null;
    }

    // Method to print the linked list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedList list = new LinkedList();

        System.out.println("Enter elements for the linked list (type -1 to stop):");

        while (true) {
            int data = scanner.nextInt();
            if (data == -1) break;
            list.append(data);
        }

        System.out.print("Enter number of rotations: ");
        int k = scanner.nextInt();

        System.out.println("Original Linked List:");
        list.printList();

        list.rotate(k);

        System.out.println("Rotated Linked List:");
        list.printList();
    }
}