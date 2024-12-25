package leetcode_easy;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 * <p>
 * Time Complexity: O(n +m)
 * Space Complexity: O(1)
 */
public class Merge_Two_Sorted_Lists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode current = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        if (list1 != null) {
            current.next = list1;
            list1 = list1.next;
        }
        if (list2 != null) {
            current.next = list2;
            list2 = list2.next;
        }
        return head.next;
    }

    private void printList(ListNode root) {
        while (root != null) {
            System.out.print(" " + root.val);
            root = root.next;
        }
    }

    public static void main(String[] args) {
        Merge_Two_Sorted_Lists obj = new Merge_Two_Sorted_Lists();
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(2);
        list2.next = new ListNode(4);
        list2.next.next = new ListNode(6);
        ListNode mergedList = obj.mergeTwoLists(list1, list2);
        obj.printList(mergedList);
    }
}
