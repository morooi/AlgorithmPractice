import java.util.*;

public class MajorityElement {

    // 解法 1: 利用 HashMap
    public int majorityElement01(int[] nums) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];
        int counts = nums.length >> 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                Integer count = map.get(num);
                if (++count > counts) return num;
                map.put(num, count);
            } else {
                map.put(num, 1);
            }
        }
        return -1;
    }

    // 解法 2: 排序后, 中间的数一定是众数
    public int majorityElement02(int[] nums) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) {
            if (nums[0] == nums[1]) return nums[0];
            else return -1;
        }
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }

    // 解法 3: 摩尔投票法
    public int majorityElement03(int[] nums) {
        if (nums.length == 0) return -1;
        int res = 0, count = 0;
        for (int num : nums) {
            if (count == 0) res = num;
            count += res == num ? 1 : -1;  // res == num 加一, 否则减一
        }
        return res;
    }
}
