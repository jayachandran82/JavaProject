package leetcode_medium;

/**
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 * <p>
 * Example 1:
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 * <p>
 * Example 2:
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 * <p>
 * https://www.youtube.com/watch?v=vcmg81uHBco&ab_channel=WeAreTechies
 * <p>
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public interface Kth_Smallest_Element_BST {
    //InOrder Binary Search

    private static int kthSmallest(TreeNode root, int k) {
        int[] arr = new int[2];
        inOrderTraversal(root, k, arr);
        return arr[1];
    }

    private static void inOrderTraversal(TreeNode root, int k, int[] arr) {
        if (root == null) return;

        inOrderTraversal(root.left, k, arr);

        if (++arr[0] == k) {
            arr[1] = root.val;
        }
        inOrderTraversal(root.right, k, arr);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        // Adding left and right child
        //            3
        //          /  \
        //        1     4
        //          \
        //           2
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        int result = kthSmallest(root, 1);
        System.out.println("Kth Smallest Element in a BST :  " + result);

    }
}
