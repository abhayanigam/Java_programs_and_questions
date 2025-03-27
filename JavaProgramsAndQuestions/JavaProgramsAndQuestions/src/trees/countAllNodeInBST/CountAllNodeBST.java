package trees.countAllNodeInBST;

import trees.Node;

public class CountAllNodeBST {
    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("The Number Of Node are : " + countAllNode(root));
    }

    private static int countAllNode(Node root) {
        if (root == null){
            return 0;
        }

        return countAllNode(root.left) + countAllNode(root.right) + 1;
    }
}
