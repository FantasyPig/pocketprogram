package leetcode;

import org.omg.CORBA.INTERNAL;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode23 {

    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        ListNode tail = null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        while (queue.size() > 0) {
            ListNode currNode = queue.poll();
            if (head == null && tail == null) {
                tail = new ListNode(currNode.val);
                head = tail;
            } else {
                tail.next = new ListNode(currNode.val);
                tail = tail.next;
            }
            if (currNode.next != null) {
                queue.add(currNode.next);
            }
        }
        return head;
    }


}
