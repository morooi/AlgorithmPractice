import java.util.ArrayList;

public class ReversePrint {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int length = list.size();
        int[] ints = new int[length];
//        for (int i = length - 1; i >= 0; i--) {
//            ints[length - i - 1] = list.get(i);
//        }
        for (int i = 0; i < length; i++) {
            ints[i] = list.get(length - i - 1);
        }
        return ints;
    }
}

