package trees.flattenBinaryTree;

import trees.Node;

public class FlattenBT {
    public static void main(String[] args) {
        Node root = new Node(4);

        root.left = new Node(9);
        root.right = new Node(5);

        root.left.left = new Node(1);
        root.left.right = new Node(3);

        root.right.right = new Node(6);

        System.out.println("Before flattening the tree :");
        inOrderTraversal(root);

        System.out.println();

        System.out.println("After flattening the tree :");
        flattenTree(root);
        inOrderTraversal(root);
    }

    private static void flattenTree(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }

        if (root.left != null) {
            flattenTree(root.left);

            Node temp = root.right;
            root.right = root.left;
            root.left = null;

            Node newTemp = root.right;
            while (newTemp.right != null) {
                newTemp = newTemp.right;
            }

            newTemp.right = temp;
        }

        flattenTree(root.right);
    }

    private static void inOrderTraversal(Node root) {
        if (root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }
}
