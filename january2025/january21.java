import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (head != null) {
            ListNode tail = prev;
            for (int i = 0; i < k; i++) {
                tail = tail.next;
                if (tail == null) {
                    return dummy.next;
                }
            }

            ListNode nextSublist = tail.next;
            tail.next = null; 

            ListNode sublistHead = prev.next;
            ListNode sublistTail = reverseSublist(sublistHead);

            prev.next = sublistTail;
            sublistHead.next = nextSublist;

            prev = sublistHead;
            head = nextSublist;
        }

        return dummy.next;
    }

    private ListNode reverseSublist(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
