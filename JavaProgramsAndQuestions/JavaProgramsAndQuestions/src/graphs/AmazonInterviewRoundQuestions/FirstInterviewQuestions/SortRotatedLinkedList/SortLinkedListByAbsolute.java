package graphs.AmazonInterviewRoundQuestions.FirstInterviewQuestions.SortRotatedLinkedList;

/*
    Given a linked list which is sorted in order of absolute values,
    you have to sort the integer values.

    Input: 1->3->5->8-10->-11
    Output:-11->-10->-3->1->5->8
 */

// --------------Method 1 :------------------
// Time Complexity : O(n)
// Space Complexity : O(1)

// Node definition for the linked list.
class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
    }
}

public class SortLinkedListByAbsolute {

    // Function to sort the linked list
    public static Node sortList(Node head) {
        // Edge case: empty list or single element list
        if (head == null || head.next == null) {
            return head;
        }

        // Initialize current pointer to head
        Node curr = head;
        // Traverse the list until the end
        while (curr != null && curr.next != null) {
            // If the next node has a negative value,
            // remove it and insert at the beginning.
            if (curr.next.data < 0) {
                Node temp = curr.next;
                curr.next = temp.next;  // Remove the negative node from current position

                // Insert the negative node at the beginning
                temp.next = head;
                head = temp;
            } else {
                // Move to the next node if no negative found
                curr = curr.next;
            }
        }
        return head;
    }

    // Utility method to print the list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if(temp.next != null) {
                System.out.print("->");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    // Driver code to test the algorithm
    public static void main(String[] args) {
        // Construct the list: 1->3->5->8->-10->-11
        // Which is sorted by absolute values: abs(1)<abs(3)<abs(5)<abs(8)<abs(-10)<abs(-11)
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(5);
        head.next.next.next = new Node(8);
        head.next.next.next.next = new Node(-10);
        head.next.next.next.next.next = new Node(-11);

        System.out.print("Input: ");
        printList(head);

        // Sort the list
        head = sortList(head);

        System.out.print("Output: ");
        printList(head);
    }
}

// -----------Method 2:------------------
/*
    You can solve this problem using two linked lists:
    1. One for negative numbers** (inserted at the beginning to maintain sorted order).
    2. One for positive numbers** (inserted at the end).

    Steps to Solve:
    - Traverse the original list.
    - If the value is **negative**, insert it at the beginning of the negative list.
    - If the value is **positive**, insert it at the end of the positive list.
    - Merge both lists.

    Time Complexity:
    - O(N) (single pass to split into two lists + O(1) merge operation).

    Space Complexity:
    - O(1) (No extra space used apart from pointers).


class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class SortAbsoluteLinkedList {

    public static Node sortAbsoluteList(Node head) {
        if (head == null || head.next == null) return head;

        Node negativeHead = null, negativeTail = null;
        Node positiveHead = null, positiveTail = null;

        Node curr = head;

        while (curr != null) {
            Node next = curr.next;  // Store next node
            curr.next = null;  // Isolate current node

            if (curr.data < 0) {
                // Insert negative number at the beginning
                if (negativeHead == null) {
                    negativeHead = negativeTail = curr;
                } else {
                    curr.next = negativeHead;
                    negativeHead = curr;
                }
            } else {
                // Insert positive number at the end
                if (positiveHead == null) {
                    positiveHead = positiveTail = curr;
                } else {
                    positiveTail.next = curr;
                    positiveTail = curr;
                }
            }
            curr = next;
        }

        // Merge two lists
        if (negativeHead == null) return positiveHead; // No negatives
        negativeTail.next = positiveHead;  // Connect last negative to first positive
        return negativeHead;
    }

    // Helper function to print linked list
    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        head.next = new Node(1);
        head.next.next = new Node(5);
        head.next.next.next = new Node(8);
        head.next.next.next.next = new Node(-10);
        head.next.next.next.next.next = new Node(-11);

        System.out.println("Original List:");
        printList(head);

        head = sortAbsoluteList(head);

        System.out.println("Sorted List:");
        printList(head);
    }
}
*/