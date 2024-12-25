package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * Note: A leaf is a node with no children.
 * <p>
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 2
 * <p>
 * https://www.youtube.com/watch?v=eD3tmO66aBA&ab_channel=takeUforward
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class BinaryTree_Minimum_Depth {
    //Level order && Breadth First Search( Queue )
    static int minimumDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();

                //IF the leaf node is not found and just return the depth;
                if (treeNode.left == null && treeNode.right == null) {
                    return depth;
                }
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
            depth++;
        }
        return depth;
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

        int result = minimumDepth(root);
        System.out.println("Minimum Depth Result:  " + result);
    }
}
