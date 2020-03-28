public class MergeTwoLists {

    static class ListNode {
        ListNode next;
        int val;

        ListNode(int val) {
            this.val = val;
        }

        ListNode() {
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode temp = head;
        while (l1 != null && l2 != null) {
           if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
           } else {
                temp.next = l2;
                l2 = l2.next;
           }
            temp = temp.next;
        }
        // 剩余未空的接在最后面
        temp.next = (l1 == null) ? l2 : l1;

        return head.next;
    }
}
