package algorithm;
/**
 * 
 * @author Jayachandran
 * https://www.youtube.com/watch?v=wjI1WNcIntg
 */
public class StackExample {

 class Node{
	 private int data;
	 private Node next;
	 private Node(int data) {
		 this.data= data;
		 
	 }
 }
 private Node top;
 
 public boolean isEmpty() {
	 return top==null;
 }
 
 public int  peak() {
	 return top.data;
	 
 }
 
  public void push(int data) {
	  Node node = new Node(data);
	  top.next =node;
	  top= node;
  }
  
  public int pop() {
	  int data = top.data;
	  top= top.next;
	  return data;
  }
}
