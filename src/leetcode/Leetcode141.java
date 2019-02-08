package leetcode;

public class Leetcode141 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (slow != null && fast != null) {
            slow = slow.next;
            if (slow == null) {
                return false;
            }
            fast = slow.next;
            if (slow.equals(fast)) {
                return true;
            }
        }
        return false;
    }
}
