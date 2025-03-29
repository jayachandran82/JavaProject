package leetcode_medium;

/**
 * Given the head of a linked list, return the list after sorting it in ascending order.
 * Input: head = [4,2,1,3]
 * Output: [1,2,3,4]
 * <p>
 * https://www.youtube.com/watch?v=GdYu6Z55LKw&ab_channel=EricProgramming
 * <p>
 * Time Complexity: O(n log n)
 * Space Complexity: O(1)
 */
public class Sort_List {
    // Two pointer approach => Slow & Fast
    // MergeSort

    private ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // Step 1: Split the list into two halves
        ListNode mid = middleNode(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;

        // Step 2: Recursively sort both halves
        left = sortList(left);
        right = sortList(right);

        // Step 3: Merge the two sorted halves
        return merge(left, right);
    }

    // find the middle of the linked list
    ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        if (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

    // merge two sorted linked lists
    ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        if (left != null) {
            current.next = left;
        } else {
            current.next = right;
        }

        return dummy.next;
    }


    public static void main(String[] args) {
        // Create the linked list: 4 -> 2 -> 1 -> 3
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        Sort_List solution = new Sort_List();
        ListNode sortedHead = solution.sortList(head);

        // Print the sorted linked list
        while (sortedHead != null) {
            System.out.print(sortedHead.val + " ");
            sortedHead = sortedHead.next;
        }
    }


}
