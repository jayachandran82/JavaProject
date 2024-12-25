package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all root-to-leaf path where sum of node values matches given sum.
 * <p>
 * Example :
 *          1
 *         / \
 *       2    6
 *      / \
 *     3   4
 *    /
 *   5
 * <p>
 * Out put: [ [1, 2, 4] , [1,6] ]
 * <p>
 * Time Complexity : O(n)
 * Space complexity: O(n) + n log(n)
 * Explanation: O(n) +n log(n)
 * 1). O(n)  -> singlePath
 * 2). n log(n) ==> One operation will be n ==> [1, 2, 4] and multiple operation log n  ==> [ [1, 2, 4] , [1,6] ]
 */
public class Sum_All_Paths {
    //Depth First Search (DFS)
    public static void main(String[] args) {
        Sum_All_Paths obj = new Sum_All_Paths();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(5);
        root.left.right = new TreeNode(4);
        int sum = 7;
        List<List<Integer>> result = obj.showAllSumPath(root, sum);
        System.out.println(" Result" + result);
    }

    private List<List<Integer>> showAllSumPath(TreeNode node, int sum) {
        List<Integer> singlePath = new ArrayList<>();
        List<List<Integer>> allSumPathList = new ArrayList<>();
        findPathUtil(node, sum, singlePath, allSumPathList);
        return allSumPathList;
    }

    void findPathUtil(TreeNode node, int sum, List<Integer> singlePath, List<List<Integer>> allSumPathList) {
        if (node == null) {
            return;
        }
        singlePath.add(node.val);
        if (node.left == null && node.right == null && node.val == sum) {
            allSumPathList.add(new ArrayList<>(singlePath));
        } else {
            findPathUtil(node.left, sum - node.val, singlePath, allSumPathList);
            findPathUtil(node.right, sum - node.val, singlePath, allSumPathList);
        }

        singlePath.remove(singlePath.size() - 1);
    }
}
