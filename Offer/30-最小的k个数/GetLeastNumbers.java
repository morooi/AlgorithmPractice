import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class GetLeastNumbers {

    // 方法一, 排序后取最小的 k 个
    public int[] getLeastNumbers01(int[] arr, int k) {
        if (arr.length == 0 || k <= 0 || k > arr.length) return new int[0];
        Arrays.sort(arr);
        return Arrays.copyOf(arr, k);
    }

    // 方法二: 利用快速排序的特点
    public int[] getLeastNumbers02(int[] arr, int k) {
        if (arr.length == 0 || k <= 0 || k > arr.length) return new int[0];
        return sort(arr, 0, arr.length - 1, k);
    }

    public int[] sort(int[] arr, int left, int right, int k) {
        int mid = partition(arr, left, right); // 返回中间值的索引
        if (mid == k - 1) return Arrays.copyOf(arr, k);
        return mid < k - 1 ? sort(arr, mid + 1, right, k) : sort(arr, left, mid - 1, k);
    }

    /**
     * @param arr  待排序的数组
     * @param low  分段的 head
     * @param high 分段的 tail
     * @return 快排后中间值的索引
     */
    public int partition(int[] arr, int low, int high) {
        int num = arr[low];  // 第一个元素为分割点的值
        int l = low, r = high;  // 初始化两个指针

        while (l < r) {
            while (l < r && arr[r] >= num) r--;
            while (l < r && arr[l] <= num) l++;
            if (l < r) {
                swap(arr, l, r);
            }
        }
        swap(arr, low, l);  // 把中间值换到指定位置
        return l;
    }

    public void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }


    // 方法三：堆排序
    public int[] getLeastNumbers03(int[] arr, int k) {
        if (arr.length == 0 || k <= 0 || k > arr.length) return new int[0];
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1); // 优先队列，默认小根堆，此处使用大根堆
        for (int i : arr) {
            if (queue.size() < k) {
                queue.offer(i);
            } else if (i < queue.peek()) {
                queue.poll();
                queue.offer(i);
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < res.length; i++) {
            if (!queue.isEmpty()) res[i] = queue.poll();
        }
        return res;
    }


    @Test
    public void test() {
        int[] set = new int[]{0, 0, 1, 2, 4, 2, 2, 3, 1, 4};
        int[] res = getLeastNumbers02(set, 8);
        System.out.println(Arrays.toString(res));
    }
}
