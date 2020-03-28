package leetcode;

/*
leetcode 148: 排序链表
https://leetcode-cn.com/problems/sort-list/
 */
public class SortList {

    static class ListNode {
        ListNode next;
        int val;

        public ListNode() {
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(mid);

        ListNode newHead = new ListNode();
        ListNode n = newHead;
        while (left != null && right != null) {
            if (left.val > right.val) {
                n.next = right;
                right = right.next;
            } else {
                n.next = left;
                left = left.next;
            }
            n = n.next;
        }
        n.next = left == null ? right : left;
        return newHead.next;
    }

}
