package leetcode;

/**
 * Given the beginning of a linked list head, return true if there is a cycle in the linked list. Otherwise, return false.
 * There is a cycle in a linked list if at least one node in the list that can be visited again by following the next pointer.
 * Internally, index determines the index of the beginning of the cycle, if it exists. The tail node of the list will set it's next pointer to the index-th node. If index = -1, then the tail node points to null and no cycle exists.
 * <p>
 * Note: index is not given to you as a parameter.
 *
 * https://www.youtube.com/watch?v=wiOo4DC5GGA&ab_channel=takeUforward
 */
public class Cycle_Detection_LinkedList {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        Cycle_Detection_LinkedList obj = new Cycle_Detection_LinkedList();
        int[] values1 = {3, 2, 0, -4};
        ListNode head1 = obj.createLinkedList(values1);
        boolean hasCycle1 = obj.hasCycle(head1);
        System.out.println("Test Case 1: " + (hasCycle1 ? "Cycle detected." : "No cycle."));

        // Test Case 2: Linked List with a cycle (cycle starts at node index 1)
        int[] values2 = {1, 2, 3, 4, 5};
        int pos2 = 1; // The tail connects to the node at index 1 (value 2)
        ListNode head2 = obj.createCyclicLinkedList(values2, pos2);
        boolean hasCycle2 = obj.hasCycle(head2);
        System.out.println("Test Case 2: " + (hasCycle2 ? "Cycle detected." : "No cycle."));

    }


    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer by one
            fast = fast.next.next; // Move fast pointer by two
            if (fast == slow) { // Cycle detected
                return true;
                //Find the starting point of the Loop/Cycle in LinkedList
                /**
                 *                slow = head;
                 *                 while(slow !=fast){
                 *                     slow = slow.next;
                 *                     fast = fast.next;
                 *                 }
                 *                 return slow;
                 */


            }
        }
        return false;
    }

    // Helper method to create a linked list without a cycle
    public ListNode createLinkedList(int[] values) {
        if (values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    // Helper method to create a linked list with a cycle
    public ListNode createCyclicLinkedList(int[] values, int pos) {
        if (values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        ListNode cycleNode = null;
        if (pos == 0) cycleNode = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
            if (i == pos) {
                cycleNode = current;
            }
        }
        if (cycleNode != null) {
            current.next = cycleNode; // Create the cycle
        }
        return head;
    }
}
