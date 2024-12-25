package leetcode;

public class Reverse_Sub_List_LinkedList {
    public static void main(String[] args) {
        // Initialize linked list:
        // 10 -> 20 -> 30 -> 40 -> 50 -> 60 -> 70
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);
        head.next.next.next.next.next.next = new Node(70);

        System.out.print("Original list: ");
        print(head);

        head = reverseBetween(head, 3, 6);

        System.out.print("Modified list: ");
        print(head);
    }

    static void print(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(" " + current.val);
            current = current.next;
        }
        System.out.println();
    }

    static Node reverseBetween(Node head, int m, int n) {
        if (head == null || m == n) {
            return head;
        }

        Node current = head;
        Node prevNode = null;
        int i;
        for (i = 1; i < m; i++) {
            prevNode = current;
            current = current.next;
        }

        // Store pointers to the start and end of the reversed segment
        Node revTail = null;
        Node prevHead = current;
        Node nextNode;
        // Reverse the linked list from position m to n
        while (i <= n) {
            nextNode = current.next;
            current.next = revTail;
            revTail = current;
            current = nextNode;
            i++;
        }

        // Connect the reversed segment back to the list
        if (prevNode != null) {
            prevNode.next = revTail;
        } else {
            head = revTail;
        }

        prevHead.next = current;

        return head;
    }
}
