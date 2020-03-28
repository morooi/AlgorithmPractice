public class GetKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail != null) {
                tail = tail.next;
            } else {
                return head;
            }
        }

        while (tail != null) {
            tail = tail.next;
            head = head.next;
        }
        return head;
    }

    static class ListNode {
        ListNode next;
        int value;

        ListNode(int value) {
            this.value = value;
        }
    }
}
