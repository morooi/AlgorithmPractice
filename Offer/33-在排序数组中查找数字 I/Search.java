import org.junit.Test;

import java.security.interfaces.RSAKey;

public class Search {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return 0;
        // 二分法找到target的左边界和右边界
        int i = 0, j = nums.length - 1;
        // 先找右边界
        while (i <= j) {
            int m = (j + i) >> 1;
            if (nums[m] <= target) i = m + 1;  // 若nums[m] == target，right在[m + 1, j]之间
            else j = m - 1;
        }
        int right = i;
        if (j >= 0 && nums[j] != target) return 0;
        // 找左边界
        i = 0; j = right;
        while (i <= j) {
            int m = (j + i) >> 1;
            if (nums[m] < target) i = m + 1;
            else j = m - 1;  // 若nums[m] = target，left在[i, m - 1]之间
        }
        int left = j;
        return right - left - 1;
    }

    @Test
    public void test() {
        int[] nums = new int[]{5, 7, 8, 8, 8, 9};
        System.out.println(search(nums, 8));
    }
}
