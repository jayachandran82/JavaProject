package leetcode_easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 * Example 1:
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 * <p>
 * Time Complexity: O(n)
 * Space Complexity : O(n)
 */
public class Symmetric_Tree {
    //Level Order Traversal
    //Breadth First Search

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2, new TreeNode(3), new TreeNode(4));
        root.right = new TreeNode(2, new TreeNode(4), new TreeNode(3));
        boolean symetricTree = isSymmetric(root);
        System.out.println("Symetric Tree: " + symetricTree);
    }

    private static boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> leftQueue = new LinkedList<>();
        Queue<TreeNode> rightQueue = new LinkedList<>();
        leftQueue.add(root.left);
        rightQueue.add(root.right);
        while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
            TreeNode leftNode = leftQueue.poll();
            TreeNode rightNode = rightQueue.poll();
            if (leftNode == null && rightNode == null) continue;
            if (leftNode == null || rightNode == null) return false;
            if (leftNode.val != rightNode.val) return false;
            leftQueue.add(leftNode.left);
            leftQueue.add(leftNode.right);
            rightQueue.add(rightNode.right);
            rightQueue.add(rightNode.left);
        }
        return true;
    }
}
