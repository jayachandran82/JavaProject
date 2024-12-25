package leetcode_easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 * Input: nums = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: [0,-10,5,null,-3,null,9] is also accepted:
 */
public class Binary_Search_Tree_Convert_Sorted_Array {

    private static TreeNode convertSortedArrayBST(int[] nums) {
        if (nums.length == 0) return null;
        return binarSearchTree(nums, 0, nums.length - 1);
    }

    private static TreeNode binarSearchTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        // Find the middle element
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        // Recursively build the left subtree
        node.left = binarSearchTree(nums, left, mid - 1);
        // Recursively build the right subtree
        node.right = binarSearchTree(nums, mid + 1, right);
        return node;
    }

    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = convertSortedArrayBST(nums);
        System.out.print("Output Tree (Level Order): ");
        printTree(root); // Optional print to visualize tree structure
    }


    // Helper method to print the tree in level order (optional)
    static private void printTree(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                System.out.print(node.val + " ");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                System.out.print("null ");
            }
        }
    }
}
