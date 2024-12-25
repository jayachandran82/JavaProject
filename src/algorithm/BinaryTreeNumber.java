package algorithm;
/*             A
			|     |
          B           C
        |   |       |   |
     D        E    F     G
// 1).In-Order   ==> Start from Left node then, Root Node then, Right Node(D → B → E → A → F → C → G)
// 2).Pre-Order  ==> Start from Root Node then, Left Node then, Right Node(A → B → D → E → C → F → G)
// 3).Post-Order ==> Start from Left Node then, Right Node then, Root Node(D → E → B → F → G → C → A)
**/

import java.util.Arrays;

public class BinaryTreeNumber {

    private int data;
    private BinaryTreeNumber left;
    private BinaryTreeNumber right;

    public BinaryTreeNumber(int num) {
        this.data = num;
        this.left = null;
        this.right = null;
    }

    // As a convention, if the key to be inserted is less than the key of root node,
    // then key is inserted in
    // left sub-tree; If key is greater, it is inserted in right sub-tree. If it is
    // equal, as a convention, it
    // is inserted in right sub-tree
    public void addNode(int num) {
        if (num < this.data) {
            if (this.left != null) {
                this.left.addNode(num);
            } else {
                this.left = new BinaryTreeNumber(num);
            }

        } else {
            if (this.right != null) {
                this.right.addNode(num);
            } else {
                this.right = new BinaryTreeNumber(num);
            }

        }
    }

    // Visit left sub-tree, then node and then, right sub-tree
    // 1).In-Order   ==> Start from Left node then, Root Node then, Right Node(D → B → E → A → F → C → G)
    void traverseInOrder() {
        if (this.left != null) {
            this.left.traverseInOrder();
        }
        System.out.print(" " + this.data);
        if (this.right != null) {
            this.right.traverseInOrder();
        }
    }

    // 2).Pre-Order  ==> Start from Root Node then, Left Node then, Right Node(A → B → D → E → C → F → G)
    void traversePreOrder() {
        System.out.print(" " + this.data);
        if (this.left != null) {
            this.left.traversePreOrder();
        }
        if (this.right != null) {
            this.right.traversePreOrder();
        }
    }

    // 3).Post-Order ==> Start from Left Node then, Right Node then, Root Node(D → E → B → F → G → C → A)
    void traversePostOrder() {
        if (this.left != null) {
            this.left.traversePostOrder();
        }
        if (this.right != null) {
            this.right.traversePostOrder();
        }
        System.out.print(" " + this.data);
    }

    public static void main(String[] args) {
        BinaryTreeNumber tree = new BinaryTreeNumber(6);
        int[] nums = {1, 2, 3, 4, 25, 0, 6, 7, 8, 9};
        System.out.println(" Before Actual list: " + Arrays.toString(nums));
        for (int i : nums) {
            tree.addNode(i);
        }

        System.out.println("\n In Order : ");
        tree.traverseInOrder();
        System.out.println("\n Pre Order: ");
        tree.traversePreOrder();
        System.out.println("\n Post Order");
        tree.traversePostOrder();
    }
}
