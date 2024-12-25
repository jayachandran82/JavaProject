package queue;

import java.util.Stack;

public class QueueWithTwoStacks {
	private Stack<Integer> stack1;
	private Stack<Integer> stack2;

	public QueueWithTwoStacks() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}

	public void enqueue(int item) {
		stack1.push(item);
	}

	public int dequeue() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		if (stack2.isEmpty()) {
			throw new RuntimeException("dequeue from an empty queue");
		}
		return stack2.pop();
	}

	public int peek() {
		if (stack2.isEmpty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		if (stack2.isEmpty()) {
			throw new RuntimeException("peek from an empty queue");
		}
		return stack2.peek();
	}

	public boolean isEmpty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}
	public static void main(String[] args) {
		QueueWithTwoStacks queue = new QueueWithTwoStacks();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);

		System.out.println(queue.dequeue());  // Output: 1
		System.out.println(queue.peek());     // Output: 2
		System.out.println(queue.dequeue());  // Output: 2
		System.out.println(queue.isEmpty());  // Output: false
		System.out.println(queue.dequeue());  // Output: 3
		System.out.println(queue.isEmpty());  // Output: true

	}
}
