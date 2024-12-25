package node;


public class InsertNodeSpecificPosition {
    Node head;

    public InsertNodeSpecificPosition() {
        this.head = null;
    }

    public void insert(int data, int position) {
        Node newNode = new Node(data);
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node current = head;
        int currentPosition = 0;
        while (current != null && currentPosition < position - 1) {
            current = current.next;
            currentPosition++;
        }
        if (current == null) {
            System.out.println("Position out of bounds");
            return;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        InsertNodeSpecificPosition list = new InsertNodeSpecificPosition();
        list.insert(1, 0); // Insert at position 0
        list.insert(2, 1); // Insert at position 1
        list.insert(3, 1); // Insert at position 1
        list.insert(4, 3); // Insert at position 3
        list.display(); // Output: 1 3 2 4
    }
}
