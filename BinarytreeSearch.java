
private static int isPresent(Node root, int val) {
    /* For your reference
    class Node {
        Node left, right;
        int data;
        Node(int newData) {
            left = right = null;
            data = newData;
        }
    }
    */

    while (root != null) {
        if (root.data == val) {
            return 1;
        } else if (root.left != null && root.data > val) {
            root = root.left;
        } else {
            root = root.right;
        }
    }
    return 0;
}
