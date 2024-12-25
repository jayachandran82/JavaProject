package algorithm;

/*             A
			/      \
          B           C
        /   \       /   \
     D        E    F     G
// 1).In-Order   ==> Start from Left node then, Root Node then, Right Node(D → B → E → A → F → C → G)
// 2).Pre-Order  ==> Start from Root Node then, Left Node then, Right Node(A → B → D → E → C → F → G)
// 3).Post-Order ==> Start from Left Node then, Right Node then, Root Node(D → E → B → F → G → C → A)
**/

public class BinaryTree {
    // Root of Binary Tree
    Node root;

    BinaryTree() {
        root = null;
    }

    /* Given a binary tree, print its nodes in inorder*/
    void printInorder(Node node) {
        if (node == null)
            return;

        /* first recur on left child */
        printInorder(node.left);

        /* then print the data of node */
        System.out.print(node.key + " ");

        /* now recur on right child */
        printInorder(node.right);
    }

    /* Given a binary tree, print its nodes in preorder*/
    void printPreorder(Node node) {
        if (node == null)
            return;

        /* first print data of node */
        System.out.print(node.key + " ");

        /* then recur on left subtree */
        printPreorder(node.left);

        /* now recur on right subtree */
        printPreorder(node.right);
    }

    /* Given a binary tree, print its nodes according to the
      "bottom-up" postorder traversal. */
    void printPostorder(Node node) {
        if (node == null)
            return;

        // first recur on left subtree
        printPostorder(node.left);

        // then recur on right subtree
        printPostorder(node.right);

        // now deal with the node
        System.out.print(node.key + " ");
    }


    // Wrappers over above recursive functions
    void printPostorder() {
        printPostorder(root);
    }

    void printInorder() {
        printInorder(root);
    }

    void printPreorder() {
        printPreorder(root);
    }

    // Driver method
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node('A');
        tree.root.left = new Node('B');
        tree.root.right = new Node('C');
        tree.root.left.left = new Node('D');
        tree.root.left.right = new Node('E');
        tree.root.right.left = new Node('F');
        tree.root.right.right = new Node('G');

        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreorder();

        System.out.println("Inorder traversal of binary tree is ");
        tree.printInorder();

        System.out.println("Postorder traversal of binary tree is ");
        tree.printPostorder();
    }
}