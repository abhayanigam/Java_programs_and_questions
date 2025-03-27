package trees.ZigzagTraversal;

import trees.Node;

import java.util.Stack;

public class ZigZagTraversal {
    public static void main(String[] args) {
        Node root = new Node(12);
        root.left = new Node(9);
        root.right = new Node(15);
        root.left.left = new Node(5);
        root.left.right = new Node(10);

        zigZagTraversal(root);
    }

    private static void zigZagTraversal(Node root) {
        if (root == null){
            return;
        }

        Stack<Node> currentLevel = new Stack<>();
        Stack<Node> nextLevel = new Stack<>();

        boolean leftToRight = true;

        currentLevel.push(root);

        while(!currentLevel.isEmpty()){
            Node temp = currentLevel.pop();
            System.out.print(temp.data +  " ");

            if (leftToRight){
                if(temp.left != null){
                    nextLevel.push(temp.left);
                }

                if (temp.right != null){
                    nextLevel.push(temp.right);
                }
            }
            else{
                if (temp.right != null){
                    nextLevel.push(temp.right);
                }

                if (temp.left != null){
                    nextLevel.push(temp.left);
                }
            }

            if (currentLevel.isEmpty()){
                leftToRight = !leftToRight;

                Stack<Node> tempStack = new Stack<>();

                currentLevel = nextLevel;
                nextLevel = tempStack;
            }
        }
    }
}
