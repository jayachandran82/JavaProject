package leetcode_medium;

import java.util.HashMap;

/**
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 * Example 1:
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * <p>
 * https://www.youtube.com/watch?v=PbPS460rbMo&ab_channel=NikhilLohia
 * <p>
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class BinaryTree_Preorder_Inorder_Traversal {
    //Construct Binary Tree from Preorder and Inorder Traversal

    private static TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return splitTree(preorder, inOrderMap, 0, 0, inorder.length - 1);
    }

    private static TreeNode splitTree(int[] preorder, HashMap<Integer, Integer> inOrderMap, int rootIndex, int left, int right) {
        TreeNode root = new TreeNode(preorder[rootIndex]);
        int mid = inOrderMap.get(preorder[rootIndex]);
        if (mid > left) {
            root.left = splitTree(preorder, inOrderMap, rootIndex + 1, left, mid - 1);
        }
        if (mid < right) {
            root.right = splitTree(preorder, inOrderMap, rootIndex + mid - left + 1, mid + 1, right);
        }
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode result = buildTree(preorder, inorder);
        System.out.println("[ " + result.val + ", " + result.left.val + ", " + result.right.val + ", " + result.right.left.val + ", " + result.right.right.val + " ]");
    }

}
