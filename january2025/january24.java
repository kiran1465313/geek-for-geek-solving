// Importing necessary libraries
import java.util.Scanner;

// Node Class
class Node {
    int data; // data -> value stored in node
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

// Linked List Class
class LinkedList {
    Node head;
    Node tail;

    LinkedList() {
        this.head = null;
        this.tail = null;
    }

    // creates a new node with given value and appends it at the end of the linked list
    void insert(int val) {
        if (head == null) {
            head = new Node(val);
            tail = head;
        } else {
            tail.next = new Node(val);
            tail = tail.next;
        }
    }

    // connects last node to node at position pos from beginning.
    void loopHere(int pos) {
        if (pos == 0) {
            return;
        }

        Node walk = head;
        for (int i = 1; i < pos; i++) {
            walk = walk.next;
        }

        tail.next = walk;
    }
}

// Solution Class
class Solution {
    // Function to check if the linked list has a loop.
    boolean detectLoop(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}

// Driver Code
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        while (t-- > 0) {
            LinkedList LL = new LinkedList();
            String[] values = scanner.nextLine().split(" ");
            for (String value : values) {
                LL.insert(Integer.parseInt(value));
            }
            LL.loopHere(Integer.parseInt(scanner.nextLine()));
            boolean res = new Solution().detectLoop(LL.head);
            System.out.println(res ? "true" : "false");
            System.out.println("~");
        }
        scanner.close();
    }
}

