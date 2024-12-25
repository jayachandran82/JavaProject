package leetcode;


/**
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * <p>
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 * https://www.youtube.com/watch?v=eD3tmO66aBA&ab_channel=takeUforward
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class BinaryTree_Maximum_Depth {

    static int maximumDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maximumDepth(root.left);
        int right = maximumDepth(root.right);
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        //          3
        //      /       \
        //    9           20
        //              /     \
        //            16        17

        int result = maximumDepth(root);
        System.out.println("Maximum Depth Result:  " + result);
    }
}
