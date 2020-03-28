public class ReverseList {

    static class ListNode {
        ListNode next;
        int value;

        ListNode(int value) {
            this.value = value;
        }
    }

    public ListNode reverseList(ListNode head) {
        // 若为空直接返回
        if (head == null) return null;
        ListNode pre = head;
        ListNode cur = pre.next;
        ListNode temp;
        // 头指针指向 null
        head.next = null;
        while (cur != null) {
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}
