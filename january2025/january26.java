import java.util.Scanner;

class Node {
    Node next;
    int data;

    Node(int val) {
        this.data = val;
        this.next = null;
    }
}

class Solution {
    // Function to remove a loop in the linked list.
    void removeLoop(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null && (slow = slow.next) != (fast = fast.next.next)) {
            // do nothing
        }
        if (fast == null || fast.next == null) return;
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        while (fast.next != slow) {
            fast = fast.next;
        }
        fast.next = null;
    }
}

class LinkedList {
    Node head;
    Node tail;

    LinkedList() {
        this.head = null;
        this.tail = null;
    }

    void add(int num) {
        if (head == null) {
            head = new Node(num);
            tail = head;
        } else {
            tail.next = new Node(num);
            tail = tail.next;
        }
    }

    boolean isLoop() {
        if (head == null) {
            return false;
        }

        Node fast = head.next;
        Node slow = head;

        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        return true;
    }

    void loopHere(int position) {
        if (position == 0) {
            return;
        }

        Node walk = head;
        for (int i = 1; i < position; i++) {
            walk = walk.next;
        }
        tail.next = walk;
    }

    int length() {
        Node walk = head;
        int ret = 0;
        while (walk != null) {
            ret++;
            walk = walk.next;
        }
        return ret;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        while (t-- > 0) {
            String[] arr = scanner.nextLine().split(" ");
            int pos = Integer.parseInt(scanner.nextLine());
            int n = arr.length;
            LinkedList ll = new LinkedList();
            for (String s : arr) {
                ll.add(Integer.parseInt(s));
            }
            ll.loopHere(pos);

            new Solution().removeLoop(ll.head);

            if (ll.isLoop() || ll.length() != n) {
                System.out.println("false");
                continue;
            } else {
                System.out.println("true");
            }
            System.out.println("~");
        }
        scanner.close();
    }
}

