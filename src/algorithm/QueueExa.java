package algorithm;

public class QueueExa {
	private class Node {
		private int data;
		private Node next;

		private Node(int data) {
			this.data = data;
		}
	}

	private Node head; // remove from the head
	private Node tail; // add thing to here

	public boolean isEmpty() {
		return head == null;
	}

	public int peak() {
		return head.data;
	}

	// first element is pushed into the queue
	public void enQueue(int data) {
		Node node = new Node(data);
		if (tail != null) {
			tail.next = node;
		}
		tail = node;
		if (head == null) {
			head = node;
		}
	}

	// same element when it has to be removed from the queue
	public int deQueue() {
		int data = head.data;
		head = head.next;
		if (head == null) {
			tail = null;
		}
		return data;
	}

	public static void main(String[] args) {
		QueueExa queue = new QueueExa();
		for (int i = 0; i < 10; i++) {
			queue.enQueue(i);
		}
		System.out.println("De Queue : "+queue.deQueue());
	}
}
