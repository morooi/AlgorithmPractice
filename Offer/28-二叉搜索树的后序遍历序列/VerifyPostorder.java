public class VerifyPostorder {

    /**
     * 思路:
     *  1. 最后一个肯定是根节点
     *  2. 通过根节点找到左子树和右子树
     *  3. 对左子树和右子树做同样的操作
     *
     * @param postorder
     * @return
     */

    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    public boolean recur(int[] array, int head, int tail) {
        // 必须为大于等于 0
        if (head >= tail) return true;
        int temp = head;
        while (array[temp] < array[tail]) temp++;
        int mid = temp;
        while (array[temp] > array[tail]) temp++;
        return temp == tail && recur(array, head, mid - 1) && recur(array, mid, tail - 1);
    }
}
