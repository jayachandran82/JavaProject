package leetcode;

/**
 * You are given the root of a binary tree containing digits from 0 to 9 only.
 * Each root-to-leaf path in the tree represents a number.
 * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
 * Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
 * A leaf node is a node with no children.
 * Example 1:
 *      1
 *    /   \
 *   2     3
 * Input: root = [1,2,3]
 * Output: 25
 * Explanation:
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Therefore, sum = 12 + 13 = 25.
 * <p>
 * Time Complexity:  O(n), where  n is the number of nodes, as we visit each node exactly once.
 * Space Complexity: O(h), where  h is the height of the tree, due to the recursion stack in DFS.
 */
public class Sum_Root_To_Leaf_Numbers {
    //  Depth First Search (DFS)
    public static void main(String[] args) {
        Sum_Root_To_Leaf_Numbers solution = new Sum_Root_To_Leaf_Numbers();
        // Creating a sample binary tree:
        //         1
        //        / \
        //       2   3
        //      / \
        //     4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        int result = solution.sumNumbers(root);
        System.out.println(" Result Depth First Search : " + result);
    }

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    int dfs(TreeNode root, int sumNumber) {
        if (root == null) return 0;
        sumNumber = sumNumber * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sumNumber;
        }
        int left = dfs(root.left, sumNumber);
        int right = dfs(root.right, sumNumber);
        return left + right;
    }
}
