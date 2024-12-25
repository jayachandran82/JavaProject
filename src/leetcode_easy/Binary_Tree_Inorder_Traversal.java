package leetcode_easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 * Example 1:
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 * <p>
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 *
 * https://www.youtube.com/watch?v=Uc5r-1q0pKY&ab_channel=TechTutor
 */
public class Binary_Tree_Inorder_Traversal {
    //Depth First Search

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        List<Integer> list = inorderTraversal(root);
        System.out.println("Binary Tree Inorder Traversal: " + list);
    }

    static public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list;

    }

    static void dfs(TreeNode root, List<Integer> list) {
        if (root != null) {
            if (root.left != null) {
                dfs(root.left, list);
            }
            list.add(root.val);
            if (root.right != null) {
                dfs(root.right, list);
            }
        }
    }

}
