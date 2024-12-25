package node;

public class ReverseLinkedList {
    public static void main(String[] args) {
        // Create a hard-coded linked list:
        // 1 -> 2 -> 3 -> 4 -> 5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.print("Given Linked list:");
        printList(head);

        head = reverseList(head);

        System.out.print("\nReversed Linked List:");
        printList(head);
    }

    static Node reverseList(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        Node prev = null;
        Node current = head;
        Node nextNode;
        while (current != null) {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        head = prev;

        return head;
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(" " + head.data);
            head = head.next;
        }
    }
}
