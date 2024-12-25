package node;

public class DoubleLinkedList {
	class Node {
		int data;
		Node next;
		Node prev;

		Node(int data) {
			this.data = data;
		}
	}
	Node head, tail = null;

	public void addNode(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = tail = newNode;
			head.prev = null;
			tail.next = null;
		} else {
			//   head                  tail
			//        [prev|data|next]       [prev|data|next]
			tail.next = newNode;
			tail.prev = tail ;
			tail = newNode;
			tail.next = null;
		}
	}
	
	public void printNodes() {
		//Node current will point to head
		Node current = head;
		if(head == null) {
			System.out.println("Doubly linked list is empty"); 
			return;
		}
		while(current !=null) {
			System.out.println(current.data +"");
			current = current.next;
		}
	}

	public static void main(String[] args) {
		DoubleLinkedList dl_List = new DoubleLinkedList();
        //Add nodes to the list  
        dl_List.addNode(10);  
        dl_List.addNode(20);  
        dl_List.addNode(30);  
        dl_List.addNode(40);  
        dl_List.addNode(50);  
   
        //print the nodes of DoublyLinkedList  
        dl_List.printNodes();
	}

}
