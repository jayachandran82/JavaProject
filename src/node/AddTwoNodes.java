package node;

/**
 * Given two numbers represented by two lists, write a function that returns the sum in the form of a linked list.
 * Input:
 * List1: 5->6->3 // represents number 563
 * List2: 8->4->2 // represents number 842
 * Output:
 * Resultant list: 1->4->0->5 // represents number 1405
 * Explanation: 563 + 842 = 1405
 */
//public class AddTwoNodes {


class AddTwoNodes {

    Node head1, head2;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node addTwoLists(Node l1, Node l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        Node dumy_head = new Node(0);
        Node l3 = dumy_head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int a = l1 != null ? l1.data : 0;
            int b = l2 != null ? l2.data : 0;
            int sum = a + b + carry;
            carry = sum / 10;
            int last_digit = sum % 10;
            Node new_node = new Node(last_digit);
            l3.next = new_node;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            l3 = l3.next;
        }
        if (carry > 0) {
            Node new_node = new Node(carry);
            l3.next = new_node;
            l3 = l3.next;
        }


        return dumy_head.next;
    }
    /*    *//* Adds contents of two linked lists and prints it *//*
    Node addTwoLists(Node first, Node second) {
        Node start1 = new Node(0);
        start1.next = first;
        Node start2 = new Node(0);
        start2.next = second;

        addPrecedingZeros(start1, start2);
        Node result = new Node(0);
        if (sumTwoNodes(start1.next, start2.next, result) == 1) {
            Node node = new Node(1);
            node.next = result.next;
            result.next = node;
        }

        //printList(result.next);
        return result.next;
    }*/

    /* Adds lists and returns the carry */
    private int sumTwoNodes(Node first, Node second, Node result) {
        if (first == null) {
            return 0;
        }
        int number = first.data + second.data + sumTwoNodes(first.next, second.next, result);
        Node node = new Node(number % 10);
        node.next = result.next;
        result.next = node;
        return number / 10;
    }


    /* Utility function to print a linked list */
    void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println("");
    }

    Node reverseNode(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return node = prev;
    }

    // Driver Code
    public static void main(String[] args) {
        AddTwoNodes list = new AddTwoNodes();

        // creating first list
        list.head1 = new Node(5);
        list.head1.next = new Node(6);
        list.head1.next.next = new Node(3);


        // creating second list
        list.head2 = new Node(8);
        list.head2.next = new Node(4);
        list.head2.next.next = new Node(2);

        System.out.print("Resultant List is ");

        Node l1 = list.reverseNode(list.head1);
        list.printList(l1);
        Node l2 = list.reverseNode(list.head2);
        list.printList(l2);
        // add the two lists and see the result

        Node result = list.addTwoLists(l1, l2);
        Node finalResult = list.reverseNode(result);
        list.printList(finalResult);

    }
}