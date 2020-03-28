package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class findKthLargest215 {

    // 解法 1：排序
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // 解法 2：冒泡
    public int findKthLargest01(int[] nums, int k) {
        if (nums.length == 0 || k > nums.length) return -1;
        int top = nums.length - 1;
        while (top != nums.length - k - 1) {
            for (int i = 0; i < top; i++) {
                if (nums[i] > nums[i + 1]) swap(nums, i, i + 1);
            }
            top--;
        }
        return nums[nums.length - k];
    }

    public void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    // 解法 3：优先队列
    public int findKthLargest03(int[] nums, int k) {
        if (nums.length == 0 || k > nums.length) return -1;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : nums) {
            if (priorityQueue.size() < k) {
                priorityQueue.offer(num);
            } else if (num > priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.offer(num);
            }
        }
        return priorityQueue.peek();
    }


    @Test
    public void test() {
        int[] ints = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest03(ints, 5));
    }

}
