import java.util.Scanner;

class StackNode {
    int data;
    StackNode next;

    // Constructor to create a new node
    public StackNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class StackUsingLinkedList {

    // top of the stack
    private StackNode top;
    public StackUsingLinkedList() {
        top = null;
    }


    public void push(int data) {
        StackNode newNode = new StackNode(data);
        newNode.next = top;
        top = newNode;
        System.out.println(data + " pushed onto the stack");
    }

    public int pop() {
        if (top == null) {
            System.out.println("Stack is empty. Cannot pop.");
            return -1;
        }
        int poppedData = top.data;
        top = top.next;
        return poppedData;
    }


    public int peek() {
        if (top == null) {
            System.out.println("Stack is empty.");
            return -1;
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }


    public void display() {
        if (top == null) {
            System.out.println("Stack is empty.");
            return;
        }
        StackNode current = top;
        System.out.print("Stack elements: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StackUsingLinkedList stack = new StackUsingLinkedList();

        while (true) {
            System.out.println("Stack Operations:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display Stack");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the element to push: ");
                    int element = scanner.nextInt();
                    stack.push(element);
                    break;
                case 2:
                    int poppedElement = stack.pop();
                    if (poppedElement != -1) {
                        System.out.println("Popped element: " + poppedElement);
                    }
                    break;
                case 3:
                    int topElement = stack.peek();
                    if (topElement != -1) {
                        System.out.println("Top element: " + topElement);
                    }
                    break;
                case 4:
                    stack.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}