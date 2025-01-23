import java.util.HashMap;

class Node {
    int data;
    Node next;
    Node random;

    Node(int x) {
        this.data = x;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node cloneLinkedList(Node head) {
        if (head == null) {
            return null;
        }
        HashMap<Node, Node> d = new HashMap<>();
        Node ch = new Node(head.data);
        Node chh = ch;
        d.put(head, ch);

        Node h = head.next;
        while (h != null) {
            Node nn = new Node(h.data);
            chh.next = nn;
            d.put(h, nn);
            h = h.next;
            chh = nn;
        }
        h = head;
        chh = ch;
        while (h != null) {
            if (h.random != null) {
                chh.random = d.get(h.random);
            }
            h = h.next;
            chh = chh.next;
        }

        return ch;
    }
}

public class Main {
    public static void printLinkedList(Node root) {
        HashMap<Node, Integer> link = new HashMap<>();
        Node temp = root;
        int index = 0;
        while (temp != null) {
            link.put(temp, index);
            temp = temp.next;
            index++;
        }

        temp = root;
        StringBuilder result = new StringBuilder();
        while (temp != null) {
            String randomIndex = (temp.random == null) ? "NULL" : String.valueOf(link.get(temp.random) + 1);
            result.append("[").append(temp.data).append(", ").append(randomIndex).append("]");
            temp = temp.next;
            if (temp != null) {
                result.append(", ");
            }
        }

        System.out.println("[" + result.toString() + "]");
    }

    public static Node buildLinkedList(int[][] v, HashMap<Node, Integer> orgAddress) {
        Node[] address = new Node[v.length];
        Node head = new Node(v[0][0]);
        address[0] = head;
        orgAddress.put(head, 0);
        Node temp = head;

        for (int i = 1; i < v.length; i++) {
            Node newNode = new Node(v[i][0]);
            orgAddress.put(newNode, i);
            address[i] = newNode;
            temp.next = newNode;
            temp = temp.next;
        }

        temp = head;
        for (int i = 0; i < v.length; i++) {
            int randomIndex = v[i][1];
            if (randomIndex != -1) {
                temp.random = address[randomIndex - 1];
            }
            temp = temp.next;
        }

        return head;
    }

    public static boolean validateInput(HashMap<Node, Integer> orgAddress, Node head, int[][] v) {
        Node[] address = new Node[v.length];
        Node temp = head;
        for (int i = 0; i < v.length; i++) {
            if (!orgAddress.containsKey(temp) || orgAddress.get(temp) != i) {
                return false;
            }
            address[i] = temp;
            temp = temp.next;
        }

        if (temp != null) {
            return false;
        }

        temp = head;
        for (int i = 0; i < v.length; i++) {
            int value = v[i][0];
            int randomIndex = v[i][1];

            if (randomIndex == -1) {
                if (temp.random != null) {
                    return false;
                }
            } else {
                Node tempNode = address[randomIndex - 1];
                if (temp.random != tempNode) {
                    return false;
                }
            }
            temp = temp.next;
        }
        return true;
    }

    public static boolean validation(Node res, HashMap<Node, Integer> orgAddress) {
        Node temp = res;
        while (temp != null) {
            if (orgAddress.containsKey(temp)) {
                return false;
            }
            if (temp.random != null && orgAddress.containsKey(temp.random)) {
                return false;
            }
            temp = temp.next;
        }
        return true;
    }

    public static void main(String[] args) {
        // Driver code to be implemented as per the input requirements
    }
}

