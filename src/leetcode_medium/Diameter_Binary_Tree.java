package leetcode_medium;

/**
 * Time Complexity: O(n)
 * Space Complexity : O(n)
 */
public class Diameter_Binary_Tree {
    private static int diameterOfBinaryTree(Node node) {
        int[] diameter = new int[1];
        height(node, diameter);
        return diameter[0];
    }

    private static int height(Node node, int[] diameter) {

        if (node == null) return 0;
        int left = height(node.left, diameter);
        int right = height(node.right, diameter);
        diameter[0] = Math.max(diameter[0], left + right);
        return 1 + Math.max(left, right);

    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        int result = diameterOfBinaryTree(root);
        System.out.println("Diameter Binary Tree :  " + result);

    }
}
