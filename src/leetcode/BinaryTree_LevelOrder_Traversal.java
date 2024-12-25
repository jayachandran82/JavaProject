package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 * <p>
 * Input: root = [1, 2, 3, 4, 5, 6]
 * Output: [[1], [2, 3], [4, 5, 6]]
 */

public class BinaryTree_LevelOrder_Traversal {
    //Level order && BFS(Breath First Search)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(root);
        while (!treeNodeQueue.isEmpty()) {
            int size = treeNodeQueue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = treeNodeQueue.poll();
                level.add(treeNode.val);
                if (treeNode.left != null) {
                    treeNodeQueue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    treeNodeQueue.offer(treeNode.right);
                }
            }
            result.add(level);
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryTree_LevelOrder_Traversal traversal = new BinaryTree_LevelOrder_Traversal();
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
        List<List<Integer>> levels = traversal.levelOrder(root);
        System.out.println(levels);
    }


}
