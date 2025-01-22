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
    public Node reverse(Node head) {
        Node prev = null, curr = head;
        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    public Node addTwoLists(Node l1, Node l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        Node dummy = new Node(0);
        Node tail = dummy;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int summ = carry;
            if (l1 != null) {
                summ += l1.data;
                l1 = l1.next;
            }
            if (l2 != null) {
                summ += l2.data;
                l2 = l2.next;
            }
            carry = summ / 10;
            tail.next = new Node(summ % 10);
            tail = tail.next;
        }

        Node res = reverse(dummy.next);
        while (res != null && res.data == 0 && res.next != null) {
            res = res.next;
        }
        return res;
    }
}

class LinkedList {
    Node head;
    Node tail;

    LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insert(int val) {
        if (head == null) {
            head = new Node(val);
            tail = head;
        } else {
            tail.next = new Node(val);
            tail = tail.next;
        }
    }
}

public class Main {
    public static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        while (t-- > 0) {
            String[] arr1 = scanner.nextLine().split(" ");
            LinkedList num1 = new LinkedList();
            for (String s : arr1) {
                num1.insert(Integer.parseInt(s));
            }

            String[] arr2 = scanner.nextLine().split(" ");
            LinkedList num2 = new LinkedList();
            for (String s : arr2) {
                num2.insert(Integer.parseInt(s));
            }

            Node res = new Solution().addTwoLists(num1.head, num2.head);
            printList(res);
            System.out.println("~");
        }
        scanner.close();
    }
}

