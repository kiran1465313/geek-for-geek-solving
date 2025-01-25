import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {
    public Node findFirstNode(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}

public class Main {
    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void loopHere(Node head, Node tail, int position) {
        if (position == 0) {
            return;
        }

        Node walk = head;
        for (int i = 1; i < position; i++) {
            walk = walk.next;
        }
        tail.next = walk;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            int k = scanner.nextInt();
            Node head = new Node(arr[0]);
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(arr[i]);
                tail = tail.next;
            }
            loopHere(head, tail, k);

            Solution ob = new Solution();
            Node ans = ob.findFirstNode(head);
            if (ans == null) {
                System.out.println(-1);
            } else {
                System.out.println(ans.data);
            }
            System.out.println("~");
        }
        scanner.close();
    }
}

