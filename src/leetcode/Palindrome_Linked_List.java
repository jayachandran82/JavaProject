package leetcode;

/**
 * Given the head of a singly linked list, return true if it is a  palindrome or false otherwise.
 * <p>
 * Example 1:
 * Input: head = [1,2,2,1]
 * Output: true
 * <p>
 * Time complexity:  O(n)
 * Space complexity: O(1)
 * <p>
 * https://www.youtube.com/watch?v=lRY_G-u_8jk&ab_channel=takeUforward
 */
public class Palindrome_Linked_List {
    // 1. Find the middle of the list using the fast and slow pointer technique.
    // 2. Reverse the second half of the linked list.
    // 3. Compare the two halves element by element.

    boolean isPalindrome(Node head) {
        if (head == null || head.next != null) {
            return true;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && slow != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            fast = fast.next;
        }
        slow = reverseNode(slow);
        fast = head;
        while (slow != null) {
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    Node reverseNode(Node head) {
        Node preNode = null;
        Node currNode = head;
        Node nextNode;
        while (currNode != null) {
            nextNode = currNode.next;
            currNode.next = preNode;
            preNode = currNode;
            currNode = nextNode;
        }
        head = preNode;
        return head;
    }

    public static void main(String[] args) {
        // Creating a linked list: 1 -> 2 -> 2 -> 1
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        Palindrome_Linked_List obj = new Palindrome_Linked_List();
        boolean result = obj.isPalindrome(head);

        // Output the result
        System.out.println("Is the linked list a palindrome: " + result);
    }
}
