package leetcode_easy;

/**
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
 * For example, the following two linked lists begin to intersect at node c1:
 * The test cases are generated such that there are no cycles anywhere in the entire linked structure.
 * Note that the linked lists must retain their original structure after the function returns.
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * Output: Intersected at '8'
 * <p>
 * https://www.youtube.com/watch?v=0JHQ26NQcPk&ab_channel=NikhilLohia
 * Time Complexity: O(n + m)
 * Space Complexity: O(1)
 */
public class Intersection_Two_Linked_Lists {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int nodeA = getlength(headA);
        int nodeB = getlength(headB);
        while (nodeA > nodeB) {
            nodeA--;
            headA = headA.next;
        }
        while (nodeB > nodeA) {
            nodeB--;
            headB = headB.next;

        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    private static int getlength(ListNode node) {
        int len = 0;
        while (node != null) {
            len++;
            node = node.next;
        }
        return len;

    }

    public static void main(String[] args) {
        // Create list1
        //    4 -> 1 -> 8 -> 4 -> 5 -> null
        // head1  l2   l3   l4   l5
        ListNode head1 = new ListNode(4);
        ListNode l2 = new ListNode(1);
        head1.next = l2;
        ListNode l3 = new ListNode(8);
        l2.next = l3;
        ListNode l4 = new ListNode(4);
        l3.next = l4;
        ListNode l5 = new ListNode(5);
        l4.next = l5;
        l5.next = null;

        // Create list2
        //    5 -> 6 -> 1 -> null
        // head2   b1   b2
        ListNode head2 = new ListNode(5);
        ListNode b1 = new ListNode(6);
        head2.next = b1;
        ListNode b2 = new ListNode(1);
        b1.next = b2;

        // Set up intersection point
        //         head1    l2
        //            4  ->  1
        //                     \ l3     l4     l5
        //                       8  ->  4  ->  5  ->  null
        //                     /
        //     5  ->  6  ->  1
        //  head2    b1     b2
        b2.next = l3;

        ListNode intersection = getIntersectionNode(head1, head2);
        if (intersection != null) {
            System.out.println("Intersection at node with value: " + intersection.val);
        } else {
            System.out.println("No intersection");
        }
    }
}
