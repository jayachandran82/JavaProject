package leetcode_medium;

/**
 * A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand-new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.
 * For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
 * Return the head of the copied linked list.
 * The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
 * Your code will only be given the head of the original linked list.
 * <p>
 * Example 1:
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * <p>
 * https://www.youtube.com/watch?v=_GBo_CgST1M&ab_channel=NikhilLohia
 * <p>
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class Copy_List_With_Random_Pointer {
    private static NodeR copyNodeRandomPointer(NodeR head) {
        if (head == null) return null;

        NodeR curr = head;

        // Step 1: Create new Node list with same values
        while (curr != null) {
            NodeR newNode = new NodeR(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        // Step 2: Copy the random pointer
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        // Step 3: Separate the two lists
        curr = head;
        NodeR newHead = head.next;
        NodeR newCur = newHead;
        while (curr != null) {
            curr.next = newCur.next;
            curr = curr.next;
            if (curr != null) {
                newCur.next = curr.next;
                newCur = newCur.next;
            }
        }
        return newHead;
    }

    public static void main(String[] args) {
        // Creating a linked list: [[7,null],[13,0],[11,4],[10,2],[1,0]]
        NodeR node1 = new NodeR(7);
        NodeR node2 = new NodeR(13);
        NodeR node3 = new NodeR(11);
        NodeR node4 = new NodeR(10);
        NodeR node5 = new NodeR(1);

        // Connecting next pointers
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        // Connecting random pointers
        node2.random = node1; // 13 → 7
        node3.random = node5; // 11 → 1
        node4.random = node3; // 10 → 11
        node5.random = node1; // 1 → 7

        System.out.println("Original List:");
        printList(node1);

        NodeR copiedHead = copyNodeRandomPointer(node1);

        System.out.println("\nCopied List:");
        printList(copiedHead);
    }


    // Utility method to print a linked list
    private static void printList(NodeR head) {
        NodeR temp = head;
        while (temp != null) {
            int randomVal = (temp.random != null) ? temp.random.val : -1;
            System.out.print("[" + temp.val + ", " + randomVal + "] → ");
            temp = temp.next;
        }
        System.out.println("null");
    }

}
