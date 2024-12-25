package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between)
 * <p>
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
 * <p>
 * Time Complexity : O(n)
 * <p>
 * O(n) for the Deque holding nodes of the current level.
 * O(n) for storing the result list of lists.
 * Total Space Complexity : O(n)
 */
public class Zigzag_Traversal_BinaryTree {
    // Breadth First Search (BFS)
    public static void main(String[] args) {
        Zigzag_Traversal_BinaryTree traversal = new Zigzag_Traversal_BinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        /**
         *         1
         *        / \
         *       2   3
         *      / \   \
         *     4   5   6
         */
        List<List<Integer>> levels = traversal.levelOrderZigzag(root);
        System.out.println(levels);
    }

    private List<List<Integer>> levelOrderZigzag(TreeNode head) {
        List<List<Integer>> result = new ArrayList<>();
        if (head == null) {
            return result;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(head);
        boolean leftToRight = true;

        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = leftToRight ? deque.pollFirst() : deque.pollLast();
                level.add(treeNode.val);
                if (leftToRight) {
                    if (treeNode.left != null) {
                        deque.offerLast(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        deque.offerLast(treeNode.right);
                    }
                } else {
                    if (treeNode.left != null) {
                        deque.offerFirst(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        deque.offerFirst(treeNode.right);
                    }
                }
            }
            result.add(level);
            leftToRight = !leftToRight;

        }
        return result;
    }
}
