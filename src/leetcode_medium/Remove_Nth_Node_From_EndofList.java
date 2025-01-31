package leetcode_medium;

import leetcode.Node;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * <p>
 * https://www.youtube.com/watch?v=6gI8OMoac4Q&ab_channel=NikhilLohia
 * <p>
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class Remove_Nth_Node_From_EndofList {
    // Two Pointer Technique

    static private ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode firstPtr = dummy;
        ListNode secondPtr = dummy;

        for (int i = 0; i < n; i++) {
            secondPtr = secondPtr.next;
        }

        while (secondPtr.next != null) {
            secondPtr = secondPtr.next;
            firstPtr = firstPtr.next;
        }
        firstPtr.next = firstPtr.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        int n = 2;
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode result = removeNthFromEnd(head, n);
        printNode(result);
    }

    static void printNode(ListNode current) {
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

}
