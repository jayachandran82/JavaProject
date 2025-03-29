package leetcode_medium;

/**
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 * Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 * <p>
 * https://www.youtube.com/watch?v=yFTr_EnlERM&ab_channel=NareshGupta
 * <p>
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 */
public class Populating_Next_Right_Pointers {

//    private static Node connect(Node root) {
//        if(root == null ) return null ;
//        Node current = root;
//        while(current.left !=null){
//            Node temp = current;
//            while(current != null){
//                current.left.next = current.right;
//                current.right.next = (current.next == null) ? null : current.next.left;
//                current = current.next;
//            }
//            current = temp.left;
//        }
//        return root;
//    }
}
