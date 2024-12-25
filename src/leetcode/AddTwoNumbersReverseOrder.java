package leetcode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Time Complexity : O(n)
 * Space Complexity : O(n)
 */
public class AddTwoNumbersReverseOrder {

    public Node addTwoNumbers(Node l1, Node l2) {
        Node dummyHead = new Node(0);
        Node curr = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new Node(sum % 10);
            curr = curr.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return dummyHead.next;
    }

    void printNode(Node current) {
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        AddTwoNumbersReverseOrder obj = new AddTwoNumbersReverseOrder();
        // Example: 342 + 465 = 807 (represented as [2,4,3] + [5,6,4])
        Node l1 = new Node(2);
        l1.next = new Node(4);
        l1.next.next = new Node(3);

        Node l2 = new Node(5);
        l2.next = new Node(6);
        l2.next.next = new Node(4);

        Node result = obj.addTwoNumbers(l1, l2);
        obj.printNode(result); // Output: 7 0 8 (represents 807)
    }
}
