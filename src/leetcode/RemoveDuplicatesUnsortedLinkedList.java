package leetcode;

public class RemoveDuplicatesUnsortedLinkedList {
	static Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			this.data = d;
			next = null;
		}
	}

	void remove_duplicates() {
		Node ptr1 = null,ptr2 = null;
		ptr1 = head;
		// Outer loop to go through each element
		while (ptr1 != null && ptr1.next != null) {
			ptr2 = ptr1;
			// Inner loop to check for duplicates of the current node
			while (ptr2.next != null) {
				if (ptr1.data == ptr2.next.data) {
					// Duplicate found, remove it
					ptr2.next = ptr2.next.next;
				} else {
					ptr2 = ptr2.next;
				}
			}

			ptr1 = ptr1.next;
		}

	}

	void printList(Node nod) {

		while (nod != null) {
			System.out.print(nod.data +" ");
			nod = nod.next;
		}
	}

	public static void main(String[] args) {
		RemoveDuplicatesUnsortedLinkedList list = new RemoveDuplicatesUnsortedLinkedList();
		list.head = new Node(10);
		list.head.next = new Node(12);
		list.head.next.next = new Node(11);
		list.head.next.next.next = new Node(11);
		list.head.next.next.next.next = new Node(12);
		list.head.next.next.next.next.next = new Node(11);
		list.head.next.next.next.next.next.next = new Node(10);

		System.out.println("Linked List before removing duplicates : \n ");
		list.printList(head);

		list.remove_duplicates();
		System.out.println("");
		System.out.println("Linked List after removing duplicates : \n ");
		list.printList(head);

	}

}
