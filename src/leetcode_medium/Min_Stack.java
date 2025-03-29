package leetcode_medium;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * Implement the MinStack class:
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * You must implement a solution with O(1) time complexity for each function.
 * <p>
 * Example 1:
 * <p>
 * Input
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * Output
 * [null,null,null,null,-3,null,0,-2]
 * Explanation
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin(); // return -3
 * minStack.pop();
 * minStack.top();    // return 0
 * minStack.getMin(); // return -2
 * <p>
 * https://www.youtube.com/watch?v=To2iap-ac3g&ab_channel=DestinationFAANG
 * <p>
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */
public class Min_Stack {
    private Node head;

    public Min_Stack() {

    }

    public void push(int val) {
        if (head == null) {
            head = new Node(val, val, null);
        } else {
            head = new Node(val, Math.min(head.mini, val), head);
        }
    }

    private void pop() {
        head = head.next;
    }

    private int top() {
        return head.val;
    }

    private int getMin() {
        return head.mini;
    }

    private class Node {
        int val;
        int mini;
        Node next;

        Node(int val, int mini, Node next) {
            this.val = val;
            this.mini = mini;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Min_Stack minStack = new Min_Stack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // Output: -3
        minStack.pop();
        System.out.println(minStack.top());    // Output: 0
        System.out.println(minStack.getMin()); // Output: -2
    }
}
