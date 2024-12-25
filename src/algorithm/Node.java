package algorithm;

/*             A
			|     |
          B           C
        |   |       |   |
     D        E    F     G
// 1).In-Order   ==> Start from Left node then, Root Node then, Right Node(D → B → E → A → F → C → G)
// 2).Pre-Order  ==> Start from Root Node then, Left Node then, Right Node(A → B → D → E → C → F → G)
// 3).Post-Order ==> Start from Left Node then, Right Node then, Root Node(D → E → B → F → G → C → A)
**/
class Node {
    char key;
    Node left, right;

    public Node(char item) {
        key = item;
        left = right = null;
    }
}
