package trees.diameterBinaryTree;

import trees.Node;

public class DiameterBinaryTree {
    public static void main(String[] args) {
        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);

        root.left.right = new Node(4);
        root.left.left = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("The Diameter of the tree using Method is : " + calculateDiameter(root));

    }

    private static int calculateDiameter(Node root) {
        if (root == null){
            return 0;
        }

        int leftHeight = calculateHeight(root.left);
        int rightHeight = calculateHeight(root.right);

        int totalMaxHeight = leftHeight + rightHeight + 1;

        int leftDiameter = calculateDiameter(root.left);
        int rightDiameter = calculateDiameter(root.right);

        int currentDiameter = Math.max(leftDiameter,rightDiameter);

        return Math.max(totalMaxHeight,currentDiameter);
    }

    private static int calculateHeight(Node root) {
        if (root == null){
            return 0;
        }

        return Math.max(calculateHeight(root.left),calculateHeight(root.right)) + 1;
    }
}
