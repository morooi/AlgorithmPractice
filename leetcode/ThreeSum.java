package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeSum {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length <= 0) return new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int first = nums[i];
            if (first > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            List<List<Integer>> twoSumRes = twoSum(nums, i + 1, -first);
            if (!twoSumRes.isEmpty()) {
                for (List<Integer> tsr : twoSumRes) {
                    tsr.add(first);
                    res.add(tsr);
                }
            }
        }
        return res;
    }

    private List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> twoSumRes = new ArrayList<>();
        int low = start, high = nums.length - 1;
        while (low < high) {
            int a = nums[low], b = nums[high];
            if (a + b == target) {
                List<Integer> list = new ArrayList<>();
                list.add(a);
                list.add(b);
                twoSumRes.add(list);
                while (low < high && a == nums[++low]) ;
                while (low < high && b == nums[--high]) ;
            } else if (a + b < target) {
                while (low < high && a == nums[++low]) ;
            } else {
                while (low < high && b == nums[--high]) ;
            }
        }
        return twoSumRes;
    }

    @Test
    public void test() {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> lists = threeSum.threeSum(arr);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
