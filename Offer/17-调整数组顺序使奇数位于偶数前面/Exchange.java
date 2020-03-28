import org.junit.Test;

import java.util.Arrays;

/**
 * @author morooi
 */

public class Exchange {

    public int[] exchange(int[] nums) {
        int head = 0; // 头指针
        int tail = nums.length - 1; // 尾指针
        int temp;
        while (head < tail) {
            while ((nums[head] & 1) == 1 && (head < tail)) head++; // 如果是奇数, 就后移
            while ((nums[tail] & 1) == 0 && (head < tail)) tail--; // 如果是偶数, 就前移
            // 交换奇偶
            temp = nums[head];
            nums[head] = nums[tail];
            nums[tail] = temp;
        }
        return nums;
    }

    @Test
    public void test() {
        int[] nums1 = {1, 2, 3, 4};
        int[] nums2 = {2, 4, 6};
        System.out.println(Arrays.toString(exchange(nums1)));
        System.out.println(Arrays.toString(exchange(nums2)));
    }
}
