package leetcode_medium;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * https://www.youtube.com/watch?v=WRAJ8Q9bICM&ab_channel=AlgorithmsMadeEasy
 * <p>
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class Lowest_Common_Ancestor_BinaryTree {

    public static TreeNode lowestCommonAncestor(TreeNode p, TreeNode q, TreeNode root) {
        if (root == null)
            return null;

        if (root.equals(p) || root.equals(q))
            return root;

        TreeNode left = lowestCommonAncestor(p, q, root.left);
        TreeNode right = lowestCommonAncestor(p, q, root.right);

        if (left != null && right != null) return root;

        return (left != null) ? left : right;
    }

/*    public static void main(String[] args) {
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(1);
        TreeNode root = new TreeNode(3, left, right);
        left.left = new TreeNode(6);
        left.right = new TreeNode(2, new TreeNode(7), new TreeNode(4));
        right.left = new TreeNode(9);
        right.right = new TreeNode(8);

        TreeNode p = new TreeNode(6);
        TreeNode q = new TreeNode(4);
        TreeNode ancestor = lowestCommonAncestor(p, q, root);
        System.out.println("Ancestor for " + p.val + " and " + q.val + " is " + ancestor.val);

    }*/


}




