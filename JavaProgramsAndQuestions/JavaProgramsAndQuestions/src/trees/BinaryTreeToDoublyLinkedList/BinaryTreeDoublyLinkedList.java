package trees.BinaryTreeToDoublyLinkedList;

import trees.Node;

public class BinaryTreeDoublyLinkedList {
    public static void main(String[] args) {
        // Constructing the binary tree:
        //         5 
        //        / \ 
        //      3     6 
        //     / \     \ 
        //     1  4     8 
        //    / \      / \ 
        //    0 2      7  9

        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        root.right.right = new Node(8);
        root.left.left.left = new Node(0);
        root.left.left.right = new Node(2);
        root.right.right.left = new Node(7);
        root.right.right.right = new Node(9);
        
        Node head = bToDLL(root);
        
        printList(head);
    }

    private static Node bToDLL(Node root) {
        Node[] head = new Node[1];
        BToDLL(root,head);

        return head[0];
    }

    private static void BToDLL(Node root, Node[] head) {
        if (root == null){
            return;
        }

        BToDLL(root.right,head);

        root.right = head[0];

        if (head[0] != null){
            head[0].left = root;
        }

        head[0] = root;

        BToDLL(root.left,head);
    }


    private static void printList(Node head) {
        while(head != null){
            System.out.print(head.data + " ");
            head = head.right;
        }

        System.out.println();
    }
}
