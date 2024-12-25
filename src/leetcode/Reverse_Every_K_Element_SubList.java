package leetcode;

/**
 * Given the head of a linked list, reverse the nodes of the list k at a time, and return the modified list.
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 * You may not alter the values in the list's nodes, only nodes themselves may be changed.
 * <p>
 * Example 1:
 * Input: head = [1,2,3,4,5], k = 2
 * Output: [2,1,4,3,5]
 * <p>
 * Example 2:
 * Input: head = [1,2,3,4,5], k = 3
 * Output: [3,2,1,4,5]
 * <p>
 * https://www.youtube.com/watch?v=lIar1skcQYI&ab_channel=takeUforward
 */
public class Reverse_Every_K_Element_SubList {

    static Node kReverse(Node head, int k) {
        Node current = head;
        Node prevLast = null;

        while (current != null) {
            // Get the Kth node of the current group
            Node kThNode = getKthNode(current, k);

            if (kThNode == null) {
                // If there was a previous group, link the last node to the current node
                if (prevLast != null) {
                    prevLast.next = current;
                }
                break;
            }
            // Store the next node after the Kth node
            Node nextNode = kThNode.next;

            // Disconnect the Kth node to prepare for reversal
            kThNode.next = null;
            reverseNode(current);

            // Adjust the head if the reversal starts from the head
            if (head == current) {
                head = kThNode;
            } else {
                // Link the last node of the previous group to the reversed group
                prevLast.next = kThNode;
            }

            // Update the pointer to the last node of the previous group
            prevLast = current;
            // Move to the next group
            current = nextNode;
        }
        return head;
    }

    static Node getKthNode(Node head, int k) {
        // Decrement K as we already start from the 1st node
        //k = k - 1;
        while (head != null && k > 1) {
            head = head.next;
            k--;
        }
        return head;
    }

    static Node reverseNode(Node head) {
        Node prevNode = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prevNode;
            prevNode = current;
            current = nextNode;
        }
        head = prevNode;
        return head;
    }

    public static void main(String[] args) {
        // Create a linked list with values: 5, 4, 3, 7, 9 , 2
        Node head = new Node(5);
        head.next = new Node(4);
        head.next.next = new Node(3);
        head.next.next.next = new Node(7);
        head.next.next.next.next = new Node(9);
        head.next.next.next.next.next = new Node(2);

        // Print the original linked list
        System.out.print("Original Linked List: ");
        printLinkedList(head);

        // Reverse the linked list
        head = kReverse(head, 4);

        // Print the reversed linked list
        System.out.print("Reversed Linked List: ");
        printLinkedList(head);
    }

    static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print("  " + temp.val);
            temp = temp.next;
        }
        System.out.println();
    }
}
