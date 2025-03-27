package trees.identicalBST;

import trees.Node;

public class IdenticalBST {
    public static void main(String[] args) {
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(3);

        Node root2 = new Node(2);
        root2.left = new Node(1);
        root2.right = new Node(3);

        if(isIdentical(root1,root2)){
            System.out.println("The BST is Identical");
        }else{
            System.out.println("The BST is not Identical");
        }
    }

    private static boolean isIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null){
            return true;
        }
        if (root1 == null || root2 == null){
            return false;
        }

        boolean condition1 = root1.data == root2.data;
        boolean condition2 = isIdentical(root1.left, root2.left);
        boolean condition3 = isIdentical(root2.right, root2.right);

        return condition1 && condition2 && condition3;
    }
}
