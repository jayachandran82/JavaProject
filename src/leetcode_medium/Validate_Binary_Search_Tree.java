package leetcode_medium;

import java.util.LinkedList;
import java.util.List;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * A valid BST is defined as follows:
 * The left  subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * <p>
 * Example 1:
 * Input: root = [2,1,3]
 * Output: true
 * <p>
 * https://www.youtube.com/watch?v=sLoZJ2E4ZDs&ab_channel=NikhilLohia
 * <p>
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class Validate_Binary_Search_Tree {

    static private boolean isValidBST(TreeNode root) {
        boolean isBST = true;
        List<Integer> inOrderList = new LinkedList<>();
        checkBST(root, inOrderList);
        int prev = inOrderList.get(0);
        for (int i = 1; i < inOrderList.size(); i++) {
            if (inOrderList.get(i) <= prev) {
                isBST = false;
            }
            prev = inOrderList.get(i);
        }
        return isBST;
    }

    static void checkBST(TreeNode root, List<Integer> inOrderList) {
        if (root == null) return;
        checkBST(root.left, inOrderList);
        inOrderList.add(root.val);
        checkBST(root.right, inOrderList);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        // Adding left and right child
        //            3
        //          /  \
        //        1     5
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        boolean scenario_One = isValidBST(root);
        System.out.println("Validate Binary Search Tree Scenario One: " + scenario_One);

        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.right.left = new TreeNode(3);
        root1.right.right = new TreeNode(6);
        boolean scenario_Two = isValidBST(root1);
        System.out.println("Validate Binary Search Tree Scenario Two: " + scenario_Two);

    }
}
