package node;

public class SinglyLinkedList {

    class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }
    //Represent the head and tail of the singly linked list
    Node head = null;
    Node tail = null;

    //addNode() will add a new node to the list
    public void add(int data){
        Node currentNode = new Node(data);
        if(head ==null){
            head= tail=currentNode;
        }else{
            tail.next= currentNode;
            tail = currentNode;
        }
    }
    public void display(){
        //Node current will point to head
        Node current = head;
        if(head == null){
            System.out.println(" Empty Node");
            return;
        }
        while(current!=null){
            System.out.println(current.data +" ");
            current = current.next;
        }
    }
    public static void main(String[] args) {
        SinglyLinkedList singlyList = new SinglyLinkedList();
        singlyList.add(1);
        singlyList.add(8);
        singlyList.add(3);
        singlyList.add(9);

        singlyList.display();
    }
}
