package trees.LeftRightTopBottomView;

import trees.Node;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class Pair {
    Node node;
    int horizontalDistance;

    Pair(Node node, int horizontalDistance) {
        this.node = node;
        this.horizontalDistance = horizontalDistance;
    }
}

public class LeftRightTopBottomView {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Right View of the tree is ");
        rightView(root);

        System.out.println();

        System.out.println("Left View of the tree is ");
        leftView(root);

        System.out.println();

        System.out.println("Top View of the tree is ");
        topView(root);

        System.out.println();

        System.out.println("Bottom View of the tree is ");
        bottomView(root);

    }

    // Time Complexity O(N log N) -> Sorting in TreeMap
    private static void bottomView(Node root) {
        if(root == null) return;

        Map<Integer, Integer> map = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root,0));

        while (!q.isEmpty()){
            Pair p = q.poll();

            map.put(p.horizontalDistance,p.node.data);

            if (p.node.left != null){
                q.add(new Pair(p.node.left, p.horizontalDistance-1));
            }

            if (p.node.right != null){
                q.add(new Pair(p.node.right, p.horizontalDistance+1));
            }
        }

        for (int val : map.values()){
            System.out.print(val + " ");
        }
    }

    // Time Complexity O(N log N) -> Sorting in TreeMap
    private static void topView(Node root) {
        if (root == null) return;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(root,0));

        while (!q.isEmpty()){
            Pair p = q.poll();

            if (!map.containsKey(p.horizontalDistance)){
                map.put(p.horizontalDistance, p.node.data);
            }

            if (p.node.left !=null){
                q.add(new Pair(p.node.left,p.horizontalDistance-1));
            }

            if (p.node.right != null){
                q.add(new Pair(p.node.right,p.horizontalDistance+1));
            }
        }

        for (int val : map.values()){
            System.out.print(val + " ");
        }
    }

    // Time Complexity O(n) -> Level Order Traversal
    private static void leftView(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()){
            int size = q.size();

            for (int i = 0; i < size; i++) {
                Node currentNode = q.poll();

                if (i == size - 1){
                    System.out.print(currentNode.data + " ");
                }

                if (currentNode.left != null) q.add(currentNode.right);
                if (currentNode.right != null) q.add(currentNode.left);
            }
        }
    }

    // Time Complexity O(n) -> Level Order Traversal
    private static void rightView(Node root) {
        if (root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {

                Node current = q.poll();

                if (i == size - 1) {
                    System.out.print(current.data + " ");
                }

                if (current.left != null) q.add(current.left);
                if (current.right != null) q.add(current.right);
            }
        }
    }
}
