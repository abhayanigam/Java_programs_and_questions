package trees.buildBalancedBST;

import trees.Node;

public class BuildBalancedBinarySearchTree {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40,50};

        Node root = sortedArrayToBST(arr,0,4);

        preOrderTraversal(root); // Output : 30 10 20 40 50
    }

    private static void preOrderTraversal(Node root) {
        if (root == null){
            return;
        }

        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    private static Node sortedArrayToBST(int[] arr, int start, int end) {
        if (start > end){
            return null;
        }

        int mid = (start + end) / 2;

        Node midRoot = new Node(arr[mid]);

        midRoot.left = sortedArrayToBST(arr,start,mid-1);
        midRoot.right = sortedArrayToBST(arr,mid+1,end);

        return midRoot;
    }
}
