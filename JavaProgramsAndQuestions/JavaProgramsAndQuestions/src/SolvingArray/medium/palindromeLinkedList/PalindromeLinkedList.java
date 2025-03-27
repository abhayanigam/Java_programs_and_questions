package SolvingArray.medium.palindromeLinkedList;

class Node{
    int data;
    Node next;

    Node(int value){
        data = value;
        next = null;
    }
}

public class PalindromeLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(4);

        boolean result = isPalindrome(head);

        if (result){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }

//    Using Recursion – O(n) Time and O(n) Space
    private static boolean isPalindrome(Node head) {
        Node[] start = new Node[]{head};

        return isPalindromeRecur(head, start);
    }

    private static boolean isPalindromeRecur(Node end, Node[] start) {
        if(end == null) return true;

        boolean right = isPalindromeRecur(end.next, start);

        boolean ans = right && start[0].data == end.data;

        start[0] = start[0].next;

        return ans;
    }
}
