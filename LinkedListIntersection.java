import java.util.Scanner;

public class LinkedListIntersection {
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

    public static Node getIntersectionNode(Node headA, Node headB) {
        if (headA == null || headB == null) return null;

        Node pointer1 = headA;
        Node pointer2 = headB;

        // Traverse both lists
        while (pointer1 != pointer2) {
            pointer1 = (pointer1 == null) ? headB : pointer1.next;
            pointer2 = (pointer2 == null) ? headA : pointer2.next;
        }

        return pointer1;
    }

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

        LinkedListIntersection list1 = new LinkedListIntersection();
        LinkedListIntersection list2 = new LinkedListIntersection();

        System.out.println("Enter elements for the first linked list (type -1 to stop):");

        while (true) {
            int data = scanner.nextInt();
            if (data == -1) break;
            list1.append(data);
        }

        System.out.println("Enter elements for the second linked list (type -1 to stop):");

        while (true) {
            int data = scanner.nextInt();
            if (data == -1) break;
            list2.append(data);
        }

        if (list1.head != null && list1.head.next != null) {
            System.out.println("Creating intersection at node with value: " + list1.head.next.data);
            list2.head.next.next = list1.head.next;
        }

        System.out.println("First Linked List:");
        list1.printList();

        System.out.println("Second Linked List:");
        list2.printList();

        // Finding intersection
        Node intersectionNode = getIntersectionNode(list1.head, list2.head);

        if (intersectionNode != null) {
            System.out.println("The intersection point is: " + intersectionNode.data);
        } else {
            System.out.println("No intersection point.");
        }
    }
}