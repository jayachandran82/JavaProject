package leetcode;

import java.util.PriorityQueue;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 * <p>
 * Example 1:
 * <p>
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 *  [
 *      1->4->5,
 *      1->3->4,
 *      2->6
 *  ]
 * merging them into one sorted list:
 *      1->1->2->3->4->4->5->6
 * <p>
 * Time Complexity : O(N log K).
 * Space Complexity: O(K)
 */

public class Merge_K_SortedList {

    public Node mergeKLists(Node[] lists) {
        if (lists == null || lists.length == 0) return null;

        // Min-heap to store the nodes based on their value
        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the head of each linked list to the min-heap
        for (Node head : lists) {
            if (head != null) {
                minHeap.add(head);
            }
        }

        Node dumy = new Node(-1);
        Node current = dumy;
        // Extract the minimum element and add its next node to the heap
        while (!minHeap.isEmpty()) {
            Node nextNode = minHeap.poll();
            current.next = nextNode;
            current = current.next;
            // If there is a next node, add it to the heap
            if (nextNode.next != null) {
                minHeap.add(nextNode.next);
            }
        }
        return dumy.next;
    }

    public static void main(String[] args) {
        Merge_K_SortedList merger = new Merge_K_SortedList();
        Node[] lists = new Node[3];
        lists[0] = new Node(1);
        lists[0].next = new Node(4);
        lists[0].next.next = new Node(5);

        lists[1] = new Node(1);
        lists[1].next = new Node(3);
        lists[1].next.next = new Node(4);

        lists[2] = new Node(2);
        lists[2].next = new Node(6);

        Node mergedList = merger.mergeKLists(lists);
        System.out.print("Merged List: ");
        merger.printList(mergedList);
    }

    void printList(Node head) {
        while (head != null) {
            System.out.print(" " + head.val);
            head = head.next;
        }

    }

}
